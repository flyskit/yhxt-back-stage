package com.yhxt.khxd.common;

/**
 * @ClassName CrystalSteelDoorOrderStatus
 * @Author zqi
 * @Date 2019/3/26 20:33
 * @Version 1.0
 * @Description 晶钢门-订单状态
 */
public enum CrystalSteelDoorOrderStatus {
  /**
   * 暂存：0
   * 提交：1
   * 撤销：2
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
