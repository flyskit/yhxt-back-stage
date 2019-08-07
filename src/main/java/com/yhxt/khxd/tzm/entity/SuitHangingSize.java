package com.yhxt.khxd.tzm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName SuitHangingSize
 * @Author zqi
 * @Date 2019/7/17 10:16
 * @Version 1.0
 * @Description 套装门-推门尺寸
 */
@Entity
@Table(name = "suit_hanging_size")
public class SuitHangingSize implements Serializable {
  private static final long serialVersionUID = -6274689865531995758L;

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
   * 面板
   */
  @Column(name = "mb")
  private String mb;

  /**
   * 油漆
   */
  @Column(name = "yq")
  private String yq;

  /**
   * 墙体
   */
  @Column(name = "qt")
  private String qt;

  /**
   * 推门类型
   */
  @Column(name = "tmlx")
  private String tmlx;

  /**
   * 推门位置
   */
  @Column(name = "tmwz")
  private String tmwz;

  /**
   * 玻璃
   */
  @Column(name = "bl")
  private String bl;

  /**
   * 门洞高度
   */
  @Column(name = "mdgd")
  private BigDecimal mdgd;

  /**
   * 门洞宽度
   */
  @Column(name = "mdkd")
  private BigDecimal mdkd;

  /**
   * 门洞厚度
   */
  @Column(name = "mdhd")
  private BigDecimal mdhd;

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
   * 门扇数量
   */
  @Column(name = "mssl")
  private Integer mssl;

  /**
   * 门套数量
   */
  @Column(name = "mtsl")
  private Integer mtsl;

  /**
   * 套数
   */
  @Column(name = "ts")
  private Integer ts;

  /**
   * 单价
   */
  @Column(name = "dj")
  private BigDecimal dj;

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

  public SuitHangingSize() {
  }

  public SuitHangingSize(String cz, String zx, String ys, String mb, String yq, String qt, String tmlx, String tmwz, String bl, BigDecimal mdgd, BigDecimal mdkd, BigDecimal mdhd, BigDecimal msgd, BigDecimal mskd, Integer mssl, Integer mtsl, Integer ts, BigDecimal dj, BigDecimal je, String bz) {
    this.cz = cz;
    this.zx = zx;
    this.ys = ys;
    this.mb = mb;
    this.yq = yq;
    this.qt = qt;
    this.tmlx = tmlx;
    this.tmwz = tmwz;
    this.bl = bl;
    this.mdgd = mdgd;
    this.mdkd = mdkd;
    this.mdhd = mdhd;
    this.msgd = msgd;
    this.mskd = mskd;
    this.mssl = mssl;
    this.mtsl = mtsl;
    this.ts = ts;
    this.dj = dj;
    this.je = je;
    this.bz = bz;
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

  public String getMb() {
    return mb;
  }

  public void setMb(String mb) {
    this.mb = mb;
  }

  public String getYq() {
    return yq;
  }

  public void setYq(String yq) {
    this.yq = yq;
  }

  public String getQt() {
    return qt;
  }

  public void setQt(String qt) {
    this.qt = qt;
  }

  public String getTmlx() {
    return tmlx;
  }

  public void setTmlx(String tmlx) {
    this.tmlx = tmlx;
  }

  public String getTmwz() {
    return tmwz;
  }

  public void setTmwz(String tmwz) {
    this.tmwz = tmwz;
  }

  public String getBl() {
    return bl;
  }

  public void setBl(String bl) {
    this.bl = bl;
  }

  public BigDecimal getMdgd() {
    return mdgd;
  }

  public void setMdgd(BigDecimal mdgd) {
    this.mdgd = mdgd;
  }

  public BigDecimal getMdkd() {
    return mdkd;
  }

  public void setMdkd(BigDecimal mdkd) {
    this.mdkd = mdkd;
  }

  public BigDecimal getMdhd() {
    return mdhd;
  }

  public void setMdhd(BigDecimal mdhd) {
    this.mdhd = mdhd;
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

  public Integer getMssl() {
    return mssl;
  }

  public void setMssl(Integer mssl) {
    this.mssl = mssl;
  }

  public Integer getMtsl() {
    return mtsl;
  }

  public void setMtsl(Integer mtsl) {
    this.mtsl = mtsl;
  }

  public Integer getTs() {
    return ts;
  }

  public void setTs(Integer ts) {
    this.ts = ts;
  }

  public BigDecimal getDj() {
    return dj;
  }

  public void setDj(BigDecimal dj) {
    this.dj = dj;
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
    return "SuitHangingSize{" +
            "id='" + id + '\'' +
            ", cz='" + cz + '\'' +
            ", zx='" + zx + '\'' +
            ", ys='" + ys + '\'' +
            ", mb='" + mb + '\'' +
            ", yq='" + yq + '\'' +
            ", qt='" + qt + '\'' +
            ", tmlx='" + tmlx + '\'' +
            ", tmwz='" + tmwz + '\'' +
            ", bl='" + bl + '\'' +
            ", mdgd=" + mdgd +
            ", mdkd=" + mdkd +
            ", mdhd=" + mdhd +
            ", msgd=" + msgd +
            ", mskd=" + mskd +
            ", mssl=" + mssl +
            ", mtsl=" + mtsl +
            ", ts=" + ts +
            ", dj=" + dj +
            ", je=" + je +
            ", bz='" + bz + '\'' +
            '}';
  }
}
