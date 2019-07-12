package com.yhxt.ddcl.service;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.entity.OrderDetail;
import com.yhxt.ddcl.vo.OrderAccessoryParamVO;
import com.yhxt.ddcl.vo.OrderAddDataBaseParamVO;
import com.yhxt.ddcl.vo.OrderDelParamVO;
import com.yhxt.ddcl.vo.OrderUpdateStatusVO;

import java.util.Map;

/**
 * @ClassName OrderService
 * @Author zqi
 * @Date 2019/6/20 17:40
 * @Version 1.0
 * @Description 订单信息处理
 */
public interface OrderService {
  /**
   * 获取编号
   *
   * @return baseMessage 返回信息
   */
  BaseMessage getOrderNumber();

  /**
   * 编号处理
   *
   * @param orderDetail 订单信息记录
   * @return ddbh 订单编号
   */
  StringBuilder handleOrderNumber(OrderDetail orderDetail);

  /**
   * 添加订单-预处理
   *
   * @param orderAddDataBaseParamVO 接受参数
   * @return 订单信息
   * @throws Exception 异常
   */
  OrderDetail orderAddDataPreDeal(OrderAddDataBaseParamVO orderAddDataBaseParamVO) throws Exception;

  /**
   * 修改订单状态
   *
   * @param orderUpdateStatusVO 接受参数
   * @return baseMessage
   */
  BaseMessage orderUpdateStatus(OrderUpdateStatusVO orderUpdateStatusVO);

  /**
   * 删除订单
   *
   * @param orderDelParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage delData(OrderDelParamVO orderDelParamVO);

  /**
   * 添加配件
   *
   * @param orderAccessoryParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage addAccessory(OrderAccessoryParamVO orderAccessoryParamVO);

  /**
   * 根据订单编号获取配件信息
   *
   * @param ddbh 订单编号
   * @return baseMessage
   */
  BaseMessage getAccessory(String ddbh);

  /**
   * 拼装配件信息
   *
   * @param ddid 订单编号
   * @return accessoryListInfo
   */
  Map<String, Object> getAccessoryListInfo(String ddid);

  /**
   * 删除配件
   *
   * @param id 订单-配件id标识
   * @return baseMessage
   */
  BaseMessage delAccessory(String id);
}
