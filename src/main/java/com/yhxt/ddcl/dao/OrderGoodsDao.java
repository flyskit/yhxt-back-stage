package com.yhxt.ddcl.dao;

import com.yhxt.ddcl.entity.OrderGoods;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName OrderGoodsDao
 * @Author zqi
 * @Date 2019/6/23 18:43
 * @Version 1.0
 * @Description 关联：订单信息、商品统计信息
 */
public interface OrderGoodsDao extends CrudRepository<OrderGoods, String> {

  /**
   * 根据ddid查询记录
   *
   * @param ddid 订单id
   * @return orderGoods
   */
  OrderGoods findByDdid(String ddid);
}
