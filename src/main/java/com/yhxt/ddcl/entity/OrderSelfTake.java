package com.yhxt.ddcl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderSelfTake
 * @Author zqi
 * @Date 2019/6/20 12:48
 * @Version 1.0
 * @Description 订单-自提记录表
 */
@Entity
@Table(name = "order_self_take")
public class OrderSelfTake implements Serializable {
  private static final long serialVersionUID = -3065750878735514321L;

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
  public String ddid;

  /**
   * 提货件数
   */
  @Column(name = "thjs")
  public Integer thjs;

  /**
   * 提货人
   */
  @Column(name = "thr")
  public String thr;

  /**
   * 提货时间
   */
  @Column(name = "thsj")
  public Date thsj;

  /**
   * 付款金额
   */
  @Column(name = "fkje")
  public BigDecimal fkje;

  /**
   * 默认构造器
   */
  public OrderSelfTake() {
  }

  public OrderSelfTake(String ddid, Integer thjs, String thr, Date thsj, BigDecimal fkje) {
    this.ddid = ddid;
    this.thjs = thjs;
    this.thr = thr;
    this.thsj = thsj;
    this.fkje = fkje;
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

  public Integer getThjs() {
    return thjs;
  }

  public void setThjs(Integer thjs) {
    this.thjs = thjs;
  }

  public String getThr() {
    return thr;
  }

  public void setThr(String thr) {
    this.thr = thr;
  }

  public Date getThsj() {
    return thsj;
  }

  public void setThsj(Date thsj) {
    this.thsj = thsj;
  }

  public BigDecimal getFkje() {
    return fkje;
  }

  public void setFkje(BigDecimal fkje) {
    this.fkje = fkje;
  }

  @Override
  public String toString() {
    return "OrderSelfTake{" +
            "id='" + id + '\'' +
            ", ddid='" + ddid + '\'' +
            ", thjs=" + thjs +
            ", thr='" + thr + '\'' +
            ", thsj=" + thsj +
            ", fkje=" + fkje +
            '}';
  }
}
