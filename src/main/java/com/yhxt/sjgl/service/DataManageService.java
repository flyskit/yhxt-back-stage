package com.yhxt.sjgl.service;

import com.yhxt.common.BaseMessage;
import com.yhxt.sjgl.entity.AccessoryDetail;
import com.yhxt.sjgl.entity.BoardPriceDetail;
import com.yhxt.sjgl.entity.DoorHandleDetail;

/**
 * @ClassName DataManageService
 * @Author zqi
 * @Date 2019/6/24 10:58
 * @Version 1.0
 * @Description 数据管理
 */
public interface DataManageService {
  /**
   * 添加拉手
   *
   * @param doorHandleDetail 拉手信息
   * @return baseMessage
   */
  BaseMessage addHandle(DoorHandleDetail doorHandleDetail);

  /**
   * 修改拉手信息
   *
   * @param doorHandleDetail 拉手信息
   * @return baseMessage
   */
  BaseMessage updateHandle(DoorHandleDetail doorHandleDetail);

  /**
   * 删除拉手
   *
   * @param id id标识
   * @return baseMessage
   */
  BaseMessage delHandle(String id);

  /**
   * 根据类型获取拉手
   *
   * @param handleType 拉手类型
   * @return baseMessage
   */
  BaseMessage getHandleByType(Integer handleType);

  /**
   * 根据客户姓名模糊查询客户
   *
   * @param customerName 客户姓名
   * @return baseMessage
   */
  BaseMessage getCustomerByName(String customerName);

  /**
   * 添加配件
   *
   * @param accessoryDetail 配件信息
   * @return baseMessage
   */
  BaseMessage addAccessory(AccessoryDetail accessoryDetail);

  /**
   * 删除配件
   *
   * @param id id标识
   * @return baseMessage
   */
  BaseMessage delAccessory(String id);

  /**
   * 修改配件信息
   *
   * @param accessoryDetail 配件信息
   * @return baseMessage
   */
  BaseMessage updateAccessory(AccessoryDetail accessoryDetail);

  /**
   * 根据配件名模糊查询配件列表
   *
   * @param accessoryName 配件名称
   * @return baseMessage
   */
  BaseMessage getAccessoryByName(String accessoryName);

  /**
   * 板材报价管理-添加材料报价信息
   *
   * @param boardPriceDetail 材料报价信息
   * @return baseMessage
   */
  BaseMessage addBoardPriceDetail(BoardPriceDetail boardPriceDetail);

  /**
   * 板材报价管理-修改材料报价信息
   *
   * @param boardPriceDetail 材料报价信息
   * @return baseMessage
   */
  BaseMessage updateBoardPriceDetail(BoardPriceDetail boardPriceDetail);

  /**
   * 板材报价管理-删除材料报价ixnxi
   *
   * @param id id标识
   * @return baseMessage
   */
  BaseMessage delBoardPriceDetail(String id);

  /**
   * 板材报价管理-根据商品类型查询记录
   *
   * @param splx 商品类型
   * @return baseMessage
   */
  BaseMessage getBoardPriceDetailByGoodsType(Integer splx);
}
