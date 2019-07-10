package com.yhxt.khxd.yklm.service.impl;

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
import com.yhxt.khxd.jgm.dao.CupboardDoorSizeDao;
import com.yhxt.khxd.jgm.entity.CupboardDoorDetailSize;
import com.yhxt.khxd.jgm.entity.CupboardDoorSize;
import com.yhxt.khxd.yklm.dao.AcrylicDetailDao;
import com.yhxt.khxd.yklm.dto.AcrylicHistoryRecordDTO;
import com.yhxt.khxd.yklm.entity.AcrylicDetail;
import com.yhxt.khxd.yklm.service.AcrylicService;
import com.yhxt.khxd.yklm.vo.AcrylicAddParamVO;
import com.yhxt.khxd.yklm.vo.AcrylicTodayDetailReturnVO;
import com.yhxt.khxd.yklm.vo.AcrylicViewDetailVO;
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

/**
 * @ClassName AcrylicServiceImpl
 * @Author zqi
 * @Date 2019/7/3 15:03
 * @Version 1.0
 * @Description 亚克力模块
 */
@Service
public class AcrylicServiceImpl implements AcrylicService {

  @Resource
  private OrderService orderService;

  @Resource
  private OrderDetailDao orderDetailDao;

  @Resource
  private AcrylicDetailDao acrylicDetailDao;

  @Resource
  private OrderGoodsDao orderGoodsDao;

  @Resource
  private OrderRecordDao orderRecordDao;

  @Resource
  private CupboardDoorSizeDao cupboardDoorSizeDao;

  @Resource
  private CupboardDoorDetailSizeDao cupboardDoorDetailSizeDao;

  private static Logger logger = Logger.getLogger(AcrylicServiceImpl.class);

