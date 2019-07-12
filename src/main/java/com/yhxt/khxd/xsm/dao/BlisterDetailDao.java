package com.yhxt.khxd.xsm.dao;

import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.xsm.dto.BlisterHistoryRecordDTO;
import com.yhxt.khxd.xsm.entity.BlisterDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @ClassName BlisterDetailDao
 * @Author zqi
 * @Date 2019/7/12 14:25
 * @Version 1.0
 * @Description 吸塑门-基本信息
 */
public interface BlisterDetailDao extends CrudRepository<BlisterDetail, String> {
  /**
   * 今日已下单-记录查询
   *
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @return lists
   */
  List<BlisterHistoryRecordDTO> listDataToDay(Date startTime, Date endTime);

  /**
   * 暂存列表-查询记录
   *
   * @return lists
   */
  List<BlisterHistoryRecordDTO> listDataTemporary();

  /**
   * 根据ID标识查询记录
   *
   * @param id id标识
   * @return blisterDetail
   */
  BlisterDetail findById(String id);

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 查询条件
   * @param pageable          分页信息
   * @return pages
   */
  Page<BlisterHistoryRecordDTO> condData(OrderQueryParamVO orderQueryParamVO, Pageable pageable);
}
