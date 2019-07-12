package com.yhxt.khxd.xsm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName BlisterSize
 * @Author zqi
 * @Date 2019/7/12 14:16
 * @Version 1.0
 * @Description 吸塑门-尺寸信息
 */
@Entity
@Table(name = "blister_size")
public class BlisterSize implements Serializable {
  private static final long serialVersionUID = 7342731660124507789L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 位置
   */
  @Column(name = "wz")
  private String wz;

  /**
   * 造型
   */
  @Column(name = "zx")
  private String zx;

  /**
   * 颜色
   */
  @Column(name = "ys")
  private String ys;

  /**
   * 高度
   */
  @Column(name = "gd")
  private BigDecimal gd;

  /**
   * 宽度
   */
  @Column(name = "kd")
  private BigDecimal kd;

  /**
   * 数量
   */
  @Column(name = "sl")
  private Integer sl;

  /**
   * 平方
   */
  @Column(name = "pf")
  private BigDecimal pf;

  /**
   * 备注
   */
  @Column(name = "bz")
  private String bz;

  public BlisterSize() {
  }

  public BlisterSize(String wz, String zx, String ys, BigDecimal gd, BigDecimal kd, Integer sl, BigDecimal pf, String bz) {
    this.wz = wz;
    this.zx = zx;
    this.ys = ys;
    this.gd = gd;
    this.kd = kd;
    this.sl = sl;
    this.pf = pf;
    this.bz = bz;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getWz() {
    return wz;
  }

  public void setWz(String wz) {
    this.wz = wz;
  }

  public String getZx() {
    return zx;
  }

  public void setZx(String zx) {
    this.zx = zx;
  }

  public String getYs() {
    return ys;
  }

  public void setYs(String ys) {
    this.ys = ys;
  }

  public BigDecimal getGd() {
    return gd;
  }

  public void setGd(BigDecimal gd) {
    this.gd = gd;
  }

  public BigDecimal getKd() {
    return kd;
  }

  public void setKd(BigDecimal kd) {
    this.kd = kd;
  }

  public Integer getSl() {
    return sl;
  }

  public void setSl(Integer sl) {
    this.sl = sl;
  }

  public BigDecimal getPf() {
    return pf;
  }

  public void setPf(BigDecimal pf) {
    this.pf = pf;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  @Override
  public String toString() {
    return "BlisterSize{" +
            "id='" + id + '\'' +
            ", wz='" + wz + '\'' +
            ", zx='" + zx + '\'' +
            ", ys='" + ys + '\'' +
            ", gd=" + gd +
            ", kd=" + kd +
            ", sl=" + sl +
            ", pf=" + pf +
            ", bz='" + bz + '\'' +
            '}';
  }
}