  /**
   * 添加
   *
   * @param acrylicAddParamVO 参数
   * @return baseMessage 返回信息
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addData(AcrylicAddParamVO acrylicAddParamVO) {
    AcrylicDetail acrylicDetailToBeAdded = new AcrylicDetail(acrylicAddParamVO.getBcmc(), acrylicAddParamVO.getBcdj(),
            acrylicAddParamVO.getLsmc(), acrylicAddParamVO.getLsdj(), acrylicAddParamVO.getYs(), acrylicAddParamVO.getJe(),
            acrylicAddParamVO.getHjpf(), acrylicAddParamVO.getBcpf(), acrylicAddParamVO.getHjsl(), acrylicAddParamVO.getYjdb());
    try {
      // 添加订单基本信息
      OrderDetail orderDetail = orderService.orderAddDataPreDeal(acrylicAddParamVO);
      // 保存亚克力门信息表
      AcrylicDetail acrylicDetailAdded = acrylicDetailDao.save(acrylicDetailToBeAdded);
      // 保存订单-商品信息关联表
      OrderGoods orderGoodsToBeAdded = GoodsType.getAcrylic();
      orderGoodsToBeAdded.setDdid(orderDetail.getId());
      orderGoodsToBeAdded.setSpid(acrylicDetailAdded.getId());
      orderGoodsToBeAdded.setZt(BaseStatus.VALID.getValue());
      orderGoodsDao.save(orderGoodsToBeAdded);
      for (CupboardDoorSize cupboardDoorSizeToBeAdded : acrylicAddParamVO.getCupboardDoorSizes()) {
        // 保存尺寸信息
        CupboardDoorSize cupboardDoorSizeAdded = cupboardDoorSizeDao.save(cupboardDoorSizeToBeAdded);
        // 保存商品信息-尺寸信息关联表
        cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(acrylicDetailAdded.getId(), cupboardDoorSizeAdded.getId(), BaseStatus.VALID.getValue()));
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
      List<AcrylicHistoryRecordDTO> lists = acrylicDetailDao.getDataByToDay(
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
  private AcrylicTodayDetailReturnVO doReturnInfo(List<AcrylicHistoryRecordDTO> lists) {
    Integer totalNum = 0;
    BigDecimal totalDoorSquare = new BigDecimal("0");
    BigDecimal totalBoardSquare = new BigDecimal("0");
    Integer totalDoorNum = 0;
    Integer totalReworkNum = 0;
    BigDecimal totalReworkDoorSquare = new BigDecimal("0");
    BigDecimal totalReworkBoardSquare = new BigDecimal("0");
    Integer totalReworkDoorNum = 0;
    for (AcrylicHistoryRecordDTO acrylicHistoryRecordDTO : lists) {
      OrderDetail orderDetail = orderDetailDao.findByDdbh(acrylicHistoryRecordDTO.getDdbh());
      StringBuilder accessoryListInfo = orderService.getAccessoryListInfo(orderDetail.getId());
      acrylicHistoryRecordDTO.setPj(accessoryListInfo);
      if (acrylicHistoryRecordDTO.getDdlx().equals(OrderType.ORDER_REWORK.getValue())) {
        //返工单
        totalReworkNum = totalReworkNum + 1;
        totalReworkDoorSquare = totalReworkDoorSquare.add(acrylicHistoryRecordDTO.getHjpf());
        totalReworkBoardSquare = totalReworkBoardSquare.add(acrylicHistoryRecordDTO.getBcpf());
        totalReworkDoorNum = totalReworkDoorNum + acrylicHistoryRecordDTO.getHjsl();
      } else {
        // 新订单或者补单
        totalNum = totalNum + 1;
        totalDoorSquare = totalDoorSquare.add(acrylicHistoryRecordDTO.getHjpf());
        totalBoardSquare = totalBoardSquare.add(acrylicHistoryRecordDTO.getBcpf());
        totalDoorNum = totalDoorNum + acrylicHistoryRecordDTO.getHjsl();
      }
    }
    return new AcrylicTodayDetailReturnVO(totalNum, totalDoorSquare, totalBoardSquare, totalDoorNum, totalReworkNum,
            totalReworkDoorSquare, totalReworkBoardSquare, totalReworkDoorNum, lists);
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
      List<AcrylicHistoryRecordDTO> lists = acrylicDetailDao.getDataByTemporary();
      for (AcrylicHistoryRecordDTO acrylicHistoryRecordDTO : lists) {
        OrderDetail orderDetail = orderDetailDao.findByDdbh(acrylicHistoryRecordDTO.getDdbh());
        StringBuilder accessoryListInfo = orderService.getAccessoryListInfo(orderDetail.getId());
        acrylicHistoryRecordDTO.setPj(accessoryListInfo);
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
   * @param acrylicAddParamVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage updateData(AcrylicAddParamVO acrylicAddParamVO) {
    LocalDateTime nowTime = LocalDateTime.now();
    OrderDetail orderDetail = orderDetailDao.findByDdbh(acrylicAddParamVO.getDdbh());
    orderDetail.updateDetail(acrylicAddParamVO.getDdlx(), acrylicAddParamVO.getDdly(), acrylicAddParamVO.getScsl(), acrylicAddParamVO.getGq(),
            acrylicAddParamVO.getKhxm(), acrylicAddParamVO.getDz(), acrylicAddParamVO.getDh(), acrylicAddParamVO.getBz());
    OrderGoods orderGoods = orderGoodsDao.findByDdid(orderDetail.getId());
    AcrylicDetail acrylicDetail = acrylicDetailDao.findById(orderGoods.getSpid());
    acrylicDetail.updateDetail(acrylicAddParamVO.getBcmc(), acrylicAddParamVO.getBcdj(), acrylicAddParamVO.getLsmc(), acrylicAddParamVO.getLsdj(), acrylicAddParamVO.getHjpf(),
            acrylicAddParamVO.getHjsl(), acrylicAddParamVO.getBcpf(), acrylicAddParamVO.getYjdb(), acrylicAddParamVO.getYs(), acrylicAddParamVO.getJe());
    OrderRecord orderRecordToBeAdded = OrderRecordType.getUpdate();
    orderRecordToBeAdded.setDdid(orderDetail.getId());
    // TODO 获取当前登录角色信息
    orderRecordToBeAdded.setCzr("李四");
    orderRecordToBeAdded.setCzsj(BaseTimeTransform.localDateTimeToDate(nowTime));
    try {
      orderDetailDao.save(orderDetail);
      acrylicDetailDao.save(acrylicDetail);
      orderRecordDao.save(orderRecordToBeAdded);
      cupboardDoorSizeDao.save(acrylicAddParamVO.getCupboardDoorSizes());
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
      AcrylicDetail acrylicDetail = acrylicDetailDao.findById(orderGoods.getSpid());
      List<CupboardDoorDetailSize> detailSizeLists = cupboardDoorDetailSizeDao.findByMbid(acrylicDetail.getId());
      List<CupboardDoorSize> sizeLists = new LinkedList<>();
      for (CupboardDoorDetailSize detailSize : detailSizeLists) {
        CupboardDoorSize size = cupboardDoorSizeDao.findById(detailSize.getCcid());
        sizeLists.add(size);
      }
      StringBuilder accessoryListInfo = orderService.getAccessoryListInfo(orderDetail.getId());
      if (StringUtils.isEmpty(accessoryListInfo)) {
        return BaseMessage.success().add(new AcrylicViewDetailVO(orderDetail, acrylicDetail, sizeLists));
      }
      return BaseMessage.success().add(new AcrylicViewDetailVO(orderDetail, acrylicDetail, sizeLists, accessoryListInfo));
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
      Page<AcrylicHistoryRecordDTO> page = acrylicDetailDao.condData(orderQueryParamVO, pageable);
      for (AcrylicHistoryRecordDTO historyRecordDTO : page.getContent()) {
        OrderDetail orderDetail = orderDetailDao.findByDdbh(historyRecordDTO.getDdbh());
        StringBuilder accessoryListInfo = orderService.getAccessoryListInfo(orderDetail.getId());
        historyRecordDTO.setPj(accessoryListInfo);
      }
      return BaseMessage.success().add(page);
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }
}
