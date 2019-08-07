package com.yhxt.khxd.tzm.service;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.tzm.vo.SuitAddParamVO;

/**
 * @ClassName SuitService
 * @Author zqi
 * @Date 2019/7/17 10:33
 * @Version 1.0
 * @Description 套装门
 */
public interface SuitService {

  /**
   * 添加订单
   *
   * @param suitAddParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage addData(SuitAddParamVO suitAddParamVO);

  /**
   * 今日已下单-查询记录
   *
   * @return baseMessage
   */
  BaseMessage getDataByToDay();

  /**
   * 暂存列表-查询订单
   *
   * @return baseMessage
   */
  BaseMessage getDataByTemporary();

  /**
   * 更新记录
   *
   * @param suitAddParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage updateData(SuitAddParamVO suitAddParamVO);

  /**
   * 根据编号查询记录
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
