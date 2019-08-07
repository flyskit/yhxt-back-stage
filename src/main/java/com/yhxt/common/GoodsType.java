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
   * 吸塑门：5
   * 衣柜移门：6
   * 强化门：7
   * 实木贴面门：8
   * 原木门：9
   * 非常规门：10
   */
  CRYSTAL_STEEL_DOOR(1), ACRYLIC(2), TITANIUM_ALLOY_DOOR_SWING(3), TITANIUM_ALLOY_DOOR_HANGING(4), BLISTER(5), WARDROBE_SLIDE(6),
  ENHANCED_DOOR(7), SOLID_WOOD_PANEL(8), LOG_DOOR(9), UNCONVENTIONAL_DOOR(10);

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

  public static OrderGoods getBlister() {
    return new OrderGoods(GoodsType.BLISTER.value, "吸塑门");
  }

  public static OrderGoods getWardrobeSlide() {
    return new OrderGoods(GoodsType.WARDROBE_SLIDE.value, "衣柜移门");
  }

  public static OrderGoods getEnhancedDoor() {
    return new OrderGoods(GoodsType.ENHANCED_DOOR.value, "强化门");
  }

  public static OrderGoods getSolidWoodPanel() {
    return new OrderGoods(GoodsType.SOLID_WOOD_PANEL.value, "实木贴面门");
  }

  public static OrderGoods getLogDoor() {
    return new OrderGoods(GoodsType.LOG_DOOR.value, "原木门");
  }

  public static OrderGoods getUnconventionalDoor() {
    return new OrderGoods(GoodsType.UNCONVENTIONAL_DOOR.value, "非常规门");
  }
}
