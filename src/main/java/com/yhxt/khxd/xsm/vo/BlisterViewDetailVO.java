package com.yhxt.khxd.xsm.vo;

import com.yhxt.ddcl.entity.OrderDetail;
import com.yhxt.khxd.xsm.entity.BlisterDetail;
import com.yhxt.khxd.xsm.entity.BlisterSize;

import java.util.List;

/**
 * @ClassName BlisterViewDetailVO
 * @Author zqi
 * @Date 2019/7/12 14:37
 * @Version 1.0
 * @Description 查询详细信息-返回字段
 */
public class BlisterViewDetailVO {

  /**
   * 订单信息
   */
  private OrderDetail orderDetail;

  /**
   * 亚克力门统计信息
   */
  private BlisterDetail blisterDetail;

  /**
   * 橱柜门尺寸信息
   */
  private List<BlisterSize> blisterSizes;

  /**
   * 配件信息
   */
  private StringBuilder accessoryListInfo;

  public BlisterViewDetailVO() {
  }

  public BlisterViewDetailVO(OrderDetail orderDetail, BlisterDetail blisterDetail, List<BlisterSize> blisterSizes, StringBuilder accessoryListInfo) {
    this.orderDetail = orderDetail;
    this.blisterDetail = blisterDetail;
    this.blisterSizes = blisterSizes;
    this.accessoryListInfo = accessoryListInfo;
  }

  public OrderDetail getOrderDetail() {
    return orderDetail;
  }

  public void setOrderDetail(OrderDetail orderDetail) {
    this.orderDetail = orderDetail;
  }

  public BlisterDetail getBlisterDetail() {
    return blisterDetail;
  }

  public void setBlisterDetail(BlisterDetail blisterDetail) {
    this.blisterDetail = blisterDetail;
  }

  public List<BlisterSize> getBlisterSizes() {
    return blisterSizes;
  }

  public void setBlisterSizes(List<BlisterSize> blisterSizes) {
    this.blisterSizes = blisterSizes;
  }

  public StringBuilder getAccessoryListInfo() {
    return accessoryListInfo;
  }

  public void setAccessoryListInfo(StringBuilder accessoryListInfo) {
    this.accessoryListInfo = accessoryListInfo;
  }

  @Override
  public String toString() {
    return "BlisterViewDetailVO{" +
            "orderDetail=" + orderDetail +
            ", blisterDetail=" + blisterDetail +
            ", blisterSizes=" + blisterSizes +
            ", accessoryListInfo=" + accessoryListInfo +
            '}';
  }
}
