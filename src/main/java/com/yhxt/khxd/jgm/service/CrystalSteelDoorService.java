package com.yhxt.khxd.jgm.service;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.jgm.vo.CrystalSteelDoorAddParamVO;

/**
 * @ClassName CrystalSteelDoorService
 * @Author zqi
 * @Date 2019/1/17 11:43
 * @Version 1.0
 * @Description 晶钢门模块
 */
public interface CrystalSteelDoorService {
  /**
   * 添加订单
   *
   * @param crystalSteelDoorAddParamVO 参数
   * @return baseMessage 返回信息
   */
  BaseMessage addData(CrystalSteelDoorAddParamVO crystalSteelDoorAddParamVO);

  /**
   * 今日已下单-查询
   *
   * @return baseMessage
   */
  BaseMessage getDataByToDay();

  /**
   * 暂存列表-查询
   *
   * @return baseMassage
   */
  BaseMessage getDataByTemporary();

  /**
   * 查询详细信息
   *
   * @param ddbh 订单编号
   * @return baseMessage
   */
  BaseMessage getDataByBh(String ddbh);

  /**
   * 更新记录
   *
   * @param crystalSteelDoorAddParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage updateData(CrystalSteelDoorAddParamVO crystalSteelDoorAddParamVO);

  /**
   * 条件查询记录
   *
   * @param orderQueryParamVO 查询条件
   * @return baseMessage
   */
  BaseMessage condData(OrderQueryParamVO orderQueryParamVO);
}
