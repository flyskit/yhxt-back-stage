package com.yhxt.ddcl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName InstallRecord
 * @Author zqi
 * @Date 2019/6/20 14:45
 * @Version 1.0
 * @Description 安装记录表
 */
@Entity
@Table(name = "install_record")
public class InstallRecord implements Serializable {
  private static final long serialVersionUID = 7193676284736617098L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 安装任务
   */
  @Column(name = "azrw")
  private String azrw;

  /**
   * 开始时间
   */
  @Column(name = "kssj")
  private Date kssj;

  /**
   * 预计工期
   */
  @Column(name = "yjgq")
  private String yjgq;

  /**
   * 安装进度
   */
  @Column(name = "azjd")
  private Integer azjd;

  /**
   * 完工时间
   */
  @Column(name = "wgsj")
  private Date wgsj;

  /**
   * 实际工期
   */
  @Column(name = "sjgq")
  private String sjgq;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  /**
   * 默认构造器
   */
  public InstallRecord() {
  }

  public InstallRecord(String azrw, Date kssj, String yjgq, Integer azjd, Date wgsj, String sjgq, Boolean zt) {
    this.azrw = azrw;
    this.kssj = kssj;
    this.yjgq = yjgq;
    this.azjd = azjd;
    this.wgsj = wgsj;
    this.sjgq = sjgq;
    this.zt = zt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAzrw() {
    return azrw;
  }

  public void setAzrw(String azrw) {
    this.azrw = azrw;
  }

  public Date getKssj() {
    return kssj;
  }

  public void setKssj(Date kssj) {
    this.kssj = kssj;
  }

  public String getYjgq() {
    return yjgq;
  }

  public void setYjgq(String yjgq) {
    this.yjgq = yjgq;
  }

  public Integer getAzjd() {
    return azjd;
  }

  public void setAzjd(Integer azjd) {
    this.azjd = azjd;
  }

  public Date getWgsj() {
    return wgsj;
  }

  public void setWgsj(Date wgsj) {
    this.wgsj = wgsj;
  }

  public String getSjgq() {
    return sjgq;
  }

  public void setSjgq(String sjgq) {
    this.sjgq = sjgq;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }

  @Override
  public String toString() {
    return "InstallRecord{" +
            "id='" + id + '\'' +
            ", azrw='" + azrw + '\'' +
            ", kssj=" + kssj +
            ", yjgq='" + yjgq + '\'' +
            ", azjd=" + azjd +
            ", wgsj=" + wgsj +
            ", sjgq='" + sjgq + '\'' +
            ", zt=" + zt +
            '}';
  }
}
