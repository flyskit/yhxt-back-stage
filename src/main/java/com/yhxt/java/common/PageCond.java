package com.yhxt.java.common;/**
 * Created by zqi on 2018/12/29.
 */

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @ClassName PageCond
 * @Author zqi
 * @Date 2018/12/29 14:28
 * @Version 1.0
 * @Description 分页信息
 */
public class PageCond {
  /**
   * 页码
   */
  private Integer page;

  /**
   * 每页数量
   */
  private Integer pageSize;

  public Integer getPage() {
    return page - 1;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Pageable getRequest() {
    return new PageRequest(this.getPage(), this.getPageSize());
  }
}
