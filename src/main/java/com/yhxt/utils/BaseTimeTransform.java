package com.yhxt.utils;

import com.yhxt.common.BaseException;
import org.springframework.util.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName BaseTimeTransform
 *
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
   * localDate 转 Date
   *
   * @param localDate 日期
   * @return date
   */
  public static Date localDateToDate(LocalDate localDate) {
    if (StringUtils.isEmpty(localDate)) {
      throw new BaseException("localDate is null！");
    }
    ZoneId zone = ZoneId.systemDefault();
    Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
    return Date.from(instant);
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

  /**
   * Date转LocalDateTime
   *
   * @param date 日期
   * @return localDate
   */
  public static LocalDateTime dateToLocalDateTime(Date date) {
    if (StringUtils.isEmpty(date)) {
      throw new BaseException("date is null！");
    }
    Instant instant = date.toInstant();
    ZoneId zone = ZoneId.systemDefault();
    return LocalDateTime.ofInstant(instant, zone);
  }

  /**
   * Date转LocalDate
   *
   * @param date 日期
   * @return localDate
   */
  public static LocalDate dateToLocalDate(Date date) {
    if (StringUtils.isEmpty(date)) {
      throw new BaseException("date is null！");
    }
    return BaseTimeTransform.dateToLocalDateTime(date).toLocalDate();
  }
}
