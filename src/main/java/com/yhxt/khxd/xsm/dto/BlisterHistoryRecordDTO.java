package com.yhxt.khxd.xsm.dto;

import com.yhxt.ddcl.dto.BaseHistoryRecordDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName BlisterHistoryRecordDTO
 * @Author zqi
 * @Date 2019/7/12 14:35
 * @Version 1.0
 * @Description 查询记录-返回字段
 */
public class BlisterHistoryRecordDTO extends BaseHistoryRecordDTO {
  /**
   * 板材
   */
  private String bc;

  /**
   * 单价
   */
  private BigDecimal dj;

  /**
   * 合计平方
   */
  private BigDecimal hjpf;

  public BlisterHistoryRecordDTO() {
    super();
  }

  public BlisterHistoryRecordDTO(String ddbh, String khxm, Integer ddlx, Integer ddly, Integer scsl, Integer gq, BigDecimal je, Integer hjsl, String bz, Integer yjdb, Date wgsj, String dz, String dh, String czr, Date czsj, String bc, BigDecimal dj, BigDecimal hjpf) {
    super(ddbh, khxm, ddlx, ddly, scsl, gq, je, hjsl, bz, yjdb, wgsj, dz, dh, czr, czsj);
    this.bc = bc;
    this.dj = dj;
    this.hjpf = hjpf;
  }

  public String getBc() {
    return bc;
  }

  public void setBc(String bc) {
    this.bc = bc;
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

  @Override
  public String toString() {
    return "BlisterHistoryRecordDTO{" +
            "bc='" + bc + '\'' +
            ", dj=" + dj +
            ", hjpf=" + hjpf +
            '}';
  }
}
