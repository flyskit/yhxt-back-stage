package com.yhxt.khxd.tzm.common;

import com.yhxt.common.BaseStatus;
import com.yhxt.khxd.tzm.entity.SuitDetailType;

/**
 * @ClassName SuitDoorType
 * @Author zqi
 * @Date 2019/7/17 10:30
 * @Version 1.0
 * @Description 原木门-尺寸类型
 */
public enum SuitDoorType {
  /**
   * 平开门：1
   * 推门：2
   * 空套：3
   * 线条：4
   */
  TYPE_SWING(1), TYPE_HANGING(2), TYPE_POCKET(3), TYPE_LINE(4);

  private final Integer value;

  SuitDoorType(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }

  public static SuitDetailType getSwing() {
    return new SuitDetailType(SuitDoorType.TYPE_SWING.getValue(), BaseStatus.VALID.getValue());
  }

  public static SuitDetailType getHanging() {
    return new SuitDetailType(SuitDoorType.TYPE_HANGING.getValue(), BaseStatus.VALID.getValue());
  }

  public static SuitDetailType getPocket() {
    return new SuitDetailType(SuitDoorType.TYPE_POCKET.getValue(), BaseStatus.VALID.getValue());
  }

  public static SuitDetailType getLine() {
    return new SuitDetailType(SuitDoorType.TYPE_LINE.getValue(), BaseStatus.VALID.getValue());
  }
}
