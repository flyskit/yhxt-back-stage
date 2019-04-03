package com.yhxt.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BaseMessage
 * @Author zqi
 * @Date 2019/1/18 15:12
 * @Version 1.0
 * @Description 返回基本信息
 */
public class BaseMessage {
  /**
   * 操作结果状态
   */
  private Integer status;
  /**
   * 提示信息
   */
  private String info;

  private Map<String, Object> map = new HashMap<>();

  /**
   * success：默认返回info
   *
   * @return baseMessage
   */
  public static BaseMessage success() {
    return new BaseMessage(200, "操作成功！");
  }

  /**
   * failed: 默认返回info
   *
   * @return baseMessage
   */
  public static BaseMessage failed() {
    return new BaseMessage(100, "出现异常，请联系管理员！");
  }

  /**
   * failed: 返回失败信息
   *
   * @param info 信息
   * @return baseMessage
   */
  public static BaseMessage failed(String info) {
    return new BaseMessage(100, info);
  }

  public BaseMessage add(Object value) {
    this.getMap().put("data", value);
    return this;
  }

  /**
   * 声明默认构造器
   */
  public BaseMessage() {
  }

  /**
   * 构造器重载
   *
   * @param status 状态
   * @param info   信息
   */
  private BaseMessage(Integer status, String info) {
    this.status = status;
    this.info = info;
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
