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
}
