package com.yhxt.khxd.tzm.dao;

import com.yhxt.khxd.tzm.entity.SuitDetailType;
import org.springframework.data.repository.CrudRepository;

import java.util.LinkedList;

/**
 * @ClassName SuitDetailTypeDao
 * @Author zqi
 * @Date 2019/7/17 10:35
 * @Version 1.0
 * @Description 套装门-基本统计信息表、尺寸类型关联
 */
public interface SuitDetailTypeDao extends CrudRepository<SuitDetailType, String> {

  /**
   * 根据门板ID查询记录
   *
   * @param mbid 门板ID
   * @param zt   状态
   * @return linkedList
   */
  LinkedList<SuitDetailType> findByMbidAndZt(String mbid, Boolean zt);
}
