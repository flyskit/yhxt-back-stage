package com.yhxt.khxd.jgm.controller;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.jgm.service.CrystalSteelDoorService;
import com.yhxt.khxd.jgm.vo.CrystalSteelDoorAddParamVO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName CrystalSteelDoorController
 * @Author zqi
 * @Date 2019/1/17 11:40
 * @Version 1.0
 * @Description 晶钢门模块
 */
@RestController
@RequestMapping(value = "/khxd/jgm")
public class CrystalSteelDoorController {

  @Resource
  private CrystalSteelDoorService crystalSteelDoorService;

  /**
   * 创建订单
   *
   * @param crystalSteelDoorAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/addData", method = RequestMethod.POST)
  public BaseMessage addData(@RequestBody CrystalSteelDoorAddParamVO crystalSteelDoorAddParamVO) {
    return crystalSteelDoorService.addData(crystalSteelDoorAddParamVO);
  }

  /**
   * 根据编号查询详细信息
   *
   * @param ddbh 编号
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByBh/{ddbh}", method = RequestMethod.POST)
  public BaseMessage getDataByBh(@PathVariable String ddbh) {
    if (StringUtils.isEmpty(ddbh)) {
      return BaseMessage.failed("参数为空");
    }
    return crystalSteelDoorService.getDataByBh(ddbh);
  }

  /**
   * 更新信息
   *
   * @param crystalSteelDoorAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/updateData", method = RequestMethod.POST)
  public BaseMessage updateData(@RequestBody CrystalSteelDoorAddParamVO crystalSteelDoorAddParamVO) {
    return crystalSteelDoorService.updateData(crystalSteelDoorAddParamVO);
  }

  /**
   * 今日已下单-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByToDay", method = RequestMethod.POST)
  public BaseMessage getDataByToDay() {
    return crystalSteelDoorService.getDataByToDay();
  }

  /**
   * 暂存列表-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByTemporary", method = RequestMethod.POST)
  public BaseMessage getDataByTemporary() {
    return crystalSteelDoorService.getDataByTemporary();
  }

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 查询条件
   * @return baseMessage
   */
  @RequestMapping(value = "/condData", method = RequestMethod.POST)
  public BaseMessage condData(@RequestBody OrderQueryParamVO orderQueryParamVO) {
    if (StringUtils.isEmpty(orderQueryParamVO)) {
      return BaseMessage.failed("参数为空");
    }
    return crystalSteelDoorService.condData(orderQueryParamVO);
  }
}
