package com.yhxt.java.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ReturnInfo
 * @Author zqi
 * @Date 2018/12/20 10:53
 * @Version 1.0
 * @Description 返回信息
 */
public class ReturnInfo {
  /**
   * 操作结果状态
   */
  private Integer status;
  /**
   * 提示信息
   */
  private String info;

  private Map<String, Object> map = new HashMap<>();

  public static ReturnInfo success() {
    ReturnInfo result = new ReturnInfo();
    result.setStatus(200);
    result.setInfo("操作成功！");
    return result;
  }

  public static ReturnInfo failed(String info) {
    ReturnInfo result = new ReturnInfo();
    result.setStatus(100);
    result.setInfo(info);
    return result;
  }

  public ReturnInfo add(Object value) {
    this.getMap().put("data", value);
    return this;
  }

  /**
   * 获取 status。
   *
   * @return status。
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param status 要设置的 status。
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * 获取 info。
   *
   * @return info。
   */
  public String getInfo() {
    return info;
  }

  /**
   * @param info 要设置的 info。
   */
  public void setInfo(String info) {
    this.info = info;
  }

  /**
   * 获取 map。
   *
   * @return map。
   */
  public Map<String, Object> getMap() {
    return map;
  }

  /**
   * @param map 要设置的 map。
   */
  public void setMap(Map<String, Object> map) {
    this.map = map;
  }
}
