package com.yhxt.khxd.jgm.service.impl;

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
import com.yhxt.khxd.jgm.dao.CrystalSteelDoorDetailDao;
import com.yhxt.khxd.jgm.dao.CupboardDoorDetailSizeDao;
import com.yhxt.khxd.jgm.dao.CupboardDoorSizeDao;
import com.yhxt.khxd.jgm.dto.HistoryRecordDTO;
import com.yhxt.khxd.jgm.entity.CrystalSteelDoorDetail;
import com.yhxt.khxd.jgm.entity.CupboardDoorDetailSize;
import com.yhxt.khxd.jgm.entity.CupboardDoorSize;
import com.yhxt.khxd.jgm.service.CrystalSteelDoorService;
import com.yhxt.khxd.jgm.vo.CrystalSteelDoorAddParamVO;
import com.yhxt.khxd.jgm.vo.CrystalSteelDoorReturnInfoVO;
import com.yhxt.khxd.jgm.vo.CrystalSteelDoorViewDetailVO;
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
 * @ClassName CrystalSteelDoorServiceImpl
 * @Author zqi
 * @Date 2019/1/17 11:44
 * @Version 1.0
 * @Description 晶钢门模块
 */
@Service
public class CrystalSteelDoorServiceImpl implements CrystalSteelDoorService {

  @Resource
  private OrderService orderService;

  @Resource
  private OrderDetailDao orderDetailDao;

  @Resource
  private CrystalSteelDoorDetailDao crystalSteelDoorDetailDao;

  @Resource
  private CupboardDoorSizeDao cupboardDoorSizeDao;

  @Resource
  private OrderGoodsDao orderGoodsDao;

  @Resource
  private OrderRecordDao orderRecordDao;

  @Resource
  private CupboardDoorDetailSizeDao cupboardDoorDetailSizeDao;

  private static Logger logger = Logger.getLogger(CrystalSteelDoorServiceImpl.class);

