package com.yhxt.khxd.jgm.vo;

import com.yhxt.khxd.jgm.entity.JGMCCXX;
import com.yhxt.khxd.jgm.entity.JGMXDXX;

import java.util.List;

/**
 * @ClassName CrystalSteelDoorParamVO
 * @Author zqi
 * @Date 2019/1/18 15:18
 * @Version 1.0
 * @Description 晶钢门-参数
 */
public class CrystalSteelDoorParamVO {
  /**
   * 下单信息
   */
  private JGMXDXX xdxx;

  /**
   * 尺寸信息
   */
  private List<JGMCCXX> ccxx;

  /**
   * 默认构造器
   */
  public CrystalSteelDoorParamVO() {

  }

  /**
   * 构造器重载
   * @param xdxx 下单信息
   * @param ccxx 尺寸信息
   */
  public CrystalSteelDoorParamVO(JGMXDXX xdxx, List<JGMCCXX> ccxx) {
    this.xdxx = xdxx;
    this.ccxx = ccxx;
  }

  public JGMXDXX getXdxx() {
    return xdxx;
  }

  public void setXdxx(JGMXDXX xdxx) {
    this.xdxx = xdxx;
  }

  public List<JGMCCXX> getCcxx() {
    return ccxx;
  }

  public void setCcxx(List<JGMCCXX> ccxx) {
    this.ccxx = ccxx;
  }

  @Override
  public String toString() {
    return "CrystalSteelDoorParamVO{" +
            "xdxx=" + xdxx +
            ", list=" + ccxx +
            '}';
  }
}
