package com.yhxt.khxd.thjm.dto;

import com.yhxt.ddcl.dto.BaseHistoryRecordDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName TitaniumAlloyHistoryRecordDTO
 * @Author zqi
 * @Date 2019/7/9 14:24
 * @Version 1.0
 * @Description 历史记录-字段
 */
public class TitaniumAlloyHistoryRecordDTO extends BaseHistoryRecordDTO {
  /**
   * 商品类型
   */
  private Integer splx;

  /**
   * 商品名称
   */
  private String spmc;

  /**
   * 合计平方
   */
  private BigDecimal hjpf;

  public TitaniumAlloyHistoryRecordDTO() {
    super();
  }

  public TitaniumAlloyHistoryRecordDTO(String ddbh, String khxm, Integer ddlx, Integer ddly, Integer scsl, Integer gq, BigDecimal je, Integer hjsl, String bz, Integer yjdb, Date wgsj, String dz, String dh, String czr, Date czsj, Integer splx, String spmc, BigDecimal hjpf) {
    super(ddbh, khxm, ddlx, ddly, scsl, gq, je, hjsl, bz, yjdb, wgsj, dz, dh, czr, czsj);
    this.splx = splx;
    this.spmc = spmc;
    this.hjpf = hjpf;
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

  public BigDecimal getHjpf() {
    return hjpf;
  }

  public void setHjpf(BigDecimal hjpf) {
    this.hjpf = hjpf;
  }

  @Override
  public String toString() {
    return "TitaniumAlloyHistoryRecordDTO{" +
            "splx=" + splx +
            ", spmc='" + spmc + '\'' +
            ", hjpf=" + hjpf +
            '}';
  }
}
