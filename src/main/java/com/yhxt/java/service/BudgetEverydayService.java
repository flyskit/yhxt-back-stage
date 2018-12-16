package com.yhxt.java.service;

import com.yhxt.java.entity.MRSZSR;

/**
 * @ClassName BudgetEverydayService
 * @Author zqi
 * @Date 2018/12/16 11:53
 * @Version 1.0
 * @Description
 */
public interface BudgetEverydayService {
  /**
   * 添加：收入账单
   * @param mrszsr 收入信息
   */
  void addIncome(MRSZSR mrszsr);
}
