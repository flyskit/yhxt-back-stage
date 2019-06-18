package com.yhxt.khxd.jgm.dao.impl;

import com.yhxt.khxd.jgm.entity.JGMXDXX;
import com.yhxt.khxd.jgm.vo.CrystalSteelDoorFindParamVO;
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
 * @ClassName CrystalSteelDoorDaoImpl
 * @Author zqi
 * @Date 2019/1/17 11:45
 * @Version 1.0
 * @Description 晶钢门模块
 */
public class CrystalSteelDoorOrderDaoImpl {

  @PersistenceContext
  private EntityManager entityManager;

  /**
   * 历史记录-条件查询
   *
   * @param crystalSteelDoorFindParamVO 查询条件
   * @param pageable                    分页条件
   * @return page
   */
  public Page<JGMXDXX> pageDataByCond(CrystalSteelDoorFindParamVO crystalSteelDoorFindParamVO, Pageable pageable) {
    // 保存查询条件
    Map<String, Object> map = new HashMap<>(5);
    StringBuilder jpql = new StringBuilder("select xdxx FROM JGMXDXX xdxx WHERE 1=1");
    StringBuilder queryCond = new StringBuilder();
    // 编号-模糊查询
    if (StringUtils.hasText(crystalSteelDoorFindParamVO.getBh())) {
      queryCond.append(" AND xdxx.bh like :bh");
      map.put("bh", "%" + crystalSteelDoorFindParamVO.getBh() + "%");
    }
    // 客户姓名-模糊查询
    if (StringUtils.hasText(crystalSteelDoorFindParamVO.getKhxm())) {
      queryCond.append(" AND xdxx.khxm like :khxm");
      map.put("khxm", "%" + crystalSteelDoorFindParamVO.getKhxm() + "%");
    }
    // 下单类型
    if (crystalSteelDoorFindParamVO.getXdlx() != null) {
      queryCond.append(" AND xdxx.xdlx = :xdlx");
      map.put("xdlx", crystalSteelDoorFindParamVO.getXdlx());
    }
    // 订单来源
    if (crystalSteelDoorFindParamVO.getDdly() != null) {
      queryCond.append(" AND xdxx.ddly = :ddly");
      map.put("ddly", crystalSteelDoorFindParamVO.getDdly());
    }
    queryCond.append(" ORDER BY xdxx.cjsj asc");
    Query query = entityManager.createQuery(jpql.append(queryCond).toString());
    map.forEach(query::setParameter);
    query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
    query.setMaxResults(pageable.getPageSize());
    @SuppressWarnings(value = "unchecked")
    List<JGMXDXX> list = query.getResultList();
    StringBuilder jpql2 = new StringBuilder("select count(*) FROM JGMXDXX xdxx WHERE 1=1");
    Query query2 = entityManager.createQuery(jpql2.append(queryCond).toString());
    map.forEach(query2::setParameter);
    long total = (Long) query2.getSingleResult();
    return new PageImpl<>(list, pageable, total);
  }
}
