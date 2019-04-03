package com.yhxt.utils;

import com.yhxt.common.BaseException;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName BaseTimeTransform
 * @Author zqi
 * @Date 2019/4/3 10:39
 * @Version 1.0
 * @Description 公共类-时间转换
 */
public class BaseTimeTransform {

  /**
   * localDateTime 转 Date
   *
   * @param localDateTime 时间
   * @return date
   */
  public static Date localDateTimeToDate(LocalDateTime localDateTime) {
    if (StringUtils.isEmpty(localDateTime)) {
      throw new BaseException("localDateTime is null！");
    }
    ZoneId zoneId = ZoneId.systemDefault();
    ZonedDateTime zdt = localDateTime.atZone(zoneId);
    return Date.from(zdt.toInstant());
  }

  /**
   * localDate 转 String
   *
   * @param localDate 时间
   * @return string
   */
  public static String localDateToString(LocalDate localDate) {
    if (StringUtils.isEmpty(localDate)) {
      throw new BaseException("localDate is null！");
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    return localDate.format(formatter);
  }
}
