package com.yhxt.ddcl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yhxt.common.PageCond;
import com.yhxt.utils.BaseTimeTransform;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @ClassName OrderQueryParamVO
 * @Author zqi
 * @Date 2019/7/3 18:06
 * @Version 1.0
 * @Description 订单记录查询-接受字段
 */
public class OrderQueryParamVO {

  /**
   * 订单编号
   */
  private String ddbh;

  /**
   * 订单类型
   */
  private Integer ddlx;

  /**
   * 订单来源
   */
  private Integer ddly;

  /**
   * 客户姓名
   */
  private String khxm;

  /**
   * 商品类型
   */
  private Integer splx;

  /**
   * 订单状态
   */
  private Integer ddzt;

  /**
   * 订单有效状态
   */
  private Boolean yxzt;

  /**
   * 审核状态
   */
  private Integer shzt;

  /**
   * 开始日期
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date startTime;

  /**
   * 结束日期
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date endTime;

  /**
   * 分页信息
   */
  private PageCond page;

  public OrderQueryParamVO() {
  }

  public OrderQueryParamVO(String ddbh, Integer ddlx, Integer ddly, String khxm, Integer splx, Integer ddzt, Boolean yxzt, Integer shzt, Date startTime, Date endTime, PageCond page) {
    this.ddbh = ddbh;
    this.ddlx = ddlx;
    this.ddly = ddly;
    this.khxm = khxm;
    this.splx = splx;
    this.ddzt = ddzt;
    this.yxzt = yxzt;
    this.shzt = shzt;
    this.startTime = startTime;
    this.endTime = endTime;
    this.page = page;
  }

  public String getDdbh() {
    return ddbh;
  }

  public void setDdbh(String ddbh) {
    this.ddbh = ddbh;
  }

  public Integer getDdlx() {
    return ddlx;
  }

  public void setDdlx(Integer ddlx) {
    this.ddlx = ddlx;
  }

  public Integer getDdly() {
    return ddly;
  }

  public void setDdly(Integer ddly) {
    this.ddly = ddly;
  }

  public String getKhxm() {
    return khxm;
  }

  public void setKhxm(String khxm) {
    this.khxm = khxm;
  }

  public Integer getSplx() {
    return splx;
  }

  public void setSplx(Integer splx) {
    this.splx = splx;
  }

  public Integer getDdzt() {
    return ddzt;
  }

  public void setDdzt(Integer ddzt) {
    this.ddzt = ddzt;
  }

  public Boolean getYxzt() {
    return yxzt;
  }

  public void setYxzt(Boolean yxzt) {
    this.yxzt = yxzt;
  }

  public Integer getShzt() {
    return shzt;
  }

  public void setShzt(Integer shzt) {
    this.shzt = shzt;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    if (!StringUtils.isEmpty(endTime)) {
      // 时间格式yyyy-MM-dd 00:00:00, 需要增加一天
      return BaseTimeTransform.localDateToDate(BaseTimeTransform.dateToLocalDate(endTime).plusDays(1));
    }
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public PageCond getPage() {
    return page;
  }

  public void setPage(PageCond page) {
    this.page = page;
  }

  @Override
  public String toString() {
    return "OrderQueryParamVO{" +
            "ddbh='" + ddbh + '\'' +
            ", ddlx=" + ddlx +
            ", ddly=" + ddly +
            ", khxm='" + khxm + '\'' +
            ", splx=" + splx +
            ", ddzt=" + ddzt +
            ", yxzt=" + yxzt +
            ", shzt=" + shzt +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", page=" + page +
            '}';
  }
}
