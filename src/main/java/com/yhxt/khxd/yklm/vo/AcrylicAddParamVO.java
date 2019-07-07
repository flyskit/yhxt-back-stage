package com.yhxt.khxd.yklm.vo;

import com.yhxt.ddcl.vo.OrderAddDataBaseParamVO;
import com.yhxt.khxd.jgm.entity.CupboardDoorSize;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * @ClassName AcrylicAddParamVO
 * @Author zqi
 * @Date 2019/7/3 15:05
 * @Version 1.0
 * @Description 添加订单-接受参数
 */
public class AcrylicAddParamVO extends OrderAddDataBaseParamVO {

  /**
   * 板材名称
   */
  private String bcmc;

  /**
   * 板材单价
   */
  private BigDecimal bcdj;

  /**
   * 拉手名称
   */
  private String lsmc;

  /**
   * 拉手单价
   */
  private BigDecimal lsdj;

  /**
   * 颜色
   */
  private String ys;

  /**
   * 合计平方
   */
  private BigDecimal hjpf;

  /**
   * 板材平方
   */
  private BigDecimal bcpf;

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

  public AcrylicAddParamVO() {
    super();
  }

  public AcrylicAddParamVO(String bcmc, BigDecimal bcdj, String lsmc, BigDecimal lsdj, String ys, BigDecimal hjpf, BigDecimal bcpf, Integer hjsl, BigDecimal je, Integer yjdb, LinkedList<CupboardDoorSize> cupboardDoorSizes) {
    this.bcmc = bcmc;
    this.bcdj = bcdj;
    this.lsmc = lsmc;
    this.lsdj = lsdj;
    this.ys = ys;
    this.hjpf = hjpf;
    this.bcpf = bcpf;
    this.hjsl = hjsl;
    this.je = je;
    this.yjdb = yjdb;
    this.cupboardDoorSizes = cupboardDoorSizes;
  }

  public AcrylicAddParamVO(String ddbh, Integer ddly, Integer ddlx, Integer scsl, Integer gq, String khxm, String dz, String dh, String bz, Integer ddzt, String bcmc, BigDecimal bcdj, String lsmc, BigDecimal lsdj, String ys, BigDecimal hjpf, BigDecimal bcpf, Integer hjsl, BigDecimal je, Integer yjdb, LinkedList<CupboardDoorSize> cupboardDoorSizes) {
    super(ddbh, ddly, ddlx, scsl, gq, khxm, dz, dh, bz, ddzt);
    this.bcmc = bcmc;
    this.bcdj = bcdj;
    this.lsmc = lsmc;
    this.lsdj = lsdj;
    this.ys = ys;
    this.hjpf = hjpf;
    this.bcpf = bcpf;
    this.hjsl = hjsl;
    this.je = je;
    this.yjdb = yjdb;
    this.cupboardDoorSizes = cupboardDoorSizes;
  }

  public String getYs() {
    return ys;
  }

  public void setYs(String ys) {
    this.ys = ys;
  }

  public String getBcmc() {
    return bcmc;
  }

  public void setBcmc(String bcmc) {
    this.bcmc = bcmc;
  }

  public BigDecimal getBcdj() {
    return bcdj;
  }

  public void setBcdj(BigDecimal bcdj) {
    this.bcdj = bcdj;
  }

  public String getLsmc() {
    return lsmc;
  }

  public void setLsmc(String lsmc) {
    this.lsmc = lsmc;
  }

  public BigDecimal getLsdj() {
    return lsdj;
  }

  public void setLsdj(BigDecimal lsdj) {
    this.lsdj = lsdj;
  }

  public BigDecimal getHjpf() {
    return hjpf;
  }

  public void setHjpf(BigDecimal hjpf) {
    this.hjpf = hjpf;
  }

  public BigDecimal getBcpf() {
    return bcpf;
  }

  public void setBcpf(BigDecimal bcpf) {
    this.bcpf = bcpf;
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
    return "AcrylicAddParamVO{" +
            "bcmc='" + bcmc + '\'' +
            ", bcdj=" + bcdj +
            ", lsmc='" + lsmc + '\'' +
            ", lsdj=" + lsdj +
            ", ys='" + ys + '\'' +
            ", hjpf=" + hjpf +
            ", bcpf=" + bcpf +
            ", hjsl=" + hjsl +
            ", je=" + je +
            ", yjdb=" + yjdb +
            ", cupboardDoorSizes=" + cupboardDoorSizes +
            '}';
  }
}
