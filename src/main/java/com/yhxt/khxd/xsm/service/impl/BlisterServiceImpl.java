package com.yhxt.khxd.xsm.service.impl;

import com.yhxt.common.BaseMessage;
import com.yhxt.common.BaseStatus;
import com.yhxt.common.GoodsType;
import com.yhxt.common.PageCond;
import com.yhxt.ddcl.common.OrderRecordType;
import com.yhxt.ddcl.common.OrderType;
import com.yhxt.ddcl.dao.OrderDetailDao;
import com.yhxt.ddcl.dao.OrderGoodsDao;
import com.yhxt.ddcl.dao.OrderRecordDao;
import com.yhxt.ddcl.entity.OrderDetail;
import com.yhxt.ddcl.entity.OrderGoods;
import com.yhxt.ddcl.entity.OrderRecord;
import com.yhxt.ddcl.service.OrderService;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.jgm.dao.CupboardDoorDetailSizeDao;
import com.yhxt.khxd.jgm.entity.CupboardDoorDetailSize;
import com.yhxt.khxd.xsm.dao.BlisterDetailDao;
import com.yhxt.khxd.xsm.dao.BlisterSizeDao;
import com.yhxt.khxd.xsm.dto.BlisterHistoryRecordDTO;
import com.yhxt.khxd.xsm.entity.BlisterDetail;
import com.yhxt.khxd.xsm.entity.BlisterSize;
import com.yhxt.khxd.xsm.service.BlisterService;
import com.yhxt.khxd.xsm.vo.BlisterAddParamVO;
import com.yhxt.khxd.xsm.vo.BlisterTodayDetailReturnVO;
import com.yhxt.khxd.xsm.vo.BlisterViewDetailVO;
import com.yhxt.utils.BaseTimeTransform;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BlisterServiceImpl
 * @Author zqi
 * @Date 2019/7/12 14:24
 * @Version 1.0
 * @Description 吸塑门
 */
@Service
public class BlisterServiceImpl implements BlisterService {

  @Resource
  private OrderService orderService;

  @Resource
  private OrderDetailDao orderDetailDao;

  @Resource
  private OrderGoodsDao orderGoodsDao;

  @Resource
  private OrderRecordDao orderRecordDao;

  @Resource
  private BlisterDetailDao blisterDetailDao;

  @Resource
  private BlisterSizeDao blisterSizeDao;

  @Resource
  private CupboardDoorDetailSizeDao cupboardDoorDetailSizeDao;

  private static Logger logger = Logger.getLogger(BlisterServiceImpl.class);

  /**
   * 添加
   *
   * @param blisterAddParamVO 参数
   * @return baseMessage 返回信息
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addData(BlisterAddParamVO blisterAddParamVO) {
    BlisterDetail blisterDetailToBeAdded = new BlisterDetail(blisterAddParamVO.getJe(), blisterAddParamVO.getHjpf(), blisterAddParamVO.getHjsl(), blisterAddParamVO.getYjdb());
    try {
      // 添加订单基本信息
      OrderDetail orderDetail = orderService.orderAddDataPreDeal(blisterAddParamVO);
      // 保存亚克力门信息表
      BlisterDetail blisterDetailAdded = blisterDetailDao.save(blisterDetailToBeAdded);
      // 保存订单-商品信息关联表
      OrderGoods orderGoodsToBeAdded = GoodsType.getBlister();
      orderGoodsToBeAdded.setDdid(orderDetail.getId());
      orderGoodsToBeAdded.setSpid(blisterDetailAdded.getId());
      orderGoodsToBeAdded.setZt(BaseStatus.VALID.getValue());
      orderGoodsDao.save(orderGoodsToBeAdded);
      for (BlisterSize blisterSizeToBeAdded : blisterAddParamVO.getBlisterSizes()) {
        // 保存尺寸信息
        BlisterSize blisterSizeAdded = blisterSizeDao.save(blisterSizeToBeAdded);
        // 保存商品信息-尺寸信息关联表
        cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(blisterDetailAdded.getId(), blisterSizeAdded.getId(), BaseStatus.VALID.getValue()));
      }
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 今日已下单-查询记录
   *
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getDataByToDay() {
    LocalDateTime startTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    try {
      List<BlisterHistoryRecordDTO> lists = blisterDetailDao.listDataToDay(
              BaseTimeTransform.localDateTimeToDate(startTime),
              BaseTimeTransform.localDateTimeToDate(endTime));
      return BaseMessage.success().add(this.doReturnInfo(lists));
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 查询今日已下单-处理返回结果
   *
   * @param lists 查询结果
   * @return vo
   */
  private BlisterTodayDetailReturnVO doReturnInfo(List<BlisterHistoryRecordDTO> lists) {
    Integer totalNum = 0;
    BigDecimal totalDoorSquare = new BigDecimal("0");
    Integer totalDoorNum = 0;
    Integer totalReworkNum = 0;
    BigDecimal totalReworkDoorSquare = new BigDecimal("0");
    Integer totalReworkDoorNum = 0;
    for (BlisterHistoryRecordDTO blisterHistoryRecordDTO : lists) {
      OrderDetail orderDetail = orderDetailDao.findByDdbh(blisterHistoryRecordDTO.getDdbh());
      Map<String, Object> map = orderService.getAccessoryListInfo(orderDetail.getId());
      blisterHistoryRecordDTO.setPj((StringBuilder) map.get("accessoryListInfo"));
      blisterHistoryRecordDTO.setPjje((BigDecimal) map.get("accessoryMoney"));
      if (blisterHistoryRecordDTO.getDdlx().equals(OrderType.ORDER_REWORK.getValue())) {
        //返工单
        totalReworkNum = totalReworkNum + 1;
        totalReworkDoorSquare = totalReworkDoorSquare.add(blisterHistoryRecordDTO.getHjpf());
        totalReworkDoorNum = totalReworkDoorNum + blisterHistoryRecordDTO.getHjsl();
      } else {
        // 新订单或者补单
        totalNum = totalNum + 1;
        totalDoorSquare = totalDoorSquare.add(blisterHistoryRecordDTO.getHjpf());
        totalDoorNum = totalDoorNum + blisterHistoryRecordDTO.getHjsl();
      }
    }
    return new BlisterTodayDetailReturnVO(totalNum, totalDoorSquare, totalDoorNum, totalReworkNum,
            totalReworkDoorSquare, totalReworkDoorNum, lists);
  }

