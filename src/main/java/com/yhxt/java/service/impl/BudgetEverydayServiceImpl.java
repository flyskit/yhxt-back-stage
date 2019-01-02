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
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    ReturnInfo returnInfo;
    MRSZSR mrszsrNew = budgetEverydayDao.save(mrszsr);
    if (!StringUtils.hasText(mrszsrNew.getId())) {
      returnInfo = ReturnInfo.failed("操作失败");
      return returnInfo;
    }
    returnInfo = ReturnInfo.success("操作成功");
    return returnInfo;
  }

  /**
   * 根据天健查询信息
   *
   * @param budgetEverydayVO 查询条件
   * @return returnInfo 返回信息
   */
  @Override
  public ReturnInfo getDataByCond(BudgetEverydayVO budgetEverydayVO) {
    PageCond pageCond = budgetEverydayVO.getPage();
    Pageable pageable = new PageRequest(pageCond.getPage(), pageCond.getPageSize());
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
    MRSZSR mrszsr = budgetEverydayDao.findFirstByOrderByLrrqDesc();
    //LocalDate转换为String
    LocalDate localDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    String timeString = localDate.format(formatter);
    String timeStringSub = timeString.substring(6,8);
    StringBuilder stringBuilder = new StringBuilder(timeString);
    // 判断：数据表为空，或者每个月第一天，重新改写编号
    if (mrszsr == null || initDay.equals(timeStringSub)) {
      stringBuilder.append(initNum);
      return ReturnInfo.success("操作成功").add("data", stringBuilder);
    }
    // 获取编号，截取最后四位
    String bhLastFour = mrszsr.getBh().substring(8,12);
    // 编号+1，位数不够前面补0
    stringBuilder.append(String.format("%0" + bhLastFour.length() + "d", Integer.parseInt(bhLastFour) + 1));
    return ReturnInfo.success("操作成功").add("data", stringBuilder);
  }
}
