package com.yhxt.khxd.yklm.dao.impl;

import com.yhxt.common.BaseStatus;
import com.yhxt.common.GoodsType;
import com.yhxt.ddcl.common.OrderRecordType;
import com.yhxt.ddcl.common.OrderStatus;
import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.yklm.dto.AcrylicHistoryRecordDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.HashMap;
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
    // 订单记录-新建状态
    Integer orderNew = OrderRecordType.NEW.getValue();
    // 保存查询条件
    Map<String, Object> map = new HashMap<>(10);
    StringBuilder jpql = new StringBuilder("select new com.yhxt.khxd.yklm.dto.AcrylicHistoryRecordDTO(")
            .append("orderDetail.ddbh, orderDetail.khxm, orderDetail.ddlx, orderDetail.ddly, orderDetail.scsl, orderDetail.gq, ")
            .append("acrylicDetail.je, acrylicDetail.hjsl, orderDetail.bz, acrylicDetail.yjdb, orderDetail.wgsj, ")
            .append("orderDetail.dz, orderDetail.dh, orderRecord.czr, orderRecord.czsj, acrylicDetail.bcmc, acrylicDetail.bcdj, ")
            .append("acrylicDetail.lsmc, acrylicDetail.lsdj, acrylicDetail.ys, acrylicDetail.hjpf, acrylicDetail.bcpf) ")
            .append("FROM OrderDetail orderDetail left join OrderGoods orderGoods on orderGoods.ddid = orderDetail.id ")
            .append("left join OrderRecord orderRecord on orderRecord.ddid = orderDetail.id ")
            .append("left join AcrylicDetail acrylicDetail on acrylicDetail.id = orderGoods.spid ")
            .append("WHERE 1=1 AND orderRecord.czlb = :orderNew ");
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
    map.put("orderNew", orderNew);
    queryCond.append("ORDER BY orderRecord.czsj desc ");
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
