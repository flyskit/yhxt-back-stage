package com.yhxt.khxd.yklm.service;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.yklm.vo.AcrylicAddParamVO;

/**
 * @ClassName AcrylicService
 * @Author zqi
 * @Date 2019/7/3 15:02
 * @Version 1.0
 * @Description 亚克力模块
 */
public interface AcrylicService {

  /**
   * 添加订单
   *
   * @param acrylicAddParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage addData(AcrylicAddParamVO acrylicAddParamVO);

  /**
   * 今日已下单-查询记录
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
   * 更新记录数据
   *
   * @param acrylicAddParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage updateData(AcrylicAddParamVO acrylicAddParamVO);


  /**
   * 根据编号查询详细信息
   *
   * @param ddbh 订单比那好
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
