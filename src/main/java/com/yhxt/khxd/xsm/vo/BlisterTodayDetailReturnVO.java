package com.yhxt.khxd.xsm.vo;

import com.yhxt.khxd.xsm.dto.BlisterHistoryRecordDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName BlisterTodayDetailReturnVO
 * @Author zqi
 * @Date 2019/7/12 14:34
 * @Version 1.0
 * @Description 今日已下单-详细信息列表
 */
public class BlisterTodayDetailReturnVO {
  /**
   * 有效订单数量
   */
  private Integer totalNum;

  /**
   * 门板总平方
   */
  private BigDecimal totalDoorSquare;

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
   * 返工-门板数量
   */
  private Integer totalReworkDoorNum;

  /**
   * 数据记录
   */
  private List<BlisterHistoryRecordDTO> list;

  public BlisterTodayDetailReturnVO() {
  }

  public BlisterTodayDetailReturnVO(Integer totalNum, BigDecimal totalDoorSquare, Integer totalDoorNum, Integer totalReworkNum, BigDecimal totalReworkDoorSquare, Integer totalReworkDoorNum, List<BlisterHistoryRecordDTO> list) {
    this.totalNum = totalNum;
    this.totalDoorSquare = totalDoorSquare;
    this.totalDoorNum = totalDoorNum;
    this.totalReworkNum = totalReworkNum;
    this.totalReworkDoorSquare = totalReworkDoorSquare;
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

  public Integer getTotalReworkDoorNum() {
    return totalReworkDoorNum;
  }

  public void setTotalReworkDoorNum(Integer totalReworkDoorNum) {
    this.totalReworkDoorNum = totalReworkDoorNum;
  }

  public List<BlisterHistoryRecordDTO> getList() {
    return list;
  }

  public void setList(List<BlisterHistoryRecordDTO> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "BlisterTodayDetailReturnVO{" +
            "totalNum=" + totalNum +
            ", totalDoorSquare=" + totalDoorSquare +
            ", totalDoorNum=" + totalDoorNum +
            ", totalReworkNum=" + totalReworkNum +
            ", totalReworkDoorSquare=" + totalReworkDoorSquare +
            ", totalReworkDoorNum=" + totalReworkDoorNum +
            ", list=" + list +
            '}';
  }
}
