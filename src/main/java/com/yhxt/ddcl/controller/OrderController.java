package com.yhxt.ddcl.controller;

import com.yhxt.common.BaseMessage;
import com.yhxt.ddcl.service.OrderService;
import com.yhxt.ddcl.vo.OrderAccessoryParamVO;
import com.yhxt.ddcl.vo.OrderDelParamVO;
import com.yhxt.ddcl.vo.OrderUpdateStatusVO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Author zqi
 * @Date 2019/6/24 9:41
 * @Version 1.0
 * @Description 订单信息处理
 */
@RestController
@RequestMapping(value = "/ddcl")
public class OrderController {

  @Resource
  private OrderService orderService;

  /**
   * 获取编号
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/getOrderNumber", method = RequestMethod.POST)
  public BaseMessage addData() {
    return orderService.getOrderNumber();
  }

  /**
   * 修改订单状态
   *
   * @param orderUpdateStatusVO 参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/orderUpdateStatus", method = RequestMethod.POST)
  public BaseMessage orderUpdateStatus(@RequestBody OrderUpdateStatusVO orderUpdateStatusVO) {
    if (StringUtils.isEmpty(orderUpdateStatusVO)) {
      return BaseMessage.failed("接受参数为空");
    }
    return orderService.orderUpdateStatus(orderUpdateStatusVO);
  }

  /**
   * 删除订单
   *
   * @param orderDelParamVO 参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/delData", method = RequestMethod.POST)
  public BaseMessage delData(@RequestBody OrderDelParamVO orderDelParamVO) {
    if (StringUtils.isEmpty(orderDelParamVO)) {
      return BaseMessage.failed("接受参数为空");
    }
    return orderService.delData(orderDelParamVO);
  }

  /**
   * 订单-添加配件
   *
   * @param orderAccessoryParamVO 参数
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/addAccessory", method = RequestMethod.POST)
  public BaseMessage addAccessory(@RequestBody OrderAccessoryParamVO orderAccessoryParamVO) {
    if (StringUtils.isEmpty(orderAccessoryParamVO)) {
      return BaseMessage.failed("接受参数为空");
    }
    return orderService.addAccessory(orderAccessoryParamVO);
  }

  /**
   * 查询配件列表
   *
   * @param ddbh 订单编号
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/getAccessory/{ddbh}", method = RequestMethod.POST)
  public BaseMessage getAccessory(@PathVariable String ddbh) {
    if (StringUtils.isEmpty(ddbh)) {
      return BaseMessage.failed("接受参数为空");
    }
    return orderService.getAccessory(ddbh);
  }

  /**
   * 删除订单-配件
   *
   * @param id 订单-配件id
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/delAccessory/{id}", method = RequestMethod.POST)
  public BaseMessage delAccessory(@PathVariable String id) {
    if (StringUtils.isEmpty(id)) {
      return BaseMessage.failed("接受参数为空");
    }
    return orderService.delAccessory(id);
  }
}
