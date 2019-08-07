package com.yhxt.khxd.tzm.dao;

import com.yhxt.khxd.tzm.entity.SuitLineDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName SuitLineDetailDao
 * @Author zqi
 * @Date 2019/7/17 10:39
 * @Version 1.0
 * @Description 套装门-线条-基本信息
 */
public interface SuitLineDetailDao extends CrudRepository<SuitLineDetail, String> {

  /**
   * 根据Id查询记录
   *
   * @param id ID标识
   * @return suitLineDetail
   */
  SuitLineDetail findById(String id);
}
