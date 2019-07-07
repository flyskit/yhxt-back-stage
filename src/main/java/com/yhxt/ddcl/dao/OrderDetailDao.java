package com.yhxt.ddcl.dao;

import com.yhxt.ddcl.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName OrderDetailDao
 * @Author zqi
 * @Date 2019/6/20 17:46
 * @Version 1.0
 * @Description 订单基本信息
 */
public interface OrderDetailDao extends CrudRepository<OrderDetail, String> {
  /**
   * 获取最新一条记录
   *
   * @return orderDetail
   */
  OrderDetail findFirstByOrderByDdbhDesc();

  /**
   * 根据订单编号查询记录
   *
   * @param orderNumber 订单编号
   * @return orderDetail
   */
  OrderDetail findByDdbh(String orderNumber);

  /**
   * 根据ID标识和状态查询记录
   *
   * @param id id标识
   * @param zt 状态
   * @return orderDetail
   */
  OrderDetail findByIdAndZt(String id, Boolean zt);
}
