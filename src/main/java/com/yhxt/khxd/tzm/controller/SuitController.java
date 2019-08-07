package com.yhxt.khxd.tzm.controller;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.tzm.service.SuitService;
import com.yhxt.khxd.tzm.vo.SuitAddParamVO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName SuitController
 * @Author zqi
 * @Date 2019/7/17 10:32
 * @Version 1.0
 * @Description 套装门
 */
@RestController
@RequestMapping(value = "/khxd/tzm")
public class SuitController {

  @Resource
  private SuitService suitService;

  /**
   * 创建订单
   *
   * @param suitAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/addData", method = RequestMethod.POST)
  public BaseMessage addData(@RequestBody SuitAddParamVO suitAddParamVO) {
    if (StringUtils.isEmpty(suitAddParamVO)) {
      return BaseMessage.failed("参数为空");
    }
    return suitService.addData(suitAddParamVO);
  }

  /**
   * 今日已下单-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByToDay", method = RequestMethod.POST)
  public BaseMessage getDataByToDay() {
    return suitService.getDataByToDay();
  }

  /**
   * 暂存列表-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByTemporary", method = RequestMethod.POST)
  public BaseMessage getDataByTemporary() {
    return suitService.getDataByTemporary();
  }

  /**
   * 更新信息
   *
   * @param suitAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/updateData", method = RequestMethod.POST)
  public BaseMessage updateData(@RequestBody SuitAddParamVO suitAddParamVO) {
    return suitService.updateData(suitAddParamVO);
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
    return suitService.getDataByBh(ddbh);
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
    return suitService.condData(orderQueryParamVO);
  }
}
