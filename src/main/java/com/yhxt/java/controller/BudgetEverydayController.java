package com.yhxt.java.controller;

import com.yhxt.java.common.ReturnInfo;
import com.yhxt.java.entity.MRSZSR;
import com.yhxt.java.service.BudgetEverydayService;
import com.yhxt.java.vo.BudgetEverydayVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName BudgetEverydayController
 * @Author zqi
 * @Date 2018/12/16 11:59
 * @Version 1.0
 * @Description 财务管理-每日收支
 */
@RestController
@RequestMapping(value = "/finance-management")
public class BudgetEverydayController {
  @Resource
  private BudgetEverydayService budgetEverydayService;

  /**
   * 获取编号
   * @return bh 编号
   */
  @RequestMapping(value = "/getBh", method = RequestMethod.POST)
  public String getBh() {
    return "00001";
  }

  /**
   * 添加收入账单
   * @param mrszsr 收入信息
   */
  @RequestMapping(value = "/addIncome", method = RequestMethod.POST)
  public ReturnInfo addIncome(@RequestBody MRSZSR mrszsr) {
    return budgetEverydayService.addIncome(mrszsr);
  }

  /**
   * 根据条件查询记录
   * @return returnInfo 返回信息
   */
  @RequestMapping(value = "/getDataByCond", method = RequestMethod.POST)
  public ReturnInfo getDataByCond(@RequestBody BudgetEverydayVO budgetEverydayVO) {
    return budgetEverydayService.getDataByCond(budgetEverydayVO);
  }
}
