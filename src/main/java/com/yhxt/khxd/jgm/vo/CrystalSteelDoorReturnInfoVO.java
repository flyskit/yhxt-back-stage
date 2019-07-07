package com.yhxt.khxd.jgm.vo;

import com.yhxt.khxd.jgm.dto.HistoryRecordDTO;

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
   * 总数量
   */
  private Integer totalNum;

  /**
   * 门板总平方
   */
  private BigDecimal totalDoorSquare;

  /**
   * 玻璃总平方
   */
  private BigDecimal totalGlassSquare;

  /**
   * 门板总数量
   */
  private Integer totalDoorNum;

  /**
   * 返工-订单数量
   */
  private Integer totalReworkNum;
  /**
   * 返工-门板平方
   */
  private BigDecimal totalReworkDoorSquare;

  /**
   * 返工-玻璃平方
   */
  private BigDecimal totalReworkGlassSquare;

  /**
   * 返工-门板数量
   */
  private Integer totalReworkDoorNum;

  /**
   * 数据记录
   */
  private List<HistoryRecordDTO> list;

  public CrystalSteelDoorReturnInfoVO() {
  }

  public CrystalSteelDoorReturnInfoVO(Integer totalNum, BigDecimal totalDoorSquare, BigDecimal totalGlassSquare, Integer totalDoorNum, Integer totalReworkNum, BigDecimal totalReworkDoorSquare, BigDecimal totalReworkGlassSquare, Integer totalReworkDoorNum, List<HistoryRecordDTO> list) {
    this.totalNum = totalNum;
    this.totalDoorSquare = totalDoorSquare;
    this.totalGlassSquare = totalGlassSquare;
    this.totalDoorNum = totalDoorNum;
    this.totalReworkNum = totalReworkNum;
    this.totalReworkDoorSquare = totalReworkDoorSquare;
    this.totalReworkGlassSquare = totalReworkGlassSquare;
    this.totalReworkDoorNum = totalReworkDoorNum;
    this.list = list;
  }

  public Integer getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(Integer totalNum) {
    this.totalNum = totalNum;
  }

  public BigDecimal getTotalDoorSquare() {
    return totalDoorSquare;
  }

  public void setTotalDoorSquare(BigDecimal totalDoorSquare) {
    this.totalDoorSquare = totalDoorSquare;
  }

  public BigDecimal getTotalGlassSquare() {
    return totalGlassSquare;
  }

  public void setTotalGlassSquare(BigDecimal totalGlassSquare) {
    this.totalGlassSquare = totalGlassSquare;
  }

  public Integer getTotalDoorNum() {
    return totalDoorNum;
  }

  public void setTotalDoorNum(Integer totalDoorNum) {
    this.totalDoorNum = totalDoorNum;
  }

  public Integer getTotalReworkNum() {
    return totalReworkNum;
  }

  public void setTotalReworkNum(Integer totalRewordNum) {
    this.totalReworkNum = totalRewordNum;
  }

  public BigDecimal getTotalReworkDoorSquare() {
    return totalReworkDoorSquare;
  }

  public void setTotalReworkDoorSquare(BigDecimal totalReworkDoorSquare) {
    this.totalReworkDoorSquare = totalReworkDoorSquare;
  }

  public BigDecimal getTotalReworkGlassSquare() {
    return totalReworkGlassSquare;
  }

  public void setTotalReworkGlassSquare(BigDecimal totalReworkGlassSquare) {
    this.totalReworkGlassSquare = totalReworkGlassSquare;
  }

  public Integer getTotalReworkDoorNum() {
    return totalReworkDoorNum;
  }

  public void setTotalReworkDoorNum(Integer totalReworkDoorNum) {
    this.totalReworkDoorNum = totalReworkDoorNum;
  }

  public List<HistoryRecordDTO> getList() {
    return list;
  }

  public void setList(List<HistoryRecordDTO> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "CrystalSteelDoorReturnInfoVO{" +
            "totalNum=" + totalNum +
            ", totalDoorSquare=" + totalDoorSquare +
            ", totalGlassSquare=" + totalGlassSquare +
            ", totalDoorNum=" + totalDoorNum +
            ", totalRewordNum=" + totalReworkNum +
            ", totalReworkDoorSquare=" + totalReworkDoorSquare +
            ", totalReworkGlassSquare=" + totalReworkGlassSquare +
            ", totalReworkDoorNum=" + totalReworkDoorNum +
            ", list=" + list +
            '}';
  }
}
