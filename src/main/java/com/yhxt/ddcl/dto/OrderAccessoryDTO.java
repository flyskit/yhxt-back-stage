package com.yhxt.ddcl.dto;

import java.math.BigDecimal;

/**
 * @ClassName OrderAccessoryDTO
 * @Author zqi
 * @Date 2019/6/29 15:31
 * @Version 1.0
 * @Description 配件查询
 */
public class OrderAccessoryDTO {
  /**
   * 订单-配件id标识
   */
  private String id;

  /**
   * 配件名称
   */
  private String mc;

  /**
   * 配件编号
   */
  private String bh;

  /**
   * 规格
   */
  private String gg;

  /**
   * 配件数量
   */
  private Integer pjsl;

  /**
   * 单位
   */
  private String dw;

  /**
   * 配件单价
   */
  private BigDecimal pjdj;

  /**
   * 配件金额
   */
  private BigDecimal pjje;

  public OrderAccessoryDTO() {
  }

  public OrderAccessoryDTO(String id, String mc, String bh, String gg, Integer pjsl, String dw, BigDecimal pjdj, BigDecimal pjje) {
    this.id = id;
    this.mc = mc;
    this.bh = bh;
    this.gg = gg;
    this.pjsl = pjsl;
    this.dw = dw;
    this.pjdj = pjdj;
    this.pjje = pjje;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMc() {
    return mc;
  }

  public void setMc(String mc) {
    this.mc = mc;
  }

  public String getBh() {
    return bh;
  }

  public void setBh(String bh) {
    this.bh = bh;
  }

  public String getGg() {
    return gg;
  }

  public void setGg(String gg) {
    this.gg = gg;
  }

  public Integer getPjsl() {
    return pjsl;
  }

  public void setPjsl(Integer pjsl) {
    this.pjsl = pjsl;
  }

  public BigDecimal getPjdj() {
    return pjdj;
  }

  public void setPjdj(BigDecimal pjdj) {
    this.pjdj = pjdj;
  }

  public BigDecimal getPjje() {
    return pjje;
  }

  public void setPjje(BigDecimal pjje) {
    this.pjje = pjje;
  }

  public String getDw() {
    return dw;
  }

  public void setDw(String dw) {
    this.dw = dw;
  }

  @Override
  public String toString() {
    return "OrderAccessoryDTO{" +
            "id='" + id + '\'' +
            ", mc='" + mc + '\'' +
            ", bh='" + bh + '\'' +
            ", gg='" + gg + '\'' +
            ", pjsl=" + pjsl +
            ", dw='" + dw + '\'' +
            ", pjdj=" + pjdj +
            ", pjje=" + pjje +
            '}';
  }
}
