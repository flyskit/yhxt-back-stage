package com.yhxt.khxd.thjm.dao.impl;

import com.yhxt.common.BaseStatus;
import com.yhxt.common.GoodsType;
import com.yhxt.ddcl.common.OrderRecordType;
import com.yhxt.ddcl.common.OrderStatus;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.thjm.dto.TitaniumAlloyHistoryRecordDTO;
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
 * @ClassName TitaniumAlloyDoorDetailImpl
 * @Author zqi
 * @Date 2019/7/9 13:08
 * @Version 1.0
 * @Description 钛合金门-基本信息
 */
public class TitaniumAlloyDoorDetailDaoImpl {
  @PersistenceContext
  private EntityManager entityManager;

  /**
   * 今日已下单-查询记录
   *
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @return list
   */
  public List<TitaniumAlloyHistoryRecordDTO> getDataByToDay(Date startTime, Date endTime) {
    // 订单有效状态
    Boolean orderValid = BaseStatus.VALID.getValue();
    // 已下单状态
    Integer orderSubmit = OrderStatus.SUBMIT.getValue();
    // 商品类型-平开门
    Integer swingType = GoodsType.TITANIUM_ALLOY_DOOR_SWING.getValue();
    // 商品类型-吊趟门
    Integer hangingType = GoodsType.TITANIUM_ALLOY_DOOR_HANGING.getValue();
    // 订单记录-新建状态
    Integer orderNew = OrderRecordType.NEW.getValue();

    StringBuilder jpql = new StringBuilder("select new com.yhxt.khxd.thjm.dto.TitaniumAlloyHistoryRecordDTO(")
            .append("orderDetail.ddbh, orderDetail.khxm, orderDetail.ddlx, orderDetail.ddly, orderDetail.scsl, orderDetail.gq, ")
            .append("titaniumAlloyDoorDetail.hjje, titaniumAlloyDoorDetail.hjsl, orderDetail.bz, titaniumAlloyDoorDetail.yjdb, orderDetail.wgsj, ")
            .append("orderDetail.dz, orderDetail.dh, orderRecord.czr, orderRecord.czsj, ")
            .append("orderGoods.splx, orderGoods.spmc, titaniumAlloyDoorDetail.hjpf) ")
            .append("FROM OrderDetail orderDetail left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join TitaniumAlloyDoorDetail titaniumAlloyDoorDetail on titaniumAlloyDoorDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderDetail.zt =:orderValid AND orderGoods.zt =:orderValid AND orderRecord.czlb = :orderNew ")
            .append("AND (orderGoods.splx = :swingType or orderGoods.splx = :hangingType) AND (orderRecord.czsj between :startTime and :endTime) AND orderDetail.ddzt = :orderSubmit ")
            .append("ORDER BY orderRecord.czsj desc");
    Query query = entityManager.createQuery(jpql.toString());
    query.setParameter("orderValid", orderValid);
    query.setParameter("orderNew", orderNew);
    query.setParameter("orderSubmit", orderSubmit);
    query.setParameter("swingType", swingType);
    query.setParameter("hangingType", hangingType);
    query.setParameter("startTime", startTime);
    query.setParameter("endTime", endTime);
    @SuppressWarnings(value = "unchecked")
    List<TitaniumAlloyHistoryRecordDTO> list = query.getResultList();
    return list;
  }