  /**
   * 暂存订单-查询
   *
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getDataByTemporary() {
    try {
      List<BlisterHistoryRecordDTO> lists = blisterDetailDao.listDataTemporary();
      for (BlisterHistoryRecordDTO blisterHistoryRecordDTO : lists) {
        OrderDetail orderDetail = orderDetailDao.findByDdbh(blisterHistoryRecordDTO.getDdbh());
        Map<String, Object> map = orderService.getAccessoryListInfo(orderDetail.getId());
        blisterHistoryRecordDTO.setPj((StringBuilder) map.get("accessoryListInfo"));
        blisterHistoryRecordDTO.setPjje((BigDecimal) map.get("accessoryMoney"));
      }
      return BaseMessage.success().add(lists);
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 更新记录
   *
   * @param blisterAddParamVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage updateData(BlisterAddParamVO blisterAddParamVO) {
    LocalDateTime nowTime = LocalDateTime.now();
    OrderDetail orderDetail = orderDetailDao.findByDdbh(blisterAddParamVO.getDdbh());
    orderDetail.updateDetail(blisterAddParamVO.getDdlx(), blisterAddParamVO.getDdly(), blisterAddParamVO.getScsl(), blisterAddParamVO.getGq(),
            blisterAddParamVO.getKhxm(), blisterAddParamVO.getDz(), blisterAddParamVO.getDh(), blisterAddParamVO.getBz());
    OrderGoods orderGoods = orderGoodsDao.findByDdid(orderDetail.getId());
    BlisterDetail blisterDetail = blisterDetailDao.findById(orderGoods.getSpid());
    blisterDetail.updateDetail(blisterAddParamVO.getHjpf(), blisterAddParamVO.getHjsl(), blisterAddParamVO.getYjdb(), blisterAddParamVO.getJe());
    OrderRecord orderRecordToBeAdded = OrderRecordType.getUpdate();
    orderRecordToBeAdded.setDdid(orderDetail.getId());
    // TODO 获取当前登录角色信息
    orderRecordToBeAdded.setCzr("李四");
    orderRecordToBeAdded.setCzsj(BaseTimeTransform.localDateTimeToDate(nowTime));
    try {
      orderDetailDao.save(orderDetail);
      blisterDetailDao.save(blisterDetail);
      orderRecordDao.save(orderRecordToBeAdded);
      blisterSizeDao.save(blisterAddParamVO.getBlisterSizes());
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 根据订单编号查询详细信息
   *
   * @param ddbh 编号
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getDataByBh(String ddbh) {
    try {
      OrderDetail orderDetail = orderDetailDao.findByDdbh(ddbh);
      OrderGoods orderGoods = orderGoodsDao.findByDdid(orderDetail.getId());
      BlisterDetail blisterDetail = blisterDetailDao.findById(orderGoods.getSpid());
      List<CupboardDoorDetailSize> detailSizeLists = cupboardDoorDetailSizeDao.findByMbid(blisterDetail.getId());
      List<BlisterSize> sizeLists = new LinkedList<>();
      for (CupboardDoorDetailSize detailSize : detailSizeLists) {
        BlisterSize size = blisterSizeDao.findById(detailSize.getCcid());
        sizeLists.add(size);
      }
      Map<String, Object> map = orderService.getAccessoryListInfo(orderDetail.getId());
      return BaseMessage.success().add(new BlisterViewDetailVO(orderDetail, blisterDetail, sizeLists, (StringBuilder) map.get("accessoryListInfo")));
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 查询条件
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage condData(OrderQueryParamVO orderQueryParamVO) {
    PageCond pageCond = orderQueryParamVO.getPage();
    Pageable pageable = new PageRequest(pageCond.getPage(), pageCond.getPageSize());
    try {
      Page<BlisterHistoryRecordDTO> page = blisterDetailDao.condData(orderQueryParamVO, pageable);
      for (BlisterHistoryRecordDTO blisterHistoryRecordDTO : page.getContent()) {
        OrderDetail orderDetail = orderDetailDao.findByDdbh(blisterHistoryRecordDTO.getDdbh());
        Map<String, Object> map = orderService.getAccessoryListInfo(orderDetail.getId());
        blisterHistoryRecordDTO.setPj((StringBuilder) map.get("accessoryListInfo"));
        blisterHistoryRecordDTO.setPjje((BigDecimal) map.get("accessoryMoney"));
      }
      return BaseMessage.success().add(page);
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }
}
