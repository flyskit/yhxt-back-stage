package com.yhxt.khxd.thjm.vo;

import com.yhxt.ddcl.entity.OrderDetail;
import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorDetail;
import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorHangingSize;
import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorSwingSize;

import java.util.List;

/**
 * @ClassName TitaniumAlloyDoorViewDetailVO
 * @Author zqi
 * @Date 2019/7/9 14:03
 * @Version 1.0
 * @Description
 */
public class TitaniumAlloyDoorViewDetailVO {
  /**
   * 订单信息
   */
  private OrderDetail orderDetail;

  /**
   * 钛合金门统计信息
   */
  private TitaniumAlloyDoorDetail titaniumAlloyDoorDetail;

  /**
   * 钛合金-平开门尺寸信息
   */
  private List<TitaniumAlloyDoorSwingSize> swingSizeList;

  /**
   * 钛合金-吊趟门尺寸信息
   */
  private List<TitaniumAlloyDoorHangingSize> hangingSizeList;

  /**
   * 配件信息
   */
  private StringBuilder accessoryListInfo;

  public TitaniumAlloyDoorViewDetailVO() {
  }

  public TitaniumAlloyDoorViewDetailVO(OrderDetail orderDetail, TitaniumAlloyDoorDetail titaniumAlloyDoorDetail, StringBuilder accessoryListInfo) {
    this.orderDetail = orderDetail;
    this.titaniumAlloyDoorDetail = titaniumAlloyDoorDetail;
    this.accessoryListInfo = accessoryListInfo;
  }

  public OrderDetail getOrderDetail() {
    return orderDetail;
  }

  public void setOrderDetail(OrderDetail orderDetail) {
    this.orderDetail = orderDetail;
  }

  public TitaniumAlloyDoorDetail getTitaniumAlloyDoorDetail() {
    return titaniumAlloyDoorDetail;
  }

  public void setTitaniumAlloyDoorDetail(TitaniumAlloyDoorDetail titaniumAlloyDoorDetail) {
    this.titaniumAlloyDoorDetail = titaniumAlloyDoorDetail;
  }

  public List<TitaniumAlloyDoorSwingSize> getSwingSizeList() {
    return swingSizeList;
  }

  public void setSwingSizeList(List<TitaniumAlloyDoorSwingSize> swingSizeList) {
    this.swingSizeList = swingSizeList;
  }

  public List<TitaniumAlloyDoorHangingSize> getHangingSizeList() {
    return hangingSizeList;
  }

  public void setHangingSizeList(List<TitaniumAlloyDoorHangingSize> hangingSizeList) {
    this.hangingSizeList = hangingSizeList;
  }

  public StringBuilder getAccessoryListInfo() {
    return accessoryListInfo;
  }

  public void setAccessoryListInfo(StringBuilder accessoryListInfo) {
    this.accessoryListInfo = accessoryListInfo;
  }

  @Override
  public String toString() {
    return "TitaniumAlloyDoorViewDetailVO{" +
            "orderDetail=" + orderDetail +
            ", titaniumAlloyDoorDetail=" + titaniumAlloyDoorDetail +
            ", swingSizeList=" + swingSizeList +
            ", hangingSizeList=" + hangingSizeList +
            ", accessoryListInfo=" + accessoryListInfo +
            '}';
  }
}
