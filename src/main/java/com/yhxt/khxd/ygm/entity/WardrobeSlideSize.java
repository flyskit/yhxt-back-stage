package com.yhxt.khxd.ygm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName WardrobeSlideDetail
 * @Author zqi
 * @Date 2019/7/13 14:47
 * @Version 1.0
 * @Description 衣柜移门-尺寸信息表
 */
@Entity
@Table(name = "wardrobe_slide_size")
public class WardrobeSlideSize implements Serializable {
  private static final long serialVersionUID = -200149825585877185L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 材质
   */
  @Column(name = "cz")
  private String cz;

  /**
   * 造型
   */
  @Column(name = "zx")
  private String zx;

  /**
   * 颜色
   */
  @Column(name = "ys")
  private String ys;

  /**
   * 边框形状
   */
  @Column(name = "bkxz")
  private String bkxz;

  /**
   * 边框宽度
   */
  @Column(name = "bkkd")
  private String bkkd;

  /**
   * 内框高度
   */
  @Column(name = "nkgd")
  private BigDecimal nkgd;

  /**
   * 内框宽度
   */
  @Column(name = "nkkd")
  private BigDecimal nkkd;

  /**
   * 门扇数量
   */
  @Column(name = "mssl")
  private Integer mssl;

  /**
   * 竖方
   */
  @Column(name = "sf")
  private BigDecimal sf;

  /**
   * 上下方
   */
  @Column(name = "sxf")
  private BigDecimal sxf;

  /**
   * 芯板高度
   */
  @Column(name = "xbgd")
  private BigDecimal xbgd;

  /**
   * 芯板宽度
   */
  @Column(name = "xbkd")
  private BigDecimal xbkd;

  /**
   * 芯板平方
   */
  @Column(name = "xbpf")
  private BigDecimal xbpf;

  /**
   * 门扇高度
   */
  @Column(name = "msgd")
  private BigDecimal msgd;

  /**
   * 门扇宽度
   */
  @Column(name = "mskd")
  private BigDecimal mskd;

  /**
   * 平方
   */
  @Column(name = "pf")
  private BigDecimal pf;

  /**
   * 单价
   */
  @Column(name = "dj")
  private BigDecimal dj;

  /**
   * 套数
   */
  @Column(name = "ts")
  private Integer ts;

  /**
   * 金额
   */
  @Column(name = "je")
  private BigDecimal je;

  /**
   * 备注
   */
  @Column(name = "bz")
  private String bz;

  public WardrobeSlideSize() {
  }

  public WardrobeSlideSize(String cz, String zx, String ys, String bkxz, String bkkd, BigDecimal nkgd, BigDecimal nkkd, Integer mssl, BigDecimal sf, BigDecimal sxf, BigDecimal xbgd, BigDecimal xbkd, BigDecimal xbpf, BigDecimal msgd, BigDecimal mskd, BigDecimal pf, BigDecimal dj, Integer ts, BigDecimal je, String bz) {
    this.cz = cz;
    this.zx = zx;
    this.ys = ys;
    this.bkxz = bkxz;
    this.bkkd = bkkd;
    this.nkgd = nkgd;
    this.nkkd = nkkd;
    this.mssl = mssl;
    this.sf = sf;
    this.sxf = sxf;
    this.xbgd = xbgd;
    this.xbkd = xbkd;
    this.xbpf = xbpf;
    this.msgd = msgd;
    this.mskd = mskd;
    this.pf = pf;
    this.dj = dj;
    this.ts = ts;
    this.je = je;
    this.bz = bz;
  }

  public BigDecimal getXbpf() {
    return xbpf;
  }

  public void setXbpf(BigDecimal xbpf) {
    this.xbpf = xbpf;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCz() {
    return cz;
  }

  public void setCz(String cz) {
    this.cz = cz;
  }

  public String getZx() {
    return zx;
  }

  public void setZx(String zx) {
    this.zx = zx;
  }

  public String getYs() {
    return ys;
  }

  public void setYs(String ys) {
    this.ys = ys;
  }

  public String getBkxz() {
    return bkxz;
  }

  public void setBkxz(String bkxz) {
    this.bkxz = bkxz;
  }

  public String getBkkd() {
    return bkkd;
  }

  public void setBkkd(String bkkd) {
    this.bkkd = bkkd;
  }

  public BigDecimal getNkgd() {
    return nkgd;
  }

  public void setNkgd(BigDecimal nkgd) {
    this.nkgd = nkgd;
  }

  public BigDecimal getNkkd() {
    return nkkd;
  }

  public void setNkkd(BigDecimal nkkd) {
    this.nkkd = nkkd;
  }

  public Integer getMssl() {
    return mssl;
  }

  public void setMssl(Integer mssl) {
    this.mssl = mssl;
  }

  public BigDecimal getSf() {
    return sf;
  }

  public void setSf(BigDecimal sf) {
    this.sf = sf;
  }

  public BigDecimal getSxf() {
    return sxf;
  }

  public void setSxf(BigDecimal sxf) {
    this.sxf = sxf;
  }

  public BigDecimal getXbgd() {
    return xbgd;
  }

  public void setXbgd(BigDecimal xbgd) {
    this.xbgd = xbgd;
  }

  public BigDecimal getXbkd() {
    return xbkd;
  }

  public void setXbkd(BigDecimal xbkd) {
    this.xbkd = xbkd;
  }

  public BigDecimal getMsgd() {
    return msgd;
  }

  public void setMsgd(BigDecimal msgd) {
    this.msgd = msgd;
  }

  public BigDecimal getMskd() {
    return mskd;
  }

  public void setMskd(BigDecimal mskd) {
    this.mskd = mskd;
  }

  public BigDecimal getPf() {
    return pf;
  }

  public void setPf(BigDecimal pf) {
    this.pf = pf;
  }

  public BigDecimal getDj() {
    return dj;
  }

  public void setDj(BigDecimal dj) {
    this.dj = dj;
  }

  public Integer getTs() {
    return ts;
  }

  public void setTs(Integer ts) {
    this.ts = ts;
  }

  public BigDecimal getJe() {
    return je;
  }

  public void setJe(BigDecimal je) {
    this.je = je;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  @Override
  public String toString() {
    return "WardrobeSlideSize{" +
            "id='" + id + '\'' +
            ", cz='" + cz + '\'' +
            ", zx='" + zx + '\'' +
            ", ys='" + ys + '\'' +
            ", bkxz='" + bkxz + '\'' +
            ", bkkd='" + bkkd + '\'' +
            ", nkgd=" + nkgd +
            ", nkkd=" + nkkd +
            ", mssl=" + mssl +
            ", sf=" + sf +
            ", sxf=" + sxf +
            ", xbgd=" + xbgd +
            ", xbkd=" + xbkd +
            ", xbpf=" + xbpf +
            ", msgd=" + msgd +
            ", mskd=" + mskd +
            ", pf=" + pf +
            ", dj=" + dj +
            ", ts=" + ts +
            ", je=" + je +
            ", bz='" + bz + '\'' +
            '}';
  }
}
