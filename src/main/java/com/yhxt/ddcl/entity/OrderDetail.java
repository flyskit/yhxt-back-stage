package com.yhxt.ddcl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OrderDetail
 * @Author zqi
 * @Date 2019/6/20 10:33
 * @Version 1.0
 * @Description 订单信息表
 */
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
  private static final long serialVersionUID = -7171711208741402813L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 订单编号
   */
  @Column(name = "ddbh")
  private String ddbh;

  /**
   * 订单类型
   */
  @Column(name = "ddlx")
  private Integer ddlx;

  /**
   * 订单来源
   */
  @Column(name = "ddly")
  private Integer ddly;

  /**
   * 生产速率
   */
  @Column(name = "scsl")
  private Integer scsl;

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
   * 工期
   */
  @Column(name = "gq")
  private Integer gq;

  /**
   * 完工时间
   */
  @Column(name = "wgsj")
  private Date wgsj;

  /**
   * 发货方式
   */
  @Column(name = "fhfs")
  private Integer fhfs;

  /**
   * 备注
   */
  @Column(name = "bz")
  private String bz;

  /**
   * 订单状态
   */
  @Column(name = "ddzt")
  private Integer ddzt;

  /**
   * 审核状态
   */
  @Column(name = "shzt")
  private Integer shzt;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  /**
   * 更新记录
   *
   * @param ddlx 订单类型
   * @param ddly 订单来源
   * @param scsl 生产速率
   * @param gq   工期
   * @param khxm 客户姓名
   * @param dz   地址
   * @param dh   电话
   * @param bz   备注
   */
  public void updateDetail(Integer ddlx, Integer ddly, Integer scsl, Integer gq, String khxm, String dz, String dh, String bz) {
    this.setDdlx(ddlx);
    this.setDdly(ddly);
    this.setScsl(scsl);
    this.setGq(gq);
    this.setKhxm(khxm);
    this.setDz(dz);
    this.setDh(dh);
    this.setBz(bz);
  }

  /**
   * 默认构造器
   */
  public OrderDetail() {
  }

  /**
   * 创建新订单
   *
   * @param ddbh 订单编号
   * @param ddlx 订单类型
   * @param ddly 订单来源
   * @param scsl 生产速率
   * @param khxm 客户
   * @param dz   地址
   * @param dh   电话
   * @param gq   工期
   * @param wgsj 完工时间
   * @param bz   备注
   * @param ddzt 订单状态
   * @param shzt 审核状态
   * @param zt   记录状态
   */
  public OrderDetail(String ddbh, Integer ddlx, Integer ddly, Integer scsl, String khxm, String dz, String dh, Integer gq, Date wgsj, String bz, Integer ddzt, Integer shzt, Boolean zt) {
    this.ddbh = ddbh;
    this.ddlx = ddlx;
    this.ddly = ddly;
    this.scsl = scsl;
    this.khxm = khxm;
    this.dz = dz;
    this.dh = dh;
    this.gq = gq;
    this.wgsj = wgsj;
    this.bz = bz;
    this.ddzt = ddzt;
    this.shzt = shzt;
    this.zt = zt;
  }

  public OrderDetail(String ddbh, Integer ddlx, Integer ddly, Integer scsl, String khxm, String dz, String dh, Integer gq, Date wgsj, Integer fhfs, String bz, Integer ddzt, Integer shzt, Boolean zt) {
    this.ddbh = ddbh;
    this.ddlx = ddlx;
    this.ddly = ddly;
    this.scsl = scsl;
    this.khxm = khxm;
    this.dz = dz;
    this.dh = dh;
    this.gq = gq;
    this.wgsj = wgsj;
    this.fhfs = fhfs;
    this.bz = bz;
    this.ddzt = ddzt;
    this.shzt = shzt;
    this.zt = zt;
  }

  public Integer getShzt() {
    return shzt;
  }

  public void setShzt(Integer shzt) {
    this.shzt = shzt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDdbh() {
    return ddbh;
  }

  public void setDdbh(String ddbh) {
    this.ddbh = ddbh;
  }

  public Integer getDdlx() {
    return ddlx;
  }

  public void setDdlx(Integer ddlx) {
    this.ddlx = ddlx;
  }

  public Integer getDdly() {
    return ddly;
  }

  public void setDdly(Integer ddly) {
    this.ddly = ddly;
  }

  public Integer getScsl() {
    return scsl;
  }

  public void setScsl(Integer scsl) {
    this.scsl = scsl;
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

  public Integer getGq() {
    return gq;
  }

  public void setGq(Integer gq) {
    this.gq = gq;
  }

  public Date getWgsj() {
    return wgsj;
  }

  public void setWgsj(Date wgsj) {
    this.wgsj = wgsj;
  }

  public Integer getFhfs() {
    return fhfs;
  }

  public void setFhfs(Integer fhfs) {
    this.fhfs = fhfs;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public Integer getDdzt() {
    return ddzt;
  }

  public void setDdzt(Integer ddzt) {
    this.ddzt = ddzt;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }

  @Override
  public String toString() {
    return "OrderDetail{" +
            "id='" + id + '\'' +
            ", ddbh='" + ddbh + '\'' +
            ", ddlx=" + ddlx +
            ", ddly=" + ddly +
            ", scsl=" + scsl +
            ", khxm='" + khxm + '\'' +
            ", dz='" + dz + '\'' +
            ", dh='" + dh + '\'' +
            ", gq=" + gq +
            ", wgsj=" + wgsj +
            ", fhfs=" + fhfs +
            ", bz='" + bz + '\'' +
            ", ddzt=" + ddzt +
            ", shzt=" + shzt +
            ", zt=" + zt +
            '}';
  }
}
