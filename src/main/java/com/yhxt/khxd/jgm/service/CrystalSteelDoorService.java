package com.yhxt.khxd.jgm.service;

import com.yhxt.common.BaseMessage;
import com.yhxt.khxd.jgm.vo.CrystalSteelDoorFindParamVO;
import com.yhxt.khxd.jgm.vo.CrystalSteelDoorParamVO;

/**
 * @ClassName CrystalSteelDoorService
 * @Author zqi
 * @Date 2019/1/17 11:43
 * @Version 1.0
 * @Description 晶钢门模块
 */
public interface CrystalSteelDoorService {
  /**
   * 添加
   *
   * @param crystalSteelDoorParamVO 参数
   * @return baseMessage 返回信息
   */
  BaseMessage addData(CrystalSteelDoorParamVO crystalSteelDoorParamVO);

  /**
   * 获取编号
   *
   * @return baseMessage 返回信息
   */
  BaseMessage getBh();

  /**
   * 根据编号查找记录
   *
   * @param bh 编号
   * @return baseMessage
   */
  BaseMessage getDataByBh(String bh);

  /**
   * 查询今日已下单
   *
   * @return baseMessage
   */
  BaseMessage getDataByToDay();

  /**
   * 查询暂存订单
   *
   * @return baseMessage
   */
  BaseMessage getDataByTemporary();

  /**
   * 提交暂存订单
   *
   * @return bassMessage
   */
  BaseMessage subDataByTemporary(String bh);

  /**
   * 删除订单
   *
   * @param bh 编号
   * @return baseMessage
   */
  BaseMessage delData(String bh);

  /**
   * 更新订单
   *
   * @param crystalSteelDoorParamVO 更新信息
   * @return baseMessage
   */
  BaseMessage updateData(CrystalSteelDoorParamVO crystalSteelDoorParamVO);

  /**
   * 历史记录-条件查下账
   *
   * @param crystalSteelDoorFindParamVO 查询条件
   * @return baseMessage
   */
  BaseMessage pageDataByCond(CrystalSteelDoorFindParamVO crystalSteelDoorFindParamVO);
}
