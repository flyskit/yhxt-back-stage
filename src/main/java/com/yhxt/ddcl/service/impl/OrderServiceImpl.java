package com.yhxt.ddcl.service.impl;

import com.yhxt.common.AuditStatus;
import com.yhxt.common.BaseMessage;
import com.yhxt.common.BaseStatus;
import com.yhxt.ddcl.common.OrderRecordType;
import com.yhxt.ddcl.dao.OrderAccessoryDao;
import com.yhxt.ddcl.dao.OrderDetailDao;
import com.yhxt.ddcl.dao.OrderRecordDao;
import com.yhxt.ddcl.dto.OrderAccessoryDTO;
import com.yhxt.ddcl.entity.OrderAccessory;
import com.yhxt.ddcl.entity.OrderDetail;
import com.yhxt.ddcl.entity.OrderRecord;
import com.yhxt.ddcl.service.OrderService;
import com.yhxt.ddcl.vo.OrderAccessoryParamVO;
import com.yhxt.ddcl.vo.OrderAddDataBaseParamVO;
import com.yhxt.ddcl.vo.OrderDelParamVO;
import com.yhxt.ddcl.vo.OrderUpdateStatusVO;
import com.yhxt.sjgl.dao.AccessoryDetailDao;
import com.yhxt.sjgl.entity.AccessoryDetail;
import com.yhxt.utils.BaseTimeTransform;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Author zqi
 * @Date 2019/6/20 17:41
 * @Version 1.0
 * @Description 订单信息处理
 */
@Service
public class OrderServiceImpl implements OrderService {

  @Resource
  private OrderDetailDao orderDetailDao;

  @Resource
  private OrderRecordDao orderRecordDao;

  @Resource
  private OrderAccessoryDao orderAccessoryDao;

  @Resource
  private AccessoryDetailDao accessoryDetailDao;

  private static Logger logger = Logger.getLogger(OrderServiceImpl.class);

  /**
   * 获取编号
   *
   * @return baseMessage 返回信息
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getOrderNumber() {
    //查询最新一条记录
    OrderDetail orderDetail = orderDetailDao.findFirstByOrderByDdbhDesc();
    return BaseMessage.success().add(this.handleOrderNumber(orderDetail));
  }

  /**
   * 编号处理
   *
   * @param orderDetail 订单信息记录
   * @return ddbh 订单编号
   */
  @Override
  public StringBuilder handleOrderNumber(OrderDetail orderDetail) {
    StringBuilder initNum = new StringBuilder("0001");
    //获取当前时间
    String timeString = BaseTimeTransform.localDateToString(LocalDate.now());
    //获取当前天数
    String initDay = timeString.substring(6, 8);
    StringBuilder stringBuilder = new StringBuilder(timeString);
    // 判断：数据表为空，或者每天，重新改写编号
    if (StringUtils.isEmpty(orderDetail) || !orderDetail.getDdbh().substring(6, 8).equals(initDay)) {
      return stringBuilder.append(initNum);
    }
    // 获取编号，截取最后四位
    String lastFour = orderDetail.getDdbh().substring(8, 12);
    // 编号+1，位数不够前面补0
    stringBuilder.append(String.format("%0" + lastFour.length() + "d", Integer.parseInt(lastFour) + 1));
    return stringBuilder;
  }

