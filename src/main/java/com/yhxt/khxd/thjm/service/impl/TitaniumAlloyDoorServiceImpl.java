package com.yhxt.khxd.thjm.service.impl;

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
import com.yhxt.khxd.thjm.dao.TitaniumAlloyDoorDetailDao;
import com.yhxt.khxd.thjm.dao.TitaniumAlloyDoorDetailSizeDao;
import com.yhxt.khxd.thjm.dao.TitaniumAlloyDoorHangingSizeDao;
import com.yhxt.khxd.thjm.dao.TitaniumAlloyDoorSwingSizeDao;
import com.yhxt.khxd.thjm.dto.TitaniumAlloyHistoryRecordDTO;
import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorDetail;
import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorDetailSize;
import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorHangingSize;
import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorSwingSize;
import com.yhxt.khxd.thjm.service.TitaniumAlloyDoorService;
import com.yhxt.khxd.thjm.vo.TitaniumAlloyDoorHangingAddParamVO;
import com.yhxt.khxd.thjm.vo.TitaniumAlloyDoorReturnInfoVO;
import com.yhxt.khxd.thjm.vo.TitaniumAlloyDoorSwingAddParamVO;
import com.yhxt.khxd.thjm.vo.TitaniumAlloyDoorViewDetailVO;
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

/**
 * @ClassName TitaniumAlloyDoorServiceImpl
 * @Author zqi
 * @Date 2019/7/9 13:07
 * @Version 1.0
 * @Description 钛合金门
 */
@Service
public class TitaniumAlloyDoorServiceImpl implements TitaniumAlloyDoorService {

  @Resource
  private OrderService orderService;

  @Resource
  private OrderDetailDao orderDetailDao;

  @Resource
  private OrderRecordDao orderRecordDao;

  @Resource
  private OrderGoodsDao orderGoodsDao;

  @Resource
  private TitaniumAlloyDoorDetailDao titaniumAlloyDoorDetailDao;

  @Resource
  private TitaniumAlloyDoorDetailSizeDao titaniumAlloyDoorDetailSizeDao;

  @Resource
  private TitaniumAlloyDoorHangingSizeDao titaniumAlloyDoorHangingSizeDao;

  @Resource
  private TitaniumAlloyDoorSwingSizeDao titaniumAlloyDoorSwingSizeDao;

  private static Logger logger = Logger.getLogger(TitaniumAlloyDoorServiceImpl.class);

