package com.yhxt.khxd.ygm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName WardrobeSlideDetail
 * @Author zqi
 * @Date 2019/7/13 15:14
 * @Version 1.0
 * @Description 衣柜移门-基本统计信息表
 */
@Entity
@Table(name = "wardrobe_slide_detail")
public class WardrobeSlideDetail implements Serializable {
  private static final long serialVersionUID = -200149825585877185L;

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
   * 芯板平方
   */
  @Column(name = "xbpf")
  private BigDecimal xbpf;

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
   * @param xbpf 芯板平方
   * @param hjsl 合计数量
   * @param yjdb 预计打包
   * @param je   金额
   */
  public void updateDetail(BigDecimal hjpf, BigDecimal xbpf, Integer hjsl, Integer yjdb, BigDecimal je) {
    this.setHjpf(hjpf);
    this.setXbpf(xbpf);
    this.setHjsl(hjsl);
    this.setYjdb(yjdb);
    this.setJe(je);
  }

  public WardrobeSlideDetail() {
  }

  public WardrobeSlideDetail(BigDecimal je, BigDecimal hjpf, BigDecimal xbpf, Integer hjsl, Integer yjdb) {
    this.je = je;
    this.hjpf = hjpf;
    this.xbpf = xbpf;
    this.hjsl = hjsl;
    this.yjdb = yjdb;
  }

  public BigDecimal getXbpf() {
    return xbpf;
  }

  public void setXbpf(BigDecimal xbpf) {
    this.xbpf = xbpf;
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
    return "WardrobeSlideDetail{" +
            "id='" + id + '\'' +
            ", je=" + je +
            ", hjpf=" + hjpf +
            ", hjsl=" + hjsl +
            ", yjdb=" + yjdb +
            '}';
  }
}
