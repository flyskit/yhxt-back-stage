package com.yhxt.khxd.yklm.dto;

import com.yhxt.ddcl.dto.BaseHistoryRecordDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName AcrylicHistoryRecordDTO
 * @Author zqi
 * @Date 2019/7/3 16:45
 * @Version 1.0
 * @Description 亚克力门-记录查询返回字段
 */
public class AcrylicHistoryRecordDTO extends BaseHistoryRecordDTO {
  /**
   * 板材名称
   */
  private String bcmc;

  /**
   * 板材单价
   */
  private BigDecimal bcdj;

  /**
   * 拉手名称
   */
  private String lsmc;

  /**
   * 拉手单价
   */
  private BigDecimal lsdj;

  /**
   * 颜色
   */
  private String ys;

  /**
   * 合计平方
   */
  private BigDecimal hjpf;

  /**
   * 板材平方
   */
  private BigDecimal bcpf;

  public AcrylicHistoryRecordDTO() {
    super();
  }

  public AcrylicHistoryRecordDTO(String ddbh, String khxm, Integer ddlx, Integer ddly, Integer scsl, Integer gq, BigDecimal je, Integer hjsl, String bz, Integer yjdb, Date wgsj, String dz, String dh, String czr, Date czsj, String bcmc, BigDecimal bcdj, String lsmc, BigDecimal lsdj, String ys, BigDecimal hjpf, BigDecimal bcpf) {
    super(ddbh, khxm, ddlx, ddly, scsl, gq, je, hjsl, bz, yjdb, wgsj, dz, dh, czr, czsj);
    this.bcmc = bcmc;
    this.bcdj = bcdj;
    this.lsmc = lsmc;
    this.lsdj = lsdj;
    this.ys = ys;
    this.hjpf = hjpf;
    this.bcpf = bcpf;
  }

  public String getBcmc() {
    return bcmc;
  }

  public void setBcmc(String bcmc) {
    this.bcmc = bcmc;
  }

  public BigDecimal getBcdj() {
    return bcdj;
  }

  public void setBcdj(BigDecimal bcdj) {
    this.bcdj = bcdj;
  }

  public String getLsmc() {
    return lsmc;
  }

  public void setLsmc(String lsmc) {
    this.lsmc = lsmc;
  }

  public BigDecimal getLsdj() {
    return lsdj;
  }

  public void setLsdj(BigDecimal lsdj) {
    this.lsdj = lsdj;
  }

  public String getYs() {
    return ys;
  }

  public void setYs(String ys) {
    this.ys = ys;
  }

  public BigDecimal getHjpf() {
    return hjpf;
  }

  public void setHjpf(BigDecimal hjpf) {
    this.hjpf = hjpf;
  }

  public BigDecimal getBcpf() {
    return bcpf;
  }

  public void setBcpf(BigDecimal bcpf) {
    this.bcpf = bcpf;
  }

  @Override
  public String toString() {
    return "AcrylicHistoryRecordDTO{" +
            "bcmc='" + bcmc + '\'' +
            ", bcdj=" + bcdj +
            ", lsmc='" + lsmc + '\'' +
            ", lsdj=" + lsdj +
            ", ys='" + ys + '\'' +
            ", hjpf=" + hjpf +
            ", bcpf=" + bcpf +
            '}';
  }
}
