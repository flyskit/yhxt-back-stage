package com.yhxt.sjgl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName CustomerDetail
 * @Author zqi
 * @Date 2019/6/20 17:17
 * @Version 1.0
 * @Description 客户信息表
 */
@Entity
@Table(name = "customer_detail")
public class CustomerDetail implements Serializable {
  private static final long serialVersionUID = 3340689084345449005L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 客户姓名
   */
  @Column(name = "khxm")
  private String khxm;

  /**
   * 地址
   */
  @Column(name = "dz")
  private String dz;

  /**
   * 电话
   */
  @Column(name = "dh")
  private String dh;

  /**
   * 来源
   */
  @Column(name = "ly")
  private String ly;

  /**
   * 类别
   */
  @Column(name = "lb")
  private String lb;

  /**
   * 主营
   */
  @Column(name = "zy")
  private String zy;

  /**
   * 添加日期
   */
  @Column(name = "tjrq")
  private Date tjrq;

  /**
   * 备注
   */
  @Column(name = "bz")
  private String bz;

  public CustomerDetail() {
  }

  public CustomerDetail(String khxm, String dz, String dh, String ly, String lb, String zy, Date tjrq, String bz) {
    this.khxm = khxm;
    this.dz = dz;
    this.dh = dh;
    this.ly = ly;
    this.lb = lb;
    this.zy = zy;
    this.tjrq = tjrq;
    this.bz = bz;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getKhxm() {
    return khxm;
  }

  public void setKhxm(String khxm) {
    this.khxm = khxm;
  }

  public String getDz() {
    return dz;
  }

  public void setDz(String dz) {
    this.dz = dz;
  }

  public String getDh() {
    return dh;
  }

  public void setDh(String dh) {
    this.dh = dh;
  }

  public String getLy() {
    return ly;
  }

  public void setLy(String ly) {
    this.ly = ly;
  }

  public String getLb() {
    return lb;
  }

  public void setLb(String lb) {
    this.lb = lb;
  }

  public String getZy() {
    return zy;
  }

  public void setZy(String zy) {
    this.zy = zy;
  }

  public Date getTjrq() {
    return tjrq;
  }

  public void setTjrq(Date tjrq) {
    this.tjrq = tjrq;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  @Override
  public String toString() {
    return "CustomerDetail{" +
            "id='" + id + '\'' +
            ", khxm='" + khxm + '\'' +
            ", dz='" + dz + '\'' +
            ", dh='" + dh + '\'' +
            ", ly='" + ly + '\'' +
            ", lb='" + lb + '\'' +
            ", zy='" + zy + '\'' +
            ", tjrq=" + tjrq +
            ", bz='" + bz + '\'' +
            '}';
  }
}
