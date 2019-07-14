package com.yhxt.khxd.xsm.vo;

import com.yhxt.ddcl.vo.OrderAddDataBaseParamVO;
import com.yhxt.khxd.xsm.entity.BlisterSize;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * @ClassName BlisterAddParamVO
 * @Author zqi
 * @Date 2019/7/12 14:30
 * @Version 1.0
 * @Description 吸塑门-添加订单
 */
public class BlisterAddParamVO extends OrderAddDataBaseParamVO {

  /**
   * 合计平方
   */
  private BigDecimal hjpf;

  /**
   * 合计数量
   */
  private Integer hjsl;

  /**
   * 合计金额
   */
  private BigDecimal je;

  /**
   * 预计打包
   */
  private Integer yjdb;

  /**
   * 订单-尺寸信息
   */
  private LinkedList<BlisterSize> blisterSizes;

  public BlisterAddParamVO() {
    super();
  }

  public BlisterAddParamVO(String ddbh, Integer ddly, Integer ddlx, Integer scsl, Integer gq, String khxm, String dz, String dh, String bz, Integer ddzt, BigDecimal hjpf, Integer hjsl, BigDecimal je, Integer yjdb, LinkedList<BlisterSize> blisterSizes) {
    super(ddbh, ddly, ddlx, scsl, gq, khxm, dz, dh, bz, ddzt);
    this.hjpf = hjpf;
    this.hjsl = hjsl;
    this.je = je;
    this.yjdb = yjdb;
    this.blisterSizes = blisterSizes;
  }

  public BigDecimal getHjpf() {
    return hjpf;
  }

  public void setHjpf(BigDecimal hjpf) {
    this.hjpf = hjpf;
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

  public LinkedList<BlisterSize> getBlisterSizes() {
    return blisterSizes;
  }

  public void setBlisterSizes(LinkedList<BlisterSize> blisterSizes) {
    this.blisterSizes = blisterSizes;
  }

  @Override
  public String toString() {
    return "BlisterAddParamVO{" +
            ", hjpf=" + hjpf +
            ", hjsl=" + hjsl +
            ", je=" + je +
            ", yjdb=" + yjdb +
            ", blisterSizes=" + blisterSizes +
            '}';
  }
}
