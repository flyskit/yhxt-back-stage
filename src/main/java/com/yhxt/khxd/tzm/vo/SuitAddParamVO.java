package com.yhxt.khxd.tzm.vo;

import com.yhxt.ddcl.vo.OrderAddDataBaseParamVO;
import com.yhxt.khxd.tzm.entity.SuitHangingSize;
import com.yhxt.khxd.tzm.entity.SuitLineDetail;
import com.yhxt.khxd.tzm.entity.SuitPocketDetail;
import com.yhxt.khxd.tzm.entity.SuitSwingSize;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * @ClassName SuitAddParamVO
 * @Author zqi
 * @Date 2019/7/17 10:48
 * @Version 1.0
 * @Description 添加订单-接受参数
 */
public class SuitAddParamVO extends OrderAddDataBaseParamVO {

  /**
   * 门板类型
   */
  private Integer mblx;

  /**
   * 平开门门扇
   */
  private Integer pkmms;

  /**
   * 平开门套数
   */
  private Integer pkmts;

  /**
   * 推门门扇
   */
  private Integer tmms;

  /**
   * 推门套数
   */
  private Integer tmts;

  /**
   * 合计门套
   */
  private Integer hjmt;

  /**
   * 合计线条
   */
  private Integer hjxt;

  /**
   * 金额
   */
  private BigDecimal je;

  /**
   * 预计打包
   */
  private Integer yjdb;

  /**
   * 平开门-尺寸信息
   */
  private LinkedList<SuitSwingSize> swingSizes;

  /**
   * 推门-尺寸信息
   */
  private LinkedList<SuitHangingSize> hangingSizes;

  /**
   * 空套-尺寸信息
   */
  private LinkedList<SuitPocketDetail> pocketDetails;

  /**
   * 线条-尺寸信息
   */
  private LinkedList<SuitLineDetail> lineDetails;

  public SuitAddParamVO() {
    super();
  }

  public SuitAddParamVO(String ddbh, Integer ddly, Integer ddlx, Integer scsl, Integer gq, String khxm, String dz, String dh, String bz, Integer ddzt, Integer mblx, Integer pkmms, Integer pkmts, Integer tmms, Integer tmts, Integer hjmt, Integer hjxt, BigDecimal je, Integer yjdb, LinkedList<SuitSwingSize> swingSizes, LinkedList<SuitHangingSize> hangingSizes, LinkedList<SuitPocketDetail> pocketDetails, LinkedList<SuitLineDetail> lineDetails) {
    super(ddbh, ddly, ddlx, scsl, gq, khxm, dz, dh, bz, ddzt);
    this.mblx = mblx;
    this.pkmms = pkmms;
    this.pkmts = pkmts;
    this.tmms = tmms;
    this.tmts = tmts;
    this.hjmt = hjmt;
    this.hjxt = hjxt;
    this.je = je;
    this.yjdb = yjdb;
    this.swingSizes = swingSizes;
    this.hangingSizes = hangingSizes;
    this.pocketDetails = pocketDetails;
    this.lineDetails = lineDetails;
  }

  public LinkedList<SuitSwingSize> getSwingSizes() {
    return swingSizes;
  }

  public void setSwingSizes(LinkedList<SuitSwingSize> swingSizes) {
    this.swingSizes = swingSizes;
  }

  public LinkedList<SuitHangingSize> getHangingSizes() {
    return hangingSizes;
  }

  public void setHangingSizes(LinkedList<SuitHangingSize> hangingSizes) {
    this.hangingSizes = hangingSizes;
  }

  public LinkedList<SuitPocketDetail> getPocketDetails() {
    return pocketDetails;
  }

  public void setPocketDetails(LinkedList<SuitPocketDetail> pocketDetails) {
    this.pocketDetails = pocketDetails;
  }

  public LinkedList<SuitLineDetail> getLineDetails() {
    return lineDetails;
  }

  public void setLineDetails(LinkedList<SuitLineDetail> lineDetails) {
    this.lineDetails = lineDetails;
  }

  public Integer getMblx() {
    return mblx;
  }

  public void setMblx(Integer mblx) {
    this.mblx = mblx;
  }

  public Integer getPkmms() {
    return pkmms;
  }

  public void setPkmms(Integer pkmms) {
    this.pkmms = pkmms;
  }

  public Integer getPkmts() {
    return pkmts;
  }

  public void setPkmts(Integer pkmts) {
    this.pkmts = pkmts;
  }

  public Integer getTmms() {
    return tmms;
  }

  public void setTmms(Integer tmms) {
    this.tmms = tmms;
  }

  public Integer getTmts() {
    return tmts;
  }

  public void setTmts(Integer tmts) {
    this.tmts = tmts;
  }

  public Integer getHjmt() {
    return hjmt;
  }

  public void setHjmt(Integer hjmt) {
    this.hjmt = hjmt;
  }

  public Integer getHjxt() {
    return hjxt;
  }

  public void setHjxt(Integer hjxt) {
    this.hjxt = hjxt;
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

  @Override
  public String toString() {
    return "SuitAddParamVO{" +
            "mblx='" + mblx + '\'' +
            ", pkmms=" + pkmms +
            ", pkmts=" + pkmts +
            ", tmms=" + tmms +
            ", tmts=" + tmts +
            ", hjmt=" + hjmt +
            ", hjxt=" + hjxt +
            ", je=" + je +
            ", yjdb=" + yjdb +
            ", swingSizes=" + swingSizes +
            ", hangingSizes=" + hangingSizes +
            ", pocketDetails=" + pocketDetails +
            ", lineDetails=" + lineDetails +
            '}';
  }
}
