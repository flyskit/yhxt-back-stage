package com.yhxt.khxd.service.impl;

import com.yhxt.common.BaseException;
import com.yhxt.common.BaseMessage;
import com.yhxt.khxd.common.CrystalSteelDoorOrderStatus;
import com.yhxt.khxd.dao.CrystalSteelDoorOrderAndSizeDao;
import com.yhxt.khxd.dao.CrystalSteelDoorOrderDao;
import com.yhxt.khxd.dao.CrystalSteelDoorSizeDao;
import com.yhxt.khxd.entity.JGMCCXX;
import com.yhxt.khxd.entity.JGMXDXX;
import com.yhxt.khxd.entity.XDXXACCXX;
import com.yhxt.khxd.service.CrystalSteelDoorService;
import com.yhxt.khxd.vo.CrystalSteelDoorParamVO;
import com.yhxt.khxd.vo.CrystalSteelDoorReturnInfoVO;
import com.yhxt.sjgl.dao.DataManageOnCryStalSteelDoorHandleDao;
import com.yhxt.sjgl.entity.JGMLSXX;
import com.yhxt.utils.BaseTimeTransform;
import org.springframework.cache.annotation.Cacheable;
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
  private CrystalSteelDoorOrderDao crystalSteelDoorOrderDao;

  @Resource
  private CrystalSteelDoorSizeDao crystalSteelDoorSizeDao;

  @Resource
  private CrystalSteelDoorOrderAndSizeDao crystalSteelDoorOrderAndSizeDao;

  /**
   * 数据管理-拉手信息
   */
  @Resource
  private DataManageOnCryStalSteelDoorHandleDao dataManageOnCryStalSteelDoorHandleDao;

  /**
   * 添加
   *
   * @param crystalSteelDoorParamVO 参数
   * @return baseMessage 返回信息
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addData(CrystalSteelDoorParamVO crystalSteelDoorParamVO) {
    crystalSteelDoorParamVO = this.dataHandle(crystalSteelDoorParamVO);
    JGMXDXX jgmxdxx = crystalSteelDoorParamVO.getXdxx();
    try {
      JGMXDXX jgmxdxxNew = crystalSteelDoorOrderDao.save(jgmxdxx);
      List<JGMCCXX> list = crystalSteelDoorParamVO.getCcxx();
      for (JGMCCXX jgmccxx : list) {
        JGMCCXX jgmccxxNew = crystalSteelDoorSizeDao.save(jgmccxx);
        crystalSteelDoorOrderAndSizeDao.save(new XDXXACCXX(jgmxdxxNew.getId(), jgmccxxNew.getId()));
      }
      return BaseMessage.success().add(crystalSteelDoorParamVO);
    } catch (Exception e) {
      e.printStackTrace();
      return BaseMessage.failed();
    }
  }

  /**
   * 订单数据处理
   *
   * @param crystalSteelDoorParamVO 订单信息
   * @return crystalSteelDoorParamVO
   */
  private CrystalSteelDoorParamVO dataHandle(CrystalSteelDoorParamVO crystalSteelDoorParamVO) {
    BigDecimal totalAluminiumAlloySquare = new BigDecimal("0");
    BigDecimal totalGlassSquare = new BigDecimal("0");
    Integer totalNumberOfSlices = new Integer("0");
    List<JGMCCXX> list = crystalSteelDoorParamVO.getCcxx();
    for (JGMCCXX jgmccxx : list) {
      /* 获取拉手信息 */
      JGMLSXX jgmlsxx = this.getCrystalSteelDoorHandleInfo(jgmccxx.getLs());
      if (StringUtils.isEmpty(jgmlsxx)) {
        throw new BaseException("未找到相关拉手信息");
      }
      /* 逻辑处理 */
      jgmccxx.setBlgd(jgmccxx.getLhjgd().subtract(jgmlsxx.getGd()));
      jgmccxx.setBlkd(jgmccxx.getLhjkd().subtract(jgmlsxx.getKd()));
      totalAluminiumAlloySquare = totalAluminiumAlloySquare.add(jgmccxx.getLhjpf());
      totalGlassSquare = totalGlassSquare.add(jgmccxx.getBlpf());
      totalNumberOfSlices = totalNumberOfSlices + jgmccxx.getPs();
    }
    JGMXDXX jgmxdxx = crystalSteelDoorParamVO.getXdxx();
    jgmxdxx.setHjlhjpf(totalAluminiumAlloySquare);
    jgmxdxx.setHjblpf(totalGlassSquare);
    jgmxdxx.setHjps(totalNumberOfSlices);
    jgmxdxx.setCjsj(BaseTimeTransform.localDateTimeToDate(LocalDateTime.now()));
    jgmxdxx.setCjr("张三");
    return crystalSteelDoorParamVO;
  }

  /**
   * 根据拉手编号查找尺寸信息
   *
   * @param bh 编号
   * @return jgmlsxx 晶钢门拉手信息
   */
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  @Cacheable(value = "lsccxx", key = "#bh + 'findByBh'")
  public JGMLSXX getCrystalSteelDoorHandleInfo(Integer bh) {
    if (StringUtils.isEmpty(bh)) {
      throw new BaseException("编号为空");
    }
    try {
      return dataManageOnCryStalSteelDoorHandleDao.findByBh(bh);
    } catch (Exception e) {
      e.printStackTrace();
      throw new BaseException("查找拉手-出现未知异常", e);
    }
  }

  /**
   * 获取编号
   *
   * @return baseMessage 返回信息
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getBh() {
    StringBuilder initNum = new StringBuilder("0001");
    JGMXDXX jgmxdxx = crystalSteelDoorOrderDao.findFirstByOrderByBhDesc();
    //LocalDate转换为String
    String timeString = BaseTimeTransform.localDateToString(LocalDate.now());
    //获取initDay
    String initDay = timeString.substring(6, 8);
    StringBuilder stringBuilder = new StringBuilder(timeString);
    // 判断：数据表为空，或者每天，重新改写编号
    if (StringUtils.isEmpty(jgmxdxx) || !jgmxdxx.getBh().substring(6, 8).equals(initDay)) {
      return BaseMessage.success().add(stringBuilder.append(initNum));
    }
    // 获取编号，截取最后四位
    String bhLastFour = jgmxdxx.getBh().substring(8, 12);
    // 编号+1，位数不够前面补0
    stringBuilder.append(String.format("%0" + bhLastFour.length() + "d", Integer.parseInt(bhLastFour) + 1));
    return BaseMessage.success().add(stringBuilder);
  }

  /**
   * 根据编号查询记录
   *
   * @param bh 编号
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getDataByBh(String bh) {
    if (StringUtils.isEmpty(bh)) {
      return BaseMessage.failed("传入编号未找到！");
    }
    try {
      JGMXDXX jgmxdxx = crystalSteelDoorOrderDao.findByBh(bh);
      List<XDXXACCXX> list = crystalSteelDoorOrderAndSizeDao.findByXdxxId(jgmxdxx.getId());
      List<JGMCCXX> jgmccxxList = new LinkedList<>();
      for (XDXXACCXX xdxxaccxx : list) {
        JGMCCXX jgmccxx = crystalSteelDoorSizeDao.findById(xdxxaccxx.getCcxxId());
        jgmccxxList.add(jgmccxx);
      }
      return BaseMessage.success().add(new CrystalSteelDoorParamVO(jgmxdxx, jgmccxxList));
    } catch (Exception e) {
      e.printStackTrace();
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
      List<JGMXDXX> lists = crystalSteelDoorOrderDao.findByZtAndCjsjBetweenOrderByCjsjDesc(
              CrystalSteelDoorOrderStatus.SUBMIT.getValue(),
              BaseTimeTransform.localDateTimeToDate(startTime),
              BaseTimeTransform.localDateTimeToDate(endTime));
      return BaseMessage.success().add(this.doReturnInfo(lists));
    } catch (Exception e) {
      e.printStackTrace();
      return BaseMessage.failed();
    }
  }

  /**
   * 处理返回结果
   *
   * @param lists 查询结果
   * @return vo
   */
  private CrystalSteelDoorReturnInfoVO doReturnInfo(List<JGMXDXX> lists) {
    BigDecimal totalLhjpf = new BigDecimal("0");
    BigDecimal totalBlpf = new BigDecimal("0");
    Integer totalPs = 0;
    for (JGMXDXX jgmxdxx : lists) {
      totalLhjpf = totalLhjpf.add(jgmxdxx.getHjlhjpf());
      totalBlpf = totalBlpf.add(jgmxdxx.getHjblpf());
      totalPs = totalPs + jgmxdxx.getHjps();
    }
    return new CrystalSteelDoorReturnInfoVO(lists, totalLhjpf, totalBlpf, totalPs, lists.size());
  }

  /**
   * 查询暂存订单
   *
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getDataByTemporary() {
    try {
      List<JGMXDXX> lists = crystalSteelDoorOrderDao.findByZtOrderByCjsjDesc(CrystalSteelDoorOrderStatus.TEMPORARY.getValue());
      return BaseMessage.success().add(lists);
    } catch (Exception e) {
      e.printStackTrace();
      return BaseMessage.failed();
    }
  }

  /**
   * 提交暂存订单
   *
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage subDataByTemporary(String bh) {
    if (StringUtils.isEmpty(bh)) {
      return BaseMessage.failed("请重新输入编号！");
    }
    JGMXDXX jgmxdxx = crystalSteelDoorOrderDao.findByBh(bh);
    if (StringUtils.isEmpty(jgmxdxx)) {
      return BaseMessage.failed("根据编号未查找到记录！");
    }
    jgmxdxx.setZt(CrystalSteelDoorOrderStatus.SUBMIT.getValue());
    jgmxdxx.setCjsj(BaseTimeTransform.localDateTimeToDate(LocalDateTime.now()));
    jgmxdxx.setCjr("张三");
    try {
      JGMXDXX jgmxdxxNew = crystalSteelDoorOrderDao.save(jgmxdxx);
      return this.getDataByBh(jgmxdxxNew.getBh());
    } catch (Exception e) {
      e.printStackTrace();
      return BaseMessage.failed();
    }
  }
}

