package com.yhxt.khxd.jgm.common;

/**
 * @ClassName CrystalSteelDoorOrderType
 * @Author zqi
 * @Date 2019/3/26 20:52
 * @Version 1.0
 * @Description
 */
public enum CrystalSteelDoorOrderType {
  /**
   * 新订单：0
   * 补单：1
   * 返工：2
   */
  NEW_ORDER(0), ADD_ORDER(1), REWORK_ORDER(2);
  private final Integer value;

  CrystalSteelDoorOrderType(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}
