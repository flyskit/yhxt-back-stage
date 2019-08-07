package com.yhxt.khxd.tzm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName SuitDetail
 * @Author zqi
 * @Date 2019/7/17 9:56
 * @Version 1.0
 * @Description 套装门-基本统计信息
 */
@Entity
@Table(name = "suit_detail")
public class SuitDetail implements Serializable {
  private static final long serialVersionUID = -4040067786938394636L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 门板类型
   */
  @Column(name = "mblx")
  private Integer mblx;

  /**
   * 平开门门扇
   */
  @Column(name = "pkmms")
  private Integer pkmms;

  /**
   * 平开门套数
   */
  @Column(name = "pkmts")
  private Integer pkmts;

  /**
   * 推门门扇
   */
  @Column(name = "tmms")
  private Integer tmms;

  /**
   * 推门套数
   */
  @Column(name = "tmts")
  private Integer tmts;

  /**
   * 合计门套
   */
  @Column(name = "hjmt")
  private Integer hjmt;

  /**
   * 合计线条
   */
  @Column(name = "hjxt")
  private Integer hjxt;

  /**
   * 金额
   */
  @Column(name = "je")
  private BigDecimal je;

  /**
   * 预计打包
   */
  @Column(name = "yjdb")
  private Integer yjdb;

  /**
   * 更新记录
   *
   * @param mblx  门板类型
   * @param pkmms 平开门门扇
   * @param pkmts 平开门套数
   * @param tmms  推门门扇
   * @param tmts  推门套数
   * @param hjmt  合计门套
   * @param hjxt  合计线条
   * @param je    金额
   * @param yjdb  预计打包
   */
  public void updateDetail(Integer mblx, Integer pkmms, Integer pkmts, Integer tmms, Integer tmts, Integer hjmt, Integer hjxt, BigDecimal je, Integer yjdb) {
    this.setMblx(mblx);
    this.setPkmms(pkmms);
    this.setPkmts(pkmts);
    this.setTmms(tmms);
    this.setTmts(tmts);
    this.setHjmt(hjmt);
    this.setHjxt(hjxt);
    this.setJe(je);
    this.setYjdb(yjdb);
  }

  public SuitDetail() {
  }

  public SuitDetail(Integer mblx, Integer pkmms, Integer pkmts, Integer tmms, Integer tmts, Integer hjmt, Integer hjxt, BigDecimal je, Integer yjdb) {
    this.mblx = mblx;
    this.pkmms = pkmms;
    this.pkmts = pkmts;
    this.tmms = tmms;
    this.tmts = tmts;
    this.hjmt = hjmt;
    this.hjxt = hjxt;
    this.je = je;
    this.yjdb = yjdb;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getMblx() {
    return mblx;
  }

  public void setMblx(Integer mblx) {
    this.mblx = mblx;
  }

  public Integer getPkmms() {
    return pkmms;
  }

  public void setPkmms(Integer pkmms) {
    this.pkmms = pkmms;
  }

  public Integer getPkmts() {
    return pkmts;
  }

  public void setPkmts(Integer pkmts) {
    this.pkmts = pkmts;
  }

  public Integer getTmms() {
    return tmms;
  }

  public void setTmms(Integer tmms) {
    this.tmms = tmms;
  }

  public Integer getTmts() {
    return tmts;
  }

  public void setTmts(Integer tmts) {
    this.tmts = tmts;
  }

  public Integer getHjmt() {
    return hjmt;
  }

  public void setHjmt(Integer hjmt) {
    this.hjmt = hjmt;
  }

  public Integer getHjxt() {
    return hjxt;
  }

  public void setHjxt(Integer hjxt) {
    this.hjxt = hjxt;
  }

  public BigDecimal getJe() {
    return je;
  }

  public void setJe(BigDecimal je) {
    this.je = je;
  }

  public Integer getYjdb() {
    return yjdb;
  }

  public void setYjdb(Integer yjdb) {
    this.yjdb = yjdb;
  }

  @Override
  public String toString() {
    return "SuitDetail{" +
            "id='" + id + '\'' +
            ", mblx='" + mblx + '\'' +
            ", pkmms=" + pkmms +
            ", pkmts=" + pkmts +
            ", tmms=" + tmms +
            ", tmts=" + tmts +
            ", hjmt=" + hjmt +
            ", hjxt=" + hjxt +
            ", je=" + je +
            ", yjdb=" + yjdb +
            '}';
  }
}
