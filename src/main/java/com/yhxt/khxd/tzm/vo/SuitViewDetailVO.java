package com.yhxt.khxd.tzm.vo;

import com.yhxt.ddcl.entity.OrderDetail;
import com.yhxt.khxd.tzm.entity.*;

import java.util.LinkedList;

/**
 * @ClassName SuitViewDetailVO
 * @Author zqi
 * @Date 2019/7/17 11:03
 * @Version 1.0
 * @Description 查看详细信息
 */
public class SuitViewDetailVO {

  /**
   * 订单信息
   */
  private OrderDetail orderDetail;

  /**
   * 套装门统计信息
   */
  private SuitDetail suitDetail;

  /**
   * 套装门-平开门尺寸信息
   */
  private LinkedList<SuitSwingSize> swingSizeList;

  /**
   * 套装门-推门尺寸信息
   */
  private LinkedList<SuitHangingSize> hangingSizeList;

  /**
   * 套装门-空套尺寸信息
   */
  private LinkedList<SuitPocketDetail> suitPocketDetailList;

  /**
   * 套装门-推门尺寸信息
   */
  private LinkedList<SuitLineDetail> suitLineDetailsList;

  /**
   * 配件信息
   */
  private StringBuilder accessoryListInfo;

  public SuitViewDetailVO() {
  }

  public SuitViewDetailVO(OrderDetail orderDetail, SuitDetail suitDetail, LinkedList<SuitSwingSize> swingSizeList, LinkedList<SuitHangingSize> hangingSizeList, LinkedList<SuitPocketDetail> suitPocketDetailList, LinkedList<SuitLineDetail> suitLineDetailsList) {
    this.orderDetail = orderDetail;
    this.suitDetail = suitDetail;
    this.swingSizeList = swingSizeList;
    this.hangingSizeList = hangingSizeList;
    this.suitPocketDetailList = suitPocketDetailList;
    this.suitLineDetailsList = suitLineDetailsList;
  }

  public SuitViewDetailVO(OrderDetail orderDetail, SuitDetail suitDetail, LinkedList<SuitSwingSize> swingSizeList, LinkedList<SuitHangingSize> hangingSizeList, LinkedList<SuitPocketDetail> suitPocketDetailList, LinkedList<SuitLineDetail> suitLineDetailsList, StringBuilder accessoryListInfo) {
    this.orderDetail = orderDetail;
    this.suitDetail = suitDetail;
    this.swingSizeList = swingSizeList;
    this.hangingSizeList = hangingSizeList;
    this.suitPocketDetailList = suitPocketDetailList;
    this.suitLineDetailsList = suitLineDetailsList;
    this.accessoryListInfo = accessoryListInfo;
  }

  public OrderDetail getOrderDetail() {
    return orderDetail;
  }

  public void setOrderDetail(OrderDetail orderDetail) {
    this.orderDetail = orderDetail;
  }

  public SuitDetail getSuitDetail() {
    return suitDetail;
  }

  public void setSuitDetail(SuitDetail suitDetail) {
    this.suitDetail = suitDetail;
  }

  public LinkedList<SuitSwingSize> getSwingSizeList() {
    return swingSizeList;
  }

  public void setSwingSizeList(LinkedList<SuitSwingSize> swingSizeList) {
    this.swingSizeList = swingSizeList;
  }

  public LinkedList<SuitHangingSize> getHangingSizeList() {
    return hangingSizeList;
  }

  public void setHangingSizeList(LinkedList<SuitHangingSize> hangingSizeList) {
    this.hangingSizeList = hangingSizeList;
  }

  public LinkedList<SuitPocketDetail> getSuitPocketDetailList() {
    return suitPocketDetailList;
  }

  public void setSuitPocketDetailList(LinkedList<SuitPocketDetail> suitPocketDetailList) {
    this.suitPocketDetailList = suitPocketDetailList;
  }

  public LinkedList<SuitLineDetail> getSuitLineDetailsList() {
    return suitLineDetailsList;
  }

  public void setSuitLineDetailsList(LinkedList<SuitLineDetail> suitLineDetailsList) {
    this.suitLineDetailsList = suitLineDetailsList;
  }

  public StringBuilder getAccessoryListInfo() {
    return accessoryListInfo;
  }

  public void setAccessoryListInfo(StringBuilder accessoryListInfo) {
    this.accessoryListInfo = accessoryListInfo;
  }

  @Override
  public String toString() {
    return "SuitViewDetailVO{" +
            "orderDetail=" + orderDetail +
            ", suitDetail=" + suitDetail +
            ", swingSizeList=" + swingSizeList +
            ", hangingSizeList=" + hangingSizeList +
            ", suitPocketDetailList=" + suitPocketDetailList +
            ", suitLineDetailsList=" + suitLineDetailsList +
            ", accessoryListInfo=" + accessoryListInfo +
            '}';
  }
}
