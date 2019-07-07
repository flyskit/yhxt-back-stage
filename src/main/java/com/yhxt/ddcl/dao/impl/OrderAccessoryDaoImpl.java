package com.yhxt.ddcl.dao.impl;

import com.yhxt.common.BaseStatus;
import com.yhxt.ddcl.dto.OrderAccessoryDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @ClassName OrderAccessoryDaoImpl
 * @Author zqi
 * @Date 2019/6/29 15:00
 * @Version 1.0
 * @Description 订单-配件管理
 */
public class OrderAccessoryDaoImpl {

  @PersistenceContext
  private EntityManager entityManager;

  /**
   * 查询配件列表
   *
   * @param ddbh 订单编号
   * @return list
   */
  public List<OrderAccessoryDTO> getAccessory(String ddbh) {
    // 有效状态
    Boolean valid = BaseStatus.VALID.getValue();
    StringBuilder jpql = new StringBuilder("select new com.yhxt.ddcl.dto.OrderAccessoryDTO(")
            .append("orderAccessory.id, accessoryDetail.mc, accessoryDetail.bh, accessoryDetail.gg, orderAccessory.pjsl, accessoryDetail.dw, orderAccessory.pjdj, orderAccessory.pjje) ")
            .append("FROM OrderAccessory orderAccessory left join AccessoryDetail accessoryDetail on accessoryDetail.id = orderAccessory.pjid ")
            .append("left join OrderDetail orderDetail on orderAccessory.ddid = orderDetail.id ")
            .append("WHERE 1=1 AND orderAccessory.zt =:valid AND accessoryDetail.zt =:valid AND orderDetail.zt =:valid ")
            .append("AND orderDetail.ddbh = :ddbh ");
    Query query = entityManager.createQuery(jpql.toString());
    query.setParameter("valid", valid);
    query.setParameter("ddbh", ddbh);
    @SuppressWarnings(value = "unchecked")
    List<OrderAccessoryDTO> list = query.getResultList();
    return list;
  }
}
