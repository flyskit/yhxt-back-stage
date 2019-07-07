package com.yhxt.ddcl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName OrderGoods
 * @Author zqi
 * @Date 2019/6/20 10:46
 * @Version 1.0
 * @Description 订单-商品表
 */
@Entity
@Table(name = "order_goods")
public class OrderGoods implements Serializable {
  private static final long serialVersionUID = 2286368312643364505L;

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
   * 商品id
   */
  @Column(name = "spid")
  private String spid;

  /**
   * 商品类型
   */
  @Column(name = "splx")
  private Integer splx;

  /**
   * 商品名称
   */
  @Column(name = "spmc")
  private String spmc;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  /**
   * 默认构造器
   */
  public OrderGoods() {
  }

  public OrderGoods(Integer splx, String spmc) {
    this.splx = splx;
    this.spmc = spmc;
  }

  public OrderGoods(String ddid, String spid, Integer splx, String spmc, Boolean zt) {
    this.ddid = ddid;
    this.spid = spid;
    this.splx = splx;
    this.spmc = spmc;
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

  public String getSpid() {
    return spid;
  }

  public void setSpid(String spid) {
    this.spid = spid;
  }

  public Integer getSplx() {
    return splx;
  }

  public void setSplx(Integer splx) {
    this.splx = splx;
  }

  public String getSpmc() {
    return spmc;
  }

  public void setSpmc(String spmc) {
    this.spmc = spmc;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }

  @Override
  public String toString() {
    return "OrderGoods{" +
            "id='" + id + '\'' +
            ", ddid='" + ddid + '\'' +
            ", spid='" + spid + '\'' +
            ", splx=" + splx +
            ", spmc='" + spmc + '\'' +
            ", zt=" + zt +
            '}';
  }
}
