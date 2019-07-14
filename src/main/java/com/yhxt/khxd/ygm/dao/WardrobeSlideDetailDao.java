package com.yhxt.khxd.ygm.dao;

import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.ygm.dto.WardrobeSlideHistoryRecordDTO;
import com.yhxt.khxd.ygm.entity.WardrobeSlideDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @ClassName WardrobeSlideDetailDao
 * @Author zqi
 * @Date 2019/7/13 15:08
 * @Version 1.0
 * @Description 衣柜移门-基本信息
 */
public interface WardrobeSlideDetailDao extends CrudRepository<WardrobeSlideDetail, String> {

  /**
   * 今日已下单-查询记录
   *
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @return lists
   */
  List<WardrobeSlideHistoryRecordDTO> listDataToDay(Date startTime, Date endTime);

  /**
   * 暂存列表-查询记录
   *
   * @return lists
   */
  List<WardrobeSlideHistoryRecordDTO> listDataTemporary();

  /**
   * 根据id查询记录
   *
   * @param id ID标识
   * @return wardrobeSlideDetail
   */
  WardrobeSlideDetail findById(String id);

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 查询条件
   * @param pageable          分页信息
   * @return pages
   */
  Page<WardrobeSlideHistoryRecordDTO> condData(OrderQueryParamVO orderQueryParamVO, Pageable pageable);
}
