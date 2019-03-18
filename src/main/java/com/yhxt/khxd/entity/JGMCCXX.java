package com.yhxt.khxd.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName JGMCCXX
 * @Author zqi
 * @Date 2019/1/17 11:49
 * @Version 1.0
 * @Description 晶钢门尺寸信息
 */
@Table(name = "jgm_ccxx")
@Entity
public class JGMCCXX implements Serializable {
  private static final long serialVersionUID = 2299524595625821242L;
  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 尺寸类型
   */
  @Column(name = "cclx")
  private Integer cclx;

  /**
   * 拉手
   */
  @Column(name = "ls")
  private Integer ls;

  /**
   * 颜色
   */
  @Column(name = "ys")
  private String ys;

  /**
   * 铝合金高度
   */
  @Column(name = "lhjgd")
  private BigDecimal lhjgd;

  /**
   * 铝合金宽度
   */
  @Column(name = "lhjkd")
  private BigDecimal lhjkd;

  /**
   * 片数
   */
  @Column(name = "ps")
  private Integer ps;

  /**
   * 铝合金平方
   */
  @Column(name = "lhjpf")
  private BigDecimal lhjpf;

  /**
   * 备注
   */
  @Column(name = "bz")
  private String bz;

  /**
   * 玻璃高度
   */
  @Column(name = "blgd")
  private BigDecimal blgd;

  /**
   * 玻璃宽度
   */
  @Column(name = "blkd")
  private BigDecimal blkd;

  /**
   * 玻璃平方
   */
  @Column(name = "blpf")
  private BigDecimal blpf;

  /**
   * 默认构造器
   */
  public JGMCCXX() {

  }

  /**
   * 构造器重载
   *
   * @param cclx  尺寸类型
   * @param ls    拉手
   * @param ys    颜色
   * @param lhjgd 铝合金高度
   * @param lhjkd 铝合金宽度
   * @param ps    片数
   * @param lhjpf 铝合金平方
   * @param bz    备注
   * @param blgd  玻璃高度
   * @param blkd  玻璃宽度
   * @param blpf  玻璃平方
   */
  public JGMCCXX(Integer cclx, Integer ls, String ys, BigDecimal lhjgd, BigDecimal lhjkd, Integer ps, BigDecimal lhjpf, String bz, BigDecimal blgd, BigDecimal blkd, BigDecimal blpf) {
    this.cclx = cclx;
    this.ls = ls;
    this.ys = ys;
    this.lhjgd = lhjgd;
    this.lhjkd = lhjkd;
    this.ps = ps;
    this.lhjpf = lhjpf;
    this.bz = bz;
    this.blgd = blgd;
    this.blkd = blkd;
    this.blpf = blpf;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getCclx() {
    return cclx;
  }

  public void setCclx(Integer cclx) {
    this.cclx = cclx;
  }

  public Integer getLs() {
    return ls;
  }

  public void setLs(Integer ls) {
    this.ls = ls;
  }

  public String getYs() {
    return ys;
  }

  public void setYs(String ys) {
    this.ys = ys;
  }

  public BigDecimal getLhjgd() {
    return lhjgd;
  }

  public void setLhjgd(BigDecimal lhjgd) {
    this.lhjgd = lhjgd;
  }

  public BigDecimal getLhjkd() {
    return lhjkd;
  }

  public void setLhjkd(BigDecimal lhjkd) {
    this.lhjkd = lhjkd;
  }

  public Integer getPs() {
    return ps;
  }

  public void setPs(Integer ps) {
    this.ps = ps;
  }

  public BigDecimal getLhjpf() {
    return lhjpf;
  }

  public void setLhjpf(BigDecimal lhjpf) {
    this.lhjpf = lhjpf;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public BigDecimal getBlgd() {
    return blgd;
  }

  public void setBlgd(BigDecimal blgd) {
    this.blgd = blgd;
  }

  public BigDecimal getBlkd() {
    return blkd;
  }

  public void setBlkd(BigDecimal blkd) {
    this.blkd = blkd;
  }

  public BigDecimal getBlpf() {
    this.blpf = this.getBlgd()
            .multiply(this.getBlkd())
            .multiply(BigDecimal.valueOf(0.000001))
            .multiply(BigDecimal.valueOf(this.getPs()))
            .setScale(3, BigDecimal.ROUND_HALF_UP);
    return blpf;
  }

  public void setBlpf(BigDecimal blpf) {
    this.blpf = blpf;
  }

  @Override
  public String toString() {
    return "JGMCCXX{" +
            "id='" + id + '\'' +
            ", cclx=" + cclx +
            ", ls='" + ls + '\'' +
            ", ys='" + ys + '\'' +
            ", lhjgd=" + lhjgd +
            ", lhjkd=" + lhjkd +
            ", ps=" + ps +
            ", lhjpf=" + lhjpf +
            ", bz='" + bz + '\'' +
            ", blgd=" + blgd +
            ", blkd=" + blkd +
            ", blpf=" + blpf +
            '}';
  }
}
