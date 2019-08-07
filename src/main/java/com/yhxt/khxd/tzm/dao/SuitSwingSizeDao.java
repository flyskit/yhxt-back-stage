package com.yhxt.khxd.tzm.dao;

import com.yhxt.khxd.tzm.entity.SuitSwingSize;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName SuitSwingSizeDao
 * @Author zqi
 * @Date 2019/7/17 10:37
 * @Version 1.0
 * @Description 套装门-平开门尺寸信息
 */
public interface SuitSwingSizeDao extends CrudRepository<SuitSwingSize, String> {

  /**
   * 根据ID查询记录
   *
   * @param id id标识
   * @return suitSwingSize
   */
  SuitSwingSize findById(String id);
}
