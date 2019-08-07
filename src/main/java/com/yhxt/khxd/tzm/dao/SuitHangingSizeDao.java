package com.yhxt.khxd.tzm.dao;

import com.yhxt.khxd.tzm.entity.SuitHangingSize;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName SuitHangingSizeDao
 * @Author zqi
 * @Date 2019/7/17 10:38
 * @Version 1.0
 * @Description 套装门-推门尺寸信息
 */
public interface SuitHangingSizeDao extends CrudRepository<SuitHangingSize, String> {

  /**
   * 根据ID查询记录
   *
   * @param id id标识
   * @return suitHangingSize
   */
  SuitHangingSize findById(String id);
}
