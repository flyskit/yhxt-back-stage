package com.yhxt.khxd.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName JGM_CCXX_XDXX
 * @Author zqi
 * @Date 2019/1/18 15:59
 * @Version 1.0
 * @Description
 */
@Table(name = "jgm_xdxx_ccxx")
@Entity
public class XDXXACCXX implements Serializable {
  private static final long serialVersionUID = -3246160136496835411L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 下单信息ID
   */
  @Column(name = "xdxx_id")
  private String xdxxId;

  /**
   * 尺寸信息ID
   */
  @Column(name = "ccxx_id")
  private String ccxxId;

  /**
   * 默认构造器
   */
  public XDXXACCXX() {

  }

  /**
   * 构造器重载
   *
   * @param xdxxId 下单信息ID
   * @param ccxxId 尺寸信息ID
   */
  public XDXXACCXX(String xdxxId, String ccxxId) {
    this.xdxxId = xdxxId;
    this.ccxxId = ccxxId;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getXdxxId() {
    return xdxxId;
  }

  public void setXdxxId(String xdxxId) {
    this.xdxxId = xdxxId;
  }

  public String getCcxxId() {
    return ccxxId;
  }

  public void setCcxxId(String ccxxId) {
    this.ccxxId = ccxxId;
  }

  @Override
  public String toString() {
    return "XDXXACCXX{" +
            "id='" + id + '\'' +
            ", xdxxId='" + xdxxId + '\'' +
            ", ccxxId='" + ccxxId + '\'' +
            '}';
  }
}
