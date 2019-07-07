package com.yhxt.ddcl.vo;

/**
 * @ClassName OrderDelParamVO
 * @Author zqi
 * @Date 2019/6/27 17:28
 * @Version 1.0
 * @Description 订单删除-接受参数
 */
public class OrderDelParamVO {
  /**
   * 订单编号
   */
  private String ddbh;

  /**
   * 删除原因
   */
  private String scyy;

  public OrderDelParamVO() {
  }

  public OrderDelParamVO(String ddbh, String scyy) {
    this.ddbh = ddbh;
    this.scyy = scyy;
  }

  public String getDdbh() {
    return ddbh;
  }

  public void setDdbh(String ddbh) {
    this.ddbh = ddbh;
  }

  public String getScyy() {
    return scyy;
  }

  public void setScyy(String scyy) {
    this.scyy = scyy;
  }

  @Override
  public String toString() {
    return "OrderDelParamVO{" +
            "ddbh='" + ddbh + '\'' +
            ", scyy='" + scyy + '\'' +
            '}';
  }
}
