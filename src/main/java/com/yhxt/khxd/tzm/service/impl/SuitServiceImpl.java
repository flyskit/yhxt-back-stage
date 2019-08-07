package com.yhxt.khxd.tzm.service.impl;

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
import com.yhxt.khxd.tzm.common.SuitDoorType;
import com.yhxt.khxd.tzm.dao.*;
import com.yhxt.khxd.tzm.dto.SuitHistoryRecordDTO;
import com.yhxt.khxd.tzm.entity.*;
import com.yhxt.khxd.tzm.service.SuitService;
import com.yhxt.khxd.tzm.vo.SuitAddParamVO;
import com.yhxt.khxd.tzm.vo.SuitReturnInfoVO;
import com.yhxt.khxd.tzm.vo.SuitViewDetailVO;
import com.yhxt.utils.BaseTimeTransform;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SuitServiceImpl
 * @Author zqi
 * @Date 2019/7/17 10:34
 * @Version 1.0
 * @Description 套装门
 */
@Service
public class SuitServiceImpl implements SuitService {

  @Resource
  private OrderService orderService;

  @Resource
  private OrderDetailDao orderDetailDao;

  @Resource
  private OrderGoodsDao orderGoodsDao;

  @Resource
  private OrderRecordDao orderRecordDao;

  @Resource
  private SuitDetailDao suitDetailDao;

  @Resource
  private SuitDetailTypeDao suitDetailTypeDao;

  @Resource
  private SuitSwingSizeDao suitSwingSizeDao;

  @Resource
  private SuitHangingSizeDao suitHangingSizeDao;

  @Resource
  private SuitPocketDetailDao suitPocketDetailDao;

  @Resource
  private SuitLineDetailDao suitLineDetailDao;

  @Resource
  private CupboardDoorDetailSizeDao cupboardDoorDetailSizeDao;

  private static Logger logger = Logger.getLogger(SuitServiceImpl.class);

