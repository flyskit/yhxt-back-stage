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
   * 钛合金-平开门：3
   * 钛合金-吊趟门：4
   */
  CRYSTAL_STEEL_DOOR(1), ACRYLIC(2), TITANIUM_ALLOY_DOOR_SWING(3), TITANIUM_ALLOY_DOOR_HANGING(4);

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

  public static OrderGoods getTitaniumAlloyDoorSwing() {
    return new OrderGoods(GoodsType.TITANIUM_ALLOY_DOOR_SWING.value, "钛合金-平开门");
  }

  public static OrderGoods getTitaniumAlloyDoorHanging() {
    return new OrderGoods(GoodsType.TITANIUM_ALLOY_DOOR_HANGING.value, "钛合金-吊趟门");
  }
}
