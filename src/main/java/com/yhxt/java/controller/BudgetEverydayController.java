package com.yhxt.java.controller;

import com.yhxt.java.entity.MRSZSR;
import com.yhxt.java.service.BudgetEverydayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
   * 添加收入账单
   * @param mrszsr 收入信息
   */
  @RequestMapping(value = "/addIncome", method = RequestMethod.POST)
  public void addIncome(MRSZSR mrszsr) {
    budgetEverydayService.addIncome(mrszsr);
  }
}
