package com.yhxt.sjgl.common;

/**
 * @ClassName MaterialType
 * @Author zqi
 * @Date 2019/7/3 14:33
 * @Version 1.0
 * @Description 产品材质类型
 */
public enum MaterialType {
  /**
   * 亚克力门-多层板：1
   * 亚克力门-中纤板：2
   * 亚克力门-颗粒板：3
   */
  ACRYLIC_MULTILAYER(1), ACRYLIC_MDF(2), ACRYLIC_GRAIN(3);
  private final Integer value;

  MaterialType(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}
