package com.yhxt.java.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName MRSZSR
 * @Author zqi
 * @Date 2018/12/16 12:02
 * @Version 1.0
 * @Description 每日收支-收入
 */
@Table(name = "mrsz_sr")
@Entity
public class MRSZSR implements Serializable {

  private static final long serialVersionUID = -2586620194681132092L;
  /**
   * id标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;
  /**
   * 创建编号
   */
  @Column(name = "bh")
  private String bh;
  /**
   * 录入日期
   */
  @Column(name = "lrrq")
  private Date lrrq;
  /**
   * 收入类型
   */
  @Column(name = "srlx")
  private Integer srlx;
  /**
   * 收账日期
   */
  @Column(name = "szrq")
  private Date szrq;
  /**
   * 收入金额
   */
  @Column(name = "srje")
  private BigDecimal srje;
  /**
   * 客户姓名
   */
  @Column(name = "khxm")
  private String khxm;
  /**
   * 收入备注
   */
  @Column(name = "bz")
  private String bz;

  /**
   * 定义默认构造器
   */
  private MRSZSR() {
  }

  /**
   * 重载构造器
   *
   * @param id   id标识
   * @param bh   创建编号
   * @param lrrq 录入日期
   * @param srlx 收入类型
   * @param szrq 收账日期
   * @param srje 收入金额
   * @param khxm 客户姓名
   * @param bz   收入备注
   */
  public MRSZSR(String id, String bh, Date lrrq, Integer srlx, Date szrq, BigDecimal srje, String khxm, String bz) {
    this.id = id;
    this.bh = bh;
    this.lrrq = lrrq;
    this.srlx = srlx;
    this.szrq = szrq;
    this.srje = srje;
    this.khxm = khxm;
    this.bz = bz;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBh() {
    return bh;
  }

  public void setBh(String bh) {
    this.bh = bh;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getLrrq() {
    return lrrq;
  }

  public void setLrrq(Date lrrq) {
    this.lrrq = lrrq;
  }

  public Integer getSrlx() {
    return srlx;
  }

  public void setSrlx(Integer srlx) {
    this.srlx = srlx;
  }

  public Date getSzrq() {
    return szrq;
  }

  public void setSzrq(Date szrq) {
    this.szrq = szrq;
  }

  public BigDecimal getSrje() {
    return srje;
  }

  public void setSrje(BigDecimal srje) {
    this.srje = srje;
  }

  public String getKhxm() {
    return khxm;
  }

  public void setKhxm(String khxm) {
    this.khxm = khxm;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  @Override
  public String toString() {
    return "MRSZSR{" +
            "id='" + id + '\'' +
            ", bh='" + bh + '\'' +
            ", lrrq=" + lrrq +
            ", srlx=" + srlx +
            ", szrq=" + szrq +
            ", srje=" + srje +
            ", khxm='" + khxm + '\'' +
            ", bz='" + bz + '\'' +
            '}';
  }
}
