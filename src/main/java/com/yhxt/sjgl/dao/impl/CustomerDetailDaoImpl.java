package com.yhxt.sjgl.dao.impl;

import com.yhxt.sjgl.entity.CustomerDetail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @ClassName CustomerDetailDaoImpl
 * @Author zqi
 * @Date 2019/6/24 16:21
 * @Version 1.0
 * @Description 客户信息
 */
public class CustomerDetailDaoImpl {

  @PersistenceContext
  private EntityManager entityManager;

  /**
   * 根据姓名获取客户列表
   *
   * @param customerName 客户姓名
   * @return list
   */
  public List<CustomerDetail> getCustomerByName(String customerName) {
    Query query = entityManager.createQuery("select customerDetail FROM CustomerDetail customerDetail WHERE 1=1 AND customerDetail.khxm like :khxm");
    query.setParameter("khxm", "%" + customerName + "%");
    @SuppressWarnings(value = "unchecked")
    List<CustomerDetail> list = query.getResultList();
    return list;
  }

}
