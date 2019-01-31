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
}
