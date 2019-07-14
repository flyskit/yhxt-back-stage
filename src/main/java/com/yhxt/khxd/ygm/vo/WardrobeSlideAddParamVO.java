package com.yhxt.khxd.ygm.vo;

import com.yhxt.ddcl.vo.OrderAddDataBaseParamVO;
import com.yhxt.khxd.ygm.entity.WardrobeSlideSize;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * @ClassName WardrobeSlideAddParamVO
 * @Author zqi
 * @Date 2019/7/13 15:18
 * @Version 1.0
 * @Description
 */
public class WardrobeSlideAddParamVO extends OrderAddDataBaseParamVO {
  /**
   * 合计平方
   */
  private BigDecimal hjpf;

  /**
   * 芯板平方
   */
  private BigDecimal xbpf;

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
  private LinkedList<WardrobeSlideSize> wardrobeSlideSizes;

  public WardrobeSlideAddParamVO() {
  }

  public WardrobeSlideAddParamVO(String ddbh, Integer ddly, Integer ddlx, Integer scsl, Integer gq, String khxm, String dz, String dh, String bz, Integer ddzt, BigDecimal hjpf, BigDecimal xbpf, Integer hjsl, BigDecimal je, Integer yjdb, LinkedList<WardrobeSlideSize> wardrobeSlideSizes) {
    super(ddbh, ddly, ddlx, scsl, gq, khxm, dz, dh, bz, ddzt);
    this.hjpf = hjpf;
    this.xbpf = xbpf;
    this.hjsl = hjsl;
    this.je = je;
    this.yjdb = yjdb;
    this.wardrobeSlideSizes = wardrobeSlideSizes;
  }

  public BigDecimal getXbpf() {
    return xbpf;
  }

  public void setXbpf(BigDecimal xbpf) {
    this.xbpf = xbpf;
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

  public LinkedList<WardrobeSlideSize> getWardrobeSlideSizes() {
    return wardrobeSlideSizes;
  }

  public void setWardrobeSlideSizes(LinkedList<WardrobeSlideSize> wardrobeSlideSizes) {
    this.wardrobeSlideSizes = wardrobeSlideSizes;
  }

  @Override
  public String toString() {
    return "WardrobeSlideAddParamVO{" +
            "hjpf=" + hjpf +
            ", hjsl=" + hjsl +
            ", je=" + je +
            ", yjdb=" + yjdb +
            ", wardrobeSlideSizes=" + wardrobeSlideSizes +
            '}';
  }
}
