package com.yhxt.ddcl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OrderRecord
 * @Author zqi
 * @Date 2019/6/20 10:57
 * @Version 1.0
 * @Description 订单-操作记录表
 */
@Entity
@Table(name = "order_record")
public class OrderRecord implements Serializable {
  private static final long serialVersionUID = 2367904302693066815L;

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
   * 操作类别
   */
  @Column(name = "czlb")
  private Integer czlb;

  /**
   * 操作内容
   */
  @Column(name = "cznr")
  private String cznr;

  /**
   * 操作人
   */
  @Column(name = "czr")
  private String czr;

  /**
   * 操作时间
   */
  @Column(name = "czsj")
  private Date czsj;

  public OrderRecord() {
  }

  /**
   * 构造器重载
   *
   * @param czlb 操作类别
   * @param cznr 操作内容
   */
  public OrderRecord(Integer czlb, String cznr) {
    this.czlb = czlb;
    this.cznr = cznr;
  }

  public OrderRecord(String ddid, Integer czlb, String cznr, String czr, Date czsj) {
    this.ddid = ddid;
    this.czlb = czlb;
    this.cznr = cznr;
    this.czr = czr;
    this.czsj = czsj;
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

  public Integer getCzlb() {
    return czlb;
  }

  public void setCzlb(Integer czlb) {
    this.czlb = czlb;
  }

  public String getCznr() {
    return cznr;
  }

  public void setCznr(String cznr) {
    this.cznr = cznr;
  }

  public String getCzr() {
    return czr;
  }

  public void setCzr(String czr) {
    this.czr = czr;
  }

  public Date getCzsj() {
    return czsj;
  }

  public void setCzsj(Date czsj) {
    this.czsj = czsj;
  }

  @Override
  public String toString() {
    return "OrderRecord{" +
            "id='" + id + '\'' +
            ", ddid='" + ddid + '\'' +
            ", czlb=" + czlb +
            ", cznr='" + cznr + '\'' +
            ", czr='" + czr + '\'' +
            ", czsj=" + czsj +
            '}';
  }
}
