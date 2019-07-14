package com.yhxt.khxd.ygm.dto;

import com.yhxt.ddcl.dto.BaseHistoryRecordDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName WardrobeSlideHistoryRecordDTO
 * @Author zqi
 * @Date 2019/7/13 15:10
 * @Version 1.0
 * @Description 记录返回字段
 */
public class WardrobeSlideHistoryRecordDTO extends BaseHistoryRecordDTO {
  /**
   * 合计平方
   */
  private BigDecimal hjpf;

  /**
   * 芯板平方
   */
  private BigDecimal xbpf;

  public WardrobeSlideHistoryRecordDTO() {
    super();
  }

  public WardrobeSlideHistoryRecordDTO(String ddbh, String khxm, Integer ddlx, Integer ddly, Integer scsl, Integer gq, BigDecimal je, Integer hjsl, String bz, Integer yjdb, Date wgsj, String dz, String dh, String czr, Date czsj, BigDecimal hjpf, BigDecimal xbpf) {
    super(ddbh, khxm, ddlx, ddly, scsl, gq, je, hjsl, bz, yjdb, wgsj, dz, dh, czr, czsj);
    this.hjpf = hjpf;
    this.xbpf = xbpf;
  }

  public BigDecimal getXbpf() {
    return xbpf;
  }

  public void setXbpf(BigDecimal xbpf) {
    this.xbpf = xbpf;
  }

  public BigDecimal getHjpf() {
    return hjpf;
  }

  public void setHjpf(BigDecimal hjpf) {
    this.hjpf = hjpf;
  }

  @Override
  public String toString() {
    return "WardrobeSlideHistoryRecordDTO{" +
            "hjpf=" + hjpf +
            ", xbpf=" + xbpf +
            '}';
  }
}
