package com.yhxt.sjgl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName CityDetail
 * @Author zqi
 * @Date 2019/6/20 17:25
 * @Version 1.0
 * @Description 城市信息表
 */
@Entity
@Table(name = "city_detail")
public class CityDetail implements Serializable {
  private static final long serialVersionUID = -661006784693989352L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 上级id
   */
  @Column(name = "sjid")
  private String sjid;

  /**
   * 名称
   */
  @Column(name = "mc")
  private String mc;

  /**
   * 路径
   */
  @Column(name = "lj")
  private String lj;

  /**
   * 级别
   */
  @Column(name = "jb")
  private Integer jb;

  /**
   * 首字母
   */
  @Column(name = "szm")
  private Character szm;

  public CityDetail() {
  }

  public CityDetail(String sjid, String mc, String lj, Integer jb, Character szm) {
    this.sjid = sjid;
    this.mc = mc;
    this.lj = lj;
    this.jb = jb;
    this.szm = szm;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSjid() {
    return sjid;
  }

  public void setSjid(String sjid) {
    this.sjid = sjid;
  }

  public String getMc() {
    return mc;
  }

  public void setMc(String mc) {
    this.mc = mc;
  }

  public String getLj() {
    return lj;
  }

  public void setLj(String lj) {
    this.lj = lj;
  }

  public Integer getJb() {
    return jb;
  }

  public void setJb(Integer jb) {
    this.jb = jb;
  }

  public Character getSzm() {
    return szm;
  }

  public void setSzm(Character szm) {
    this.szm = szm;
  }

  @Override
  public String toString() {
    return "CityDetail{" +
            "id='" + id + '\'' +
            ", sjid='" + sjid + '\'' +
            ", mc='" + mc + '\'' +
            ", lj='" + lj + '\'' +
            ", jb=" + jb +
            ", szm=" + szm +
            '}';
  }
}
