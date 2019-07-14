package com.yhxt.khxd.ygm.dao;

import com.yhxt.khxd.ygm.entity.WardrobeSlideSize;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName WardrobeSlideSizeDao
 * @Author zqi
 * @Date 2019/7/13 15:17
 * @Version 1.0
 * @Description 衣柜门-尺寸信息
 */
public interface WardrobeSlideSizeDao extends CrudRepository<WardrobeSlideSize, String> {

  /**
   * 根据ID标识查询记录
   *
   * @param id id标识
   * @return wardrobeSlideSize
   */
  WardrobeSlideSize findById(String id);
}
