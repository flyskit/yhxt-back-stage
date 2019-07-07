package com.yhxt.sjgl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName AccessoryDetail
 * @Author zqi
 * @Date 2019/6/20 15:46
 * @Version 1.0
 * @Description 配件表
 */
@Entity
@Table(name = "accessory_detail")
public class AccessoryDetail implements Serializable {
  private static final long serialVersionUID = 3228442446700248862L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 名称
   */
  @Column(name = "mc")
  private String mc;

  /**
   * 编号
   */
  @Column(name = "bh")
  private String bh;

  /**
   * 单价
   */
  @Column(name = "dj")
  private BigDecimal dj;

  /**
   * 单位
   */
  @Column(name = "dw")
  private String dw;

  /**
   * 规格
   */
  @Column(name = "gg")
  private String gg;

  /**
   * 备注
   */
  @Column(name = "bz")
  private String bz;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  /**
   * 默认构造器
   */
  public AccessoryDetail() {
  }

  public AccessoryDetail(String mc, String bh, BigDecimal dj, String dw, String gg, String bz, Boolean zt) {
    this.mc = mc;
    this.bh = bh;
    this.dj = dj;
    this.dw = dw;
    this.gg = gg;
    this.bz = bz;
    this.zt = zt;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }

  public String getDw() {
    return dw;
  }

  public void setDw(String dw) {
    this.dw = dw;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMc() {
    return mc;
  }

  public void setMc(String mc) {
    this.mc = mc;
  }

  public BigDecimal getDj() {
    return dj;
  }

  public void setDj(BigDecimal dj) {
    this.dj = dj;
  }

  public String getGg() {
    return gg;
  }

  public void setGg(String gg) {
    this.gg = gg;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public String getBh() {
    return bh;
  }

  public void setBh(String bh) {
    this.bh = bh;
  }

  @Override
  public String toString() {
    return "AccessoryDetail{" +
            "id='" + id + '\'' +
            ", mc='" + mc + '\'' +
            ", bh='" + bh + '\'' +
            ", dj=" + dj +
            ", dw='" + dw + '\'' +
            ", gg='" + gg + '\'' +
            ", bz='" + bz + '\'' +
            ", zt='" + zt + '\'' +
            '}';
  }
}
