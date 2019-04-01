package com.yhxt.khxd.common;

/**
 * @ClassName CrystalSteelDoorOrderRate
 * @Author zqi
 * @Date 2019/3/26 20:39
 * @Version 1.0
 * @Description 晶钢门-生产速率
 */
public enum  CrystalSteelDoorOrderRate {
  /**
   * 正常：0
   * 加急：1
   */
  NORMAL(0), URGENT(1);
  private final Integer value;

  CrystalSteelDoorOrderRate(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}
