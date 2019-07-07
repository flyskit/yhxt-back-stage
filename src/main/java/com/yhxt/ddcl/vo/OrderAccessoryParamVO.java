package com.yhxt.ddcl.vo;

import java.math.BigDecimal;

/**
 * @ClassName OrderAccessoryParamVO
 * @Author zqi
 * @Date 2019/6/29 14:41
 * @Version 1.0
 * @Description 添加配件-接受参数
 */
public class OrderAccessoryParamVO {

  /**
   * 订单编号
   */
  private String ddbh;

  /**
   * 配件名称
   */
  private String mc;

  /**
   * 配件编号
   */
  private String bh;

  /**
   * 单价
   */
  private BigDecimal dj;

  /**
   * 单位
   */
  private String dw;

  /**
   * 规格
   */
  private String gg;

  /**
   * 配件数量
   */
  private Integer pjsl;

  /**
   * 金额
   */
  private BigDecimal pjje;

  public OrderAccessoryParamVO() {
  }

  public OrderAccessoryParamVO(String ddbh, String mc, String bh, BigDecimal dj, String dw, String gg, Integer pjsl, BigDecimal pjje) {
    this.ddbh = ddbh;
    this.mc = mc;
    this.bh = bh;
    this.dj = dj;
    this.dw = dw;
    this.gg = gg;
    this.pjsl = pjsl;
    this.pjje = pjje;
  }

  public String getDw() {
    return dw;
  }

  public void setDw(String dw) {
    this.dw = dw;
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

  public BigDecimal getDj() {
    return dj;
  }

  public void setDj(BigDecimal dj) {
    this.dj = dj;
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

  public BigDecimal getPjje() {
    return pjje;
  }

  public void setPjje(BigDecimal pjje) {
    this.pjje = pjje;
  }

  public String getDdbh() {
    return ddbh;
  }

  public void setDdbh(String ddbh) {
    this.ddbh = ddbh;
  }

  @Override
  public String toString() {
    return "OrderAccessoryParamVO{" +
            "ddbh='" + ddbh + '\'' +
            ", mc='" + mc + '\'' +
            ", bh='" + bh + '\'' +
            ", dj=" + dj +
            ", dw='" + dw + '\'' +
            ", gg='" + gg + '\'' +
            ", pjsl=" + pjsl +
            ", pjje=" + pjje +
            '}';
  }
}
