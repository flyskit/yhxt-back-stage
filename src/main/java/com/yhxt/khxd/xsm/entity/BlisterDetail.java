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
   * @param hjpf 合计平方
   * @param hjsl 合计数量
   * @param yjdb 预计打包
   * @param je   金额
   */
  public void updateDetail(BigDecimal hjpf, Integer hjsl, Integer yjdb, BigDecimal je) {
    this.setHjpf(hjpf);
    this.setHjsl(hjsl);
    this.setYjdb(yjdb);
    this.setJe(je);
  }

  public BlisterDetail() {
  }

  public BlisterDetail(BigDecimal je, BigDecimal hjpf, Integer hjsl, Integer yjdb) {
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
            ", je='" + je + '\'' +
            ", hjpf=" + hjpf +
            ", hjsl=" + hjsl +
            ", yjdb=" + yjdb +
            '}';
  }
}
