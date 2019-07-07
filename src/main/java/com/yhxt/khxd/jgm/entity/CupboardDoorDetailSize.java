package com.yhxt.khxd.jgm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName CrystalSteelDoorDetailSize
 * @Author zqi
 * @Date 2019/6/20 16:24
 * @Version 1.0
 * @Description 橱柜门基本信息-尺寸关联
 */
@Entity
@Table(name = "cupboard_door_detail_size")
public class CupboardDoorDetailSize implements Serializable {
  private static final long serialVersionUID = -1954420951291044748L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 门板id
   */
  @Column(name = "mbid")
  private String mbid;

  /**
   * 尺寸id
   */
  @Column(name = "ccid")
  private String ccid;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  public CupboardDoorDetailSize() {
  }

  public CupboardDoorDetailSize(String mbid, String ccid, Boolean zt) {
    this.mbid = mbid;
    this.ccid = ccid;
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

  public String getCcid() {
    return ccid;
  }

  public void setCcid(String ccid) {
    this.ccid = ccid;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }

  @Override
  public String toString() {
    return "CupboardDoorDetailSize{" +
            "id='" + id + '\'' +
            ", mbid='" + mbid + '\'' +
            ", ccid='" + ccid + '\'' +
            ", zt=" + zt +
            '}';
  }
}