  /**
   * 添加订单-平开门
   *
   * @param titaniumAlloyDoorSwingAddParamVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addDataSwing(TitaniumAlloyDoorSwingAddParamVO titaniumAlloyDoorSwingAddParamVO) {
    TitaniumAlloyDoorDetail titaniumAlloyDoorDetailToBeAdded = new TitaniumAlloyDoorDetail(titaniumAlloyDoorSwingAddParamVO.getHjje(),
            titaniumAlloyDoorSwingAddParamVO.getHjpf(),
            titaniumAlloyDoorSwingAddParamVO.getHjsl(),
            titaniumAlloyDoorSwingAddParamVO.getYjdb());
    try {
      // 添加订单基本信息
      OrderDetail orderDetail = orderService.orderAddDataPreDeal(titaniumAlloyDoorSwingAddParamVO);
      // 保存钛合金-吊趟门门信息表
      TitaniumAlloyDoorDetail titaniumAlloyDoorDetailAdded = titaniumAlloyDoorDetailDao.save(titaniumAlloyDoorDetailToBeAdded);
      // 保存订单-商品信息关联表
      OrderGoods orderGoodsToBeAdded = GoodsType.getTitaniumAlloyDoorSwing();
      orderGoodsToBeAdded.setDdid(orderDetail.getId());
      orderGoodsToBeAdded.setSpid(titaniumAlloyDoorDetailAdded.getId());
      orderGoodsToBeAdded.setZt(BaseStatus.VALID.getValue());
      orderGoodsDao.save(orderGoodsToBeAdded);
      for (TitaniumAlloyDoorSwingSize titaniumAlloyDoorSwingSize : titaniumAlloyDoorSwingAddParamVO.getSwingSizes()) {
        // 保存尺寸信息
        TitaniumAlloyDoorSwingSize titaniumAlloyDoorSwingSizeAdded = titaniumAlloyDoorSwingSizeDao.save(titaniumAlloyDoorSwingSize);
        // 保存商品信息-尺寸信息关联表
        titaniumAlloyDoorDetailSizeDao.save(new TitaniumAlloyDoorDetailSize(titaniumAlloyDoorDetailAdded.getId(), titaniumAlloyDoorSwingSizeAdded.getId(), BaseStatus.VALID.getValue()));
      }
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 添加订单-吊趟门
   *
   * @param titaniumAlloyDoorHangingAddParamVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addDataHanging(TitaniumAlloyDoorHangingAddParamVO titaniumAlloyDoorHangingAddParamVO) {
    TitaniumAlloyDoorDetail titaniumAlloyDoorDetailToBeAdded = new TitaniumAlloyDoorDetail(titaniumAlloyDoorHangingAddParamVO.getHjje(),
            titaniumAlloyDoorHangingAddParamVO.getHjpf(),
            titaniumAlloyDoorHangingAddParamVO.getHjsl(),
            titaniumAlloyDoorHangingAddParamVO.getYjdb());
    try {
      // 添加订单基本信息
      OrderDetail orderDetail = orderService.orderAddDataPreDeal(titaniumAlloyDoorHangingAddParamVO);
      // 保存钛合金-吊趟门信息表
      TitaniumAlloyDoorDetail titaniumAlloyDoorDetailAdded = titaniumAlloyDoorDetailDao.save(titaniumAlloyDoorDetailToBeAdded);
      // 保存订单-商品信息关联表
      OrderGoods orderGoodsToBeAdded = GoodsType.getTitaniumAlloyDoorHanging();
      orderGoodsToBeAdded.setDdid(orderDetail.getId());
      orderGoodsToBeAdded.setSpid(titaniumAlloyDoorDetailAdded.getId());
      orderGoodsToBeAdded.setZt(BaseStatus.VALID.getValue());
      orderGoodsDao.save(orderGoodsToBeAdded);
      for (TitaniumAlloyDoorHangingSize titaniumAlloyDoorHangingSize : titaniumAlloyDoorHangingAddParamVO.getHangingSizes()) {
        // 保存尺寸信息
        TitaniumAlloyDoorHangingSize titaniumAlloyDoorHangingSizeAdded = titaniumAlloyDoorHangingSizeDao.save(titaniumAlloyDoorHangingSize);
        // 保存商品信息-尺寸信息关联表
        titaniumAlloyDoorDetailSizeDao.save(new TitaniumAlloyDoorDetailSize(titaniumAlloyDoorDetailAdded.getId(), titaniumAlloyDoorHangingSizeAdded.getId(), BaseStatus.VALID.getValue()));
      }
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 更新订单-平开门
   *
   * @param titaniumAlloyDoorSwingAddParamVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage updateDataSwing(TitaniumAlloyDoorSwingAddParamVO titaniumAlloyDoorSwingAddParamVO) {
    LocalDateTime nowTime = LocalDateTime.now();
    OrderDetail orderDetail = orderDetailDao.findByDdbh(titaniumAlloyDoorSwingAddParamVO.getDdbh());
    orderDetail.updateDetail(titaniumAlloyDoorSwingAddParamVO.getDdlx(), titaniumAlloyDoorSwingAddParamVO.getDdly(), titaniumAlloyDoorSwingAddParamVO.getScsl(),
            titaniumAlloyDoorSwingAddParamVO.getGq(), titaniumAlloyDoorSwingAddParamVO.getKhxm(), titaniumAlloyDoorSwingAddParamVO.getDz(),
            titaniumAlloyDoorSwingAddParamVO.getDh(), titaniumAlloyDoorSwingAddParamVO.getBz());
    OrderGoods orderGoods = orderGoodsDao.findByDdid(orderDetail.getId());
    TitaniumAlloyDoorDetail titaniumAlloyDoorDetail = titaniumAlloyDoorDetailDao.findById(orderGoods.getSpid());
    titaniumAlloyDoorDetail.updateDetail(titaniumAlloyDoorSwingAddParamVO.getHjje(),
            titaniumAlloyDoorSwingAddParamVO.getHjpf(),
            titaniumAlloyDoorSwingAddParamVO.getHjsl(),
            titaniumAlloyDoorSwingAddParamVO.getYjdb());
    OrderRecord orderRecordToBeAdded = OrderRecordType.getUpdate();
    orderRecordToBeAdded.setDdid(orderDetail.getId());
    // TODO 获取当前登录角色信息
    orderRecordToBeAdded.setCzr("李四");
    orderRecordToBeAdded.setCzsj(BaseTimeTransform.localDateTimeToDate(nowTime));
    try {
      orderDetailDao.save(orderDetail);
      titaniumAlloyDoorDetailDao.save(titaniumAlloyDoorDetail);
      orderRecordDao.save(orderRecordToBeAdded);
      titaniumAlloyDoorSwingSizeDao.save(titaniumAlloyDoorSwingAddParamVO.getSwingSizes());
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 更新订单-吊趟门
   *
   * @param titaniumAlloyDoorHangingAddParamVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage updateDataHanging(TitaniumAlloyDoorHangingAddParamVO titaniumAlloyDoorHangingAddParamVO) {
    LocalDateTime nowTime = LocalDateTime.now();
    OrderDetail orderDetail = orderDetailDao.findByDdbh(titaniumAlloyDoorHangingAddParamVO.getDdbh());
    orderDetail.updateDetail(titaniumAlloyDoorHangingAddParamVO.getDdlx(), titaniumAlloyDoorHangingAddParamVO.getDdly(), titaniumAlloyDoorHangingAddParamVO.getScsl(),
            titaniumAlloyDoorHangingAddParamVO.getGq(), titaniumAlloyDoorHangingAddParamVO.getKhxm(), titaniumAlloyDoorHangingAddParamVO.getDz(),
            titaniumAlloyDoorHangingAddParamVO.getDh(), titaniumAlloyDoorHangingAddParamVO.getBz());
    OrderGoods orderGoods = orderGoodsDao.findByDdid(orderDetail.getId());
    TitaniumAlloyDoorDetail titaniumAlloyDoorDetail = titaniumAlloyDoorDetailDao.findById(orderGoods.getSpid());
    titaniumAlloyDoorDetail.updateDetail(titaniumAlloyDoorHangingAddParamVO.getHjje(),
            titaniumAlloyDoorHangingAddParamVO.getHjpf(),
            titaniumAlloyDoorHangingAddParamVO.getHjsl(),
            titaniumAlloyDoorHangingAddParamVO.getYjdb());
    OrderRecord orderRecordToBeAdded = OrderRecordType.getUpdate();
    orderRecordToBeAdded.setDdid(orderDetail.getId());
    // TODO 获取当前登录角色信息
    orderRecordToBeAdded.setCzr("李四");
    orderRecordToBeAdded.setCzsj(BaseTimeTransform.localDateTimeToDate(nowTime));
    try {
      orderDetailDao.save(orderDetail);
      titaniumAlloyDoorDetailDao.save(titaniumAlloyDoorDetail);
      orderRecordDao.save(orderRecordToBeAdded);
      titaniumAlloyDoorHangingSizeDao.save(titaniumAlloyDoorHangingAddParamVO.getHangingSizes());
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 根据编号查询记录
   *
   * @param ddbh 订单编号
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getDataByBh(String ddbh) {
    try {
      OrderDetail orderDetail = orderDetailDao.findByDdbh(ddbh);
      OrderGoods orderGoods = orderGoodsDao.findByDdid(orderDetail.getId());
      TitaniumAlloyDoorDetail titaniumAlloyDoorDetail = titaniumAlloyDoorDetailDao.findById(orderGoods.getSpid());
      List<TitaniumAlloyDoorDetailSize> detailSizeLists = titaniumAlloyDoorDetailSizeDao.findByTjid(titaniumAlloyDoorDetail.getId());
      StringBuilder accessoryListInfo = orderService.getAccessoryListInfo(orderDetail.getId());
      TitaniumAlloyDoorViewDetailVO titaniumAlloyDoorViewDetailVO = new TitaniumAlloyDoorViewDetailVO(orderDetail, titaniumAlloyDoorDetail, accessoryListInfo);
      if (orderGoods.getSplx().equals(GoodsType.TITANIUM_ALLOY_DOOR_HANGING.getValue())) {
        // 吊趟门
        List<TitaniumAlloyDoorHangingSize> sizeLists = new LinkedList<>();
        for (TitaniumAlloyDoorDetailSize titaniumAlloyDoorDetailSize : detailSizeLists) {
          TitaniumAlloyDoorHangingSize size = titaniumAlloyDoorHangingSizeDao.findById(titaniumAlloyDoorDetailSize.getCcid());
          sizeLists.add(size);
        }
        titaniumAlloyDoorViewDetailVO.setHangingSizeList(sizeLists);
      } else {
        // 平开门
        List<TitaniumAlloyDoorSwingSize> sizeLists = new LinkedList<>();
        for (TitaniumAlloyDoorDetailSize titaniumAlloyDoorDetailSize : detailSizeLists) {
          TitaniumAlloyDoorSwingSize size = titaniumAlloyDoorSwingSizeDao.findById(titaniumAlloyDoorDetailSize.getCcid());
          sizeLists.add(size);
        }
        titaniumAlloyDoorViewDetailVO.setSwingSizeList(sizeLists);
      }
      return BaseMessage.success().add(titaniumAlloyDoorViewDetailVO);
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
      List<TitaniumAlloyHistoryRecordDTO> lists = titaniumAlloyDoorDetailDao.getDataByToDay(
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
  private TitaniumAlloyDoorReturnInfoVO doReturnInfo(List<TitaniumAlloyHistoryRecordDTO> lists) {
    Integer totalSwingNum = 0;
    BigDecimal totalSwingSquare = new BigDecimal("0");
    Integer totalSwingDoorNum = 0;
    Integer totalHangingNum = 0;
    BigDecimal totalHangingSquare = new BigDecimal("0");
    Integer totalHangingDoorNum = 0;
    Integer totalReworkSwingNum = 0;
    BigDecimal totalReworkSwingSquare = new BigDecimal("0");
    Integer totalReworkSwingDoorNum = 0;
    Integer totalReworkHangingNum = 0;
    BigDecimal totalReworkHangingSquare = new BigDecimal("0");
    Integer totalReworkHangingDoorNum = 0;
    for (TitaniumAlloyHistoryRecordDTO titaniumAlloyHistoryRecordDTO : lists) {
      OrderDetail orderDetail = orderDetailDao.findByDdbh(titaniumAlloyHistoryRecordDTO.getDdbh());
      StringBuilder accessoryListInfo = orderService.getAccessoryListInfo(orderDetail.getId());
      titaniumAlloyHistoryRecordDTO.setPj(accessoryListInfo);
      if (titaniumAlloyHistoryRecordDTO.getDdlx().equals(OrderType.ORDER_REWORK.getValue())) {
        //返工
        if (titaniumAlloyHistoryRecordDTO.getSplx().equals(GoodsType.TITANIUM_ALLOY_DOOR_HANGING.getValue())) {
          // 吊趟门
          totalReworkHangingNum = totalReworkHangingNum + 1;
          totalReworkHangingSquare = totalReworkHangingSquare.add(titaniumAlloyHistoryRecordDTO.getHjpf());
          totalReworkHangingDoorNum = totalReworkHangingDoorNum + titaniumAlloyHistoryRecordDTO.getHjsl();
        } else {
          // 平开门
          totalReworkSwingNum = totalReworkSwingNum + 1;
          totalReworkSwingSquare = totalReworkSwingSquare.add(titaniumAlloyHistoryRecordDTO.getHjpf());
          totalReworkSwingDoorNum = totalReworkSwingDoorNum + titaniumAlloyHistoryRecordDTO.getHjsl();
        }
      } else {
        //新订单或补单
        if (titaniumAlloyHistoryRecordDTO.getSplx().equals(GoodsType.TITANIUM_ALLOY_DOOR_HANGING.getValue())) {
          // 吊趟门
          totalHangingNum = totalHangingNum + 1;
          totalHangingSquare = totalHangingSquare.add(titaniumAlloyHistoryRecordDTO.getHjpf());
          totalHangingDoorNum = totalHangingDoorNum + titaniumAlloyHistoryRecordDTO.getHjsl();
        } else {
          // 平开门
          totalSwingNum = totalSwingNum + 1;
          totalSwingSquare = totalSwingSquare.add(titaniumAlloyHistoryRecordDTO.getHjpf());
          totalSwingDoorNum = totalSwingDoorNum + titaniumAlloyHistoryRecordDTO.getHjsl();
        }
      }
    }
    return new TitaniumAlloyDoorReturnInfoVO(totalSwingNum, totalSwingSquare, totalSwingDoorNum, totalHangingNum, totalHangingSquare, totalHangingDoorNum, totalReworkSwingNum, totalReworkSwingSquare, totalReworkSwingDoorNum, totalReworkHangingNum, totalReworkHangingSquare, totalReworkHangingDoorNum, lists);
  }

  /**
   * 暂存订单-查询记录
   *
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getDataByTemporary() {
    try {
      List<TitaniumAlloyHistoryRecordDTO> lists = titaniumAlloyDoorDetailDao.getDataByTemporary();
      for (TitaniumAlloyHistoryRecordDTO titaniumAlloyHistoryRecordDTO : lists) {
        OrderDetail orderDetail = orderDetailDao.findByDdbh(titaniumAlloyHistoryRecordDTO.getDdbh());
        StringBuilder accessoryListInfo = orderService.getAccessoryListInfo(orderDetail.getId());
        titaniumAlloyHistoryRecordDTO.setPj(accessoryListInfo);
      }
      return BaseMessage.success().add(lists);
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
      Page<TitaniumAlloyHistoryRecordDTO> page = titaniumAlloyDoorDetailDao.condData(orderQueryParamVO, pageable);
      for (TitaniumAlloyHistoryRecordDTO titaniumAlloyHistoryRecordDTO : page.getContent()) {
        OrderDetail orderDetail = orderDetailDao.findByDdbh(titaniumAlloyHistoryRecordDTO.getDdbh());
        StringBuilder accessoryListInfo = orderService.getAccessoryListInfo(orderDetail.getId());
        titaniumAlloyHistoryRecordDTO.setPj(accessoryListInfo);
      }
      return BaseMessage.success().add(page);
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }
}
