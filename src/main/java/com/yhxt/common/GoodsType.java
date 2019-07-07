package com.yhxt.common;

import com.yhxt.ddcl.entity.OrderGoods;

/**
 * @ClassName BaseStatus
 * @Author zqi
 * @Date 2019/6/23 16:59
 * @Version 1.0
 * @Description 商品类型
 */
public enum GoodsType {
  /**
   * 晶钢门：1
   * 亚克力门：2
   * 钛合金门：3
   * 衣柜门：4
   */
  CRYSTAL_STEEL_DOOR(1), ACRYLIC(2);

  private final Integer value;

  GoodsType(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }

  public static OrderGoods getCrystalSteelDoor() {
    return new OrderGoods(GoodsType.CRYSTAL_STEEL_DOOR.value, "晶钢门");
  }

  public static OrderGoods getAcrylic() {
    return new OrderGoods(GoodsType.ACRYLIC.value, "亚克力门");
  }
}
