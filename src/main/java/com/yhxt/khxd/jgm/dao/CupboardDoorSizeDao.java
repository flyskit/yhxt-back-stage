package com.yhxt.khxd.jgm.dao;

import com.yhxt.khxd.jgm.entity.CupboardDoorSize;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName CupboardDoorSizeDao
 * @Author zqi
 * @Date 2019/6/23 18:18
 * @Version 1.0
 * @Description 橱柜门尺寸信息
 */
public interface CupboardDoorSizeDao extends CrudRepository<CupboardDoorSize, String> {
  /**
   * 根据id查询记录
   *
   * @param id id标识
   * @return cupboardDoordSize
   */
  CupboardDoorSize findById(String id);
}
