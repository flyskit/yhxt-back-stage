package com.yhxt.java.service;

import com.yhxt.java.common.ReturnInfo;
import com.yhxt.java.entity.MRSZSR;
import com.yhxt.java.vo.BudgetEverydayVO;

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
   *
   * @param mrszsr 收入信息
   * @return returnInfo 返回信息
   */
  ReturnInfo addIncome(MRSZSR mrszsr);

  /**
   * 查询：根据条件查询
   *
   * @param budgetEverydayVO 查询条件
   * @return returnInfo 返回信息
   */
  ReturnInfo getDataByCond(BudgetEverydayVO budgetEverydayVO);

  /**
   * 查询：编号
   *
   * @return StringBuilder 编号
   */
  ReturnInfo getBh();
}
