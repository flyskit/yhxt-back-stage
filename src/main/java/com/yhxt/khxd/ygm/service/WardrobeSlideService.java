package com.yhxt.khxd.ygm.service;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.ygm.vo.WardrobeSlideAddParamVO;

/**
 * @ClassName WardrobeSlideService
 * @Author zqi
 * @Date 2019/7/13 15:06
 * @Version 1.0
 * @Description 衣柜移门
 */
public interface WardrobeSlideService {

  /**
   * 添加订单
   *
   * @param wardrobeAddParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage addData(WardrobeSlideAddParamVO wardrobeAddParamVO);

  /**
   * 今日已下单-查询记录
   *
   * @return baseMessage
   */
  BaseMessage getDataByToDay();

  /**
   * 暂存订单-查询记录
   *
   * @return baseMessage
   */
  BaseMessage getDataByTemporary();

  /**
   * 更新记录
   *
   * @param wardrobeSlideAddParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage updateData(WardrobeSlideAddParamVO wardrobeSlideAddParamVO);

  /**
   * 根据编号查询记录
   *
   * @param ddbh 订单记录
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
