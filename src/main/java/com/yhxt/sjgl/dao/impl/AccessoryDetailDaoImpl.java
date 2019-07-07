package com.yhxt.sjgl.dao.impl;

import com.yhxt.sjgl.entity.AccessoryDetail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @ClassName AccessoryDetailDaoImpl
 * @Author zqi
 * @Date 2019/6/29 14:59
 * @Version 1.0
 * @Description 配件管理
 */
public class AccessoryDetailDaoImpl {
  @PersistenceContext
  private EntityManager entityManager;

  /**
   * 根据配件名获取配件列表
   *
   * @param accessoryName 配件名
   * @return list
   */
  public List<AccessoryDetail> getAccessoryByName(String accessoryName) {
    Query query = entityManager.createQuery("select accessotyDetail FROM AccessoryDetail accessotyDetail WHERE 1=1 AND accessotyDetail.mc like :mc");
    query.setParameter("mc", "%" + accessoryName + "%");
    @SuppressWarnings(value = "unchecked")
    List<AccessoryDetail> list = query.getResultList();
    return list;
  }
}
