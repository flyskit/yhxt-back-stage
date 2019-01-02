package com.yhxt.java.dao;

import com.yhxt.java.entity.MRSZSR;
import com.yhxt.java.vo.BudgetEverydayVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName BudgetEverydayDao
 * @Author zqi
 * @Date 2018/12/16 11:58
 * @Version 1.0
 * @Description
 */
public interface BudgetEverydayDao extends CrudRepository<MRSZSR, String> {
  /**
   * 查询：根据分页信息以及条件查询信息
   *
   * @param budgetEverydayVO 查询条件
   * @param pageable         分页信息
   * @return page 分页信息
   */
  Page<MRSZSR> getDataByCond(BudgetEverydayVO budgetEverydayVO, Pageable pageable);

  /**
   * 获取编号
   *
   * @return MRSZSR 信息
   */
  MRSZSR findFirstByOrderByLrrqDesc();
}
