package com.yhxt.khxd.tzm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName SuitDetailType
 * @Author zqi
 * @Date 2019/7/17 10:03
 * @Version 1.0
 * @Description 套装门-基本统计信息表、尺寸类型关联
 */
@Entity
@Table(name = "suit_detail_type")
public class SuitDetailType implements Serializable {
  private static final long serialVersionUID = 1992152834289611672L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 门板ID
   */
  @Column(name = "mbid")
  private String mbid;

  /**
   * 尺寸类型
   */
  @Column(name = "cclx")
  private Integer cclx;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  public SuitDetailType() {
  }

  public SuitDetailType(Integer cclx, Boolean zt) {
    this.cclx = cclx;
    this.zt = zt;
  }

  public SuitDetailType(String mbid, Integer cclx, Boolean zt) {
    this.mbid = mbid;
    this.cclx = cclx;
    this.zt = zt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMbid() {
    return mbid;
  }

  public void setMbid(String mbid) {
    this.mbid = mbid;
  }

  public Integer getCclx() {
    return cclx;
  }

  public void setCclx(Integer cclx) {
    this.cclx = cclx;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }

  @Override
  public String toString() {
    return "SuitDetailType{" +
            "id='" + id + '\'' +
            ", mbid='" + mbid + '\'' +
            ", cclx=" + cclx +
            ", zt=" + zt +
            '}';
  }
}
