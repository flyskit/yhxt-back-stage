package com.yhxt.khxd.xsm.dao;

import com.yhxt.khxd.xsm.entity.BlisterSize;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName BlisterSizeDao
 * @Author zqi
 * @Date 2019/7/12 14:26
 * @Version 1.0
 * @Description 吸塑门-尺寸
 */
public interface BlisterSizeDao extends CrudRepository<BlisterSize, String> {

  /**
   * 根据id查询记录
   *
   * @param id id标识
   * @return blisterSize
   */
  BlisterSize findById(String id);
}
