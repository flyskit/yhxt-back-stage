package com.yhxt.khxd.yklm.dao;

import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.yklm.dto.AcrylicHistoryRecordDTO;
import com.yhxt.khxd.yklm.entity.AcrylicDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @ClassName AcrylicDetailDao
 * @Author zqi
 * @Date 2019/7/3 15:03
 * @Version 1.0
 * @Description 亚克力-详细信息
 */
public interface AcrylicDetailDao extends CrudRepository<AcrylicDetail, String> {

  /**
   * 根据id查询信息
   *
   * @param id id标识
   * @return acrylicDetail
   */
  AcrylicDetail findById(String id);

  /**
   * 今日已下单-查询记录
   *
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @return
   */
  List<AcrylicHistoryRecordDTO> getDataByToDay(Date startTime, Date endTime);

  /**
   * 暂存订单-查询
   *
   * @return lists
   */
  List<AcrylicHistoryRecordDTO> getDataByTemporary();

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 查询条件
   * @param pageable          分页信息
   * @return page
   */
  Page<AcrylicHistoryRecordDTO> condData(OrderQueryParamVO orderQueryParamVO, Pageable pageable);
}
