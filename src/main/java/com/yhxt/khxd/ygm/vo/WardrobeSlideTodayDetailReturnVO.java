package com.yhxt.khxd.ygm.vo;

import com.yhxt.khxd.ygm.dto.WardrobeSlideHistoryRecordDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName WardrobeSlideTodayDetailReturnVO
 * @Author zqi
 * @Date 2019/7/13 15:21
 * @Version 1.0
 * @Description 今日已下单-详细信息列表
 */
public class WardrobeSlideTodayDetailReturnVO {
  /**
   * 有效订单数量
   */
  private Integer totalNum;

  /**
   * 门板总平方
   */
  private BigDecimal totalDoorSquare;

  /**
   * 芯板总平方
   */
  private BigDecimal totalCoreBoardSquare;

  /**
   * 返工-订单数量
   */
  private Integer totalReworkNum;
  /**
   * 返工-门板平方
   */
  private BigDecimal totalReworkDoorSquare;

  /**
   * 返工-芯板平方
   */
  private BigDecimal totalReworkCoreBoardSquare;

  /**
   * 数据记录
   */
  private List<WardrobeSlideHistoryRecordDTO> list;

  public WardrobeSlideTodayDetailReturnVO() {
  }

  public WardrobeSlideTodayDetailReturnVO(Integer totalNum, BigDecimal totalDoorSquare, BigDecimal totalCoreBoardSquare, Integer totalReworkNum, BigDecimal totalReworkDoorSquare, BigDecimal totalReworkCoreBoardSquare, List<WardrobeSlideHistoryRecordDTO> list) {
    this.totalNum = totalNum;
    this.totalDoorSquare = totalDoorSquare;
    this.totalCoreBoardSquare = totalCoreBoardSquare;
    this.totalReworkNum = totalReworkNum;
    this.totalReworkDoorSquare = totalReworkDoorSquare;
    this.totalReworkCoreBoardSquare = totalReworkCoreBoardSquare;
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

  public BigDecimal getTotalCoreBoardSquare() {
    return totalCoreBoardSquare;
  }

  public void setTotalCoreBoardSquare(BigDecimal totalCoreBoardSquare) {
    this.totalCoreBoardSquare = totalCoreBoardSquare;
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

  public BigDecimal getTotalReworkCoreBoardSquare() {
    return totalReworkCoreBoardSquare;
  }

  public void setTotalReworkCoreBoardSquare(BigDecimal totalReworkCoreBoardSquare) {
    this.totalReworkCoreBoardSquare = totalReworkCoreBoardSquare;
  }

  public List<WardrobeSlideHistoryRecordDTO> getList() {
    return list;
  }

  public void setList(List<WardrobeSlideHistoryRecordDTO> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "WardrobeSlideTodayDetailReturnVO{" +
            "totalNum=" + totalNum +
            ", totalDoorSquare=" + totalDoorSquare +
            ", totalCoreBoardSquare=" + totalCoreBoardSquare +
            ", totalReworkNum=" + totalReworkNum +
            ", totalReworkDoorSquare=" + totalReworkDoorSquare +
            ", totalReworkCoreBoardSquare=" + totalReworkCoreBoardSquare +
            ", list=" + list +
            '}';
  }
}
