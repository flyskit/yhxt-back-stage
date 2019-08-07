package com.yhxt.khxd.tzm.dto;

import com.yhxt.ddcl.dto.BaseHistoryRecordDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName SuitHistoryRecordDTO
 * @Author zqi
 * @Date 2019/7/17 10:42
 * @Version 1.0
 * @Description 历史记录基本字段
 */
public class SuitHistoryRecordDTO extends BaseHistoryRecordDTO {

  /**
   * 商品类型
   */
  private Integer splx;

  /**
   * 商品名称
   */
  private String spmc;

  /**
   * 平开门门扇
   */
  private Integer pkmms;

  /**
   * 平开门套数
   */
  private Integer pkmts;

  /**
   * 推门门扇
   */
  private Integer tmms;

  /**
   * 推门套数
   */
  private Integer tmts;

  /**
   * 合计门套
   */
  private Integer hjmt;

  /**
   * 合计线条
   */
  private Integer hjxt;

  public SuitHistoryRecordDTO() {
    super();
  }

  public SuitHistoryRecordDTO(String ddbh, String khxm, Integer ddlx, Integer ddly, Integer scsl, Integer gq, BigDecimal je, String bz, Integer yjdb, Date wgsj, String dz, String dh, String czr, Date czsj, Integer splx, String spmc, Integer pkmms, Integer pkmts, Integer tmms, Integer tmts, Integer hjmt, Integer hjxt) {
    super(ddbh, khxm, ddlx, ddly, scsl, gq, je, bz, yjdb, wgsj, dz, dh, czr, czsj);
    this.splx = splx;
    this.spmc = spmc;
    this.pkmms = pkmms;
    this.pkmts = pkmts;
    this.tmms = tmms;
    this.tmts = tmts;
    this.hjmt = hjmt;
    this.hjxt = hjxt;
  }

  public Integer getSplx() {
    return splx;
  }

  public void setSplx(Integer splx) {
    this.splx = splx;
  }

  public String getSpmc() {
    return spmc;
  }

  public void setSpmc(String spmc) {
    this.spmc = spmc;
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

  @Override
  public String toString() {
    return "SuitHistoryRecordDTO{" +
            "splx=" + splx +
            ", spmc='" + spmc + '\'' +
            ", pkmms=" + pkmms +
            ", pkmts=" + pkmts +
            ", tmms=" + tmms +
            ", tmts=" + tmts +
            ", hjmt=" + hjmt +
            ", hjxt=" + hjxt +
            '}';
  }
}
