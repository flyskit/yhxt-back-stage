package com.yhxt.khxd.jgm.dao.impl;

import com.yhxt.common.BaseStatus;
import com.yhxt.common.GoodsType;
import com.yhxt.ddcl.common.OrderRecordType;
import com.yhxt.ddcl.common.OrderStatus;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.jgm.dto.HistoryRecordDTO;
import com.yhxt.utils.BaseSqlUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CrystalSteelDoorDetailDaoImpl
 * @Author zqi
 * @Date 2019/6/23 18:11
 * @Version 1.0
 * @Description 晶钢门统计信息
 */
public class CrystalSteelDoorDetailDaoImpl {
  @PersistenceContext
  private EntityManager entityManager;

  /**
   * 查询今日下单记录
   *
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @return list
   */
  public List<HistoryRecordDTO> getDataByToDay(Date startTime, Date endTime) {
    // 订单有效状态
    Boolean orderValid = BaseStatus.VALID.getValue();
    // 已下单状态
    Integer orderSubmit = OrderStatus.SUBMIT.getValue();
    // 商品类型-晶钢门
    Integer goodsType = GoodsType.CRYSTAL_STEEL_DOOR.getValue();
    // 新建状态
    Integer orderNew = OrderRecordType.NEW.getValue();
    StringBuilder jpql = new StringBuilder("select new com.yhxt.khxd.jgm.dto.HistoryRecordDTO(")
            .append("orderDetail.ddbh, orderDetail.khxm, orderDetail.ddlx, orderDetail.ddly, orderDetail.scsl, orderDetail.gq, ")
            .append("crystalSteelDoorDetail.je, crystalSteelDoorDetail.hjsl, orderDetail.bz, crystalSteelDoorDetail.yjdb, orderDetail.wgsj, ")
            .append("orderDetail.dz, orderDetail.dh, orderRecord.czr, orderRecord.czsj, crystalSteelDoorDetail.ls, crystalSteelDoorDetail.ys, ")
            .append("crystalSteelDoorDetail.dj, crystalSteelDoorDetail.hjpf, crystalSteelDoorDetail.blpf) FROM OrderDetail orderDetail ")
            .append("left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join CrystalSteelDoorDetail crystalSteelDoorDetail on crystalSteelDoorDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderDetail.zt =:orderValid AND orderGoods.zt =:orderValid AND orderRecord.czlb = :orderNew AND orderGoods.splx = :goodsType ")
            .append("AND (orderRecord.czsj between :startTime and :endTime) AND orderDetail.ddzt =:orderSubmit ")
            .append("ORDER BY orderRecord.czsj desc");
    Query query = entityManager.createQuery(jpql.toString());
    query.setParameter("orderValid", orderValid);
    query.setParameter("orderNew", orderNew);
    query.setParameter("goodsType", goodsType);
    query.setParameter("startTime", startTime);
    query.setParameter("endTime", endTime);
    query.setParameter("orderSubmit", orderSubmit);
    @SuppressWarnings(value = "unchecked")
    List<HistoryRecordDTO> list = query.getResultList();
    return list;
  }

