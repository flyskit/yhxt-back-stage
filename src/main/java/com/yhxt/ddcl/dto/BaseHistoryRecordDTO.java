package com.yhxt.ddcl.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName BaseHistoryRecordDTO
 * @Author zqi
 * @Date 2019/7/3 16:40
 * @Version 1.0
 * @Description 订单基本返回信息
 */
public class BaseHistoryRecordDTO {
  /**
   * 订单编号
   */
  private String ddbh;

  /**
   * 客户姓名
   */
  private String khxm;

  /**
   * 订单类型
   */
  private Integer ddlx;

  /**
   * 订单来源
   */
  private Integer ddly;

  /**
   * 生产速率
   */
  private Integer scsl;

  /**
   * 工期
   */
  private Integer gq;

  /**
   * 金额
   */
  private BigDecimal je;

  /**
   * 合计数量
   */
  private Integer hjsl;

  /**
   * 备注
   */
  private String bz;

  /**
   * 预计打包
   */
  private Integer yjdb;

  /**
   * 发货时间
   */
  private Date wgsj;

  /**
   * 地址
   */
  private String dz;

  /**
   * 电话
   */
  private String dh;

  /**
   * 创建人
   */
  private String czr;

  /**
   * 创建时间
   */
  private Date czsj;

  /**
   * 配件
   */
  private StringBuilder pj;

  /**
   * 配件金额
   */
  private BigDecimal pjje;

  public BaseHistoryRecordDTO() {
  }

  public BaseHistoryRecordDTO(String ddbh, String khxm, Integer ddlx, Integer ddly, Integer scsl, Integer gq, BigDecimal je, Integer hjsl, String bz, Integer yjdb, Date wgsj, String dz, String dh, String czr, Date czsj) {
    this.ddbh = ddbh;
    this.khxm = khxm;
    this.ddlx = ddlx;
    this.ddly = ddly;
    this.scsl = scsl;
    this.gq = gq;
    this.je = je;
    this.hjsl = hjsl;
    this.bz = bz;
    this.yjdb = yjdb;
    this.wgsj = wgsj;
    this.dz = dz;
    this.dh = dh;
    this.czr = czr;
    this.czsj = czsj;
  }

  public BaseHistoryRecordDTO(String ddbh, String khxm, Integer ddlx, Integer ddly, Integer scsl, Integer gq, BigDecimal je, String bz, Integer yjdb, Date wgsj, String dz, String dh, String czr, Date czsj) {
    this.ddbh = ddbh;
    this.khxm = khxm;
    this.ddlx = ddlx;
    this.ddly = ddly;
    this.scsl = scsl;
    this.gq = gq;
    this.je = je;
    this.bz = bz;
    this.yjdb = yjdb;
    this.wgsj = wgsj;
    this.dz = dz;
    this.dh = dh;
    this.czr = czr;
    this.czsj = czsj;
  }

  public BigDecimal getPjje() {
    return pjje;
  }

  public void setPjje(BigDecimal pjje) {
    this.pjje = pjje;
  }

  public StringBuilder getPj() {
    return pj;
  }

  public void setPj(StringBuilder pj) {
    this.pj = pj;
  }

  public String getDdbh() {
    return ddbh;
  }

  public void setDdbh(String ddbh) {
    this.ddbh = ddbh;
  }

  public String getKhxm() {
    return khxm;
  }

  public void setKhxm(String khxm) {
    this.khxm = khxm;
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

  public Integer getGq() {
    return gq;
  }

  public void setGq(Integer gq) {
    this.gq = gq;
  }

  public BigDecimal getJe() {
    return je;
  }

  public void setJe(BigDecimal je) {
    this.je = je;
  }

  public Integer getHjsl() {
    return hjsl;
  }

  public void setHjsl(Integer hjsl) {
    this.hjsl = hjsl;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public Integer getYjdb() {
    return yjdb;
  }

  public void setYjdb(Integer yjdb) {
    this.yjdb = yjdb;
  }

  public Date getWgsj() {
    return wgsj;
  }

  public void setWgsj(Date wgsj) {
    this.wgsj = wgsj;
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
    return "BaseHistoryRecordDTO{" +
            "ddbh='" + ddbh + '\'' +
            ", khxm='" + khxm + '\'' +
            ", ddlx=" + ddlx +
            ", ddly=" + ddly +
            ", scsl=" + scsl +
            ", gq=" + gq +
            ", je=" + je +
            ", hjsl=" + hjsl +
            ", bz='" + bz + '\'' +
            ", yjdb=" + yjdb +
            ", wgsj=" + wgsj +
            ", dz='" + dz + '\'' +
            ", dh='" + dh + '\'' +
            ", czr='" + czr + '\'' +
            ", czsj=" + czsj +
            '}';
  }
}
