package com.yhxt.java.vo;/**
 * Created by zqi on 2018/12/29.
 */

import com.yhxt.java.common.BaseParam;

import java.util.Date;

/**
 * @ClassName BudgetEverydayVO
 * @Author zqi
 * @Date 2018/12/29 14:25
 * @Version 1.0
 * @Description 条件状态信息
 */
public class BudgetEverydayVO extends BaseParam{
  /**
   * 编号
   */
  private String bh;
  /**
   * 录入日期
   */
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

  public String getBh() {
    return bh;
  }

  public void setBh(String bh) {
    this.bh = bh;
  }

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

  @Override
  public String toString() {
    return "BudgetEverydayVO{" +
            "bh='" + bh + '\'' +
            ", lrrq=" + lrrq +
            ", szrq=" + szrq +
            ", khxm='" + khxm + '\'' +
            ", srlx='" + srlx + '\'' +
            '}';
  }
}
