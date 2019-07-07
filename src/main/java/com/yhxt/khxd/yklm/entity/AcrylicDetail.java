package com.yhxt.khxd.yklm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName AcrylicDetail
 * @Author zqi
 * @Date 2019/6/20 16:34
 * @Version 1.0
 * @Description 亚克力基本信息
 */
@Entity
@Table(name = "acrylic_detail")
public class AcrylicDetail implements Serializable {
  private static final long serialVersionUID = 8406500342069692851L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 板材名称
   */
  @Column(name = "bcmc")
  private String bcmc;

  /**
   * 板材单价
   */
  @Column(name = "bcdj")
  private BigDecimal bcdj;

  /**
   * 拉手名称
   */
  @Column(name = "lsmc")
  private String lsmc;

  /**
   * 拉手单价
   */
  @Column(name = "lsdj")
  private BigDecimal lsdj;

  /**
   * 颜色
   */
  @Column(name = "ys")
  private String ys;

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
   * 板材平方
   */
  @Column(name = "bcpf")
  private BigDecimal bcpf;

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
   * @param bcmc 板材名称
   * @param bcdj 板材单价
   * @param lsmc 拉手名称
   * @param lsdj 拉手单价
   * @param hjpf 合计平方
   * @param hjsl 合计数量
   * @param bcpf 板材平方
   * @param yjdb 预计打包
   * @param ys   颜色
   * @param je   金额
   */
  public void updateDetail(String bcmc, BigDecimal bcdj, String lsmc, BigDecimal lsdj, BigDecimal hjpf, Integer hjsl, BigDecimal bcpf, Integer yjdb, String ys, BigDecimal je) {
    this.setBcmc(bcmc);
    this.setBcdj(bcdj);
    this.setLsmc(lsmc);
    this.setLsdj(lsdj);
    this.setHjpf(hjpf);
    this.setHjsl(hjsl);
    this.setBcpf(bcpf);
    this.setYjdb(yjdb);
    this.setYs(ys);
    this.setJe(je);
  }

  public AcrylicDetail() {
  }

  public AcrylicDetail(String bcmc, BigDecimal bcdj, String lsmc, BigDecimal lsdj, String ys, BigDecimal je, BigDecimal hjpf, BigDecimal bcpf, Integer hjsl, Integer yjdb) {
    this.bcmc = bcmc;
    this.bcdj = bcdj;
    this.lsmc = lsmc;
    this.lsdj = lsdj;
    this.ys = ys;
    this.je = je;
    this.hjpf = hjpf;
    this.bcpf = bcpf;
    this.hjsl = hjsl;
    this.yjdb = yjdb;
  }

  public BigDecimal getBcpf() {
    return bcpf;
  }

  public void setBcpf(BigDecimal bcpf) {
    this.bcpf = bcpf;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBcmc() {
    return bcmc;
  }

  public void setBcmc(String bcmc) {
    this.bcmc = bcmc;
  }

  public BigDecimal getBcdj() {
    return bcdj;
  }

  public void setBcdj(BigDecimal bcdj) {
    this.bcdj = bcdj;
  }

  public String getLsmc() {
    return lsmc;
  }

  public void setLsmc(String lsmc) {
    this.lsmc = lsmc;
  }

  public BigDecimal getLsdj() {
    return lsdj;
  }

  public void setLsdj(BigDecimal lsdj) {
    this.lsdj = lsdj;
  }

  public String getYs() {
    return ys;
  }

  public void setYs(String ys) {
    this.ys = ys;
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
    return "AcrylicDetail{" +
            "id='" + id + '\'' +
            ", bcmc='" + bcmc + '\'' +
            ", bcdj=" + bcdj +
            ", lsmc='" + lsmc + '\'' +
            ", lsdj=" + lsdj +
            ", ys='" + ys + '\'' +
            ", je=" + je +
            ", hjpf=" + hjpf +
            ", bcpf=" + bcpf +
            ", hjsl=" + hjsl +
            ", yjdb=" + yjdb +
            '}';
  }
}
