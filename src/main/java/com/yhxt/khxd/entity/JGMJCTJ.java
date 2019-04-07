package com.yhxt.khxd.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName JGMJCTJ
 * @Author zqi
 * @Date 2019/4/3 18:18
 * @Version 1.0
 * @Description 晶钢门-进程统计
 */
@Entity
@Table(name = "jgm_jctj")
public class JGMJCTJ implements Serializable {

  private static final long serialVersionUID = -4053270902677924002L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 执行类别
   */
  @Column(name = "zxlb")
  private Integer zxlb;

  /**
   * 执行人
   */
  @Column(name = "zxr")
  private String zxr;

  /**
   * 执行时间
   */
  @Column(name = "zxsj")
  private Date zxsj;

  /**
   * 执行内容
   */
  @Column(name = "zxnr")
  private String zxnr;

  /**
   * 执行原因
   */
  @Column(name = "zxyy")
  private String zxyy;

  /**
   * 声明默认构造器
   */
  public JGMJCTJ() {
  }

  /**
   * 重载构造器
   *
   * @param zxlb 执行类别
   * @param zxr  执行人
   * @param zxsj 执行时间
   * @param zxnr 执行内容
   * @param zxyy 执行原因
   */
  public JGMJCTJ(Integer zxlb, String zxr, Date zxsj, String zxnr, String zxyy) {
    this.zxlb = zxlb;
    this.zxr = zxr;
    this.zxsj = zxsj;
    this.zxnr = zxnr;
    this.zxyy = zxyy;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getZxlb() {
    return zxlb;
  }

  public void setZxlb(Integer zxlb) {
    this.zxlb = zxlb;
  }

  public String getZxr() {
    return zxr;
  }

  public void setZxr(String zxr) {
    this.zxr = zxr;
  }

  public Date getZxsj() {
    return zxsj;
  }

  public void setZxsj(Date zxsj) {
    this.zxsj = zxsj;
  }

  public String getZxnr() {
    return zxnr;
  }

  public void setZxnr(String zxnr) {
    this.zxnr = zxnr;
  }

  public String getZxyy() {
    return zxyy;
  }

  public void setZxyy(String zxyy) {
    this.zxyy = zxyy;
  }

  @Override
  public String toString() {
    return "JGMJCTJ{" +
            "id='" + id + '\'' +
            ", zxlb=" + zxlb +
            ", zxr='" + zxr + '\'' +
            ", zxsj=" + zxsj +
            ", zxnr='" + zxnr + '\'' +
            ", zxyy='" + zxyy + '\'' +
            '}';
  }
}
