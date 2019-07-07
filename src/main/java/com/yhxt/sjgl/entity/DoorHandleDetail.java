package com.yhxt.sjgl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName DoorHandleDetail
 * @Author zqi
 * @Date 2019/6/20 15:32
 * @Version 1.0
 * @Description 拉手基本信息
 */
@Entity
@Table(name = "door_handle_detail")
public class DoorHandleDetail implements Serializable {
  private static final long serialVersionUID = -3203821205546057791L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 类型
   */
  @Column(name = "lx")
  private Integer lx;

  /**
   * 名称
   */
  @Column(name = "mc")
  private String mc;

  /**
   * 高度
   */
  @Column(name = "gd")
  private Integer gd;

  /**
   * 宽度
   */
  @Column(name = "kd")
  private Integer kd;

  /**
   * 单价
   */
  @Column(name = "dj")
  private BigDecimal dj;

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
  public DoorHandleDetail() {
  }

  public DoorHandleDetail(Integer lx, String mc, Integer gd, Integer kd, BigDecimal dj, Boolean zt, String bz) {
    this.lx = lx;
    this.mc = mc;
    this.gd = gd;
    this.kd = kd;
    this.dj = dj;
    this.zt = zt;
    this.bz = bz;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getLx() {
    return lx;
  }

  public void setLx(Integer lx) {
    this.lx = lx;
  }

  public String getMc() {
    return mc;
  }

  public void setMc(String mc) {
    this.mc = mc;
  }

  public Integer getGd() {
    return gd;
  }

  public void setGd(Integer gd) {
    this.gd = gd;
  }

  public Integer getKd() {
    return kd;
  }

  public void setKd(Integer kd) {
    this.kd = kd;
  }

  public BigDecimal getDj() {
    return dj;
  }

  public void setDj(BigDecimal dj) {
    this.dj = dj;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  @Override
  public String toString() {
    return "DoorHandleDetail{" +
            "id='" + id + '\'' +
            ", lx=" + lx +
            ", mc='" + mc + '\'' +
            ", gd=" + gd +
            ", kd=" + kd +
            ", dj=" + dj +
            ", zt=" + zt +
            ", bz='" + bz + '\'' +
            '}';
  }
}
