package com.yhxt.khxd.jgm.dto;

import com.yhxt.ddcl.dto.BaseHistoryRecordDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName HistoryRecordDTO
 * @Author zqi
 * @Date 2019/6/25 17:07
 * @Version 1.0
 * @Description 记录查询
 */
public class HistoryRecordDTO extends BaseHistoryRecordDTO {

  /**
   * 拉手
   */
  private String ls;

  /**
   * 颜色
   */
  private String ys;

  /**
   * 单价
   */
  private BigDecimal dj;

  /**
   * 合计平方
   */
  private BigDecimal hjpf;

  /**
   * 玻璃平方
   */
  private BigDecimal blpf;

  public HistoryRecordDTO() {
    super();
  }

  public HistoryRecordDTO(String ddbh, String khxm, Integer ddlx, Integer ddly, Integer scsl, Integer gq, BigDecimal je, Integer hjsl, String bz, Integer yjdb, Date wgsj, String dz, String dh, String czr, Date czsj, String ls, String ys, BigDecimal dj, BigDecimal hjpf, BigDecimal blpf) {
    super(ddbh, khxm, ddlx, ddly, scsl, gq, je, hjsl, bz, yjdb, wgsj, dz, dh, czr, czsj);
    this.ls = ls;
    this.ys = ys;
    this.dj = dj;
    this.hjpf = hjpf;
    this.blpf = blpf;
  }

  public String getLs() {
    return ls;
  }

  public void setLs(String ls) {
    this.ls = ls;
  }

  public String getYs() {
    return ys;
  }

  public void setYs(String ys) {
    this.ys = ys;
  }

  public BigDecimal getDj() {
    return dj;
  }

  public void setDj(BigDecimal dj) {
    this.dj = dj;
  }

  public BigDecimal getHjpf() {
    return hjpf;
  }

  public void setHjpf(BigDecimal hjpf) {
    this.hjpf = hjpf;
  }

  public BigDecimal getBlpf() {
    return blpf;
  }

  public void setBlpf(BigDecimal blpf) {
    this.blpf = blpf;
  }
}
