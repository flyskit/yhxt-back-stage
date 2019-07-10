package com.yhxt.khxd.thjm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName TitaniumAlloyDoorDetail
 * @Author zqi
 * @Date 2019/7/9 12:21
 * @Version 1.0
 * @Description 钛合金门-基本统计信息
 */
@Entity
@Table(name = "titanium_alloy_door_detail")
public class TitaniumAlloyDoorDetail implements Serializable {
  private static final long serialVersionUID = -5021212248302115760L;
  /**
   * ID标识
   */
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @Id
  private String id;

  /**
   * 合计金额
   */
  @Column(name = "hjje")
  private BigDecimal hjje;

  /**
   * 合计平方
   */
  @Column(name = "hjpf")
  private BigDecimal hjpf;

  /**
   * 合计数量
   */
  @Column(name = "hjsl")
  private Integer hjsl;

  /**
   * 预计打包
   */
  @Column(name = "yjdb")
  private Integer yjdb;

  /**
   * 默认构造器
   */
  public TitaniumAlloyDoorDetail() {
  }

  public TitaniumAlloyDoorDetail(BigDecimal hjje, BigDecimal hjpf, Integer hjsl, Integer yjdb) {
    this.hjje = hjje;
    this.hjpf = hjpf;
    this.hjsl = hjsl;
    this.yjdb = yjdb;
  }

  /**
   * 更新记录
   *
   * @param hjje 合计金额
   * @param hjpf 合计平方
   * @param hjsl 合计数量
   * @param yjdb 预计打包
   */
  public void updateDetail(BigDecimal hjje, BigDecimal hjpf, Integer hjsl, Integer yjdb) {
    this.setHjje(hjje);
    this.setHjpf(hjpf);
    this.setHjsl(hjsl);
    this.setYjdb(yjdb);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BigDecimal getHjje() {
    return hjje;
  }

  public void setHjje(BigDecimal hjje) {
    this.hjje = hjje;
  }

  public BigDecimal getHjpf() {
    return hjpf;
  }

  public void setHjpf(BigDecimal hjpf) {
    this.hjpf = hjpf;
  }

  public Integer getHjsl() {
    return hjsl;
  }

  public void setHjsl(Integer hjsl) {
    this.hjsl = hjsl;
  }

  public Integer getYjdb() {
    return yjdb;
  }

  public void setYjdb(Integer yjdb) {
    this.yjdb = yjdb;
  }

  @Override
  public String toString() {
    return "TitaniumAlloyDoorDetail{" +
            "id='" + id + '\'' +
            ", hjje=" + hjje +
            ", hjpf=" + hjpf +
            ", hjsl=" + hjsl +
            ", yjdb=" + yjdb +
            '}';
  }
}
