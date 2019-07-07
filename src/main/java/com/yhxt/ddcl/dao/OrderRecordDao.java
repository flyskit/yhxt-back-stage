package com.yhxt.ddcl.dao;

import com.yhxt.ddcl.entity.OrderRecord;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName OrderRecordDao
 * @Author zqi
 * @Date 2019/6/23 18:54
 * @Version 1.0
 * @Description 关联：订单信息、操作记录表
 */
public interface OrderRecordDao extends CrudRepository<OrderRecord, String> {
  /**
   * 根据订单id查询记录
   *
   * @param ddid 订单id
   * @return orderRecord
   */
  OrderRecord findByDdid(String ddid);

  /**
   * 根据订单ID查询记录
   *
   * @param ddid 订单id
   * @param czlb 操作类别
   * @return orderRecord
   */
  OrderRecord findByDdidAndCzlb(String ddid, Integer czlb);
}
