package com.yhxt.khxd.jgm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName XDXXAJCTJ
 * @Author zqi
 * @Date 2019/4/3 18:26
 * @Version 1.0
 * @Description 下单信息-进程统计
 */
@Entity
@Table(name = "jgm_xdxx_jctj")
public class XDXXAJCTJ implements Serializable {
  private static final long serialVersionUID = -1706192464732211833L;

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
   * 进程统计ID
   */
  @Column(name = "jctj_id")
  private String jctjId;

  /**
   * 声明默认构造器
   */
  public XDXXAJCTJ() {
  }

  /**
   * 构造器重载
   *
   * @param xdxxId 下单信息ID
   * @param jctjId 进程统计ID
   */
  public XDXXAJCTJ(String xdxxId, String jctjId) {
    this.xdxxId = xdxxId;
    this.jctjId = jctjId;
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

  public String getJctjId() {
    return jctjId;
  }

  public void setJctjId(String jctjId) {
    this.jctjId = jctjId;
  }

  @Override
  public String toString() {
    return "XDXXAJCTJ{" +
            "id='" + id + '\'' +
            ", xdxxId='" + xdxxId + '\'' +
            ", jctjId='" + jctjId + '\'' +
            '}';
  }
}
