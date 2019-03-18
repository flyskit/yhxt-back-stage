package com.yhxt.common;

/**
 * @ClassName BaseException
 * @Author zqi
 * @Date 2019/3/18 12:15
 * @Version 1.0
 * @Description 基本异常处理
 */
public class BaseException extends RuntimeException{

  private static final long serialVersionUID = 4691062409463159891L;

  public BaseException(){}

  public BaseException(String message) {
    super(message);
  }

  public BaseException(String message, Throwable cause) {
    super(message, cause);
  }
}
