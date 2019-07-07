package com.yhxt.sjgl.controller;

import com.yhxt.common.BaseMessage;
import com.yhxt.sjgl.entity.AccessoryDetail;
import com.yhxt.sjgl.entity.BoardPriceDetail;
import com.yhxt.sjgl.entity.DoorHandleDetail;
import com.yhxt.sjgl.service.DataManageService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName DataManageController
 * @Author zqi
 * @Date 2019/6/24 10:53
 * @Version 1.0
 * @Description 数据管理
 */
@RestController
@RequestMapping(value = "/sjgl")
public class DataManageController {

  @Resource
  private DataManageService dataManageService;

  /**
   * 拉手管理-添加拉手
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/addHandle", method = RequestMethod.POST)
  public BaseMessage addHandle(@RequestBody DoorHandleDetail doorHandleDetail) {
    if (StringUtils.isEmpty(doorHandleDetail)) {
      return BaseMessage.failed();
    }
    return dataManageService.addHandle(doorHandleDetail);
  }

  /**
   * 拉手管理-修改拉手信息
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/updateHandle", method = RequestMethod.POST)
  public BaseMessage updateHandle(@RequestBody DoorHandleDetail doorHandleDetail) {
    if (StringUtils.isEmpty(doorHandleDetail)) {
      return BaseMessage.failed();
    }
    return dataManageService.updateHandle(doorHandleDetail);
  }

  /**
   * 拉手管理-删除拉手
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/delHandle/{id}", method = RequestMethod.POST)
  public BaseMessage delHandle(@PathVariable String id) {
    if (StringUtils.isEmpty(id)) {
      return BaseMessage.failed();
    }
    return dataManageService.delHandle(id);
  }

  /**
   * 拉手管理-根据类型获取拉手
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/getHandleByType/{handleType}", method = RequestMethod.POST)
  public BaseMessage getHandleByType(@PathVariable Integer handleType) {
    if (StringUtils.isEmpty(handleType)) {
      return BaseMessage.failed();
    }
    return dataManageService.getHandleByType(handleType);
  }

  /**
   * 配件管理-添加配件
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/addAccessory", method = RequestMethod.POST)
  public BaseMessage addAccessory(@RequestBody AccessoryDetail accessoryDetail) {
    if (StringUtils.isEmpty(accessoryDetail)) {
      return BaseMessage.failed("参数为空");
    }
    return dataManageService.addAccessory(accessoryDetail);
  }

  /**
   * 配件管理-修改配件信息
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/updateAccessory", method = RequestMethod.POST)
  public BaseMessage updateAccessory(@RequestBody AccessoryDetail accessoryDetail) {
    if (StringUtils.isEmpty(accessoryDetail)) {
      return BaseMessage.failed("参数为空");
    }
    return dataManageService.updateAccessory(accessoryDetail);
  }

  /**
   * 配件管理-删除配件
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/delAccessory/{id}", method = RequestMethod.POST)
  public BaseMessage delAccessory(@PathVariable String id) {
    if (StringUtils.isEmpty(id)) {
      return BaseMessage.failed("参数为空");
    }
    return dataManageService.delAccessory(id);
  }


  /**
   * 配件管理-根据配件名称模糊查询配件信息
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/getAccessoryByName/{accessoryName}", method = RequestMethod.POST)
  public BaseMessage getAccessoryByName(@PathVariable String accessoryName) {
    if (StringUtils.isEmpty(accessoryName)) {
      return BaseMessage.failed("参数为空");
    }
    return dataManageService.getAccessoryByName(accessoryName);
  }

  /**
   * 板材报价管理-添加材料信息
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/addBoardPriceDetail", method = RequestMethod.POST)
  public BaseMessage addBoardPriceDetail(@RequestBody BoardPriceDetail boardPriceDetail) {
    if (StringUtils.isEmpty(boardPriceDetail)) {
      return BaseMessage.failed("参数为空");
    }
    return dataManageService.addBoardPriceDetail(boardPriceDetail);
  }

  /**
   * 板材报价管理-修改材料信息
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/updateBoardPriceDetail", method = RequestMethod.POST)
  public BaseMessage updateBoardPriceDetail(@RequestBody BoardPriceDetail boardPriceDetail) {
    if (StringUtils.isEmpty(boardPriceDetail)) {
      return BaseMessage.failed("参数为空");
    }
    return dataManageService.updateBoardPriceDetail(boardPriceDetail);
  }

  /**
   * 板材报价管理-删除板材报价
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/delBoardPriceDetail/{id}", method = RequestMethod.POST)
  public BaseMessage delBoardPriceDetail(@PathVariable String id) {
    if (StringUtils.isEmpty(id)) {
      return BaseMessage.failed("参数为空");
    }
    return dataManageService.delBoardPriceDetail(id);
  }


  /**
   * 板材报价管理-根据商品类型查询记录
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/getBoardPriceDetailByGoodsType/{splx}", method = RequestMethod.POST)
  public BaseMessage getBoardPriceDetailByGoodsType(@PathVariable Integer splx) {
    if (StringUtils.isEmpty(splx)) {
      return BaseMessage.failed("参数为空");
    }
    return dataManageService.getBoardPriceDetailByGoodsType(splx);
  }

  /**
   * 客户管理-根据客户姓名模糊查询客户信息
   *
   * @return baseMessage 返回信息
   */
  @RequestMapping(value = "/getCustomerByName/{customerName}", method = RequestMethod.POST)
  public BaseMessage getCustomerByName(@PathVariable String customerName) {
    return dataManageService.getCustomerByName(customerName);
  }
}
