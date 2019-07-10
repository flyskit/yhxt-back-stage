package com.yhxt.khxd.thjm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName TitaniumAlloyDoorSize
 * @Author zqi
 * @Date 2019/7/9 12:24
 * @Version 1.0
 * @Description
 */
@Entity
@Table(name = "titanium_alloy_door_detail_size")
public class TitaniumAlloyDoorDetailSize implements Serializable {
  private static final long serialVersionUID = 1682145002050204600L;
  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 统计ID-关联基本信息表
   */
  @Column(name = "tjid")
  private String tjid;

  /**
   * 尺寸ID-关联尺寸信息表
   */
  @Column(name = "ccid")
  private String ccid;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  public TitaniumAlloyDoorDetailSize() {
  }

  public TitaniumAlloyDoorDetailSize(String tjid, String ccid, Boolean zt) {
    this.tjid = tjid;
    this.ccid = ccid;
    this.zt = zt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTjid() {
    return tjid;
  }

  public void setTjid(String tjid) {
    this.tjid = tjid;
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
    return "TitaniumAlloyDoorDetailSize{" +
            "id='" + id + '\'' +
            ", tjid='" + tjid + '\'' +
            ", ccid='" + ccid + '\'' +
            ", zt=" + zt +
            '}';
  }
}
