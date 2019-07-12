package com.yhxt.khxd.xsm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName BlisterDetail
 * @Author zqi
 * @Date 2019/7/12 14:10
 * @Version 1.0
 * @Description 吸塑门-基本信息
 */
@Entity
@Table(name = "blister_detail")
public class BlisterDetail implements Serializable {
  private static final long serialVersionUID = -1138031322922359282L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 板材
   */
  @Column(name = "bc")
  private String bc;

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
   * @param bc   板材
   * @param dj   单价
   * @param hjpf 合计平方
   * @param hjsl 合计数量
   * @param yjdb 预计打包
   * @param je   金额
   */
  public void updateDetail(String bc, BigDecimal dj, BigDecimal hjpf, Integer hjsl, Integer yjdb, BigDecimal je) {
    this.setBc(bc);
    this.setDj(dj);
    this.setHjpf(hjpf);
    this.setHjsl(hjsl);
    this.setYjdb(yjdb);
    this.setJe(je);
  }

  public BlisterDetail() {
  }

  public BlisterDetail(String bc, BigDecimal dj, BigDecimal je, BigDecimal hjpf, Integer hjsl, Integer yjdb) {
    this.bc = bc;
    this.dj = dj;
    this.je = je;
    this.hjpf = hjpf;
    this.hjsl = hjsl;
    this.yjdb = yjdb;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBc() {
    return bc;
  }

  public void setBc(String bc) {
    this.bc = bc;
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
    return "BlisterDetail{" +
            "id='" + id + '\'' +
            ", bc='" + bc + '\'' +
            ", dj=" + dj +
            ", je='" + je + '\'' +
            ", hjpf=" + hjpf +
            ", hjsl=" + hjsl +
            ", yjdb=" + yjdb +
            '}';
  }
}
