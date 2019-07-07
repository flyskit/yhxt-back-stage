package com.yhxt.khxd.jgm.vo;

import com.yhxt.ddcl.entity.OrderDetail;
import com.yhxt.khxd.jgm.entity.CrystalSteelDoorDetail;
import com.yhxt.khxd.jgm.entity.CupboardDoorSize;

import java.util.List;

/**
 * @ClassName CrystalSteelDoorViewDetailVO
 * @Author zqi
 * @Date 2019/6/27 20:04
 * @Version 1.0
 * @Description 查看详细信息-返回字段
 */
public class CrystalSteelDoorViewDetailVO {
  /**
   * 订单信息
   */
  private OrderDetail orderDetail;

  /**
   * 晶钢门统计信息
   */
  private CrystalSteelDoorDetail crystalSteelDoorDetail;

  /**
   * 橱柜门尺寸信息
   */
  private List<CupboardDoorSize> cupboardDoorSizes;

  /**
   * 配件信息
   */
  private StringBuilder accessoryListInfo;

  public CrystalSteelDoorViewDetailVO() {
  }

  public CrystalSteelDoorViewDetailVO(OrderDetail orderDetail, CrystalSteelDoorDetail crystalSteelDoorDetail, List<CupboardDoorSize> cupboardDoorSizes) {
    this.orderDetail = orderDetail;
    this.crystalSteelDoorDetail = crystalSteelDoorDetail;
    this.cupboardDoorSizes = cupboardDoorSizes;
  }

  public CrystalSteelDoorViewDetailVO(OrderDetail orderDetail, CrystalSteelDoorDetail crystalSteelDoorDetail, List<CupboardDoorSize> cupboardDoorSizes, StringBuilder accessoryListInfo) {
    this.orderDetail = orderDetail;
    this.crystalSteelDoorDetail = crystalSteelDoorDetail;
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

  public CrystalSteelDoorDetail getCrystalSteelDoorDetail() {
    return crystalSteelDoorDetail;
  }

  public void setCrystalSteelDoorDetail(CrystalSteelDoorDetail crystalSteelDoorDetail) {
    this.crystalSteelDoorDetail = crystalSteelDoorDetail;
  }

  public List<CupboardDoorSize> getCupboardDoorSizes() {
    return cupboardDoorSizes;
  }

  public void setCupboardDoorSizes(List<CupboardDoorSize> cupboardDoorSizes) {
    this.cupboardDoorSizes = cupboardDoorSizes;
  }

  @Override
  public String toString() {
    return "CrystalSteelDoorViewDetailVO{" +
            "orderDetail=" + orderDetail +
            ", crystalSteelDoorDetail=" + crystalSteelDoorDetail +
            ", cupboardDoorSizes=" + cupboardDoorSizes +
            ", accessoryListInfo=" + accessoryListInfo +
            '}';
  }
}
