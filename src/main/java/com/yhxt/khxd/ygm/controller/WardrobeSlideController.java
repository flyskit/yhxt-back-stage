package com.yhxt.khxd.ygm.controller;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.ygm.service.WardrobeSlideService;
import com.yhxt.khxd.ygm.vo.WardrobeSlideAddParamVO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName WardrobeSlideController
 * @Author zqi
 * @Date 2019/7/13 15:05
 * @Version 1.0
 * @Description 衣柜移门
 */
@RestController
@RequestMapping(value = "/khxd/ygm")
public class WardrobeSlideController {

  @Resource
  private WardrobeSlideService wardrobeSlideService;

  /**
   * 创建订单
   *
   * @param wardrobeAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/addData", method = RequestMethod.POST)
  public BaseMessage addData(@RequestBody WardrobeSlideAddParamVO wardrobeAddParamVO) {
    if (StringUtils.isEmpty(wardrobeAddParamVO)) {
      return BaseMessage.failed("参数为空");
    }
    return wardrobeSlideService.addData(wardrobeAddParamVO);
  }

  /**
   * 今日已下单-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByToDay", method = RequestMethod.POST)
  public BaseMessage getDataByToDay() {
    return wardrobeSlideService.getDataByToDay();
  }

  /**
   * 暂存列表-查询
   *
   * @return baseMessage
   */
  @RequestMapping(value = "/getDataByTemporary", method = RequestMethod.POST)
  public BaseMessage getDataByTemporary() {
    return wardrobeSlideService.getDataByTemporary();
  }

  /**
   * 更新信息
   *
   * @param wardrobeSlideAddParamVO 接收参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/updateData", method = RequestMethod.POST)
  public BaseMessage updateData(@RequestBody WardrobeSlideAddParamVO wardrobeSlideAddParamVO) {
    return wardrobeSlideService.updateData(wardrobeSlideAddParamVO);
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
    return wardrobeSlideService.getDataByBh(ddbh);
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
    return wardrobeSlideService.condData(orderQueryParamVO);
  }
}
