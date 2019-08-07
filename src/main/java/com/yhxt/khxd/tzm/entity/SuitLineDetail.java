package com.yhxt.khxd.tzm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName SuitLineDetail
 * @Author zqi
 * @Date 2019/7/17 10:25
 * @Version 1.0
 * @Description 套装门-线条类型
 */
@Entity
@Table(name = "suit_line_detail")
public class SuitLineDetail implements Serializable {
  private static final long serialVersionUID = 827695996961392707L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 材质
   */
  @Column(name = "cz")
  private String cz;

  /**
   * 造型
   */
  @Column(name = "zx")
  private String zx;

  /**
   * 类别
   */
  @Column(name = "lb")
  private String lb;

  /**
   * 颜色
   */
  @Column(name = "ys")
  private String ys;

  /**
   * 面板
   */
  @Column(name = "mb")
  private String mb;

  /**
   * 油漆
   */
  @Column(name = "yq")
  private String yq;

  /**
   * 规格
   */
  @Column(name = "gg")
  private String gg;

  /**
   * 数量
   */
  @Column(name = "ts")
  private Integer ts;

  /**
   * 单价
   */
  @Column(name = "dj")
  private BigDecimal dj;

  /**
   * 金额
   */
  @Column(name = "je")
  private BigDecimal je;

  /**
   * 备注
   */
  @Column(name = "bz")
  private String bz;

  public SuitLineDetail() {
  }

  public SuitLineDetail(String cz, String zx, String lb, String ys, String mb, String yq, String gg, Integer ts, BigDecimal dj, BigDecimal je, String bz) {
    this.cz = cz;
    this.zx = zx;
    this.lb = lb;
    this.ys = ys;
    this.mb = mb;
    this.yq = yq;
    this.gg = gg;
    this.ts = ts;
    this.dj = dj;
    this.je = je;
    this.bz = bz;
  }

  public BigDecimal getDj() {
    return dj;
  }

  public void setDj(BigDecimal dj) {
    this.dj = dj;
  }

  public BigDecimal getJe() {
    return je;
  }

  public void setJe(BigDecimal je) {
    this.je = je;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCz() {
    return cz;
  }

  public void setCz(String cz) {
    this.cz = cz;
  }

  public String getZx() {
    return zx;
  }

  public void setZx(String zx) {
    this.zx = zx;
  }

  public String getLb() {
    return lb;
  }

  public void setLb(String lb) {
    this.lb = lb;
  }

  public String getYs() {
    return ys;
  }

  public void setYs(String ys) {
    this.ys = ys;
  }

  public String getMb() {
    return mb;
  }

  public void setMb(String mb) {
    this.mb = mb;
  }

  public String getYq() {
    return yq;
  }

  public void setYq(String yq) {
    this.yq = yq;
  }

  public String getGg() {
    return gg;
  }

  public void setGg(String gg) {
    this.gg = gg;
  }

  public Integer getTs() {
    return ts;
  }

  public void setTs(Integer ts) {
    this.ts = ts;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  @Override
  public String toString() {
    return "SuitLineDetail{" +
            "id='" + id + '\'' +
            ", cz='" + cz + '\'' +
            ", zx='" + zx + '\'' +
            ", lb='" + lb + '\'' +
            ", ys='" + ys + '\'' +
            ", mb='" + mb + '\'' +
            ", yq='" + yq + '\'' +
            ", gg='" + gg + '\'' +
            ", ts=" + ts +
            ", bz='" + bz + '\'' +
            '}';
  }
}
