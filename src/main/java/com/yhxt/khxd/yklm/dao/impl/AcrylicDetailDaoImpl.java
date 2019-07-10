package com.yhxt.khxd.yklm.dao.impl;

import com.yhxt.common.BaseStatus;
import com.yhxt.common.GoodsType;
import com.yhxt.ddcl.common.OrderRecordType;
import com.yhxt.ddcl.common.OrderStatus;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.yklm.dto.AcrylicHistoryRecordDTO;
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
 * @ClassName AcrylicDetailDaoImpl
 * @Author zqi
 * @Date 2019/7/3 15:04
 * @Version 1.0
 * @Description 亚克力-详细信息
 */
public class AcrylicDetailDaoImpl {

  @PersistenceContext
  private EntityManager entityManager;

  /**
   * 今日已下单-查询记录
   *
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @return list
   */
  public List<AcrylicHistoryRecordDTO> getDataByToDay(Date startTime, Date endTime) {
    // 订单有效状态
    Boolean orderValid = BaseStatus.VALID.getValue();
    // 已下单状态
    Integer orderSubmit = OrderStatus.SUBMIT.getValue();
    // 商品类型-亚克力门
    Integer goodsType = GoodsType.ACRYLIC.getValue();
    // 订单记录-新建状态
    Integer orderNew = OrderRecordType.NEW.getValue();
    StringBuilder jpql = new StringBuilder("select new com.yhxt.khxd.yklm.dto.AcrylicHistoryRecordDTO(")
            .append("orderDetail.ddbh, orderDetail.khxm, orderDetail.ddlx, orderDetail.ddly, orderDetail.scsl, orderDetail.gq, ")
            .append("acrylicDetail.je, acrylicDetail.hjsl, orderDetail.bz, acrylicDetail.yjdb, orderDetail.wgsj, ")
            .append("orderDetail.dz, orderDetail.dh, orderRecord.czr, orderRecord.czsj, acrylicDetail.bcmc, acrylicDetail.bcdj, ")
            .append("acrylicDetail.lsmc, acrylicDetail.lsdj, acrylicDetail.ys, acrylicDetail.hjpf, acrylicDetail.bcpf) ")
            .append("FROM OrderDetail orderDetail left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join AcrylicDetail acrylicDetail on acrylicDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderDetail.zt =:orderValid AND orderGoods.zt =:orderValid AND orderRecord.czlb = :orderNew AND orderGoods.splx = :goodsType ")
            .append("AND (orderRecord.czsj between :startTime and :endTime) AND orderDetail.ddzt = :orderSubmit ")
            .append("ORDER BY orderRecord.czsj desc");
    Query query = entityManager.createQuery(jpql.toString());
    query.setParameter("orderValid", orderValid);
    query.setParameter("orderNew", orderNew);
    query.setParameter("goodsType", goodsType);
    query.setParameter("startTime", startTime);
    query.setParameter("endTime", endTime);
    query.setParameter("orderSubmit", orderSubmit);
    @SuppressWarnings(value = "unchecked")
    List<AcrylicHistoryRecordDTO> list = query.getResultList();
    return list;
  }

  /**
   * 查询暂存订单
   *
   * @return list
   */
  public List<AcrylicHistoryRecordDTO> getDataByTemporary() {
    // 订单有效状态
    Boolean orderValid = BaseStatus.VALID.getValue();
    // 暂存状态
    Integer orderTemporary = OrderStatus.TEMPORARY.getValue();
    // 商品类型-亚克力门
    Integer goodsType = GoodsType.ACRYLIC.getValue();
    // 订单记录-新建状态
    Integer orderNew = OrderRecordType.NEW.getValue();
    StringBuilder jpql = new StringBuilder("select new com.yhxt.khxd.yklm.dto.AcrylicHistoryRecordDTO(")
            .append("orderDetail.ddbh, orderDetail.khxm, orderDetail.ddlx, orderDetail.ddly, orderDetail.scsl, orderDetail.gq, ")
            .append("acrylicDetail.je, acrylicDetail.hjsl, orderDetail.bz, acrylicDetail.yjdb, orderDetail.wgsj, ")
            .append("orderDetail.dz, orderDetail.dh, orderRecord.czr, orderRecord.czsj, acrylicDetail.bcmc, acrylicDetail.bcdj, ")
            .append("acrylicDetail.lsmc, acrylicDetail.lsdj, acrylicDetail.ys, acrylicDetail.hjpf, acrylicDetail.bcpf) ")
            .append("FROM OrderDetail orderDetail left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join AcrylicDetail acrylicDetail on acrylicDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderDetail.zt =:orderValid AND orderGoods.zt =:orderValid AND orderDetail.ddzt =:orderTemporary AND orderRecord.czlb = :orderNew AND orderGoods.splx = :goodsType ")
            .append("ORDER BY orderRecord.czsj desc");
    Query query = entityManager.createQuery(jpql.toString());
    query.setParameter("orderValid", orderValid);
    query.setParameter("goodsType", goodsType);
    query.setParameter("orderTemporary", orderTemporary);
    query.setParameter("orderNew", orderNew);
    @SuppressWarnings(value = "unchecked")
    List<AcrylicHistoryRecordDTO> list = query.getResultList();
    return list;
  }

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 接受参数
   * @param pageable          分页信息
   * @return page
   */
  public Page<AcrylicHistoryRecordDTO> condData(OrderQueryParamVO orderQueryParamVO, Pageable pageable) {
    // 条件判断
    Map<String, Object> returnMap = BaseSqlUtils.judgeCond(orderQueryParamVO);
    // 订单记录-新建状态
    Integer orderNew = OrderRecordType.NEW.getValue();
    // 保存查询条件
    @SuppressWarnings("unchecked")
    Map<String, Object> map = (Map<String, Object>) returnMap.get("map");
    StringBuilder queryCond = (StringBuilder) returnMap.get("queryCond");
    StringBuilder jpql = new StringBuilder("select new com.yhxt.khxd.yklm.dto.AcrylicHistoryRecordDTO(")
            .append("orderDetail.ddbh, orderDetail.khxm, orderDetail.ddlx, orderDetail.ddly, orderDetail.scsl, orderDetail.gq, ")
            .append("acrylicDetail.je, acrylicDetail.hjsl, orderDetail.bz, acrylicDetail.yjdb, orderDetail.wgsj, ")
            .append("orderDetail.dz, orderDetail.dh, orderRecord.czr, orderRecord.czsj, acrylicDetail.bcmc, acrylicDetail.bcdj, ")
            .append("acrylicDetail.lsmc, acrylicDetail.lsdj, acrylicDetail.ys, acrylicDetail.hjpf, acrylicDetail.bcpf) ")
            .append("FROM OrderDetail orderDetail left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join AcrylicDetail acrylicDetail on acrylicDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderRecord.czlb = :orderNew ");
    map.put("orderNew", orderNew);
    Query query = entityManager.createQuery(jpql.append(queryCond).toString());
    map.forEach(query::setParameter);
    query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
    query.setMaxResults(pageable.getPageSize());
    @SuppressWarnings(value = "unchecked")
    List<AcrylicHistoryRecordDTO> list = query.getResultList();
    StringBuilder jpql2 = new StringBuilder("select count(*) ")
            .append("FROM OrderDetail orderDetail left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join AcrylicDetail acrylicDetail on acrylicDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderRecord.czlb = :orderNew ");
    Query query2 = entityManager.createQuery(jpql2.append(queryCond).toString());
    map.forEach(query2::setParameter);
    long total = (Long) query2.getSingleResult();
    return new PageImpl<>(list, pageable, total);
  }
}
