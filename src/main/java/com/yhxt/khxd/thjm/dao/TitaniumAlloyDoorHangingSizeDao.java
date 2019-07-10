package com.yhxt.khxd.thjm.dao;

import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorHangingSize;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName TitaniumAlloyDoorHangingSizeDao
 * @Author zqi
 * @Date 2019/7/9 13:37
 * @Version 1.0
 * @Description 钛合金-吊趟门
 */
public interface TitaniumAlloyDoorHangingSizeDao extends CrudRepository<TitaniumAlloyDoorHangingSize, String> {

  /**
   * 根据id查询记录
   *
   * @param ccid id标识
   * @return titaniumAlloyDoorHangingSize
   */
  TitaniumAlloyDoorHangingSize findById(String ccid);
}
