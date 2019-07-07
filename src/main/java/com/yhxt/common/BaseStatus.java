package com.yhxt.common;

/**
 * @ClassName BaseStatus
 * @Author zqi
 * @Date 2019/6/23 16:59
 * @Version 1.0
 * @Description 基本状态
 */
public enum BaseStatus {
  /**
   * 无效：false
   * 有效：true
   */
  INVALID(false), VALID(true);

  private final Boolean value;

  BaseStatus(Boolean value) {
    this.value = value;
  }

  public Boolean getValue() {
    return this.value;
  }
}
