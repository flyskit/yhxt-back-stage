package com.yhxt.khxd.service;

import com.yhxt.common.BaseMessage;
import com.yhxt.khxd.vo.CrystalSteelDoorParamVO;

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
}
