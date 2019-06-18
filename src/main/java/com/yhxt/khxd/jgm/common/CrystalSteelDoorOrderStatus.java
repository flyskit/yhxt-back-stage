package com.yhxt.khxd.jgm.common;

/**
 * @ClassName CrystalSteelDoorOrderStatus
 * @Author zqi
 * @Date 2019/3/26 20:33
 * @Version 1.0
 * @Description 晶钢门-订单状态
 */
public enum CrystalSteelDoorOrderStatus {
  /**
   * 删除：0
   * 暂存：1
   * 已下单：2
   * 发货：3
   * 送货：4
   * 返工：5
   *
   */
  TEMPORARY(0), SUBMIT(1), REVOKE(2);
  private final Integer value;

  CrystalSteelDoorOrderStatus(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}