  /**
   * 查询暂存订单
   *
   * @return list
   */
  public List<TitaniumAlloyHistoryRecordDTO> getDataByTemporary() {
    // 订单有效状态
    Boolean orderValid = BaseStatus.VALID.getValue();
    // 暂存状态
    Integer orderTemporary = OrderStatus.TEMPORARY.getValue();
    // 商品类型-平开门
    Integer swingType = GoodsType.TITANIUM_ALLOY_DOOR_SWING.getValue();
    // 商品类型-吊趟门
    Integer hangingType = GoodsType.TITANIUM_ALLOY_DOOR_HANGING.getValue();
    // 订单记录-新建状态
    Integer orderNew = OrderRecordType.NEW.getValue();
    StringBuilder jpql = new StringBuilder("select new com.yhxt.khxd.thjm.dto.TitaniumAlloyHistoryRecordDTO(")
            .append("orderDetail.ddbh, orderDetail.khxm, orderDetail.ddlx, orderDetail.ddly, orderDetail.scsl, orderDetail.gq, ")
            .append("titaniumAlloyDoorDetail.hjje, titaniumAlloyDoorDetail.hjsl, orderDetail.bz, titaniumAlloyDoorDetail.yjdb, orderDetail.wgsj, ")
            .append("orderDetail.dz, orderDetail.dh, orderRecord.czr, orderRecord.czsj, ")
            .append("orderGoods.splx, orderGoods.spmc, titaniumAlloyDoorDetail.hjpf) ")
            .append("FROM OrderDetail orderDetail left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join TitaniumAlloyDoorDetail titaniumAlloyDoorDetail on titaniumAlloyDoorDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderDetail.zt =:orderValid AND orderGoods.zt =:orderValid AND orderRecord.czlb = :orderNew ")
            .append("AND (orderGoods.splx = :swingType or orderGoods.splx = :hangingType) AND orderDetail.ddzt = :orderTemporary ")
            .append("ORDER BY orderRecord.czsj desc");
    Query query = entityManager.createQuery(jpql.toString());
    query.setParameter("orderValid", orderValid);
    query.setParameter("swingType", swingType);
    query.setParameter("hangingType", hangingType);
    query.setParameter("orderTemporary", orderTemporary);
    query.setParameter("orderNew", orderNew);
    @SuppressWarnings(value = "unchecked")
    List<TitaniumAlloyHistoryRecordDTO> list = query.getResultList();
    return list;
  }

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 接受参数
   * @param pageable          分页信息
   * @return page
   */
  public Page<TitaniumAlloyHistoryRecordDTO> condData(OrderQueryParamVO orderQueryParamVO, Pageable pageable) {
    // 条件判断
    Map<String, Object> returnMap = BaseSqlUtils.judgeCond(orderQueryParamVO);
    // 订单记录-新建状态
    Integer orderNew = OrderRecordType.NEW.getValue();
    // 保存查询条件
    @SuppressWarnings("unchecked")
    Map<String, Object> map = (Map<String, Object>) returnMap.get("map");
    StringBuilder queryCond = (StringBuilder) returnMap.get("queryCond");
    StringBuilder jpql = new StringBuilder("select new com.yhxt.khxd.thjm.dto.TitaniumAlloyHistoryRecordDTO(")
            .append("orderDetail.ddbh, orderDetail.khxm, orderDetail.ddlx, orderDetail.ddly, orderDetail.scsl, orderDetail.gq, ")
            .append("titaniumAlloyDoorDetail.hjje, titaniumAlloyDoorDetail.hjsl, orderDetail.bz, titaniumAlloyDoorDetail.yjdb, orderDetail.wgsj, ")
            .append("orderDetail.dz, orderDetail.dh, orderRecord.czr, orderRecord.czsj, ")
            .append("orderGoods.splx, orderGoods.spmc, titaniumAlloyDoorDetail.hjpf) ")
            .append("FROM OrderDetail orderDetail left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join TitaniumAlloyDoorDetail titaniumAlloyDoorDetail on titaniumAlloyDoorDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderRecord.czlb = :orderNew ");
    map.put("orderNew", orderNew);
    Query query = entityManager.createQuery(jpql.append(queryCond).toString());
    map.forEach(query::setParameter);
    query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
    query.setMaxResults(pageable.getPageSize());
    @SuppressWarnings(value = "unchecked")
    List<TitaniumAlloyHistoryRecordDTO> list = query.getResultList();
    StringBuilder jpql2 = new StringBuilder("select count(*) ")
            .append("FROM OrderDetail orderDetail left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join TitaniumAlloyDoorDetail titaniumAlloyDoorDetail on titaniumAlloyDoorDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderRecord.czlb = :orderNew ");
    Query query2 = entityManager.createQuery(jpql2.append(queryCond).toString());
    map.forEach(query2::setParameter);
    long total = (Long) query2.getSingleResult();
    return new PageImpl<>(list, pageable, total);
  }
}