  /**
   * 添加订单-预处理
   *
   * @param orderAddDataBaseParamVO 接受参数
   * @return orderDetail
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public OrderDetail orderAddDataPreDeal(OrderAddDataBaseParamVO orderAddDataBaseParamVO) throws Exception {
    OrderDetail orderDetailNewest = orderDetailDao.findFirstByOrderByDdbhDesc();
    // 判断编号是否为最新编号，若不是则重新制定编号
    if (StringUtils.isEmpty(orderDetailNewest) || !orderDetailNewest.getDdbh().equals(orderAddDataBaseParamVO.getDdbh())) {
      orderAddDataBaseParamVO.setDdbh(this.handleOrderNumber(orderDetailNewest).toString());
    }
    LocalDateTime nowTime = LocalDateTime.now();
    Date completeTime = BaseTimeTransform.localDateTimeToDate(nowTime.plusDays(orderAddDataBaseParamVO.getGq()));
    OrderDetail orderDetailToBeAdded = new OrderDetail(orderAddDataBaseParamVO.getDdbh(), orderAddDataBaseParamVO.getDdlx(), orderAddDataBaseParamVO.getDdly(),
            orderAddDataBaseParamVO.getScsl(), orderAddDataBaseParamVO.getKhxm(), orderAddDataBaseParamVO.getDz(),
            orderAddDataBaseParamVO.getDh(), orderAddDataBaseParamVO.getGq(), completeTime,
            orderAddDataBaseParamVO.getBz(), orderAddDataBaseParamVO.getDdzt(),
            AuditStatus.AUDIT_YES.getValue(), BaseStatus.VALID.getValue());
    try {
      // 保存订单信息
      OrderDetail orderDetailAdded = orderDetailDao.save(orderDetailToBeAdded);
      // 保存订单-操作记录表
      OrderRecord orderRecordToBeAdded = OrderRecordType.getNew();
      orderRecordToBeAdded.setDdid(orderDetailAdded.getId());
      // TODO 获取当前登录角色信息
      orderRecordToBeAdded.setCzr("张三");
      orderRecordToBeAdded.setCzsj(BaseTimeTransform.localDateTimeToDate(nowTime));
      orderRecordDao.save(orderRecordToBeAdded);
      return orderDetailAdded;
    } catch (Exception e) {
      logger.error(e);
      return null;
    }
  }

  /**
   * 暂存订单-提交
   *
   * @param orderUpdateStatusVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage orderUpdateStatus(OrderUpdateStatusVO orderUpdateStatusVO) {
    try {
      OrderDetail orderDetail = orderDetailDao.findByDdbh(orderUpdateStatusVO.getDdbh());
      if (StringUtils.isEmpty(orderDetail)) {
        return BaseMessage.failed("未查找到记录！");
      }
      orderDetail.setDdzt(orderUpdateStatusVO.getZt());
      OrderRecord orderRecord = orderRecordDao.findByDdidAndCzlb(orderDetail.getId(), OrderRecordType.NEW.getValue());
      // TODO 获取当前登录角色信息
      orderRecord.setCzr("李四");
      orderRecord.setCzsj(BaseTimeTransform.localDateTimeToDate(LocalDateTime.now()));
      orderDetailDao.save(orderDetail);
      orderRecordDao.save(orderRecord);
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 删除订单
   *
   * @param orderDelParamVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage delData(OrderDelParamVO orderDelParamVO) {
    OrderDetail orderDetail = orderDetailDao.findByDdbh(orderDelParamVO.getDdbh());
    if (StringUtils.isEmpty(orderDetail)) {
      return BaseMessage.failed("未找到记录");
    }
    orderDetail.setZt(BaseStatus.INVALID.getValue());
    try {
      orderDetailDao.save(orderDetail);
      orderRecordDao.save(new OrderRecord(orderDetail.getId(),
              OrderRecordType.DELETE.getValue(),
              orderDelParamVO.getScyy(),
              "王五",
              BaseTimeTransform.localDateTimeToDate(LocalDateTime.now())));
      return BaseMessage.success();
    } catch (Exception e) {
      return BaseMessage.failed();
    }
  }

  /**
   * 添加配件
   *
   * @param orderAccessoryParamVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addAccessory(OrderAccessoryParamVO orderAccessoryParamVO) {
    OrderDetail orderDetail = orderDetailDao.findByDdbh(orderAccessoryParamVO.getDdbh());
    AccessoryDetail accessoryDetail = accessoryDetailDao.findByBh(orderAccessoryParamVO.getBh());
    OrderAccessory orderAccessory = new OrderAccessory(orderDetail.getId(), accessoryDetail.getId(), orderAccessoryParamVO.getPjsl(),
            orderAccessoryParamVO.getDj(), orderAccessoryParamVO.getPjje(), BaseStatus.VALID.getValue());
    try {
      orderAccessoryDao.save(orderAccessory);
      orderDetailDao.save(orderDetail);
      return BaseMessage.success();
    } catch (Exception e) {
      return BaseMessage.failed();
    }
  }

  /**
   * 查询配件列表
   *
   * @param ddbh 订单编号
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getAccessory(String ddbh) {
    List<OrderAccessoryDTO> list = orderAccessoryDao.getAccessory(ddbh);
    return BaseMessage.success().add(list);
  }

  /**
   * 拼装配件信息
   *
   * @param ddid 订单信息id
   * @return accessoryInfo
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public StringBuilder getAccessoryListInfo(String ddid) {
    List<OrderAccessory> accessoryDetailList = orderAccessoryDao.findByDdidAndZt(ddid, BaseStatus.VALID.getValue());
    if (StringUtils.isEmpty(accessoryDetailList)) {
      return null;
    }
    StringBuilder accessoryListInfo = new StringBuilder();
    for (OrderAccessory orderAccessory : accessoryDetailList) {
      AccessoryDetail accessoryDetail = accessoryDetailDao.findById(orderAccessory.getPjid());
      accessoryListInfo.append(accessoryDetail.getMc()).append(orderAccessory.getPjsl()).append(accessoryDetail.getDw()).append("; ");
    }
    return accessoryListInfo;
  }

  /**
   * 删除配件
   *
   * @param id 订单-配件id标识
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage delAccessory(String id) {
    try {
      OrderAccessory orderAccessory = orderAccessoryDao.findById(id);
      orderAccessory.setZt(BaseStatus.INVALID.getValue());
      orderAccessoryDao.save(orderAccessory);
      return BaseMessage.success();
    } catch (Exception e) {
      return BaseMessage.failed();
    }
  }
}