  /**
   * 添加
   *
   * @param crystalSteelDoorAddParamVO 参数
   * @return baseMessage 返回信息
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addData(CrystalSteelDoorAddParamVO crystalSteelDoorAddParamVO) {
    CrystalSteelDoorDetail crystalSteelDoorDetailToBeAdded = new CrystalSteelDoorDetail(crystalSteelDoorAddParamVO.getLs(), crystalSteelDoorAddParamVO.getYs(),
            crystalSteelDoorAddParamVO.getDj(), crystalSteelDoorAddParamVO.getJe(),
            crystalSteelDoorAddParamVO.getHjpf(), crystalSteelDoorAddParamVO.getBlpf(),
            crystalSteelDoorAddParamVO.getHjsl(), crystalSteelDoorAddParamVO.getYjdb());
    try {
      // 添加订单基本信息
      OrderDetail orderDetailAdded = orderService.orderAddDataPreDeal(crystalSteelDoorAddParamVO);
      // 保存晶钢门信息表
      CrystalSteelDoorDetail crystalSteelDoorDetailAdded = crystalSteelDoorDetailDao.save(crystalSteelDoorDetailToBeAdded);
      // 保存订单-商品信息关联表
      OrderGoods orderGoodsToBeAdded = GoodsType.getCrystalSteelDoor();
      orderGoodsToBeAdded.setDdid(orderDetailAdded.getId());
      orderGoodsToBeAdded.setSpid(crystalSteelDoorDetailAdded.getId());
      orderGoodsToBeAdded.setZt(BaseStatus.VALID.getValue());
      orderGoodsDao.save(orderGoodsToBeAdded);
      for (CupboardDoorSize cupboardDoorSizeToBeAdded : crystalSteelDoorAddParamVO.getCupboardDoorSizes()) {
        // 保存尺寸信息
        CupboardDoorSize cupboardDoorSizeAdded = cupboardDoorSizeDao.save(cupboardDoorSizeToBeAdded);
        // 保存商品信息-尺寸信息关联表
        cupboardDoorDetailSizeDao.save(new CupboardDoorDetailSize(crystalSteelDoorDetailAdded.getId(), cupboardDoorSizeAdded.getId(), BaseStatus.VALID.getValue()));
      }
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 查询今日已下单
   *
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getDataByToDay() {
    LocalDateTime startTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    try {
      List<HistoryRecordDTO> lists = crystalSteelDoorDetailDao.getDataByToDay(
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
  private CrystalSteelDoorReturnInfoVO doReturnInfo(List<HistoryRecordDTO> lists) {
    Integer totalNum = 0;
    BigDecimal totalDoorSquare = new BigDecimal("0");
    BigDecimal totalGlassSquare = new BigDecimal("0");
    Integer totalDoorNum = 0;
    Integer totalReworkNum = 0;
    BigDecimal totalReworkDoorSquare = new BigDecimal("0");
    BigDecimal totalReworkGlassSquare = new BigDecimal("0");
    Integer totalReworkDoorNum = 0;
    for (HistoryRecordDTO historyRecordDTO : lists) {
      OrderDetail orderDetail = orderDetailDao.findByDdbh(historyRecordDTO.getDdbh());
      StringBuilder accessoryListInfo = orderService.getAccessoryListInfo(orderDetail.getId());
      historyRecordDTO.setPj(accessoryListInfo);
      if (historyRecordDTO.getDdlx().equals(OrderType.ORDER_REWORK.getValue())) {
        // 返工单
        totalReworkNum = totalReworkNum + 1;
        totalReworkDoorSquare = totalReworkDoorSquare.add(historyRecordDTO.getHjpf());
        totalReworkGlassSquare = totalReworkGlassSquare.add(historyRecordDTO.getBlpf());
        totalReworkDoorNum = totalReworkDoorNum + historyRecordDTO.getHjsl();
      } else {
        // 新订单或者补单
        totalNum = totalNum + 1;
        totalDoorSquare = totalDoorSquare.add(historyRecordDTO.getHjpf());
        totalGlassSquare = totalGlassSquare.add(historyRecordDTO.getBlpf());
        totalDoorNum = totalDoorNum + historyRecordDTO.getHjsl();
      }
    }
    return new CrystalSteelDoorReturnInfoVO(totalNum, totalDoorSquare, totalGlassSquare, totalDoorNum, totalReworkNum,
            totalReworkDoorSquare, totalReworkGlassSquare, totalReworkDoorNum, lists);
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
      List<HistoryRecordDTO> lists = crystalSteelDoorDetailDao.getDataByTemporary();
      for (HistoryRecordDTO historyRecordDTO : lists) {
        OrderDetail orderDetail = orderDetailDao.findByDdbh(historyRecordDTO.getDdbh());
        StringBuilder accessoryListInfo = orderService.getAccessoryListInfo(orderDetail.getId());
        historyRecordDTO.setPj(accessoryListInfo);
      }
      return BaseMessage.success().add(lists);
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 根据编号查询记录
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
      CrystalSteelDoorDetail crystalSteelDoorDetail = crystalSteelDoorDetailDao.findById(orderGoods.getSpid());
      List<CupboardDoorDetailSize> detailSizeLists = cupboardDoorDetailSizeDao.findByMbid(crystalSteelDoorDetail.getId());
      List<CupboardDoorSize> sizeLists = new LinkedList<>();
      for (CupboardDoorDetailSize detailSize : detailSizeLists) {
        CupboardDoorSize size = cupboardDoorSizeDao.findById(detailSize.getCcid());
        sizeLists.add(size);
      }
      StringBuilder accessoryListInfo = orderService.getAccessoryListInfo(orderDetail.getId());
      if (StringUtils.isEmpty(accessoryListInfo)) {
        return BaseMessage.success().add(new CrystalSteelDoorViewDetailVO(orderDetail, crystalSteelDoorDetail, sizeLists));
      }
      return BaseMessage.success().add(new CrystalSteelDoorViewDetailVO(orderDetail, crystalSteelDoorDetail, sizeLists, accessoryListInfo));
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 更新记录
   *
   * @param crystalSteelDoorAddParamVO 接受参数
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage updateData(CrystalSteelDoorAddParamVO crystalSteelDoorAddParamVO) {
    LocalDateTime nowTime = LocalDateTime.now();
    OrderDetail orderDetail = orderDetailDao.findByDdbh(crystalSteelDoorAddParamVO.getDdbh());
    orderDetail.updateDetail(crystalSteelDoorAddParamVO.getDdlx(), crystalSteelDoorAddParamVO.getDdly(), crystalSteelDoorAddParamVO.getScsl(),
            crystalSteelDoorAddParamVO.getGq(), crystalSteelDoorAddParamVO.getKhxm(), crystalSteelDoorAddParamVO.getDz(),
            crystalSteelDoorAddParamVO.getDh(), crystalSteelDoorAddParamVO.getBz());
    OrderGoods orderGoods = orderGoodsDao.findByDdid(orderDetail.getId());
    CrystalSteelDoorDetail crystalSteelDoorDetail = crystalSteelDoorDetailDao.findById(orderGoods.getSpid());
    crystalSteelDoorDetail.updateDetail(crystalSteelDoorAddParamVO.getLs(), crystalSteelDoorAddParamVO.getYs(), crystalSteelDoorAddParamVO.getDj(),
            crystalSteelDoorAddParamVO.getJe(), crystalSteelDoorAddParamVO.getHjpf(), crystalSteelDoorAddParamVO.getBlpf(),
            crystalSteelDoorAddParamVO.getHjsl(), crystalSteelDoorAddParamVO.getYjdb());
    OrderRecord orderRecordToBeAdded = OrderRecordType.getUpdate();
    orderRecordToBeAdded.setDdid(orderDetail.getId());
    // TODO 获取当前登录角色信息
    orderRecordToBeAdded.setCzr("张三");
    orderRecordToBeAdded.setCzsj(BaseTimeTransform.localDateTimeToDate(nowTime));
    try {
      orderDetailDao.save(orderDetail);
      crystalSteelDoorDetailDao.save(crystalSteelDoorDetail);
      orderRecordDao.save(orderRecordToBeAdded);
      cupboardDoorSizeDao.save(crystalSteelDoorAddParamVO.getCupboardDoorSizes());
      return BaseMessage.success();
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
      Page<HistoryRecordDTO> page = crystalSteelDoorDetailDao.condData(orderQueryParamVO, pageable);
      for (HistoryRecordDTO historyRecordDTO : page.getContent()) {
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

