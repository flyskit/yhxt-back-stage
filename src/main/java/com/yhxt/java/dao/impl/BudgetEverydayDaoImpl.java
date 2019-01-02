package com.yhxt.java.dao.impl;

import com.yhxt.java.entity.MRSZSR;
import com.yhxt.java.vo.BudgetEverydayVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BudgetEveryDaoImpl
 * @Author zqi
 * @Date 2018/12/16 11:58
 * @Version 1.0
 * @Description
 */
public class BudgetEverydayDaoImpl {

  @PersistenceContext
  private EntityManager entityManager;

  /**
   * 查询：分页查询数据记录
   *
   * @param budgetEverydayVO 查询条件
   * @return page 分页结果
   */
  public Page<MRSZSR> getDataByCond(BudgetEverydayVO budgetEverydayVO, Pageable pageable) {
    // 保存查询条件
    Map<String, Object> map = new HashMap<>(5);
    StringBuilder jpql = new StringBuilder("select mrszsr FROM MRSZSR mrszsr WHERE 1=1");
    StringBuilder queryCond = new StringBuilder();
    // 查询条件
    if (StringUtils.hasText(budgetEverydayVO.getBh())) {
      queryCond.append(" AND mrszsr.bh like :bh");
      map.put("bh", "%" + budgetEverydayVO.getBh() + "%");
    }
    if (budgetEverydayVO.getLrrq() != null) {
      queryCond.append(" AND mrszsr.lrrq = :lrrq");
      map.put("lrrq", budgetEverydayVO.getLrrq());
    }
    if (budgetEverydayVO.getSzrq() != null) {
      queryCond.append(" AND mrszsr.szrq = :szrq");
      map.put("szrq", budgetEverydayVO.getSzrq());
    }
    if (StringUtils.hasText(budgetEverydayVO.getKhxm())) {
      queryCond.append(" AND mrszsr.khxm like :khxm");
      map.put("khxm", "%" + budgetEverydayVO.getKhxm() + "%");
    }
    if (budgetEverydayVO.getSrlx() != null) {
      queryCond.append(" AND mrszsr.srlx = :srlx");
      map.put("srlx", budgetEverydayVO.getSrlx());
    }
    queryCond.append(" ORDER BY mrszsr.bh desc, mrszsr.lrrq desc, mrszsr.szrq desc");
    Query query = entityManager.createQuery(jpql.append(queryCond).toString());
    map.forEach(query::setParameter);
    query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
    query.setMaxResults(pageable.getPageSize());
    @SuppressWarnings(value = "unchecked")
    List<MRSZSR> list = query.getResultList();
    StringBuilder jpql2 = new StringBuilder("select count(*) FROM MRSZSR mrszsr WHERE 1=1");
    Query query2 = entityManager.createQuery(jpql2.append(queryCond).toString());
    map.forEach(query2::setParameter);
    long total = (Long) query2.getSingleResult();
    return new PageImpl<>(list, pageable, total);
  }
}
