package com.yhxt.java.service.impl;

import com.yhxt.java.common.PageCond;
import com.yhxt.java.common.ReturnInfo;
import com.yhxt.java.dao.BudgetEverydayDao;
import com.yhxt.java.entity.MRSZSR;
import com.yhxt.java.service.BudgetEverydayService;
import com.yhxt.java.vo.BudgetEverydayVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName BudgetEverydayServiceImpl
 * @Author zqi
 * @Date 2018/12/16 11:53
 * @Version 1.0
 * @Description 财务管理-每日收支
 */
@Service
public class BudgetEverydayServiceImpl implements BudgetEverydayService {

  @Resource
  private BudgetEverydayDao budgetEverydayDao;

  /**
   * 添加：收入账单
   *
   * @param mrszsr 收入信息
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public ReturnInfo addIncome(MRSZSR mrszsr) {
    LocalDateTime localDateTime = LocalDateTime.now();
    ZoneId zoneId = ZoneId.systemDefault();
    ZonedDateTime zdt = localDateTime.atZone(zoneId);
    MRSZSR mrszsrOld = budgetEverydayDao.findByBh(mrszsr.getBh());
    if (mrszsrOld != null) {
      return ReturnInfo.failed("编号已存在，请重新输入！");
    }
    // 添加录入日期，格式：yyyy-MM-dd HH:mm:ss
    mrszsr.setLrrq(Date.from(zdt.toInstant()));
    MRSZSR mrszsrNew = budgetEverydayDao.save(mrszsr);
    if (mrszsrNew == null) {
      return ReturnInfo.failed("系统异常，添加失败！");
    }
    return ReturnInfo.success("操作成功");
  }

  /**
   * 分页条件查询
   *
   * @param budgetEverydayVO 查询条件
   * @return returnInfo 返回信息
   */
  @Override
  public ReturnInfo getDataByCond(BudgetEverydayVO budgetEverydayVO) {
    PageCond pageCond = budgetEverydayVO.getPage();
    Pageable pageable = new PageRequest(pageCond.getPage(), pageCond.getPageSize());
    if (budgetEverydayVO.getLrrq() != null) {
      // 时间条件，设置endTime，用于between and条件查询
      LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(budgetEverydayVO.getLrrq().getTime()), ZoneId.systemDefault());;
      LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
      Date endTime = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
      budgetEverydayVO.setEndTime(endTime);
    }
    Page<MRSZSR> page = budgetEverydayDao.getDataByCond(budgetEverydayVO, pageable);
    return ReturnInfo.success("操作成功").add("data", page);
  }

  /**
   * 获取编号
   *
   * @return StringBuilder 编号
   */
  @Override
  public ReturnInfo getBh() {
    // 每个月初始第一天
    String initDay = "01";
    String initNum = "0001";
    // 查询最新记录
    MRSZSR mrszsr = budgetEverydayDao.findFirstByOrderByBhDesc();
    //LocalDate转换为String
    LocalDate localDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    String timeString = localDate.format(formatter);
    String timeStringSub = timeString.substring(6, 8);
    StringBuilder stringBuilder = new StringBuilder(timeString);
    // 判断：数据表为空，或者每个月第一天，重新改写编号
    if (mrszsr == null || initDay.equals(timeStringSub)) {
      stringBuilder.append(initNum);
      return ReturnInfo.success("操作成功").add("data", stringBuilder);
    }
    // 获取编号，截取最后四位
    String bhLastFour = mrszsr.getBh().substring(8, 12);
    // 编号+1，位数不够前面补0
    stringBuilder.append(String.format("%0" + bhLastFour.length() + "d", Integer.parseInt(bhLastFour) + 1));
    return ReturnInfo.success("操作成功").add("data", stringBuilder);
  }
}
