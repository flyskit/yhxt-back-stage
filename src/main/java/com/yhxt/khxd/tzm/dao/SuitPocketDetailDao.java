package com.yhxt.khxd.tzm.dao;

import com.yhxt.khxd.tzm.entity.SuitPocketDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName SuitPockedDetailDao
 * @Author zqi
 * @Date 2019/7/17 10:39
 * @Version 1.0
 * @Description 套装门-空套尺寸信息
 */
public interface SuitPocketDetailDao extends CrudRepository<SuitPocketDetail, String> {

  /**
   * 根据ID查询记录
   *
   * @param id id标识
   * @return suitPocketDetail
   */
  SuitPocketDetail findById(String id);
}
