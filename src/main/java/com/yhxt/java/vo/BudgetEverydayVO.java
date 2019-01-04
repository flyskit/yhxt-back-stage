package com.yhxt.java.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yhxt.java.common.BaseParam;

import java.util.Date;

/**
 * @ClassName BudgetEverydayVO
 * @Author zqi
 * @Date 2018/12/29 14:25
 * @Version 1.0
 * @Description 条件状态信息
 */
public class BudgetEverydayVO extends BaseParam {
  /**
   * 编号
   */
  private String bh;
  /**
   * 录入日期
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date lrrq;
  /**
   * 收账日期
   */
  private Date szrq;
  /**
   * 客户姓名
   */
  private String khxm;
  /**
   * 收入类型
   */
  private Integer srlx;

  /**
   * 搜索条件-结束时间
   */
  private Date endTime;

  public String getBh() {
    return bh;
  }

  public void setBh(String bh) {
    this.bh = bh;
  }

  @JsonFormat(pattern = "yyyy-MM-dd")
  public Date getLrrq() {
    return lrrq;
  }

  public void setLrrq(Date lrrq) {
    this.lrrq = lrrq;
  }

  public Date getSzrq() {
    return szrq;
  }

  public void setSzrq(Date szrq) {
    this.szrq = szrq;
  }

  public String getKhxm() {
    return khxm;
  }

  public void setKhxm(String khxm) {
    this.khxm = khxm;
  }

  public Integer getSrlx() {
    return srlx;
  }

  public void setSrlx(Integer srlx) {
    this.srlx = srlx;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  @Override
  public String toString() {
    return "BudgetEverydayVO{" +
            "bh='" + bh + '\'' +
            ", lrrq=" + lrrq +
            ", szrq=" + szrq +
            ", khxm='" + khxm + '\'' +
            ", srlx=" + srlx +
            ", endTime=" + endTime +
            '}';
  }
}
