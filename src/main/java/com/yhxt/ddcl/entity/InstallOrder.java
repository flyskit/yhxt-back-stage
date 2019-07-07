package com.yhxt.ddcl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName InstallOrder
 * @Author zqi
 * @Date 2019/6/20 15:11
 * @Version 1.0
 * @Description 订单-安装记录表
 */
@Entity
@Table(name = "install_order")
public class InstallOrder implements Serializable {
  private static final long serialVersionUID = -7523553917027153609L;

  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 安装id
   */
  @Column(name = "azid")
  private String azid;

  /**
   * 订单id
   */
  @Column(name = "ddid")
  private String ddid;

  /**
   * 状态
   */
  @Column(name = "zt")
  private Boolean zt;

  /**
   * 默认构造器
   */
  public InstallOrder() {
  }

  public InstallOrder(String azid, String ddid, Boolean zt) {
    this.azid = azid;
    this.ddid = ddid;
    this.zt = zt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAzid() {
    return azid;
  }

  public void setAzid(String azid) {
    this.azid = azid;
  }

  public String getDdid() {
    return ddid;
  }

  public void setDdid(String ddid) {
    this.ddid = ddid;
  }

  public Boolean getZt() {
    return zt;
  }

  public void setZt(Boolean zt) {
    this.zt = zt;
  }

  @Override
  public String toString() {
    return "InstallOrder{" +
            "id='" + id + '\'' +
            ", azid='" + azid + '\'' +
            ", ddid='" + ddid + '\'' +
            ", zt=" + zt +
            '}';
  }
}
