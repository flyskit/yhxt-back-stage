package com.yhxt.ddcl.common;

/**
 * @ClassName OrderStatus
 * @Author zqi
 * @Date 2019/6/23 16:58
 * @Version 1.0
 * @Description 订单-状态
 */
public enum OrderStatus {
  /**
   * 暂存：0
   * 已下单：1
   * 已发货：2
   * 安装中：3
   */
  TEMPORARY(0), SUBMIT(1);
  private final Integer value;

  OrderStatus(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}
