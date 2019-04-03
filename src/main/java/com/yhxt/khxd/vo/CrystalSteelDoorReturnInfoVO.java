package com.yhxt.khxd.vo;

import com.yhxt.khxd.entity.JGMXDXX;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName CrystalSteelDoorReturnInfoVO
 * @Author zqi
 * @Date 2019/4/2 11:39
 * @Version 1.0
 * @Description
 */
public class CrystalSteelDoorReturnInfoVO {
  /**
   * 数据记录
   */
  private List<JGMXDXX> list;

  /**
   * 铝合金总平方
   */
  private BigDecimal totalLhjpf;

  /**
   * 玻璃总平方
   */
  private BigDecimal totalBlpf;

  /**
   * 总片数
   */
  private Integer totalPs;

  /**
   * 总数量
   */
  private Integer totalNum;

  /**
   * 声明默认构造器
   */
  public CrystalSteelDoorReturnInfoVO() {
  }

  /**
   * 重载构造器
   *
   * @param list       数据记录
   * @param totalLhjpf 铝合金总平方
   * @param totalBlpf  玻璃总平方
   * @param totalPs    总片数
   * @param totalNum   总数量
   */
  public CrystalSteelDoorReturnInfoVO(List<JGMXDXX> list, BigDecimal totalLhjpf, BigDecimal totalBlpf, Integer totalPs, Integer totalNum) {
    this.list = list;
    this.totalLhjpf = totalLhjpf;
    this.totalBlpf = totalBlpf;
    this.totalPs = totalPs;
    this.totalNum = totalNum;
  }

  public List<JGMXDXX> getList() {
    return list;
  }

  public void setList(List<JGMXDXX> list) {
    this.list = list;
  }

  public BigDecimal getTotalLhjpf() {
    return totalLhjpf;
  }

  public void setTotalLhjpf(BigDecimal totalLhjpf) {
    this.totalLhjpf = totalLhjpf;
  }

  public BigDecimal getTotalBlpf() {
    return totalBlpf;
  }

  public void setTotalBlpf(BigDecimal totalBlpf) {
    this.totalBlpf = totalBlpf;
  }

  public Integer getTotalPs() {
    return totalPs;
  }

  public void setTotalPs(Integer totalPs) {
    this.totalPs = totalPs;
  }

  public Integer getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(Integer totalNum) {
    this.totalNum = totalNum;
  }

  @Override
  public String toString() {
    return "CrystalSteelDoorReturnInfoVO{" +
            "list=" + list +
            ", totalLhjpf=" + totalLhjpf +
            ", totalBlpf=" + totalBlpf +
            ", totalPs=" + totalPs +
            ", totalNum=" + totalNum +
            '}';
  }
}
