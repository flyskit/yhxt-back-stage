package com.yhxt.sjgl.dao;

import com.yhxt.sjgl.entity.CustomerDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName CustomerDetailDao
 * @Author zqi
 * @Date 2019/6/24 16:20
 * @Version 1.0
 * @Description 客户信息
 */
public interface CustomerDetailDao extends CrudRepository<CustomerDetail, String> {

  /**
   * 根据客户姓名模糊查询客户
   *
   * @param customerName 客户姓名
   * @return list
   */
  List<CustomerDetail> getCustomerByName(String customerName);
}
