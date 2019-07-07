package com.yhxt.khxd.yklm.vo;

import com.yhxt.ddcl.entity.OrderDetail;
import com.yhxt.khxd.jgm.entity.CupboardDoorSize;
import com.yhxt.khxd.yklm.entity.AcrylicDetail;

import java.util.List;

/**
 * @ClassName AcrylicViewDetailVO
 * @Author zqi
 * @Date 2019/7/3 16:32
 * @Version 1.0
 * @Description 查询详细信息-返回字段
 */
public class AcrylicViewDetailVO {
  /**
   * 订单信息
   */
  private OrderDetail orderDetail;

  /**
   * 亚克力门统计信息
   */
  private AcrylicDetail acrylicDetail;

  /**
   * 橱柜门尺寸信息
   */
  private List<CupboardDoorSize> cupboardDoorSizes;

  /**
   * 配件信息
   */
  private StringBuilder accessoryListInfo;

  public AcrylicViewDetailVO() {
  }

  public AcrylicViewDetailVO(OrderDetail orderDetail, AcrylicDetail acrylicDetail, List<CupboardDoorSize> cupboardDoorSizes) {
    this.orderDetail = orderDetail;
    this.acrylicDetail = acrylicDetail;
    this.cupboardDoorSizes = cupboardDoorSizes;
  }

  public AcrylicViewDetailVO(OrderDetail orderDetail, AcrylicDetail acrylicDetail, List<CupboardDoorSize> cupboardDoorSizes, StringBuilder accessoryListInfo) {
    this.orderDetail = orderDetail;
    this.acrylicDetail = acrylicDetail;
    this.cupboardDoorSizes = cupboardDoorSizes;
    this.accessoryListInfo = accessoryListInfo;
  }

  public StringBuilder getAccessoryListInfo() {
    return accessoryListInfo;
  }

  public void setAccessoryListInfo(StringBuilder accessoryListInfo) {
    this.accessoryListInfo = accessoryListInfo;
  }

  public OrderDetail getOrderDetail() {
    return orderDetail;
  }

  public void setOrderDetail(OrderDetail orderDetail) {
    this.orderDetail = orderDetail;
  }

  public AcrylicDetail getAcrylicDetail() {
    return acrylicDetail;
  }

  public void setAcrylicDetail(AcrylicDetail acrylicDetail) {
    this.acrylicDetail = acrylicDetail;
  }

  public List<CupboardDoorSize> getCupboardDoorSizes() {
    return cupboardDoorSizes;
  }

  public void setCupboardDoorSizes(List<CupboardDoorSize> cupboardDoorSizes) {
    this.cupboardDoorSizes = cupboardDoorSizes;
  }

  @Override
  public String toString() {
    return "AcrylicViewDetailVO{" +
            "orderDetail=" + orderDetail +
            ", acrylicDetail=" + acrylicDetail +
            ", cupboardDoorSizes=" + cupboardDoorSizes +
            ", accessoryListInfo='" + accessoryListInfo + '\'' +
            '}';
  }
}
