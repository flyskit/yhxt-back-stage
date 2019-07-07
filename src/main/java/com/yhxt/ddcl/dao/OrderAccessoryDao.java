package com.yhxt.ddcl.dao;

import com.yhxt.ddcl.dto.OrderAccessoryDTO;
import com.yhxt.ddcl.entity.OrderAccessory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName OrderAccessoryDao
 * @Author zqi
 * @Date 2019/6/29 15:00
 * @Version 1.0
 * @Description 订单-配件管理
 */
public interface OrderAccessoryDao extends CrudRepository<OrderAccessory, String> {

  /**
   * 根据id查询订单
   *
   * @param id id标识
   * @return orderAccessory
   */
  OrderAccessory findById(String id);

  /**
   * 查询配件列表
   *
   * @param ddbh 订单编号
   * @return list
   */
  List<OrderAccessoryDTO> getAccessory(String ddbh);

  /**
   * 根据配件id和状态查询记录
   *
   * @param pjid 配件id标识
   * @param zt   状态
   * @return list
   */
  List<OrderAccessory> findByPjidAndZt(String pjid, Boolean zt);

  /**
   * 根据订单id查询配件
   *
   * @param ddid 订单id
   * @param zt   状态
   * @return lsits
   */
  List<OrderAccessory> findByDdidAndZt(String ddid, Boolean zt);
}
