package com.yhxt.sjgl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName JGMLSXX
 * @Author zqi
 * @Date 2019/3/15 11:25
 * @Version 1.0
 * @Description 数据管理-晶钢门拉手信息
 */
@Entity
@Table(name = "jgm_ls_ccxx")
public class JGMLSXX implements Serializable {

  private static final long serialVersionUID = -8822817689460237510L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 编号
   */
  @Column(name = "bh")
  private Integer bh;

  /**
   * 名称
   */
  @Column(name = "mc")
  private String mc;

  /**
   * 高度
   */
  @Column(name = "gd")
  private BigDecimal gd;

  /**
   * 宽度
   */
  @Column(name = "kd")
  private BigDecimal kd;

  /**
   * 默认构造器
   */
  public JGMLSXX() {
  }

  /**
   * 重载构造器
   *
   * @param bh 编号
   * @param mc 名称
   * @param gd 高度
   * @param kd 宽度
   */
  public JGMLSXX(Integer bh, String mc, BigDecimal gd, BigDecimal kd) {
    this.bh = bh;
    this.mc = mc;
    this.gd = gd;
    this.kd = kd;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getBh() {
    return bh;
  }

  public void setBh(Integer bh) {
    this.bh = bh;
  }

  public String getMc() {
    return mc;
  }

  public void setMc(String mc) {
    this.mc = mc;
  }

  public BigDecimal getGd() {
    return gd;
  }

  public void setGd(BigDecimal gd) {
    this.gd = gd;
  }

  public BigDecimal getKd() {
    return kd;
  }

  public void setKd(BigDecimal kd) {
    this.kd = kd;
  }

  @Override
  public String toString() {
    return "JGMLSXX{" +
            "id='" + id + '\'' +
            ", bh=" + bh +
            ", mc='" + mc + '\'' +
            ", gd=" + gd +
            ", kd=" + kd +
            '}';
  }
}
