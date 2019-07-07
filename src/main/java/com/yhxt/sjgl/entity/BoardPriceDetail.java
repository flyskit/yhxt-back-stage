package com.yhxt.sjgl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName BoardPriceDetail
 * @Author zqi
 * @Date 2019/7/3 14:42
 * @Version 1.0
 * @Description 材质报价-基本信息
 */
@Entity
@Table(name = "board_price_detail")
public class BoardPriceDetail implements Serializable {

  private static final long serialVersionUID = 7990330994063325682L;
  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 商品类型
   */
  @Column(name = "splx")
  private Integer splx;

  /**
   * 编号
   */
  @Column(name = "bh")
  private String bh;

  /**
   * 名称
   */
  @Column(name = "mc")
  private String mc;

  /**
   * 单价
   */
  @Column(name = "dj")
  private BigDecimal dj;

  /**
   * 规格
   */
  @Column(name = "gg")
  private String gg;

  /**
   * 备注
   */
  @Column(name = "bz")
  private String bz;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  public BoardPriceDetail() {
  }

  public BoardPriceDetail(Integer splx, String bh, String mc, BigDecimal dj, String gg, String bz, Boolean zt) {
    this.splx = splx;
    this.bh = bh;
    this.mc = mc;
    this.dj = dj;
    this.gg = gg;
    this.bz = bz;
    this.zt = zt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getSplx() {
    return splx;
  }

  public void setSplx(Integer splx) {
    this.splx = splx;
  }

  public String getBh() {
    return bh;
  }

  public void setBh(String bh) {
    this.bh = bh;
  }

  public String getMc() {
    return mc;
  }

  public void setMc(String mc) {
    this.mc = mc;
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

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }

  @Override
  public String toString() {
    return "BoardPriceDetail{" +
            "id='" + id + '\'' +
            ", splx=" + splx +
            ", bh=" + bh +
            ", mc='" + mc + '\'' +
            ", dj=" + dj +
            ", gg='" + gg + '\'' +
            ", bz='" + bz + '\'' +
            ", zt=" + zt +
            '}';
  }
}
