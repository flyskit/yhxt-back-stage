package com.yhxt.ddcl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName OrderAccessory
 * @Author zqi
 * @Date 2019/6/20 10:52
 * @Version 1.0
 * @Description 订单-配件表
 */
@Entity
@Table(name = "order_accessory")
public class OrderAccessory implements Serializable {
  private static final long serialVersionUID = -4293302840663683154L;

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
   * 配件id
   */
  @Column(name = "pjid")
  private String pjid;

  /**
   * 配件数量
   */
  @Column(name = "pjsl")
  private Integer pjsl;

  /**
   * 配件单价
   */
  @Column(name = "pjdj")
  private BigDecimal pjdj;

  /**
   * 配件金额
   */
  @Column(name = "pjje")
  private BigDecimal pjje;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  /**
   * 默认构造器
   */
  public OrderAccessory() {
  }

  public OrderAccessory(String ddid, String pjid, Integer pjsl, BigDecimal pjdj, BigDecimal pjje, Boolean zt) {
    this.ddid = ddid;
    this.pjid = pjid;
    this.pjsl = pjsl;
    this.pjdj = pjdj;
    this.pjje = pjje;
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

  public String getPjid() {
    return pjid;
  }

  public void setPjid(String pjid) {
    this.pjid = pjid;
  }

  public Integer getPjsl() {
    return pjsl;
  }

  public void setPjsl(Integer pjsl) {
    this.pjsl = pjsl;
  }

  public BigDecimal getPjje() {
    return pjje;
  }

  public void setPjje(BigDecimal pjje) {
    this.pjje = pjje;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }

  public BigDecimal getPjdj() {
    return pjdj;
  }

  public void setPjdj(BigDecimal pjdj) {
    this.pjdj = pjdj;
  }

  @Override
  public String toString() {
    return "OrderAccessory{" +
            "id='" + id + '\'' +
            ", ddid='" + ddid + '\'' +
            ", pjid='" + pjid + '\'' +
            ", pjsl=" + pjsl +
            ", pjdj=" + pjdj +
            ", pjje=" + pjje +
            ", zt=" + zt +
            '}';
  }
}
