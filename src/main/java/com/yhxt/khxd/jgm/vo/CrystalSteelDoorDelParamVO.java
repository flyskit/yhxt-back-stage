package com.yhxt.khxd.jgm.vo;

/**
 * @ClassName CrystalSteelDoorDelParamVO
 * @Author zqi
 * @Date 2019/4/8 16:44
 * @Version 1.0
 * @Description 晶钢门-删除订单-提交信息
 */
public class CrystalSteelDoorDelParamVO {
  /**
   * 编号
   */
  private String bh;

  /**
   * 执行类别：删除/修改
   */
  private Integer zxlb;

  /**
   * 执行原因
   */
  private String zxyy;

  /**
   * 默认构造器
   */
  public CrystalSteelDoorDelParamVO() {
  }

  /**
   * 构造器重载
   *
   * @param bh   编号
   * @param zxlb 执行类别
   * @param zxyy 执行原因
   */
  public CrystalSteelDoorDelParamVO(String bh, Integer zxlb, String zxyy) {
    this.bh = bh;
    this.zxlb = zxlb;
    this.zxyy = zxyy;
  }

  public String getBh() {
    return bh;
  }

  public void setBh(String bh) {
    this.bh = bh;
  }

  public String getZxyy() {
    return zxyy;
  }

  public void setZxyy(String zxyy) {
    this.zxyy = zxyy;
  }

  public Integer getZxlb() {
    return zxlb;
  }

  public void setZxlb(Integer zxlb) {
    this.zxlb = zxlb;
  }

  @Override
  public String toString() {
    return "CrystalSteelDoorDelParamVO{" +
            "bh='" + bh + '\'' +
            ", zxlb='" + zxlb + '\'' +
            ", zxyy='" + zxyy + '\'' +
            '}';
  }
}
