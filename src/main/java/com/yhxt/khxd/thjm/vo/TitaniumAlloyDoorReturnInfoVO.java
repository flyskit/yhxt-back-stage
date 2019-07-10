package com.yhxt.khxd.thjm.vo;

import com.yhxt.khxd.thjm.dto.TitaniumAlloyHistoryRecordDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName TitaniumAlloyDoorReturnInfoVO
 * @Author zqi
 * @Date 2019/7/9 14:17
 * @Version 1.0
 * @Description 今日已下单-返回统计信息
 */
public class TitaniumAlloyDoorReturnInfoVO {

  /**
   * 平开门订单数
   */
  private Integer totalSwingNum;

  /**
   * 平开门平方
   */
  private BigDecimal totalSwingSquare;

  /**
   * 平开门数量
   */
  private Integer totalSwingDoorNum;

  /**
   * 吊趟门订单数
   */
  private Integer totalHangingNum;

  /**
   * 吊趟门平方
   */
  private BigDecimal totalHangingSquare;

  /**
   * 吊趟门数量
   */
  private Integer totalHangingDoorNum;

  /**
   * 返工-平开门订单数
   */
  private Integer totalReworkSwingNum;

  /**
   * 返工-平开门平方
   */
  private BigDecimal totalReworkSwingSquare;

  /**
   * 返工-平开门数量
   */
  private Integer totalReworkSwingDoorNum;

  /**
   * 返工-吊趟门订单数
   */
  private Integer totalReworkHangingNum;

  /**
   * 返工-吊趟门平方
   */
  private BigDecimal totalReworkHangingSquare;

  /**
   * 返工-吊趟门数量
   */
  private Integer totalReworkHangingDoorNum;

  /**
   * 数据记录
   */
  private List<TitaniumAlloyHistoryRecordDTO> list;

  public TitaniumAlloyDoorReturnInfoVO() {
  }

  public TitaniumAlloyDoorReturnInfoVO(Integer totalSwingNum, BigDecimal totalSwingSquare, Integer totalSwingDoorNum, Integer totalHangingNum, BigDecimal totalHangingSquare, Integer totalHangingDoorNum, Integer totalReworkSwingNum, BigDecimal totalReworkSwingSquare, Integer totalReworkSwingDoorNum, Integer totalReworkHangingNum, BigDecimal totalReworkHangingSquare, Integer totalReworkHangingDoorNum, List<TitaniumAlloyHistoryRecordDTO> list) {
    this.totalSwingNum = totalSwingNum;
    this.totalSwingSquare = totalSwingSquare;
    this.totalSwingDoorNum = totalSwingDoorNum;
    this.totalHangingNum = totalHangingNum;
    this.totalHangingSquare = totalHangingSquare;
    this.totalHangingDoorNum = totalHangingDoorNum;
    this.totalReworkSwingNum = totalReworkSwingNum;
    this.totalReworkSwingSquare = totalReworkSwingSquare;
    this.totalReworkSwingDoorNum = totalReworkSwingDoorNum;
    this.totalReworkHangingNum = totalReworkHangingNum;
    this.totalReworkHangingSquare = totalReworkHangingSquare;
    this.totalReworkHangingDoorNum = totalReworkHangingDoorNum;
    this.list = list;
  }

  public Integer getTotalSwingNum() {
    return totalSwingNum;
  }

  public void setTotalSwingNum(Integer totalSwingNum) {
    this.totalSwingNum = totalSwingNum;
  }

  public BigDecimal getTotalSwingSquare() {
    return totalSwingSquare;
  }

  public void setTotalSwingSquare(BigDecimal totalSwingSquare) {
    this.totalSwingSquare = totalSwingSquare;
  }

  public Integer getTotalSwingDoorNum() {
    return totalSwingDoorNum;
  }

  public void setTotalSwingDoorNum(Integer totalSwingDoorNum) {
    this.totalSwingDoorNum = totalSwingDoorNum;
  }

  public Integer getTotalHangingNum() {
    return totalHangingNum;
  }

  public void setTotalHangingNum(Integer totalHangingNum) {
    this.totalHangingNum = totalHangingNum;
  }

  public BigDecimal getTotalHangingSquare() {
    return totalHangingSquare;
  }

  public void setTotalHangingSquare(BigDecimal totalHangingSquare) {
    this.totalHangingSquare = totalHangingSquare;
  }

  public Integer getTotalHangingDoorNum() {
    return totalHangingDoorNum;
  }

  public void setTotalHangingDoorNum(Integer totalHangingDoorNum) {
    this.totalHangingDoorNum = totalHangingDoorNum;
  }

  public Integer getTotalReworkSwingNum() {
    return totalReworkSwingNum;
  }

  public void setTotalReworkSwingNum(Integer totalReworkSwingNum) {
    this.totalReworkSwingNum = totalReworkSwingNum;
  }

  public BigDecimal getTotalReworkSwingSquare() {
    return totalReworkSwingSquare;
  }

  public void setTotalReworkSwingSquare(BigDecimal totalReworkSwingSquare) {
    this.totalReworkSwingSquare = totalReworkSwingSquare;
  }

  public Integer getTotalReworkSwingDoorNum() {
    return totalReworkSwingDoorNum;
  }

  public void setTotalReworkSwingDoorNum(Integer totalReworkSwingDoorNum) {
    this.totalReworkSwingDoorNum = totalReworkSwingDoorNum;
  }

  public Integer getTotalReworkHangingNum() {
    return totalReworkHangingNum;
  }

  public void setTotalReworkHangingNum(Integer totalReworkHangingNum) {
    this.totalReworkHangingNum = totalReworkHangingNum;
  }

  public BigDecimal getTotalReworkHangingSquare() {
    return totalReworkHangingSquare;
  }

  public void setTotalReworkHangingSquare(BigDecimal totalReworkHangingSquare) {
    this.totalReworkHangingSquare = totalReworkHangingSquare;
  }

  public Integer getTotalReworkHangingDoorNum() {
    return totalReworkHangingDoorNum;
  }

  public void setTotalReworkHangingDoorNum(Integer totalReworkHangingDoorNum) {
    this.totalReworkHangingDoorNum = totalReworkHangingDoorNum;
  }

  public List<TitaniumAlloyHistoryRecordDTO> getList() {
    return list;
  }

  public void setList(List<TitaniumAlloyHistoryRecordDTO> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "TitaniumAlloyDoorReturnInfoVO{" +
            "totalSwingNum=" + totalSwingNum +
            ", totalSwingSquare=" + totalSwingSquare +
            ", totalSwingDoorNum=" + totalSwingDoorNum +
            ", totalHangingNum=" + totalHangingNum +
            ", totalHangingSquare=" + totalHangingSquare +
            ", totalHangingDoorNum=" + totalHangingDoorNum +
            ", totalReworkSwingNum=" + totalReworkSwingNum +
            ", totalReworkSwingSquare=" + totalReworkSwingSquare +
            ", totalReworkSwingDoorNum=" + totalReworkSwingDoorNum +
            ", totalReworkHangingNum=" + totalReworkHangingNum +
            ", totalReworkHangingSquare=" + totalReworkHangingSquare +
            ", totalReworkHangingDoorNum=" + totalReworkHangingDoorNum +
            ", list=" + list +
            '}';
  }
}
