package com.yhxt.ddcl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName install_task
 * @Author zqi
 * @Date 2019/6/20 15:17
 * @Version 1.0
 * @Description 安装-任务安排表
 */
@Entity
@Table(name = "install_task")
public class InstallTask implements Serializable {
  private static final long serialVersionUID = -2580430630719457092L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 安装id
   */
  @Column(name = "azid")
  private String azid;

  /**
   * 安装师傅
   */
  @Column(name = "azsf")
  private String azsf;

  /**
   * 本次任务
   */
  @Column(name = "bcrw")
  private String bcrw;

  /**
   * 出发时间
   */
  @Column(name = "cfsj")
  private Date cfsj;

  /**
   * 结束时间
   */
  @Column(name = "jssj")
  private Date jssj;

  /**
   * 是否达标
   */
  @Column(name = "is_db")
  private Boolean sfdb;

  /**
   * 任务进度
   */
  @Column(name = "rwjd")
  private Integer rwjd;

  /**
   * 剩余处理
   */
  @Column(name = "sycl")
  private String sycl;

  /**
   * 延期原因
   */
  @Column(name = "yqyy")
  private String yqyy;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  public InstallTask() {
  }

  public InstallTask(String azid, String azsf, String bcrw, Date cfsj, Date jssj, Boolean sfdb, Integer rwjd, String sycl, String yqyy, Boolean zt) {
    this.azid = azid;
    this.azsf = azsf;
    this.bcrw = bcrw;
    this.cfsj = cfsj;
    this.jssj = jssj;
    this.sfdb = sfdb;
    this.rwjd = rwjd;
    this.sycl = sycl;
    this.yqyy = yqyy;
    this.zt = zt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAzid() {
    return azid;
  }

  public void setAzid(String azid) {
    this.azid = azid;
  }

  public String getAzsf() {
    return azsf;
  }

  public void setAzsf(String azsf) {
    this.azsf = azsf;
  }

  public String getBcrw() {
    return bcrw;
  }

  public void setBcrw(String bcrw) {
    this.bcrw = bcrw;
  }

  public Date getCfsj() {
    return cfsj;
  }

  public void setCfsj(Date cfsj) {
    this.cfsj = cfsj;
  }

  public Date getJssj() {
    return jssj;
  }

  public void setJssj(Date jssj) {
    this.jssj = jssj;
  }

  public Boolean getSfdb() {
    return sfdb;
  }

  public void setSfdb(Boolean sfdb) {
    this.sfdb = sfdb;
  }

  public Integer getRwjd() {
    return rwjd;
  }

  public void setRwjd(Integer rwjd) {
    this.rwjd = rwjd;
  }

  public String getSycl() {
    return sycl;
  }

  public void setSycl(String sycl) {
    this.sycl = sycl;
  }

  public String getYqyy() {
    return yqyy;
  }

  public void setYqyy(String yqyy) {
    this.yqyy = yqyy;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }

  @Override
  public String toString() {
    return "InstallTask{" +
            "id='" + id + '\'' +
            ", azid='" + azid + '\'' +
            ", azsf='" + azsf + '\'' +
            ", bcrw='" + bcrw + '\'' +
            ", cfsj=" + cfsj +
            ", jssj=" + jssj +
            ", sfdb=" + sfdb +
            ", rwjd=" + rwjd +
            ", sycl='" + sycl + '\'' +
            ", yqyy='" + yqyy + '\'' +
            ", zt=" + zt +
            '}';
  }
}
