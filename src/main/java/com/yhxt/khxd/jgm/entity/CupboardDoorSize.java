package com.yhxt.khxd.jgm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName CrystalSteelDoorSize
 * @Author zqi
 * @Date 2019/6/20 16:11
 * @Version 1.0
 * @Description 橱柜门尺寸信息表
 */
@Entity
@Table(name = "cupboard_door_size")
public class CupboardDoorSize implements Serializable {
  private static final long serialVersionUID = -8482777034386219444L;

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
   * 门板高度
   */
  @Column(name = "mbgd")
  private BigDecimal mbgd;

  /**
   * 门板宽度
   */
  @Column(name = "mbkd")
  private BigDecimal mbkd;

  /**
   * 数量
   */
  @Column(name = "sl")
  private Integer sl;

  /**
   * 门板平方
   */
  @Column(name = "mbpf")
  private BigDecimal mbpf;

  /**
   * 备注
   */
  @Column(name = "bz")
  private String bz;

  /**
   * 玻璃高度
   */
  @Column(name = "blgd")
  private BigDecimal blgd;

  /**
   * 玻璃宽度
   */
  @Column(name = "blkd")
  private BigDecimal blkd;

  /**
   * 玻璃平方
   */
  @Column(name = "blpf")
  private BigDecimal blpf;

  /**
   * 默认构造器
   */
  public CupboardDoorSize() {
  }

  public CupboardDoorSize(Integer lx, BigDecimal mbgd, BigDecimal mbkd, Integer sl, BigDecimal mbpf, String bz, BigDecimal blgd, BigDecimal blkd, BigDecimal blpf) {
    this.lx = lx;
    this.mbgd = mbgd;
    this.mbkd = mbkd;
    this.sl = sl;
    this.mbpf = mbpf;
    this.bz = bz;
    this.blgd = blgd;
    this.blkd = blkd;
    this.blpf = blpf;
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

  public BigDecimal getMbgd() {
    return mbgd;
  }

  public void setMbgd(BigDecimal mbgd) {
    this.mbgd = mbgd;
  }

  public BigDecimal getMbkd() {
    return mbkd;
  }

  public void setMbkd(BigDecimal mbkd) {
    this.mbkd = mbkd;
  }

  public Integer getSl() {
    return sl;
  }

  public void setSl(Integer sl) {
    this.sl = sl;
  }

  public BigDecimal getMbpf() {
    return mbpf;
  }

  public void setMbpf(BigDecimal mbpf) {
    this.mbpf = mbpf;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public BigDecimal getBlgd() {
    return blgd;
  }

  public void setBlgd(BigDecimal blgd) {
    this.blgd = blgd;
  }

  public BigDecimal getBlkd() {
    return blkd;
  }

  public void setBlkd(BigDecimal blkd) {
    this.blkd = blkd;
  }

  public BigDecimal getBlpf() {
    return blpf;
  }

  public void setBlpf(BigDecimal blpf) {
    this.blpf = blpf;
  }

  @Override
  public String toString() {
    return "CrystalSteelDoorSize{" +
            "id='" + id + '\'' +
            ", lx=" + lx +
            ", mbgd=" + mbgd +
            ", mbkd=" + mbkd +
            ", sl=" + sl +
            ", mbpf=" + mbpf +
            ", bz='" + bz + '\'' +
            ", blgd=" + blgd +
            ", blkd=" + blkd +
            ", blpf=" + blpf +
            '}';
  }
}
