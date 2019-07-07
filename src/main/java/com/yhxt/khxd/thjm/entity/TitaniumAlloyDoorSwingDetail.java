package com.yhxt.khxd.thjm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName TitaniumAlloyDoorSwingDetail
 * @Author zqi
 * @Date 2019/6/20 17:00
 * @Version 1.0
 * @Description 钛合金门-平开门基本信息表
 */
@Entity
@Table(name = "titanium_alloy_door_swing_detail")
public class TitaniumAlloyDoorSwingDetail implements Serializable {
  private static final long serialVersionUID = 633327687727904118L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 料型颜色
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
   * 方向
   */
  @Column(name = "fx")
  private String fx;

  /**
   * 边带
   */
  @Column(name = "bd")
  private String bd;

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
  public TitaniumAlloyDoorSwingDetail() {
  }

  public TitaniumAlloyDoorSwingDetail(String lxys, String zx, String bl, String fx, String bd, BigDecimal gd, BigDecimal kd, BigDecimal hd, Integer sl, String bz, BigDecimal dj, BigDecimal je) {
    this.lxys = lxys;
    this.zx = zx;
    this.bl = bl;
    this.fx = fx;
    this.bd = bd;
    this.gd = gd;
    this.kd = kd;
    this.hd = hd;
    this.sl = sl;
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

  public String getFx() {
    return fx;
  }

  public void setFx(String fx) {
    this.fx = fx;
  }

  public String getBd() {
    return bd;
  }

  public void setBd(String bd) {
    this.bd = bd;
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
    return "TitaniumAlloyDoorSwingDetail{" +
            "id='" + id + '\'' +
            ", lxys='" + lxys + '\'' +
            ", zx='" + zx + '\'' +
            ", bl='" + bl + '\'' +
            ", fx='" + fx + '\'' +
            ", bd='" + bd + '\'' +
            ", gd=" + gd +
            ", kd=" + kd +
            ", hd=" + hd +
            ", sl=" + sl +
            ", bz='" + bz + '\'' +
            ", dj=" + dj +
            ", je=" + je +
            '}';
  }
}
