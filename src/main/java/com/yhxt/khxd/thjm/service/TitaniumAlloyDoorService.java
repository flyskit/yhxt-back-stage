package com.yhxt.khxd.thjm.service;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.thjm.vo.TitaniumAlloyDoorHangingAddParamVO;
import com.yhxt.khxd.thjm.vo.TitaniumAlloyDoorSwingAddParamVO;

/**
 * @ClassName TitaniumAlloyDoorService
 * @Author zqi
 * @Date 2019/7/9 13:06
 * @Version 1.0
 * @Description 钛合金模块
 */
public interface TitaniumAlloyDoorService {
  /**
   * 添加订单-平开门
   *
   * @param titaniumAlloyDoorSwingAddParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage addDataSwing(TitaniumAlloyDoorSwingAddParamVO titaniumAlloyDoorSwingAddParamVO);

  /**
   * 添加订单-吊趟门
   *
   * @param titaniumAlloyDoorHangingAddParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage addDataHanging(TitaniumAlloyDoorHangingAddParamVO titaniumAlloyDoorHangingAddParamVO);

  /**
   * 更新信息-平开门
   *
   * @param titaniumAlloyDoorSwingAddParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage updateDataSwing(TitaniumAlloyDoorSwingAddParamVO titaniumAlloyDoorSwingAddParamVO);

  /**
   * 更新信息-吊趟门
   *
   * @param titaniumAlloyDoorHangingAddParamVO 接受参数
   * @return baseMessage
   */
  BaseMessage updateDataHanging(TitaniumAlloyDoorHangingAddParamVO titaniumAlloyDoorHangingAddParamVO);

  /**
   * 根据编号查询记录
   *
   * @param ddbh 订单编号
   * @return baseMessage
   */
  BaseMessage getDataByBh(String ddbh);

  /**
   * 今日已下单-查询记录
   *
   * @return baseMessage
   */
  BaseMessage getDataByToDay();

  /**
   * 暂存列表-查询记录
   *
   * @return baseMessage
   */
  BaseMessage getDataByTemporary();

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 查询条件
   * @return baseMessage
   */
  BaseMessage condData(OrderQueryParamVO orderQueryParamVO);
}
