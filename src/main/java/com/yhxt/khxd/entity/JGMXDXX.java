package com.yhxt.khxd.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName JGMXDXX
 * @Author zqi
 * @Date 2019/1/17 11:49
 * @Version 1.0
 * @Description 晶钢门下单信息
 */
@Table(name = "jgm_xdxx")
@Entity
public class JGMXDXX implements Serializable {
  private static final long serialVersionUID = 8532239730280787022L;

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
  private String bh;

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
   * 下单类型
   */
  @Column(name = "xdlx")
  private Integer xdlx;

  /**
   * 工期
   */
  @Column(name = "gq")
  private Integer gq;

  /**
   * 合计铝合金平方
   */
  @Column(name = "hjlhjpf")
  private BigDecimal hjlhjpf;

  /**
   * 合计玻璃平方
   */
  @Column(name = "hjblpf")
  private BigDecimal hjblpf;

  /**
   * 合计片数
   */
  @Column(name = "hjps")
  private Integer hjps;

  /**
   * 订单状态
   */
  @Column(name = "zt")
  private Integer zt;

  @Column(name = "bz")
  private String bz;

  /**
   * 默认构造器
   */
  public JGMXDXX() {

  }

  /**
   * 构造器重载
   *
   * @param bh      编号
   * @param khxm    客户姓名
   * @param dz      地址
   * @param dh      电话
   * @param xdlx    下单类型
   * @param gq      工期
   * @param hjlhjpf 合计铝合金平方
   * @param hjblpf  合计玻璃平方
   * @param hjps    合计片数
   * @param zt      状态
   * @param bz      备注
   */
  public JGMXDXX(String bh, String khxm, String dz, String dh, Integer xdlx, Integer gq, BigDecimal hjlhjpf, BigDecimal hjblpf, Integer hjps, Integer zt, String bz) {
    this.bh = bh;
    this.khxm = khxm;
    this.dz = dz;
    this.dh = dh;
    this.xdlx = xdlx;
    this.gq = gq;
    this.hjlhjpf = hjlhjpf;
    this.hjblpf = hjblpf;
    this.hjps = hjps;
    this.zt = zt;
    this.bz = bz;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBh() {
    return bh;
  }

  public void setBh(String bh) {
    this.bh = bh;
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

  public Integer getXdlx() {
    return xdlx;
  }

  public void setXdlx(Integer xdlx) {
    this.xdlx = xdlx;
  }

  public Integer getGq() {
    return gq;
  }

  public void setGq(Integer gq) {
    this.gq = gq;
  }

  public BigDecimal getHjlhjpf() {
    return hjlhjpf;
  }

  public void setHjlhjpf(BigDecimal hjlhjpf) {
    this.hjlhjpf = hjlhjpf;
  }

  public BigDecimal getHjblpf() {
    return hjblpf;
  }

  public void setHjblpf(BigDecimal hjblpf) {
    this.hjblpf = hjblpf;
  }

  public Integer getHjps() {
    return hjps;
  }

  public void setHjps(Integer hjps) {
    this.hjps = hjps;
  }

  public Integer getZt() {
    return zt;
  }

  public void setZt(Integer zt) {
    this.zt = zt;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  @Override
  public String toString() {
    return "JGMXDXX{" +
            "id='" + id + '\'' +
            ", bh='" + bh + '\'' +
            ", khxm='" + khxm + '\'' +
            ", dz='" + dz + '\'' +
            ", dh='" + dh + '\'' +
            ", xdlx=" + xdlx +
            ", gq=" + gq +
            ", hjlhjpf=" + hjlhjpf +
            ", hjblpf=" + hjblpf +
            ", hjps=" + hjps +
            ", zt=" + zt +
            ", bz='" + bz + '\'' +
            '}';
  }
}
