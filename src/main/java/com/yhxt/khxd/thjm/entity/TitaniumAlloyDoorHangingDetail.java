package com.yhxt.khxd.thjm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName TitaniumAlloyDoorHangingDetail
 * @Author zqi
 * @Date 2019/6/20 17:08
 * @Version 1.0
 * @Description 钛合金-吊趟门基本信息标配
 */
@Entity
@Table(name = "titanium_alloy_door_hanging_detail")
public class TitaniumAlloyDoorHangingDetail implements Serializable {
  private static final long serialVersionUID = 946898748161547850L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 类型颜色
   */
  @Column(name = "lxys")
  private String lxys;

  /**
   * 造型
   */
  @Column(name = "zx")
  private String zx;

  /**
   * 玻璃
   */
  @Column(name = "bl")
  private String bl;

  /**
   * 推门
   */
  @Column(name = "tm")
  private String tm;

  /**
   * 门锁
   */
  @Column(name = "ms")
  private String ms;

  /**
   * 包套
   */
  @Column(name = "bt")
  private String bt;

  /**
   * 挂门
   */
  @Column(name = "gm")
  private String gm;

  /**
   * 边线
   */
  @Column(name = "bx")
  private String bx;

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
   * 厚度
   */
  @Column(name = "hd")
  private BigDecimal hd;

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
   * 默认构造器
   */
  public TitaniumAlloyDoorHangingDetail() {
  }

  public TitaniumAlloyDoorHangingDetail(String lxys, String zx, String bl, String tm, String ms, String bt, String gm, String bx, BigDecimal gd, BigDecimal kd, BigDecimal hd, Integer sl, BigDecimal pf, String bz, BigDecimal dj, BigDecimal je) {
    this.lxys = lxys;
    this.zx = zx;
    this.bl = bl;
    this.tm = tm;
    this.ms = ms;
    this.bt = bt;
    this.gm = gm;
    this.bx = bx;
    this.gd = gd;
    this.kd = kd;
    this.hd = hd;
    this.sl = sl;
    this.pf = pf;
    this.bz = bz;
    this.dj = dj;
    this.je = je;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLxys() {
    return lxys;
  }

  public void setLxys(String lxys) {
    this.lxys = lxys;
  }

  public String getZx() {
    return zx;
  }

  public void setZx(String zx) {
    this.zx = zx;
  }

  public String getBl() {
    return bl;
  }

  public void setBl(String bl) {
    this.bl = bl;
  }

  public String getTm() {
    return tm;
  }

  public void setTm(String tm) {
    this.tm = tm;
  }

  public String getMs() {
    return ms;
  }

  public void setMs(String ms) {
    this.ms = ms;
  }

  public String getBt() {
    return bt;
  }

  public void setBt(String bt) {
    this.bt = bt;
  }

  public String getGm() {
    return gm;
  }

  public void setGm(String gm) {
    this.gm = gm;
  }

  public String getBx() {
    return bx;
  }

  public void setBx(String bx) {
    this.bx = bx;
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

  public BigDecimal getHd() {
    return hd;
  }

  public void setHd(BigDecimal hd) {
    this.hd = hd;
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

  @Override
  public String toString() {
    return "TitaniumAlloyDoorHangingDetail{" +
            "id='" + id + '\'' +
            ", lxys='" + lxys + '\'' +
            ", zx='" + zx + '\'' +
            ", bl='" + bl + '\'' +
            ", tm='" + tm + '\'' +
            ", ms='" + ms + '\'' +
            ", bt='" + bt + '\'' +
            ", gm='" + gm + '\'' +
            ", bx='" + bx + '\'' +
            ", gd=" + gd +
            ", kd=" + kd +
            ", hd=" + hd +
            ", sl=" + sl +
            ", pf=" + pf +
            ", bz='" + bz + '\'' +
            ", dj=" + dj +
            ", je=" + je +
            '}';
  }
}
