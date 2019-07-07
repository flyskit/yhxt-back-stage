package com.yhxt.khxd.yklm.vo;

import com.yhxt.khxd.yklm.dto.AcrylicHistoryRecordDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName AcrylicTodayDetailReturnVO
 * @Author zqi
 * @Date 2019/7/3 16:52
 * @Version 1.0
 * @Description
 */
public class AcrylicTodayDetailReturnVO {
  /**
   * 有效订单数量
   */
  private Integer totalNum;

  /**
   * 门板总平方
   */
  private BigDecimal totalDoorSquare;

  /**
   * 板材总平方
   */
  private BigDecimal totalBoardSquare;

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
   * 返工-板材平方
   */
  private BigDecimal totalReworkBoardSquare;

  /**
   * 返工-门板数量
   */
  private Integer totalReworkDoorNum;

  /**
   * 数据记录
   */
  private List<AcrylicHistoryRecordDTO> list;

  public AcrylicTodayDetailReturnVO() {
  }

  public AcrylicTodayDetailReturnVO(Integer totalNum, BigDecimal totalDoorSquare, BigDecimal totalBoardSquare, Integer totalDoorNum, Integer totalReworkNum, BigDecimal totalReworkDoorSquare, BigDecimal totalReworkBoardSquare, Integer totalReworkDoorNum, List<AcrylicHistoryRecordDTO> list) {
    this.totalNum = totalNum;
    this.totalDoorSquare = totalDoorSquare;
    this.totalBoardSquare = totalBoardSquare;
    this.totalDoorNum = totalDoorNum;
    this.totalReworkNum = totalReworkNum;
    this.totalReworkDoorSquare = totalReworkDoorSquare;
    this.totalReworkBoardSquare = totalReworkBoardSquare;
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

  public BigDecimal getTotalBoardSquare() {
    return totalBoardSquare;
  }

  public void setTotalBoardSquare(BigDecimal totalBoardSquare) {
    this.totalBoardSquare = totalBoardSquare;
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

  public void setTotalReworkNum(Integer totalReworkNum) {
    this.totalReworkNum = totalReworkNum;
  }

  public BigDecimal getTotalReworkDoorSquare() {
    return totalReworkDoorSquare;
  }

  public void setTotalReworkDoorSquare(BigDecimal totalReworkDoorSquare) {
    this.totalReworkDoorSquare = totalReworkDoorSquare;
  }

  public BigDecimal getTotalReworkBoardSquare() {
    return totalReworkBoardSquare;
  }

  public void setTotalReworkBoardSquare(BigDecimal totalReworkBoardSquare) {
    this.totalReworkBoardSquare = totalReworkBoardSquare;
  }

  public Integer getTotalReworkDoorNum() {
    return totalReworkDoorNum;
  }

  public void setTotalReworkDoorNum(Integer totalReworkDoorNum) {
    this.totalReworkDoorNum = totalReworkDoorNum;
  }

  public List<AcrylicHistoryRecordDTO> getList() {
    return list;
  }

  public void setList(List<AcrylicHistoryRecordDTO> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "AcrylicTodayDetailReturnVO{" +
            "totalNum=" + totalNum +
            ", totalDoorSquare=" + totalDoorSquare +
            ", totalBoardSquare=" + totalBoardSquare +
            ", totalDoorNum=" + totalDoorNum +
            ", totalReworkNum=" + totalReworkNum +
            ", totalReworkDoorSquare=" + totalReworkDoorSquare +
            ", totalReworkBoardSquare=" + totalReworkBoardSquare +
            ", totalReworkDoorNum=" + totalReworkDoorNum +
            ", list=" + list +
            '}';
  }
}
