package com.yhxt.khxd.thjm.dao;

import com.yhxt.ddcl.vo.OrderQueryParamVO;
import com.yhxt.khxd.thjm.dto.TitaniumAlloyHistoryRecordDTO;
import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @ClassName TitaniumAlloyDoorDetail
 * @Author zqi
 * @Date 2019/7/9 13:07
 * @Version 1.0
 * @Description 钛合金门-基本信息
 */
public interface TitaniumAlloyDoorDetailDao extends CrudRepository<TitaniumAlloyDoorDetail, String> {
  /**
   * 根据id查询记录
   *
   * @param id id标识
   * @return titaniumAlloyDoorDetail
   */
  TitaniumAlloyDoorDetail findById(String id);

  /**
   * 今日已下单-查询记录
   *
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @return lists
   */
  List<TitaniumAlloyHistoryRecordDTO> getDataByToDay(Date startTime, Date endTime);

  /**
   * 暂存列表-查询记录
   *
   * @return list
   */
  List<TitaniumAlloyHistoryRecordDTO> getDataByTemporary();

  /**
   * 条件查询
   *
   * @param orderQueryParamVO 查询条件
   * @param pageable          分页信息
   * @return page
   */
  Page<TitaniumAlloyHistoryRecordDTO> condData(OrderQueryParamVO orderQueryParamVO, Pageable pageable);
}
