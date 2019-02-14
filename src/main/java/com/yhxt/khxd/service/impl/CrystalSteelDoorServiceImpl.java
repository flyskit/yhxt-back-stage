package com.yhxt.khxd.service.impl;

import com.yhxt.common.BaseMessage;
import com.yhxt.khxd.dao.CrystalSteelDoorOrderAndSizeDao;
import com.yhxt.khxd.dao.CrystalSteelDoorOrderDao;
import com.yhxt.khxd.dao.CrystalSteelDoorSizeDao;
import com.yhxt.khxd.entity.JGMCCXX;
import com.yhxt.khxd.entity.JGMXDXX;
import com.yhxt.khxd.entity.XDXXACCXX;
import com.yhxt.khxd.service.CrystalSteelDoorService;
import com.yhxt.khxd.vo.CrystalSteelDoorParamVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
   * 添加
   *
   * @param crystalSteelDoorParamVO 参数
   * @return baseMessage 返回信息
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addData(CrystalSteelDoorParamVO crystalSteelDoorParamVO) {
    JGMXDXX jgmxdxx = crystalSteelDoorParamVO.getXdxx();
    JGMXDXX jgmxdxxNew = crystalSteelDoorOrderDao.save(jgmxdxx);
    if (jgmxdxxNew == null) {
      return BaseMessage.failed("添加下单信息失败！");
    }
    List<JGMCCXX> list = crystalSteelDoorParamVO.getCcxx();
    for (JGMCCXX jgmccxx : list) {
      JGMCCXX jgmccxxNew = crystalSteelDoorSizeDao.save(jgmccxx);
      if (jgmccxxNew == null) {
        return BaseMessage.failed("添加尺寸信息失败！");
      }
      XDXXACCXX xdxxaccxx = new XDXXACCXX();
      xdxxaccxx.setXdxxId(jgmxdxxNew.getId());
      xdxxaccxx.setCcxxId(jgmccxxNew.getId());
      XDXXACCXX xdxxaccxxNew = crystalSteelDoorOrderAndSizeDao.save(xdxxaccxx);
      if (xdxxaccxxNew == null) {
        return BaseMessage.failed("添加关联信息失败！");
      }
    }
    return BaseMessage.success();
  }

  /**
   * 获取编号
   * @return baseMessage 返回信息
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getBh() {
    String initDay = "01";
    String initNum = "0001";
    JGMXDXX jgmxdxx = crystalSteelDoorOrderDao.findFirstByOrderByBhDesc();
    //LocalDate转换为String
    LocalDate localDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    String timeString = localDate.format(formatter);
    String timeStringSub = timeString.substring(6, 8);
    StringBuilder stringBuilder = new StringBuilder(timeString);
    // 判断：数据表为空，或者每个月第一天，重新改写编号
    if (jgmxdxx == null || initDay.equals(timeStringSub)) {
      stringBuilder.append(initNum);
      return BaseMessage.success().add(stringBuilder);
    }
    // 获取编号，截取最后四位
    String bhLastFour = jgmxdxx.getBh().substring(8, 12);
    // 编号+1，位数不够前面补0
    stringBuilder.append(String.format("%0" + bhLastFour.length() + "d", Integer.parseInt(bhLastFour) + 1));
    return BaseMessage.success().add(stringBuilder);
  }
}

