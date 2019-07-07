package com.yhxt.khxd.jgm.dao;

import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.jgm.dto.HistoryRecordDTO;
import com.yhxt.khxd.jgm.entity.CrystalSteelDoorDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CrystalSteelDoorDetailDao
 * @Author zqi
 * @Date 2019/6/23 18:10
 * @Version 1.0
 * @Description 晶钢门统计信息
 */
public interface CrystalSteelDoorDetailDao extends CrudRepository<CrystalSteelDoorDetail, String> {
  /**
   * 查询今日已下单
   *
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @return list
   */
  List<HistoryRecordDTO> getDataByToDay(Date startTime, Date endTime);

  /**
   * 查询暂存订单列表
   *
   * @return list
   */
  List<HistoryRecordDTO> getDataByTemporary();

  /**
   * 根据ID查询记录
   *
   * @param id id标识
   * @return crystalSteelDoorDetail
   */
  CrystalSteelDoorDetail findById(String id);

  /**
   * 条件查询记录
   *
   * @param orderQueryParamVO 查询条件
   * @param pageable          分页信息
   * @return page
   */
  Page<HistoryRecordDTO> condData(OrderQueryParamVO orderQueryParamVO, Pageable pageable);
}
