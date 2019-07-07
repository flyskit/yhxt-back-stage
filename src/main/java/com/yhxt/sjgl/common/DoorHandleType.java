package com.yhxt.sjgl.common;

/**
 * @ClassName DoorHandleType
 * @Author zqi
 * @Date 2019/6/24 10:53
 * @Version 1.0
 * @Description 拉手类型
 */
public enum DoorHandleType {
  /**
   * 晶钢门：1
   * 亚克力门：2
   */
  CRYSTAL_STEEL_DOOR(1), ACRYLIC(2);
  private final Integer value;

  DoorHandleType(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}