  /**
   * 查询暂存订单
   *
   * @return list
   */
  public List<HistoryRecordDTO> getDataByTemporary() {
    // 订单有效状态
    Boolean orderValid = BaseStatus.VALID.getValue();
    // 暂存状态
    Integer orderTemporary = OrderStatus.TEMPORARY.getValue();
    // 商品类型-晶钢门
    Integer goodsType = GoodsType.CRYSTAL_STEEL_DOOR.getValue();
    // 新建状态
    Integer orderNew = OrderRecordType.NEW.getValue();
    StringBuilder jpql = new StringBuilder("select new com.yhxt.khxd.jgm.dto.HistoryRecordDTO(")
            .append("orderDetail.ddbh, orderDetail.khxm, orderDetail.ddlx, orderDetail.ddly, orderDetail.scsl, orderDetail.gq, ")
            .append("crystalSteelDoorDetail.je, crystalSteelDoorDetail.hjsl, orderDetail.bz, crystalSteelDoorDetail.yjdb, orderDetail.wgsj, ")
            .append("orderDetail.dz, orderDetail.dh, orderRecord.czr, orderRecord.czsj, crystalSteelDoorDetail.ls, crystalSteelDoorDetail.ys, ")
            .append("crystalSteelDoorDetail.dj, crystalSteelDoorDetail.hjpf, crystalSteelDoorDetail.blpf) FROM OrderDetail orderDetail ")
            .append("left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join CrystalSteelDoorDetail crystalSteelDoorDetail on crystalSteelDoorDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderDetail.zt =:orderValid AND orderGoods.zt =:orderValid AND orderDetail.ddzt =:orderTemporary AND orderRecord.czlb = :orderNew AND orderGoods.splx = :goodsType ")
            .append("ORDER BY orderRecord.czsj desc");
    Query query = entityManager.createQuery(jpql.toString());
    query.setParameter("orderValid", orderValid);
    query.setParameter("goodsType", goodsType);
    query.setParameter("orderTemporary", orderTemporary);
    query.setParameter("orderNew", orderNew);
    @SuppressWarnings(value = "unchecked")
    List<HistoryRecordDTO> list = query.getResultList();
    return list;
  }

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 接受参数
   * @param pageable          分页信息
   * @return page
   */
  public Page<HistoryRecordDTO> condData(OrderQueryParamVO orderQueryParamVO, Pageable pageable) {
    // 条件判断
    Map<String, Object> returnMap = BaseSqlUtils.judgeCond(orderQueryParamVO);
    // 订单记录-新建状态
    Integer orderNew = OrderRecordType.NEW.getValue();
    // 保存查询条件
    @SuppressWarnings("unchecked")
    Map<String, Object> map = (Map<String, Object>) returnMap.get("map");
    StringBuilder queryCond = (StringBuilder) returnMap.get("queryCond");
    StringBuilder jpql = new StringBuilder("select new com.yhxt.khxd.jgm.dto.HistoryRecordDTO(")
            .append("orderDetail.ddbh, orderDetail.khxm, orderDetail.ddlx, orderDetail.ddly, orderDetail.scsl, orderDetail.gq, ")
            .append("crystalSteelDoorDetail.je, crystalSteelDoorDetail.hjsl, orderDetail.bz, crystalSteelDoorDetail.yjdb, orderDetail.wgsj, ")
            .append("orderDetail.dz, orderDetail.dh, orderRecord.czr, orderRecord.czsj, crystalSteelDoorDetail.ls, crystalSteelDoorDetail.ys, ")
            .append("crystalSteelDoorDetail.dj, crystalSteelDoorDetail.hjpf, crystalSteelDoorDetail.blpf) FROM OrderDetail orderDetail ")
            .append("left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join CrystalSteelDoorDetail crystalSteelDoorDetail on crystalSteelDoorDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderRecord.czlb = :orderNew ");
    map.put("orderNew", orderNew);
    Query query = entityManager.createQuery(jpql.append(queryCond).toString());
    map.forEach(query::setParameter);
    query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
    query.setMaxResults(pageable.getPageSize());
    @SuppressWarnings(value = "unchecked")
    List<HistoryRecordDTO> list = query.getResultList();
    StringBuilder jpql2 = new StringBuilder("select count(*) ")
            .append("FROM OrderDetail orderDetail left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join CrystalSteelDoorDetail crystalSteelDoorDetail on crystalSteelDoorDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderRecord.czlb = :orderNew ");
    Query query2 = entityManager.createQuery(jpql2.append(queryCond).toString());
    map.forEach(query2::setParameter);
    long total = (Long) query2.getSingleResult();
    return new PageImpl<>(list, pageable, total);
  }
}
