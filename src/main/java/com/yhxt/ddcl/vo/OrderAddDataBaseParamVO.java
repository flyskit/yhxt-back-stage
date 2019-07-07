package com.yhxt.ddcl.vo;

/**
 * @ClassName OrderAddDataBaseParamVO
 * @Author zqi
 * @Date 2019/7/3 15:23
 * @Version 1.0
 * @Description 添加订单-基本参数
 */
public class OrderAddDataBaseParamVO {
  /**
   * 订单编号
   */
  private String ddbh;

  /**
   * 订单来源
   */
  private Integer ddly;

  /**
   * 订单类型
   */
  private Integer ddlx;

  /**
   * 生产速率
   */
  private Integer scsl;

  /**
   * 工期
   */
  private Integer gq;

  /**
   * 客户姓名
   */
  private String khxm;

  /**
   * 地址
   */
  private String dz;

  /**
   * 电话
   */
  private String dh;

  /**
   * 备注
   */
  private String bz;

  /**
   * 订单状态
   */
  private Integer ddzt;


  public OrderAddDataBaseParamVO() {
  }

  public OrderAddDataBaseParamVO(String ddbh, Integer ddly, Integer ddlx, Integer scsl, Integer gq, String khxm, String dz, String dh, String bz, Integer ddzt) {
    this.ddbh = ddbh;
    this.ddly = ddly;
    this.ddlx = ddlx;
    this.scsl = scsl;
    this.gq = gq;
    this.khxm = khxm;
    this.dz = dz;
    this.dh = dh;
    this.bz = bz;
    this.ddzt = ddzt;
  }

  public String getDdbh() {
    return ddbh;
  }

  public void setDdbh(String ddbh) {
    this.ddbh = ddbh;
  }

  public Integer getDdly() {
    return ddly;
  }

  public void setDdly(Integer ddly) {
    this.ddly = ddly;
  }

  public Integer getDdlx() {
    return ddlx;
  }

  public void setDdlx(Integer ddlx) {
    this.ddlx = ddlx;
  }

  public Integer getScsl() {
    return scsl;
  }

  public void setScsl(Integer scsl) {
    this.scsl = scsl;
  }

  public Integer getGq() {
    return gq;
  }

  public void setGq(Integer gq) {
    this.gq = gq;
  }

  public String getKhxm() {
    return khxm;
  }

  public void setKhxm(String khxm) {
    this.khxm = khxm;
  }

  public String getDz() {
    return dz;
  }

  public void setDz(String dz) {
    this.dz = dz;
  }

  public String getDh() {
    return dh;
  }

  public void setDh(String dh) {
    this.dh = dh;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public Integer getDdzt() {
    return ddzt;
  }

  public void setDdzt(Integer ddzt) {
    this.ddzt = ddzt;
  }

  @Override
  public String toString() {
    return "OrderAddDataBaseParamVO{" +
            "ddbh='" + ddbh + '\'' +
            ", ddly=" + ddly +
            ", ddlx=" + ddlx +
            ", scsl=" + scsl +
            ", gq=" + gq +
            ", khxm='" + khxm + '\'' +
            ", dz='" + dz + '\'' +
            ", dh='" + dh + '\'' +
            ", bz='" + bz + '\'' +
            ", ddzt=" + ddzt +
            '}';
  }
}
