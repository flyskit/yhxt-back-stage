package com.yhxt.ddcl.common;

/**
 * @ClassName OrderType
 * @Author zqi
 * @Date 2019/6/25 18:37
 * @Version 1.0
 * @Description 订单类型
 */
public enum OrderType {
  /**
   * 新订单：0
   * 补单：1
   * 返工单：2
   */
  ORDER_NEW(0), ORDER_REMEDY(1), ORDER_REWORK(2);

  private final Integer value;

  OrderType(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}
