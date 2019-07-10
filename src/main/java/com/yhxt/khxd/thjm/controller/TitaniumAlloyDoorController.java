package com.yhxt.khxd.thjm.controller;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.thjm.service.TitaniumAlloyDoorService;
import com.yhxt.khxd.thjm.vo.TitaniumAlloyDoorHangingAddParamVO;
import com.yhxt.khxd.thjm.vo.TitaniumAlloyDoorSwingAddParamVO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName TitaniumAlloyDoorController
 * @Author zqi
 * @Date 2019/7/9 13:05
 * @Version 1.0
 * @Description 钛合金门
 */
@RestController
@RequestMapping(value = "/khxd/thjm")
public class TitaniumAlloyDoorController {

  @Resource
  private TitaniumAlloyDoorService titaniumAlloyDoorService;

  /**
   * 创建订单-平开门
   *
   * @param titaniumAlloyDoorSwingAddParamVO 订单字段
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/addDataSwing", method = RequestMethod.POST)
  public BaseMessage addDataSwing(@RequestBody TitaniumAlloyDoorSwingAddParamVO titaniumAlloyDoorSwingAddParamVO) {
    return titaniumAlloyDoorService.addDataSwing(titaniumAlloyDoorSwingAddParamVO);
  }

  /**
   * 创建订单-吊趟门
   *
   * @param titaniumAlloyDoorHangingAddParamVO 订单字段
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/addDataHanging", method = RequestMethod.POST)
  public BaseMessage addDataHanging(@RequestBody TitaniumAlloyDoorHangingAddParamVO titaniumAlloyDoorHangingAddParamVO) {
    return titaniumAlloyDoorService.addDataHanging(titaniumAlloyDoorHangingAddParamVO);
  }

  /**
   * 更新信息-平开门
   *
   * @param titaniumAlloyDoorSwingAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/updateDataSwing", method = RequestMethod.POST)
  public BaseMessage updateDataSwing(@RequestBody TitaniumAlloyDoorSwingAddParamVO titaniumAlloyDoorSwingAddParamVO) {
    return titaniumAlloyDoorService.updateDataSwing(titaniumAlloyDoorSwingAddParamVO);
  }

  /**
   * 更新信息-吊趟门
   *
   * @param titaniumAlloyDoorHangingAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/updateDataHanging", method = RequestMethod.POST)
  public BaseMessage updateDataHanging(@RequestBody TitaniumAlloyDoorHangingAddParamVO titaniumAlloyDoorHangingAddParamVO) {
    return titaniumAlloyDoorService.updateDataHanging(titaniumAlloyDoorHangingAddParamVO);
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
    return titaniumAlloyDoorService.getDataByBh(ddbh);
  }

  /**
   * 今日已下单-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByToDay", method = RequestMethod.POST)
  public BaseMessage getDataByToDay() {
    return titaniumAlloyDoorService.getDataByToDay();
  }

  /**
   * 暂存列表-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByTemporary", method = RequestMethod.POST)
  public BaseMessage getDataByTemporary() {
    return titaniumAlloyDoorService.getDataByTemporary();
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
    return titaniumAlloyDoorService.condData(orderQueryParamVO);
  }
}
