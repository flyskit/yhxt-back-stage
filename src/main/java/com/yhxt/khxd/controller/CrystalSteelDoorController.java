package com.yhxt.khxd.controller;

import com.yhxt.common.BaseMessage;
import com.yhxt.khxd.service.CrystalSteelDoorService;
import com.yhxt.khxd.vo.CrystalSteelDoorParamVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName CrystalSteelDoorController
 * @Author zqi
 * @Date 2019/1/17 11:40
 * @Version 1.0
 * @Description 晶钢门模块
 */
@RestController
@RequestMapping(value = "/khxd")
public class CrystalSteelDoorController {

  @Resource
  private CrystalSteelDoorService crystalSteelDoorService;

  /**
   * 添加
   *
   * @param crystalSteelDoorParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/jgm/addData", method = RequestMethod.POST)
  public BaseMessage addData(@RequestBody CrystalSteelDoorParamVO crystalSteelDoorParamVO) {
    return crystalSteelDoorService.addData(crystalSteelDoorParamVO);
  }
}
