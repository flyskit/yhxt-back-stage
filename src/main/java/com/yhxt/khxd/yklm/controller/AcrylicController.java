package com.yhxt.khxd.yklm.controller;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.yklm.service.AcrylicService;
import com.yhxt.khxd.yklm.vo.AcrylicAddParamVO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName AcrylicController
 * @Author zqi
 * @Date 2019/7/3 15:00
 * @Version 1.0
 * @Description 亚克力门模块
 */
@RestController
@RequestMapping(value = "/khxd/ykl")
public class AcrylicController {

  @Resource
  private AcrylicService acrylicService;

  /**
   * 创建订单
   *
   * @param acrylicAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/addData", method = RequestMethod.POST)
  public BaseMessage addData(@RequestBody AcrylicAddParamVO acrylicAddParamVO) {
    if (StringUtils.isEmpty(acrylicAddParamVO)) {
      return BaseMessage.failed("参数为空");
    }
    return acrylicService.addData(acrylicAddParamVO);
  }

  /**
   * 今日已下单-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByToDay", method = RequestMethod.POST)
  public BaseMessage getDataByToDay() {
    return acrylicService.getDataByToDay();
  }

  /**
   * 暂存列表-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByTemporary", method = RequestMethod.POST)
  public BaseMessage getDataByTemporary() {
    return acrylicService.getDataByTemporary();
  }

  /**
   * 更新信息
   *
   * @param acrylicAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/updateData", method = RequestMethod.POST)
  public BaseMessage updateData(@RequestBody AcrylicAddParamVO acrylicAddParamVO) {
    return acrylicService.updateData(acrylicAddParamVO);
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
    return acrylicService.getDataByBh(ddbh);
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
    return acrylicService.condData(orderQueryParamVO);
  }
}
