package com.yhxt.khxd.thjm.dao;

import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorSwingSize;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName TitaniumAlloyDoorSwingSizeDao
 * @Author zqi
 * @Date 2019/7/9 13:42
 * @Version 1.0
 * @Description 钛合金-平开门
 */
public interface TitaniumAlloyDoorSwingSizeDao extends CrudRepository<TitaniumAlloyDoorSwingSize, String> {

  /**
   * 根据id查询记录
   *
   * @param id id标识
   * @return titaniumAlloyDoorSwingSize
   */
  TitaniumAlloyDoorSwingSize findById(String id);
}
