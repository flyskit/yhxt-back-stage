package com.yhxt.khxd.ygm.service.impl;

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
import com.yhxt.khxd.ygm.dao.WardrobeSlideDetailDao;
import com.yhxt.khxd.ygm.dao.WardrobeSlideSizeDao;
import com.yhxt.khxd.ygm.dto.WardrobeSlideHistoryRecordDTO;
import com.yhxt.khxd.ygm.entity.WardrobeSlideDetail;
import com.yhxt.khxd.ygm.entity.WardrobeSlideSize;
import com.yhxt.khxd.ygm.service.WardrobeSlideService;
import com.yhxt.khxd.ygm.vo.WardrobeSlideAddParamVO;
import com.yhxt.khxd.ygm.vo.WardrobeSlideTodayDetailReturnVO;
import com.yhxt.khxd.ygm.vo.WardrobeSlideViewDetailVO;
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
 * @ClassName WardrobeSlideServiceImpl
 * @Author zqi
 * @Date 2019/7/13 15:07
 * @Version 1.0
 * @Description 衣柜移门
 */
@Service
public class WardrobeSlideServiceImpl implements WardrobeSlideService {

  @Resource
  private OrderService orderService;

  @Resource
  private OrderDetailDao orderDetailDao;

  @Resource
  private OrderGoodsDao orderGoodsDao;

  @Resource
  private OrderRecordDao orderRecordDao;

  @Resource
  private WardrobeSlideDetailDao wardrobeSlideDetailDao;

  @Resource
  private WardrobeSlideSizeDao wardrobeSlideSizeDao;

  @Resource
  private CupboardDoorDetailSizeDao cupboardDoorDetailSizeDao;

  private static Logger logger = Logger.getLogger(WardrobeSlideServiceImpl.class);

