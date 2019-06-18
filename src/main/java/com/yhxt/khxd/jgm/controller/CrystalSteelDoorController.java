package com.yhxt.khxd.jgm.controller;

import com.yhxt.common.BaseMessage;
import com.yhxt.khxd.jgm.service.CrystalSteelDoorService;
import com.yhxt.khxd.jgm.vo.CrystalSteelDoorFindParamVO;
import com.yhxt.khxd.jgm.vo.CrystalSteelDoorParamVO;
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
@RequestMapping(value = "/khxd")
public class CrystalSteelDoorController {

  @Resource
  private CrystalSteelDoorService crystalSteelDoorService;

  /**
   * 获取编号
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/jgm/getBh", method = RequestMethod.POST)
  public BaseMessage getBh() {
    return crystalSteelDoorService.getBh();
  }

  /**
   * 添加订单
   *
   * @param crystalSteelDoorParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/jgm/addData", method = RequestMethod.POST)
  public BaseMessage addData(@RequestBody CrystalSteelDoorParamVO crystalSteelDoorParamVO) {
    return crystalSteelDoorService.addData(crystalSteelDoorParamVO);
  }

  /**
   * 更新信息
   *
   * @param crystalSteelDoorParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/jgm/updateData", method = RequestMethod.POST)
  public BaseMessage updateData(@RequestBody CrystalSteelDoorParamVO crystalSteelDoorParamVO) {
    return crystalSteelDoorService.updateData(crystalSteelDoorParamVO);
  }

  /**
   * 删除订单
   *
   * @param bh 编号
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/jgm/delData/{bh}", method = RequestMethod.POST)
  public BaseMessage delData(@PathVariable String bh) {
    return crystalSteelDoorService.delData(bh);
  }

  /**
   * 根据编号查找记录
   *
   * @param bh 编号
   * @return baseMessage
   */
  @RequestMapping(value = "/jgm/getDataByBh/{bh}", method = RequestMethod.POST)
  public BaseMessage getDataByBh(@PathVariable String bh) {
    return crystalSteelDoorService.getDataByBh(bh);
  }

  /**
   * 今日已下单-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/jgm/getDataByToDay", method = RequestMethod.POST)
  public BaseMessage getDataByToDay() {
    return crystalSteelDoorService.getDataByToDay();
  }

  /**
   * 暂存列表-查询暂存订单
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/jgm/getDataByTemporary", method = RequestMethod.POST)
  public BaseMessage getDataByTemporary() {
    return crystalSteelDoorService.getDataByTemporary();
  }

  /**
   * 暂存列表-提交暂存订单
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/jgm/subDataByTemporary/{bh}", method = RequestMethod.POST)
  public BaseMessage subDataByTemporary(@PathVariable String bh) {
    return crystalSteelDoorService.subDataByTemporary(bh);
  }

  /**
   * 历史记录-条件查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/jgm/pageDataByCond", method = RequestMethod.POST)
  public BaseMessage pageDataByCond(@RequestBody CrystalSteelDoorFindParamVO crystalSteelDoorFindParamVO) {
    return crystalSteelDoorService.pageDataByCond(crystalSteelDoorFindParamVO);
  }
}
