package com.yhxt.khxd.tzm.vo;

import com.yhxt.khxd.tzm.dto.SuitHistoryRecordDTO;

import java.util.List;

/**
 * @ClassName SuitReturnInfoVO
 * @Author zqi
 * @Date 2019/7/17 10:52
 * @Version 1.0
 * @Description 今日已下单-返回信息
 */
public class SuitReturnInfoVO {

  /**
   * 平开门套数
   */
  private Integer totalSwingNum;

  /**
   * 平开门门扇数量
   */
  private Integer totalSwingDoorNum;

  /**
   * 推门套数
   */
  private Integer totalHangingNum;

  /**
   * 推门门扇数量
   */
  private Integer totalHangingDoorNum;

  /**
   * 合计空套
   */
  private Integer totalPocketNum;

  /**
   * 合计线条
   */
  private Integer totalLineNum;

  /**
   * 返工-平开门套数
   */
  private Integer totalReworkSwingNum;

  /**
   * 返工-平开门门扇数量
   */
  private Integer totalReworkSwingDoorNum;

  /**
   * 返工-推门套数
   */
  private Integer totalReworkHangingNum;

  /**
   * 推门门扇数量
   */
  private Integer totalReworkHangingDoorNum;

  /**
   * 返工-合计空套
   */
  private Integer totalReworkPocketNum;

  /**
   * 返工-合计线条
   */
  private Integer totalReworkLineNum;

  /**
   * 返工-数据记录
   */
  private List<SuitHistoryRecordDTO> list;

  public SuitReturnInfoVO() {
  }

  public SuitReturnInfoVO(Integer totalSwingNum, Integer totalSwingDoorNum, Integer totalHangingNum, Integer totalHangingDoorNum, Integer totalPocketNum, Integer totalLineNum, Integer totalReworkSwingNum, Integer totalReworkSwingDoorNum, Integer totalReworkHangingNum, Integer totalReworkHangingDoorNum, Integer totalReworkPocketNum, Integer totalReworkLineNum, List<SuitHistoryRecordDTO> list) {
    this.totalSwingNum = totalSwingNum;
    this.totalSwingDoorNum = totalSwingDoorNum;
    this.totalHangingNum = totalHangingNum;
    this.totalHangingDoorNum = totalHangingDoorNum;
    this.totalPocketNum = totalPocketNum;
    this.totalLineNum = totalLineNum;
    this.totalReworkSwingNum = totalReworkSwingNum;
    this.totalReworkSwingDoorNum = totalReworkSwingDoorNum;
    this.totalReworkHangingNum = totalReworkHangingNum;
    this.totalReworkHangingDoorNum = totalReworkHangingDoorNum;
    this.totalReworkPocketNum = totalReworkPocketNum;
    this.totalReworkLineNum = totalReworkLineNum;
    this.list = list;
  }

  public Integer getTotalSwingNum() {
    return totalSwingNum;
  }

  public void setTotalSwingNum(Integer totalSwingNum) {
    this.totalSwingNum = totalSwingNum;
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

  public Integer getTotalHangingDoorNum() {
    return totalHangingDoorNum;
  }

  public void setTotalHangingDoorNum(Integer totalHangingDoorNum) {
    this.totalHangingDoorNum = totalHangingDoorNum;
  }

  public Integer getTotalPocketNum() {
    return totalPocketNum;
  }

  public void setTotalPocketNum(Integer totalPocketNum) {
    this.totalPocketNum = totalPocketNum;
  }

  public Integer getTotalLineNum() {
    return totalLineNum;
  }

  public void setTotalLineNum(Integer totalLineNum) {
    this.totalLineNum = totalLineNum;
  }

  public Integer getTotalReworkSwingNum() {
    return totalReworkSwingNum;
  }

  public void setTotalReworkSwingNum(Integer totalReworkSwingNum) {
    this.totalReworkSwingNum = totalReworkSwingNum;
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

  public Integer getTotalReworkHangingDoorNum() {
    return totalReworkHangingDoorNum;
  }

  public void setTotalReworkHangingDoorNum(Integer totalReworkHangingDoorNum) {
    this.totalReworkHangingDoorNum = totalReworkHangingDoorNum;
  }

  public Integer getTotalReworkPocketNum() {
    return totalReworkPocketNum;
  }

  public void setTotalReworkPocketNum(Integer totalReworkPocketNum) {
    this.totalReworkPocketNum = totalReworkPocketNum;
  }

  public Integer getTotalReworkLineNum() {
    return totalReworkLineNum;
  }

  public void setTotalReworkLineNum(Integer totalReworkLineNum) {
    this.totalReworkLineNum = totalReworkLineNum;
  }

  public List<SuitHistoryRecordDTO> getList() {
    return list;
  }

  public void setList(List<SuitHistoryRecordDTO> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "SuitReturnInfoVO{" +
            "totalSwingNum=" + totalSwingNum +
            ", totalSwingDoorNum=" + totalSwingDoorNum +
            ", totalHangingNum=" + totalHangingNum +
            ", totalHangingDoorNum=" + totalHangingDoorNum +
            ", totalPocketNum=" + totalPocketNum +
            ", totalLineNum=" + totalLineNum +
            ", totalReworkSwingNum=" + totalReworkSwingNum +
            ", totalReworkSwingDoorNum=" + totalReworkSwingDoorNum +
            ", totalReworkHangingNum=" + totalReworkHangingNum +
            ", totalReworkHangingDoorNum=" + totalReworkHangingDoorNum +
            ", totalReworkPocketNum=" + totalReworkPocketNum +
            ", totalReworkLineNum=" + totalReworkLineNum +
            ", list=" + list +
            '}';
  }
}
