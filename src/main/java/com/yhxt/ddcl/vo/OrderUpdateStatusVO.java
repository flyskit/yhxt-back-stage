package com.yhxt.ddcl.vo;

/**
 * @ClassName OrderUpdateStatusVO
 * @Author zqi
 * @Date 2019/7/3 17:40
 * @Version 1.0
 * @Description 修改订单状态-接受参数
 */
public class OrderUpdateStatusVO {
  /**
   * 订单编号
   */
  private String ddbh;

  /**
   * 修改状态
   */
  private Integer zt;

  public OrderUpdateStatusVO() {
  }

  public OrderUpdateStatusVO(String ddbh, Integer zt) {
    this.ddbh = ddbh;
    this.zt = zt;
  }

  public String getDdbh() {
    return ddbh;
  }

  public void setDdbh(String ddbh) {
    this.ddbh = ddbh;
  }

  public Integer getZt() {
    return zt;
  }

  public void setZt(Integer zt) {
    this.zt = zt;
  }

  @Override
  public String toString() {
    return "OrderUpdateStatusVO{" +
            "ddbh='" + ddbh + '\'' +
            ", zt=" + zt +
            '}';
  }
}
