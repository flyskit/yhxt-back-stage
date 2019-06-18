package com.yhxt.khxd.jgm.vo;

import com.yhxt.common.PageCond;

/**
 * @ClassName CrystalSteelDoorFindParamVO
 * @Author zqi
 * @Date 2019/6/10 14:37
 * @Version 1.0
 * @Description 历史记录查询参数
 */
public class CrystalSteelDoorFindParamVO {
  /**
   * 编号
   */
  private String bh;

  /**
   * 客户姓名
   */
  private String khxm;

  /**
   * 下单类型
   */
  private Integer xdlx;

  /**
   * 订单来源
   */
  private Integer ddly;

  /**
   * 分页信息
   */
  private PageCond page;

  /**
   * 默认构造器
   */
  public CrystalSteelDoorFindParamVO() {
  }

  public CrystalSteelDoorFindParamVO(String bh, String khxm, Integer xdlx, Integer ddly, PageCond page) {
    this.bh = bh;
    this.khxm = khxm;
    this.xdlx = xdlx;
    this.ddly = ddly;
    this.page = page;
  }

  public String getBh() {
    return bh;
  }

  public void setBh(String bh) {
    this.bh = bh;
  }

  public String getKhxm() {
    return khxm;
  }

  public void setKhxm(String khxm) {
    this.khxm = khxm;
  }

  public Integer getXdlx() {
    return xdlx;
  }

  public void setXdlx(Integer xdlx) {
    this.xdlx = xdlx;
  }

  public Integer getDdly() {
    return ddly;
  }

  public void setDdly(Integer ddly) {
    this.ddly = ddly;
  }

  public PageCond getPage() {
    return page;
  }

  public void setPage(PageCond page) {
    this.page = page;
  }

  @Override
  public String toString() {
    return "CrystalSteelDoorFindParamVO{" +
            "bh='" + bh + '\'' +
            ", khxm='" + khxm + '\'' +
            ", xdlx=" + xdlx +
            ", ddly=" + ddly +
            ", page=" + page +
            '}';
  }
}
