package com.yhxt.khxd.jgm.vo;

import com.yhxt.ddcl.vo.OrderAddDataBaseParamVO;
import com.yhxt.khxd.jgm.entity.CupboardDoorSize;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * @ClassName CrystalSteelDoorAddParamVO
 * @Author zqi
 * @Date 2019/6/20 20:04
 * @Version 1.0
 * @Description 晶钢门-添加订单-接受参数
 */
public class CrystalSteelDoorAddParamVO extends OrderAddDataBaseParamVO {
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

  /**
   * 合计数量
   */
  private Integer hjsl;

  /**
   * 金额
   */
  private BigDecimal je;

  /**
   * 预计打包
   */
  private Integer yjdb;

  /**
   * 订单-尺寸信息
   */
  private LinkedList<CupboardDoorSize> cupboardDoorSizes;

  public CrystalSteelDoorAddParamVO() {
    super();
  }

  public CrystalSteelDoorAddParamVO(String ddbh, Integer ddly, Integer ddlx, Integer scsl, Integer gq, String khxm, String dz, String dh, String bz, Integer ddzt, String ls, String ys, BigDecimal dj, BigDecimal hjpf, BigDecimal blpf, Integer hjsl, BigDecimal je, Integer yjdb, LinkedList<CupboardDoorSize> cupboardDoorSizes) {
    super(ddbh, ddly, ddlx, scsl, gq, khxm, dz, dh, bz, ddzt);
    this.ls = ls;
    this.ys = ys;
    this.dj = dj;
    this.hjpf = hjpf;
    this.blpf = blpf;
    this.hjsl = hjsl;
    this.je = je;
    this.yjdb = yjdb;
    this.cupboardDoorSizes = cupboardDoorSizes;
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

  public Integer getHjsl() {
    return hjsl;
  }

  public void setHjsl(Integer hjsl) {
    this.hjsl = hjsl;
  }

  public BigDecimal getJe() {
    return je;
  }

  public void setJe(BigDecimal je) {
    this.je = je;
  }

  public Integer getYjdb() {
    return yjdb;
  }

  public void setYjdb(Integer yjdb) {
    this.yjdb = yjdb;
  }

  public LinkedList<CupboardDoorSize> getCupboardDoorSizes() {
    return cupboardDoorSizes;
  }

  public void setCupboardDoorSizes(LinkedList<CupboardDoorSize> cupboardDoorSizes) {
    this.cupboardDoorSizes = cupboardDoorSizes;
  }

  @Override
  public String toString() {
    return "CrystalSteelDoorAddParamVO{" +
            "ls='" + ls + '\'' +
            ", ys='" + ys + '\'' +
            ", dj=" + dj +
            ", hjpf=" + hjpf +
            ", blpf=" + blpf +
            ", hjsl=" + hjsl +
            ", je=" + je +
            ", yjdb=" + yjdb +
            ", cupboardDoorSizes=" + cupboardDoorSizes +
            '}';
  }
}