  /**
   * 添加
   *
   * @param wardrobeSlideAddParamVO 参数
   * @return baseMessage 返回信息
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addData(WardrobeSlideAddParamVO wardrobeSlideAddParamVO) {
    WardrobeSlideDetail wardrobeSlideDetailToBeAdded = new WardrobeSlideDetail(wardrobeSlideAddParamVO.getJe(), wardrobeSlideAddParamVO.getHjpf(), wardrobeSlideAddParamVO.getXbpf(), wardrobeSlideAddParamVO.getHjsl(), wardrobeSlideAddParamVO.getYjdb());
    try {
      // 添加订单基本信息
      OrderDetail orderDetail = orderService.orderAddDataPreDeal(wardrobeSlideAddParamVO);
      // 保存亚克力门信息表
      WardrobeSlideDetail wardrobeSlideDetailAdded = wardrobeSlideDetailDao.save(wardrobeSlideDetailToBeAdded);
      // 保存订单-商品信息关联表
      OrderGoods orderGoodsToBeAdded = GoodsType.getWardrobeSlide();
      orderGoodsToBeAdded.setDdid(orderDetail.getId());
      orderGoodsToBeAdded.setSpid(wardrobeSlideDetailAdded.getId());
      orderGoodsToBeAdded.setZt(BaseStatus.VALID.getValue());
      orderGoodsDao.save(orderGoodsToBeAdded);
      for (WardrobeSlideSize wardrobeSlideSizeToBeAdded : wardrobeSlideAddParamVO.getWardrobeSlideSizes()) {
        // 保存尺寸信息
        WardrobeSlideSize wardrobeSlideSizeAdded = wardrobeSlideSizeDao.save(wardrobeSlideSizeToBeAdded);
        // 保存商品信息-尺寸信息关联表
        cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(wardrobeSlideDetailAdded.getId(), wardrobeSlideSizeAdded.getId(), BaseStatus.VALID.getValue()));
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
      List<WardrobeSlideHistoryRecordDTO> lists = wardrobeSlideDetailDao.listDataToDay(
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
  private WardrobeSlideTodayDetailReturnVO doReturnInfo(List<WardrobeSlideHistoryRecordDTO> lists) {
    Integer totalNum = 0;
    BigDecimal totalDoorSquare = new BigDecimal("0");
    BigDecimal totalCoreBoardSquare = new BigDecimal("0");
    Integer totalReworkNum = 0;
    BigDecimal totalReworkDoorSquare = new BigDecimal("0");
    BigDecimal totalReworkCoreBoardSquare = new BigDecimal("0");
    for (WardrobeSlideHistoryRecordDTO wardrobeSlideHistoryRecordDTO : lists) {
      OrderDetail orderDetail = orderDetailDao.findByDdbh(wardrobeSlideHistoryRecordDTO.getDdbh());
      Map<String, Object> map = orderService.getAccessoryListInfo(orderDetail.getId());
      wardrobeSlideHistoryRecordDTO.setPj((StringBuilder) map.get("accessoryListInfo"));
      wardrobeSlideHistoryRecordDTO.setPjje((BigDecimal) map.get("accessoryMoney"));
      if (wardrobeSlideHistoryRecordDTO.getDdlx().equals(OrderType.ORDER_REWORK.getValue())) {
        //返工单
        totalReworkNum = totalReworkNum + 1;
        totalReworkDoorSquare = totalReworkDoorSquare.add(wardrobeSlideHistoryRecordDTO.getHjpf());
        totalReworkCoreBoardSquare = totalReworkCoreBoardSquare.add(wardrobeSlideHistoryRecordDTO.getXbpf());
      } else {
        // 新订单或者补单
        totalNum = totalNum + 1;
        totalDoorSquare = totalDoorSquare.add(wardrobeSlideHistoryRecordDTO.getHjpf());
        totalCoreBoardSquare = totalCoreBoardSquare.add(wardrobeSlideHistoryRecordDTO.getXbpf());
      }
    }
    return new WardrobeSlideTodayDetailReturnVO(totalNum, totalDoorSquare, totalCoreBoardSquare, totalReworkNum,
            totalReworkDoorSquare, totalReworkCoreBoardSquare, lists);
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
      List<WardrobeSlideHistoryRecordDTO> lists = wardrobeSlideDetailDao.listDataTemporary();
      for (WardrobeSlideHistoryRecordDTO wardrobeSlideHistoryRecordDTO : lists) {
        OrderDetail orderDetail = orderDetailDao.findByDdbh(wardrobeSlideHistoryRecordDTO.getDdbh());
        Map<String, Object> map = orderService.getAccessoryListInfo(orderDetail.getId());
        wardrobeSlideHistoryRecordDTO.setPj((StringBuilder) map.get("accessoryListInfo"));
        wardrobeSlideHistoryRecordDTO.setPjje((BigDecimal) map.get("accessoryMoney"));
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
   * @param wardrobeSlideAddParamVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage updateData(WardrobeSlideAddParamVO wardrobeSlideAddParamVO) {
    LocalDateTime nowTime = LocalDateTime.now();
    OrderDetail orderDetail = orderDetailDao.findByDdbh(wardrobeSlideAddParamVO.getDdbh());
    orderDetail.updateDetail(wardrobeSlideAddParamVO.getDdlx(), wardrobeSlideAddParamVO.getDdly(), wardrobeSlideAddParamVO.getScsl(), wardrobeSlideAddParamVO.getGq(),
            wardrobeSlideAddParamVO.getKhxm(), wardrobeSlideAddParamVO.getDz(), wardrobeSlideAddParamVO.getDh(), wardrobeSlideAddParamVO.getBz());
    OrderGoods orderGoods = orderGoodsDao.findByDdid(orderDetail.getId());
    WardrobeSlideDetail wardrobeSlideDetail = wardrobeSlideDetailDao.findById(orderGoods.getSpid());
    wardrobeSlideDetail.updateDetail(wardrobeSlideAddParamVO.getHjpf(), wardrobeSlideAddParamVO.getXbpf(), wardrobeSlideAddParamVO.getHjsl(), wardrobeSlideAddParamVO.getYjdb(), wardrobeSlideAddParamVO.getJe());
    OrderRecord orderRecordToBeAdded = OrderRecordType.getUpdate();
    orderRecordToBeAdded.setDdid(orderDetail.getId());
    // TODO 获取当前登录角色信息
    orderRecordToBeAdded.setCzr("李四");
    orderRecordToBeAdded.setCzsj(BaseTimeTransform.localDateTimeToDate(nowTime));
    try {
      orderDetailDao.save(orderDetail);
      wardrobeSlideDetailDao.save(wardrobeSlideDetail);
      orderRecordDao.save(orderRecordToBeAdded);
      wardrobeSlideSizeDao.save(wardrobeSlideAddParamVO.getWardrobeSlideSizes());
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
      WardrobeSlideDetail wardrobeSlideDetail = wardrobeSlideDetailDao.findById(orderGoods.getSpid());
      List<CupboardDoorDetailSize> detailSizeLists = cupboardDoorDetailSizeDao.findByMbid(wardrobeSlideDetail.getId());
      List<WardrobeSlideSize> sizeLists = new LinkedList<>();
      for (CupboardDoorDetailSize detailSize : detailSizeLists) {
        WardrobeSlideSize size = wardrobeSlideSizeDao.findById(detailSize.getCcid());
        sizeLists.add(size);
      }
      Map<String, Object> map = orderService.getAccessoryListInfo(orderDetail.getId());
      return BaseMessage.success().add(new WardrobeSlideViewDetailVO(orderDetail, wardrobeSlideDetail, sizeLists, (StringBuilder) map.get("accessoryListInfo")));
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
      Page<WardrobeSlideHistoryRecordDTO> page = wardrobeSlideDetailDao.condData(orderQueryParamVO, pageable);
      for (WardrobeSlideHistoryRecordDTO wardrobeSlideHistoryRecordDTO : page.getContent()) {
        OrderDetail orderDetail = orderDetailDao.findByDdbh(wardrobeSlideHistoryRecordDTO.getDdbh());
        Map<String, Object> map = orderService.getAccessoryListInfo(orderDetail.getId());
        wardrobeSlideHistoryRecordDTO.setPj((StringBuilder) map.get("accessoryListInfo"));
        wardrobeSlideHistoryRecordDTO.setPjje((BigDecimal) map.get("accessoryMoney"));
      }
      return BaseMessage.success().add(page);
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }
}
