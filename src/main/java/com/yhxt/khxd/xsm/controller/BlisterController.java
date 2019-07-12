package com.yhxt.khxd.xsm.controller;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.xsm.service.BlisterService;
import com.yhxt.khxd.xsm.vo.BlisterAddParamVO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName BlisterController
 * @Author zqi
 * @Date 2019/7/12 14:27
 * @Version 1.0
 * @Description 吸塑门
 */
@RestController
@RequestMapping(value = "/khxd/xsm")
public class BlisterController {

  @Resource
  private BlisterService blisterService;

  /**
   * 创建订单
   *
   * @param blisterAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/addData", method = RequestMethod.POST)
  public BaseMessage addData(@RequestBody BlisterAddParamVO blisterAddParamVO) {
    if (StringUtils.isEmpty(blisterAddParamVO)) {
      return BaseMessage.failed("参数为空");
    }
    return blisterService.addData(blisterAddParamVO);
  }

  /**
   * 今日已下单-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByToDay", method = RequestMethod.POST)
  public BaseMessage getDataByToDay() {
    return blisterService.getDataByToDay();
  }

  /**
   * 暂存列表-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByTemporary", method = RequestMethod.POST)
  public BaseMessage getDataByTemporary() {
    return blisterService.getDataByTemporary();
  }

  /**
   * 更新信息
   *
   * @param blisterAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/updateData", method = RequestMethod.POST)
  public BaseMessage updateData(@RequestBody BlisterAddParamVO blisterAddParamVO) {
    return blisterService.updateData(blisterAddParamVO);
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
    return blisterService.getDataByBh(ddbh);
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
    return blisterService.condData(orderQueryParamVO);
  }
}
