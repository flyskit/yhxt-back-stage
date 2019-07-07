package com.yhxt.common;

/**
 * @ClassName AuditStatus
 * @Author zqi
 * @Date 2019/6/23 17:52
 * @Version 1.0
 * @Description
 */
public enum AuditStatus {
  /**
   * 未审核：0
   * 已审核：1
   */
  AUDIT_NO(0), AUDIT_YES(1);
  private final Integer value;

  AuditStatus(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}