  /**
   * 添加
   *
   * @param suitAddParamVO 参数
   * @return baseMessage 返回信息
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addData(SuitAddParamVO suitAddParamVO) {
    SuitDetail suitDetailToBeAdded = new SuitDetail(suitAddParamVO.getMblx(), suitAddParamVO.getPkmms(), suitAddParamVO.getPkmts(), suitAddParamVO.getTmms(),
            suitAddParamVO.getTmts(), suitAddParamVO.getHjmt(), suitAddParamVO.getHjxt(), suitAddParamVO.getJe(), suitAddParamVO.getYjdb());
    try {
      OrderDetail orderDetail = orderService.orderAddDataPreDeal(suitAddParamVO);
      SuitDetail suitDetailAdded = suitDetailDao.save(suitDetailToBeAdded);
      OrderGoods orderGoodsToBeAdded;
      if (suitAddParamVO.getMblx().equals(GoodsType.ENHANCED_DOOR.getValue())) {
        orderGoodsToBeAdded = GoodsType.getEnhancedDoor();
      } else if (suitAddParamVO.getMblx().equals(GoodsType.SOLID_WOOD_PANEL.getValue())) {
        orderGoodsToBeAdded = GoodsType.getSolidWoodPanel();
      } else if (suitAddParamVO.getMblx().equals(GoodsType.LOG_DOOR.getValue())) {
        orderGoodsToBeAdded = GoodsType.getLogDoor();
      } else {
        orderGoodsToBeAdded = GoodsType.getUnconventionalDoor();
      }
      orderGoodsToBeAdded.setDdid(orderDetail.getId());
      orderGoodsToBeAdded.setSpid(suitDetailAdded.getId());
      orderGoodsToBeAdded.setZt(BaseStatus.VALID.getValue());
      orderGoodsDao.save(orderGoodsToBeAdded);
      if (!StringUtils.isEmpty(suitAddParamVO.getSwingSizes())) {
        SuitDetailType suitDetailTypeToBeAdded = SuitDoorType.getSwing();
        suitDetailTypeToBeAdded.setMbid(suitDetailAdded.getId());
        SuitDetailType suitDetailTypeAdded = suitDetailTypeDao.save(suitDetailTypeToBeAdded);
        for (SuitSwingSize suitSwingSize : suitAddParamVO.getSwingSizes()) {
          SuitSwingSize suitSwingSizeAdded = suitSwingSizeDao.save(suitSwingSize);
          cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(suitDetailTypeAdded.getId(), suitSwingSizeAdded.getId(), BaseStatus.VALID.getValue()));
        }
      }
      if (!StringUtils.isEmpty(suitAddParamVO.getHangingSizes())) {
        SuitDetailType suitDetailTypeToBeAdded = SuitDoorType.getHanging();
        suitDetailTypeToBeAdded.setMbid(suitDetailAdded.getId());
        SuitDetailType suitDetailTypeAdded = suitDetailTypeDao.save(suitDetailTypeToBeAdded);
        for (SuitHangingSize suitHangingSize : suitAddParamVO.getHangingSizes()) {
          SuitHangingSize suitHangingSizeAdded = suitHangingSizeDao.save(suitHangingSize);
          cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(suitDetailTypeAdded.getId(), suitHangingSizeAdded.getId(), BaseStatus.VALID.getValue()));
        }
      }
      if (!StringUtils.isEmpty(suitAddParamVO.getPocketDetails())) {
        SuitDetailType suitDetailTypeToBeAdded = SuitDoorType.getPocket();
        suitDetailTypeToBeAdded.setMbid(suitDetailAdded.getId());
        SuitDetailType suitDetailTypeAdded = suitDetailTypeDao.save(suitDetailTypeToBeAdded);
        for (SuitPocketDetail suitPocketDetail : suitAddParamVO.getPocketDetails()) {
          SuitPocketDetail suitPocketDetailAdded = suitPocketDetailDao.save(suitPocketDetail);
          cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(suitDetailTypeAdded.getId(), suitPocketDetailAdded.getId(), BaseStatus.VALID.getValue()));
        }
      }
      if (!StringUtils.isEmpty(suitAddParamVO.getLineDetails())) {
        SuitDetailType suitDetailTypeToBeAdded = SuitDoorType.getLine();
        suitDetailTypeToBeAdded.setMbid(suitDetailAdded.getId());
        SuitDetailType suitDetailTypeAdded = suitDetailTypeDao.save(suitDetailTypeToBeAdded);
        for (SuitLineDetail suitLineDetail : suitAddParamVO.getLineDetails()) {
          SuitLineDetail suitLineDetailAdded = suitLineDetailDao.save(suitLineDetail);
          cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(suitDetailTypeAdded.getId(), suitLineDetailAdded.getId(), BaseStatus.VALID.getValue()));
        }
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
      List<SuitHistoryRecordDTO> lists = suitDetailDao.listDataToDay(
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
  private SuitReturnInfoVO doReturnInfo(List<SuitHistoryRecordDTO> lists) {
    Integer totalSwingNum = 0, totalSwingDoorNum = 0, totalHangingNum = 0, totalHangingDoorNum = 0, totalPocketNum = 0, totalLineNum = 0;
    Integer totalReworkSwingNum = 0, totalReworkSwingDoorNum = 0, totalReworkHangingNum = 0, totalReworkHangingDoorNum = 0, totalReworkPocketNum = 0, totalReworkLineNum = 0;
    for (SuitHistoryRecordDTO suitHistoryRecordDTO : lists) {
      OrderDetail orderDetail = orderDetailDao.findByDdbh(suitHistoryRecordDTO.getDdbh());
      Map<String, Object> map = orderService.getAccessoryListInfo(orderDetail.getId());
      suitHistoryRecordDTO.setPj((StringBuilder) map.get("accessoryListInfo"));
      suitHistoryRecordDTO.setPjje((BigDecimal) map.get("accessoryMoney"));
      if (suitHistoryRecordDTO.getDdlx().equals(OrderType.ORDER_REWORK.getValue())) {
        //返工单
        totalReworkSwingNum += suitHistoryRecordDTO.getPkmts();
        totalReworkSwingDoorNum += suitHistoryRecordDTO.getPkmms();
        totalReworkHangingNum += suitHistoryRecordDTO.getTmts();
        totalReworkHangingDoorNum += suitHistoryRecordDTO.getTmms();
        totalReworkPocketNum += suitHistoryRecordDTO.getHjmt();
        totalReworkLineNum += suitHistoryRecordDTO.getHjxt();
      } else {
        // 新订单或者补单
        totalSwingNum += suitHistoryRecordDTO.getPkmts();
        totalSwingDoorNum += suitHistoryRecordDTO.getPkmms();
        totalHangingNum += suitHistoryRecordDTO.getTmts();
        totalHangingDoorNum += suitHistoryRecordDTO.getTmms();
        totalPocketNum += suitHistoryRecordDTO.getHjmt();
        totalLineNum = totalLineNum + suitHistoryRecordDTO.getHjxt();
      }
    }
    return new SuitReturnInfoVO(totalSwingNum, totalSwingDoorNum, totalHangingNum, totalHangingDoorNum, totalPocketNum, totalLineNum,
            totalReworkSwingNum, totalReworkSwingDoorNum, totalReworkHangingNum, totalReworkHangingDoorNum, totalReworkPocketNum, totalReworkLineNum, lists);
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
      List<SuitHistoryRecordDTO> lists = suitDetailDao.listDataTemporary();
      for (SuitHistoryRecordDTO suitHistoryRecordDTO : lists) {
        OrderDetail orderDetail = orderDetailDao.findByDdbh(suitHistoryRecordDTO.getDdbh());
        Map<String, Object> map = orderService.getAccessoryListInfo(orderDetail.getId());
        suitHistoryRecordDTO.setPj((StringBuilder) map.get("accessoryListInfo"));
        suitHistoryRecordDTO.setPjje((BigDecimal) map.get("accessoryMoney"));
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
   * @param suitAddParamVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage updateData(SuitAddParamVO suitAddParamVO) {
    SuitViewDetailVO suitViewDetailVO = this.getDetail(suitAddParamVO.getDdbh());
    LinkedList<SuitSwingSize> suitSwingSizeListOld = suitViewDetailVO.getSwingSizeList();
    LinkedList<SuitHangingSize> suitHangingSizeListOld = suitViewDetailVO.getHangingSizeList();
    LinkedList<SuitPocketDetail> suitPocketDetailListOld = suitViewDetailVO.getSuitPocketDetailList();
    LinkedList<SuitLineDetail> suitLineDetailListOld = suitViewDetailVO.getSuitLineDetailsList();
    LinkedList<SuitSwingSize> suitSwingSizeList = suitAddParamVO.getSwingSizes();
    LinkedList<SuitHangingSize> suitHangingSizeList = suitAddParamVO.getHangingSizes();
    LinkedList<SuitPocketDetail> suitPocketDetailList = suitAddParamVO.getPocketDetails();
    LinkedList<SuitLineDetail> suitLineDetailList = suitAddParamVO.getLineDetails();
    OrderDetail orderDetailOld = suitViewDetailVO.getOrderDetail();
    orderDetailOld.updateDetail(suitAddParamVO.getDdlx(), suitAddParamVO.getDdly(), suitAddParamVO.getScsl(), suitAddParamVO.getGq(),
            suitAddParamVO.getKhxm(), suitAddParamVO.getDz(), suitAddParamVO.getDh(), suitAddParamVO.getBz());
    SuitDetail suitDetailOld = suitViewDetailVO.getSuitDetail();
    suitDetailOld.updateDetail(suitAddParamVO.getMblx(), suitAddParamVO.getPkmms(), suitAddParamVO.getPkmts(), suitAddParamVO.getTmms(),
            suitAddParamVO.getTmts(), suitAddParamVO.getHjmt(), suitAddParamVO.getHjxt(), suitAddParamVO.getJe(), suitAddParamVO.getYjdb());
    OrderRecord orderRecordToBeAdded = OrderRecordType.getUpdate();
    orderRecordToBeAdded.setDdid(orderDetailOld.getId());
    // TODO 获取当前登录角色信息
    orderRecordToBeAdded.setCzr("李四");
    orderRecordToBeAdded.setCzsj(BaseTimeTransform.localDateTimeToDate(LocalDateTime.now()));
    try {
      if (!suitLineDetailListOld.equals(suitLineDetailList)) {
        this.updateLine(suitLineDetailListOld, suitLineDetailList, suitDetailOld.getId());
      }
      if (!suitPocketDetailListOld.equals(suitPocketDetailList)) {
        this.updatePocket(suitPocketDetailListOld, suitPocketDetailList, suitDetailOld.getId());
      }
      if (!suitHangingSizeListOld.equals(suitHangingSizeList)) {
        this.updateHanging(suitHangingSizeListOld, suitHangingSizeList, suitDetailOld.getId());
      }
      if (!suitSwingSizeListOld.equals(suitSwingSizeList)) {
        this.updateSwing(suitSwingSizeListOld, suitSwingSizeList, suitDetailOld.getId());
      }
      orderDetailDao.save(orderDetailOld);
      suitDetailDao.save(suitDetailOld);
      orderRecordDao.save(orderRecordToBeAdded);
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 更新线条尺寸信息
   *
   * @param suitLineDetailListOld 历史列表
   * @param suitLineDetailList    新列表
   * @param suitDetailId          统计信息id
   */
  private void updateLine(LinkedList<SuitLineDetail> suitLineDetailListOld, LinkedList<SuitLineDetail> suitLineDetailList, String suitDetailId) {
    if (suitLineDetailListOld.size() < suitLineDetailList.size()) {
      // 增加
      for (SuitLineDetail suitLineDetail : suitLineDetailList) {
        Boolean flag = false;
        for (SuitLineDetail suitLineDetailOld : suitLineDetailListOld) {
          if (suitLineDetailOld.getId().equals(suitLineDetail.getId())) {
            suitLineDetailDao.save(suitLineDetail);
            flag = true;
            break;
          }
        }
        if (!flag) {
          SuitDetailType suitDetailTypeToBeAdded = SuitDoorType.getLine();
          suitDetailTypeToBeAdded.setMbid(suitDetailId);
          SuitDetailType suitDetailTypeAdded = suitDetailTypeDao.save(suitDetailTypeToBeAdded);
          SuitLineDetail suitLineDetailAdded = suitLineDetailDao.save(suitLineDetail);
          cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(suitDetailTypeAdded.getId(), suitLineDetailAdded.getId(), BaseStatus.VALID.getValue()));
        }
      }
    } else if (suitLineDetailListOld.size() > suitLineDetailList.size()) {
      // 删除
      for (SuitLineDetail suitLineDetailOld : suitLineDetailListOld) {
        Boolean flag = false;
        for (SuitLineDetail suitLineDetail : suitLineDetailList) {
          if (suitLineDetailOld.getId().equals(suitLineDetail.getId())) {
            suitLineDetailDao.save(suitLineDetail);
            flag = true;
            break;
          }
        }
        if (!flag) {
          this.delDetailSize(suitLineDetailOld.getId());
        }
      }
    } else {
      // 修改
      suitLineDetailDao.save(suitLineDetailList);
    }
  }

  /**
   * 更新空套尺寸信息
   *
   * @param suitPocketDetailListOld 历史列表
   * @param suitPocketDetailList    新列表
   * @param suitDetailId            统计信息id
   */
  private void updatePocket(LinkedList<SuitPocketDetail> suitPocketDetailListOld, LinkedList<SuitPocketDetail> suitPocketDetailList, String suitDetailId) {
    if (suitPocketDetailListOld.size() < suitPocketDetailList.size()) {
      // 增加
      for (SuitPocketDetail suitPocketDetail : suitPocketDetailList) {
        Boolean flag = false;
        for (SuitPocketDetail suitPocketDetailOld : suitPocketDetailListOld) {
          if (suitPocketDetailOld.getId().equals(suitPocketDetail.getId())) {
            suitPocketDetailDao.save(suitPocketDetail);
            flag = true;
            break;
          }
        }
        if (!flag) {
          SuitDetailType suitDetailTypeToBeAdded = SuitDoorType.getPocket();
          suitDetailTypeToBeAdded.setMbid(suitDetailId);
          SuitDetailType suitDetailTypeAdded = suitDetailTypeDao.save(suitDetailTypeToBeAdded);
          SuitPocketDetail suitPocketDetailAdded = suitPocketDetailDao.save(suitPocketDetail);
          cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(suitDetailTypeAdded.getId(), suitPocketDetailAdded.getId(), BaseStatus.VALID.getValue()));
        }
      }
    } else if (suitPocketDetailListOld.size() > suitPocketDetailList.size()) {
      // 删除
      for (SuitPocketDetail suitPocketDetailOld : suitPocketDetailListOld) {
        Boolean flag = false;
        for (SuitPocketDetail suitPocketDetail : suitPocketDetailList) {
          if (suitPocketDetailOld.getId().equals(suitPocketDetail.getId())) {
            suitPocketDetailDao.save(suitPocketDetail);
            flag = true;
            break;
          }
        }
        if (!flag) {
          this.delDetailSize(suitPocketDetailOld.getId());
        }
      }
    } else {
      // 修改
      suitPocketDetailDao.save(suitPocketDetailList);
    }
  }

  /**
   * 更新推门尺寸信息
   *
   * @param suitHangingSizeListOld 历史列表
   * @param suitHangingSizeList    新列表
   * @param suitDetailId           统计信息id
   */
  private void updateHanging(LinkedList<SuitHangingSize> suitHangingSizeListOld, LinkedList<SuitHangingSize> suitHangingSizeList, String suitDetailId) {
    if (suitHangingSizeListOld.size() < suitHangingSizeList.size()) {
      // 增加
      for (SuitHangingSize suitHangingSize : suitHangingSizeList) {
        Boolean flag = false;
        for (SuitHangingSize suitHangingSizeOld : suitHangingSizeListOld) {
          if (suitHangingSizeOld.getId().equals(suitHangingSize.getId())) {
            suitHangingSizeDao.save(suitHangingSize);
            flag = true;
            break;
          }
        }
        if (!flag) {
          SuitDetailType suitDetailTypeToBeAdded = SuitDoorType.getHanging();
          suitDetailTypeToBeAdded.setMbid(suitDetailId);
          SuitDetailType suitDetailTypeAdded = suitDetailTypeDao.save(suitDetailTypeToBeAdded);
          SuitHangingSize suitHangingSizeAdded = suitHangingSizeDao.save(suitHangingSize);
          cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(suitDetailTypeAdded.getId(), suitHangingSizeAdded.getId(), BaseStatus.VALID.getValue()));
        }
      }
    } else if (suitHangingSizeListOld.size() > suitHangingSizeList.size()) {
      // 删除
      for (SuitHangingSize suitHangingSizeOld : suitHangingSizeListOld) {
        Boolean flag = false;
        for (SuitHangingSize suitHangingSize : suitHangingSizeList) {
          if (suitHangingSizeOld.getId().equals(suitHangingSize.getId())) {
            suitHangingSizeDao.save(suitHangingSize);
            flag = true;
            break;
          }
        }
        if (!flag) {
          this.delDetailSize(suitHangingSizeOld.getId());
        }
      }
    } else {
      // 修改
      suitHangingSizeDao.save(suitHangingSizeList);
    }
  }

  /**
   * 更新平开门尺寸信息
   *
   * @param suitSwingSizeListOld 历史列表
   * @param suitSwingSizeList    新列表
   * @param suitDetailId         统计信息id
   */
  private void updateSwing(LinkedList<SuitSwingSize> suitSwingSizeListOld, LinkedList<SuitSwingSize> suitSwingSizeList, String suitDetailId) {
    if (suitSwingSizeListOld.size() < suitSwingSizeList.size()) {
      // 增加
      for (SuitSwingSize suitSwingSize : suitSwingSizeList) {
        Boolean flag = false;
        for (SuitSwingSize suitSwingSizeOld : suitSwingSizeListOld) {
          if (suitSwingSizeOld.getId().equals(suitSwingSize.getId())) {
            suitSwingSizeDao.save(suitSwingSize);
            flag = true;
            break;
          }
        }
        if (!flag) {
          SuitDetailType suitDetailTypeToBeAdded = SuitDoorType.getSwing();
          suitDetailTypeToBeAdded.setMbid(suitDetailId);
          SuitDetailType suitDetailTypeAdded = suitDetailTypeDao.save(suitDetailTypeToBeAdded);
          SuitSwingSize suitSwingSizeAdded = suitSwingSizeDao.save(suitSwingSize);
          cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(suitDetailTypeAdded.getId(), suitSwingSizeAdded.getId(), BaseStatus.VALID.getValue()));
        }
      }
    } else if (suitSwingSizeListOld.size() > suitSwingSizeList.size()) {
      // 删除
      for (SuitSwingSize suitSwingSizeOld : suitSwingSizeListOld) {
        Boolean flag = false;
        for (SuitSwingSize suitSwingSize : suitSwingSizeList) {
          if (suitSwingSizeOld.getId().equals(suitSwingSize.getId())) {
            suitSwingSizeDao.save(suitSwingSize);
            flag = true;
            break;
          }
        }
        if (!flag) {
          this.delDetailSize(suitSwingSizeOld.getId());
        }
      }
    } else {
      // 修改
      suitSwingSizeDao.save(suitSwingSizeList);
    }
  }

  /**
   * 删除关联尺寸记录
   *
   * @param ccid ccid标识
   */
  private void delDetailSize(String ccid) {
    CupboardDoorDetailSize cupboardDoorDetailSize = cupboardDoorDetailSizeDao.findByCcidAndZt(ccid, BaseStatus.VALID.getValue());
    cupboardDoorDetailSize.setZt(BaseStatus.INVALID.getValue());
    cupboardDoorDetailSizeDao.save(cupboardDoorDetailSize);
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
      SuitViewDetailVO suitViewDetailVO = this.getDetail(ddbh);
      Map<String, Object> map = orderService.getAccessoryListInfo(suitViewDetailVO.getOrderDetail().getId());
      suitViewDetailVO.setAccessoryListInfo((StringBuilder) map.get("accessoryListInfo"));
      return BaseMessage.success().add(suitViewDetailVO);
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 获取详细信息
   *
   * @param ddbh 订单编号
   * @return suitViewDetailVO
   */
  private SuitViewDetailVO getDetail(String ddbh) {
    OrderDetail orderDetail = orderDetailDao.findByDdbh(ddbh);
    OrderGoods orderGoods = orderGoodsDao.findByDdid(orderDetail.getId());
    SuitDetail suitDetail = suitDetailDao.findById(orderGoods.getSpid());
    LinkedList<SuitDetailType> suitDetailTypeList = suitDetailTypeDao.findByMbidAndZt(suitDetail.getId(), BaseStatus.VALID.getValue());
    LinkedList<SuitSwingSize> suitSwingSizeList = new LinkedList<>();
    LinkedList<SuitHangingSize> suitHangingSizeList = new LinkedList<>();
    LinkedList<SuitPocketDetail> suitPocketDetailList = new LinkedList<>();
    LinkedList<SuitLineDetail> suitLineDetailList = new LinkedList<>();
    for (SuitDetailType suitDetailType : suitDetailTypeList) {
      List<CupboardDoorDetailSize> detailSizeLists = cupboardDoorDetailSizeDao.findByMbidAndZt(suitDetailType.getId(), BaseStatus.VALID.getValue());
      if (suitDetailType.getCclx().equals(SuitDoorType.TYPE_SWING.getValue())) {
        for (CupboardDoorDetailSize detailSize : detailSizeLists) {
          SuitSwingSize size = suitSwingSizeDao.findById(detailSize.getCcid());
          suitSwingSizeList.add(size);
        }
      }
      if (suitDetailType.getCclx().equals(SuitDoorType.TYPE_HANGING.getValue())) {
        for (CupboardDoorDetailSize detailSize : detailSizeLists) {
          SuitHangingSize size = suitHangingSizeDao.findById(detailSize.getCcid());
          suitHangingSizeList.add(size);
        }
      }
      if (suitDetailType.getCclx().equals(SuitDoorType.TYPE_POCKET.getValue())) {
        for (CupboardDoorDetailSize detailSize : detailSizeLists) {
          SuitPocketDetail size = suitPocketDetailDao.findById(detailSize.getCcid());
          suitPocketDetailList.add(size);
        }
      }
      if (suitDetailType.getCclx().equals(SuitDoorType.TYPE_LINE.getValue())) {
        for (CupboardDoorDetailSize detailSize : detailSizeLists) {
          SuitLineDetail size = suitLineDetailDao.findById(detailSize.getCcid());
          suitLineDetailList.add(size);
        }
      }
    }
    return new SuitViewDetailVO(orderDetail, suitDetail, suitSwingSizeList, suitHangingSizeList, suitPocketDetailList, suitLineDetailList);
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
      Page<SuitHistoryRecordDTO> page = suitDetailDao.condData(orderQueryParamVO, pageable);
      for (SuitHistoryRecordDTO suitHistoryRecordDTO : page.getContent()) {
        OrderDetail orderDetail = orderDetailDao.findByDdbh(suitHistoryRecordDTO.getDdbh());
        Map<String, Object> map = orderService.getAccessoryListInfo(orderDetail.getId());
        suitHistoryRecordDTO.setPj((StringBuilder) map.get("accessoryListInfo"));
        suitHistoryRecordDTO.setPjje((BigDecimal) map.get("accessoryMoney"));
      }
      return BaseMessage.success().add(page);
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }
}
