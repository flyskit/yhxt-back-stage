package com.yhxt.khxd.jgm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName CrystalSteelDoorDetail
 * @Author zqi
 * @Date 2019/6/20 16:05
 * @Version 1.0
 * @Description 晶钢门基本信息表
 */
@Entity
@Table(name = "crystal_steel_door_detail")
public class CrystalSteelDoorDetail implements Serializable {
  private static final long serialVersionUID = -4966080501262054734L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 拉手
   */
  @Column(name = "ls")
  private String ls;

  /**
   * 颜色
   */
  @Column(name = "ys")
  private String ys;

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
   * 合计平方
   */
  @Column(name = "hjpf")
  private BigDecimal hjpf;

  /**
   * 玻璃平方
   */
  @Column(name = "blpf")
  private BigDecimal blpf;

  /**
   * 合计数量
   */
  @Column(name = "hjsl")
  private Integer hjsl;

  /**
   * 预计打包
   */
  @Column(name = "yjdb")
  private Integer yjdb;

  /**
   * 更新记录
   *
   * @param ls   拉手
   * @param ys   颜色
   * @param dj   单价
   * @param je   金额
   * @param hjpf 合计平方
   * @param blpf 玻璃平方
   * @param hjsl 合计数量
   * @param yjdb 预计打包
   */
  public void updateDetail(String ls, String ys, BigDecimal dj, BigDecimal je, BigDecimal hjpf, BigDecimal blpf, Integer hjsl, Integer yjdb) {
    this.setLs(ls);
    this.setYs(ys);
    this.setDj(dj);
    this.setJe(je);
    this.setHjpf(hjpf);
    this.setBlpf(blpf);
    this.setHjsl(hjsl);
    this.setYjdb(yjdb);
  }

  public CrystalSteelDoorDetail() {
  }

  public CrystalSteelDoorDetail(String ls, String ys, BigDecimal dj, BigDecimal je, BigDecimal hjpf, BigDecimal blpf, Integer hjsl, Integer yjdb) {
    this.ls = ls;
    this.ys = ys;
    this.dj = dj;
    this.je = je;
    this.hjpf = hjpf;
    this.blpf = blpf;
    this.hjsl = hjsl;
    this.yjdb = yjdb;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLs() {
    return ls;
  }

  public void setLs(String ls) {
    this.ls = ls;
  }

  public String getYs() {
    return ys;
  }

  public void setYs(String ys) {
    this.ys = ys;
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

  public BigDecimal getHjpf() {
    return hjpf;
  }

  public void setHjpf(BigDecimal hjpf) {
    this.hjpf = hjpf;
  }

  public BigDecimal getBlpf() {
    return blpf;
  }

  public void setBlpf(BigDecimal blpf) {
    this.blpf = blpf;
  }

  public Integer getHjsl() {
    return hjsl;
  }

  public void setHjsl(Integer hjsl) {
    this.hjsl = hjsl;
  }

  public Integer getYjdb() {
    return yjdb;
  }

  public void setYjdb(Integer yjdb) {
    this.yjdb = yjdb;
  }

  @Override
  public String toString() {
    return "CrystalSteelDoorDetail{" +
            "id='" + id + '\'' +
            ", ls='" + ls + '\'' +
            ", ys='" + ys + '\'' +
            ", dj=" + dj +
            ", je=" + je +
            ", hjpf=" + hjpf +
            ", blpf=" + blpf +
            ", hjsl=" + hjsl +
            ", yjdb=" + yjdb +
            '}';
  }
}
