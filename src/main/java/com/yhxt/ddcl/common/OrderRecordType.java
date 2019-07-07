package com.yhxt.ddcl.common;

import com.yhxt.ddcl.entity.OrderRecord;

/**
 * @ClassName OrderRecordType
 * @Author zqi
 * @Date 2019/6/23 19:43
 * @Version 1.0
 * @Description 订单信息-操作记录类别
 */
public enum OrderRecordType {
  /**
   * 新建：1
   * 修改：2
   * 删除：3
   */
  NEW(1), UPDATE(2), DELETE(3);

  private final Integer value;

  OrderRecordType(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }

  public static OrderRecord getNew() {
    return new OrderRecord(OrderRecordType.NEW.value, "下单");
  }

  public static OrderRecord getUpdate() {
    return new OrderRecord(OrderRecordType.UPDATE.value, "修改");
  }

  public static OrderRecord getUDelete() {
    return new OrderRecord(OrderRecordType.DELETE.value, "删除");
  }
}
