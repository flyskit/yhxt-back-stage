package com.yhxt.utils;

import com.yhxt.ddcl.vo.OrderQueryParamVO;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BaseSqlUtils
 * @Author zqi
 * @Date 2019/7/9 16:50
 * @Version 1.0
 * @Description 数据库查询操作
 */
public class BaseSqlUtils {

  /**
   * 条件查询-条件判断
   *
   * @param orderQueryParamVO 查询条件
   * @return map
   */
  public static Map<String, Object> judgeCond(OrderQueryParamVO orderQueryParamVO) {
    // 保存查询条件
    Map<String, Object> map = new HashMap<>(10);
    StringBuilder queryCond = new StringBuilder();
    //订单编号-模糊查询
    if (!StringUtils.isEmpty(orderQueryParamVO.getDdbh())) {
      queryCond.append("AND orderDetail.ddbh like :ddbh ");
      map.put("ddbh", "%" + orderQueryParamVO.getDdbh() + "%");
    }
    // 订单类型
    if (!StringUtils.isEmpty(orderQueryParamVO.getDdlx())) {
      queryCond.append("AND orderDetail.ddlx = :ddlx ");
      map.put("ddlx", orderQueryParamVO.getDdlx());
    }
    // 订单来源
    if (!StringUtils.isEmpty(orderQueryParamVO.getDdly())) {
      queryCond.append("AND orderDetail.ddly = :ddly ");
      map.put("ddly", orderQueryParamVO.getDdly());
    }
    // 客户姓名-模糊查询
    if (!StringUtils.isEmpty(orderQueryParamVO.getKhxm())) {
      queryCond.append("AND orderDetail.khxm like :khxm ");
      map.put("khxm", "%" + orderQueryParamVO.getKhxm() + "%");
    }
    // 商品类型
    if (!StringUtils.isEmpty(orderQueryParamVO.getSplx())) {
      queryCond.append("AND orderGoods.splx = :splx ");
      map.put("splx", orderQueryParamVO.getSplx());
    }
    // 订单状态
    if (!StringUtils.isEmpty(orderQueryParamVO.getDdzt())) {
      queryCond.append("AND orderDetail.ddzt = :ddzt ");
      map.put("ddzt", orderQueryParamVO.getDdzt());
    }
    // 有效状态
    if (!StringUtils.isEmpty(orderQueryParamVO.getYxzt())) {
      queryCond.append("AND orderDetail.zt = :yxzt ");
      map.put("yxzt", orderQueryParamVO.getYxzt());
    }
    // 审核状态
    if (!StringUtils.isEmpty(orderQueryParamVO.getShzt())) {
      queryCond.append("AND orderDetail.shzt = :shzt ");
      map.put("shzt", orderQueryParamVO.getShzt());
    }
    // 开始时间
    if (!StringUtils.isEmpty(orderQueryParamVO.getStartTime())) {
      queryCond.append("AND orderRecord.czsj >= :startTime ");
      map.put("startTime", orderQueryParamVO.getStartTime());
    }
    // 结束时间
    if (!StringUtils.isEmpty(orderQueryParamVO.getEndTime())) {
      queryCond.append("AND orderRecord.czsj <= :endTime ");
      map.put("endTime", orderQueryParamVO.getEndTime());
    }
    queryCond.append("ORDER BY orderRecord.czsj desc ");
    Map<String, Object> returnMap = new HashMap<>(2);
    returnMap.put("map", map);
    returnMap.put("queryCond", queryCond);
    return returnMap;
  }
}
