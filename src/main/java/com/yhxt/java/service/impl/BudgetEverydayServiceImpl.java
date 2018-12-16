package com.yhxt.java.service.impl;
import com.yhxt.java.dao.BudgetEverydayDao;
import com.yhxt.java.entity.MRSZSR;
import com.yhxt.java.service.BudgetEverydayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
   * @param mrszsr 收入信息
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void addIncome(MRSZSR mrszsr) {
    budgetEverydayDao.save(mrszsr);
  }
}
