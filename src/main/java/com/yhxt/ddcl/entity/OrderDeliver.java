package com.yhxt.ddcl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderDeliver
 * @Author zqi
 * @Date 2019/6/20 11:55
 * @Version 1.0
 * @Description 订单-发货表
 */
@Entity
@Table(name = "order_deliver")
public class OrderDeliver implements Serializable {
  private static final long serialVersionUID = -6605690415200088050L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 订单id
   */
  @Column(name = "ddid")
  private String ddid;

  /**
   * 发货日期
   */
  @Column(name = "fhrq")
  private Date fhrq;

  /**
   * 发货物流
   */
  @Column(name = "fhwl")
  private String fhwl;

  /**
   * 到站城市
   */
  @Column(name = "dzcs")
  private String dzcs;

  /**
   * 发货件数
   */
  @Column(name = "fhjs")
  private Integer fhjs;

  /**
   * 是否代收
   */
  @Column(name = "is_ds")
  private Boolean sfds;

  /**
   * 代收金额
   */
  @Column(name = "dsje")
  private BigDecimal dsje;

  /**
   * 未代收原因
   */
  @Column(name = "yy")
  private String yy;

  /**
   * 备注
   */
  @Column(name = "bz")
  private String bz;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  /**
   * 默认构造器
   */
  public OrderDeliver() {
  }

  public OrderDeliver(String ddid, Date fhrq, String fhwl, String dzcs, Integer fhjs, Boolean sfds, BigDecimal dsje, String yy, String bz, Boolean zt) {
    this.ddid = ddid;
    this.fhrq = fhrq;
    this.fhwl = fhwl;
    this.dzcs = dzcs;
    this.fhjs = fhjs;
    this.sfds = sfds;
    this.dsje = dsje;
    this.yy = yy;
    this.bz = bz;
    this.zt = zt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDdid() {
    return ddid;
  }

  public void setDdid(String ddid) {
    this.ddid = ddid;
  }

  public Date getFhrq() {
    return fhrq;
  }

  public void setFhrq(Date fhrq) {
    this.fhrq = fhrq;
  }

  public String getFhwl() {
    return fhwl;
  }

  public void setFhwl(String fhwl) {
    this.fhwl = fhwl;
  }

  public String getDzcs() {
    return dzcs;
  }

  public void setDzcs(String dzcs) {
    this.dzcs = dzcs;
  }

  public Integer getFhjs() {
    return fhjs;
  }

  public void setFhjs(Integer fhjs) {
    this.fhjs = fhjs;
  }

  public Boolean getSfds() {
    return sfds;
  }

  public void setSfds(Boolean sfds) {
    this.sfds = sfds;
  }

  public BigDecimal getDsje() {
    return dsje;
  }

  public void setDsje(BigDecimal dsje) {
    this.dsje = dsje;
  }

  public String getYy() {
    return yy;
  }

  public void setYy(String yy) {
    this.yy = yy;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }
}
