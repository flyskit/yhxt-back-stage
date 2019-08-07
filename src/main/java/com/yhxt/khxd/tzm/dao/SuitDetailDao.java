package com.yhxt.khxd.tzm.dao;

import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.tzm.dto.SuitHistoryRecordDTO;
import com.yhxt.khxd.tzm.entity.SuitDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @ClassName SuitDetailDao
 * @Author zqi
 * @Date 2019/7/17 10:34
 * @Version 1.0
 * @Description 套装门-基本统计信息
 */
public interface SuitDetailDao extends CrudRepository<SuitDetail, String> {

  /**
   * 根据ID标识查询记录
   *
   * @param id ID标识
   * @return suitDetail
   */
  SuitDetail findById(String id);

  /**
   * 今日已下单-记录查询
   *
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @return lists
   */
  List<SuitHistoryRecordDTO> listDataToDay(Date startTime, Date endTime);

  /**
   * 暂存列表-记录查询
   *
   * @return lists
   */
  List<SuitHistoryRecordDTO> listDataTemporary();

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 查询条件
   * @param pageable          分页信息
   * @return page
   */
  Page<SuitHistoryRecordDTO> condData(OrderQueryParamVO orderQueryParamVO, Pageable pageable);
}
