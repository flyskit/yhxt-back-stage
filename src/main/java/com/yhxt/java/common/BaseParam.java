package com.yhxt.java.common;

/**
 * @ClassName BaseParam
 * @Author zqi
 * @Date 2018/12/29 14:31
 * @Version 1.0
 * @Description 基本条件信息
 */
public class BaseParam {
  /**
   * 关键字
   */
  private String key;

  /**
   * 分页信息
   */
  private PageCond page;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public PageCond getPage() {
    return page;
  }

  public void setPage(PageCond page) {
    this.page = page;
  }
}
