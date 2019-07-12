package com.yhxt.khxd.xsm.service;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.xsm.vo.BlisterAddParamVO;

/**
 * @ClassName BlisterService
 * @Author zqi
 * @Date 2019/7/12 14:24
 * @Version 1.0
 * @Description 吸塑门
 */
public interface BlisterService {

  /**
   * 添加订单
   *
   * @param blisterAddParamVO 接受字段
   * @return baseMessage
   */
  BaseMessage addData(BlisterAddParamVO blisterAddParamVO);

  /**
   * 今日下单记录-查询
   *
   * @return baseMessage
   */
  BaseMessage getDataByToDay();

  /**
   * 暂存列表-查询
   *
   * @return baseMessage
   */
  BaseMessage getDataByTemporary();

  /**
   * 更新信息
   *
   * @param blisterAddParamVO 接受字段
   * @return baseMessage
   */
  BaseMessage updateData(BlisterAddParamVO blisterAddParamVO);

  /**
   * 根据编号查询详细信息
   *
   * @param ddbh 订单编号
   * @return baseMessage
   */
  BaseMessage getDataByBh(String ddbh);

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 查询条件
   * @return baseMessage
   */
  BaseMessage condData(OrderQueryParamVO orderQueryParamVO);
}
