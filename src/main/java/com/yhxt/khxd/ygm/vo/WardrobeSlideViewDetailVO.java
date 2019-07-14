package com.yhxt.khxd.ygm.vo;

import com.yhxt.ddcl.entity.OrderDetail;
import com.yhxt.khxd.ygm.entity.WardrobeSlideDetail;
import com.yhxt.khxd.ygm.entity.WardrobeSlideSize;

import java.util.List;

/**
 * @ClassName WardrobeSlideViewDetailVO
 * @Author zqi
 * @Date 2019/7/13 15:25
 * @Version 1.0
 * @Description 详细信息
 */
public class WardrobeSlideViewDetailVO {
  /**
   * 订单信息
   */
  private OrderDetail orderDetail;

  /**
   * 衣柜移门统计信息
   */
  private WardrobeSlideDetail wardrobeSlideDetail;

  /**
   * 移门尺寸信息
   */
  private List<WardrobeSlideSize> wardrobeSlideSizes;

  /**
   * 配件信息
   */
  private StringBuilder accessoryListInfo;

  public WardrobeSlideViewDetailVO() {
  }

  public WardrobeSlideViewDetailVO(OrderDetail orderDetail, WardrobeSlideDetail wardrobeSlideDetail, List<WardrobeSlideSize> wardrobeSlideSizes, StringBuilder accessoryListInfo) {
    this.orderDetail = orderDetail;
    this.wardrobeSlideDetail = wardrobeSlideDetail;
    this.wardrobeSlideSizes = wardrobeSlideSizes;
    this.accessoryListInfo = accessoryListInfo;
  }

  public OrderDetail getOrderDetail() {
    return orderDetail;
  }

  public void setOrderDetail(OrderDetail orderDetail) {
    this.orderDetail = orderDetail;
  }

  public WardrobeSlideDetail getWardrobeSlideDetail() {
    return wardrobeSlideDetail;
  }

  public void setWardrobeSlideDetail(WardrobeSlideDetail wardrobeSlideDetail) {
    this.wardrobeSlideDetail = wardrobeSlideDetail;
  }

  public List<WardrobeSlideSize> getWardrobeSlideSizes() {
    return wardrobeSlideSizes;
  }

  public void setWardrobeSlideSizes(List<WardrobeSlideSize> wardrobeSlideSizes) {
    this.wardrobeSlideSizes = wardrobeSlideSizes;
  }

  public StringBuilder getAccessoryListInfo() {
    return accessoryListInfo;
  }

  public void setAccessoryListInfo(StringBuilder accessoryListInfo) {
    this.accessoryListInfo = accessoryListInfo;
  }

  @Override
  public String toString() {
    return "WardrobeSlideViewDetailVO{" +
            "orderDetail=" + orderDetail +
            ", wardrobeSlideDetail=" + wardrobeSlideDetail +
            ", wardrobeSlideSizes=" + wardrobeSlideSizes +
            ", accessoryListInfo=" + accessoryListInfo +
            '}';
  }
}
