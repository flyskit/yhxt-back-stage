package com.yhxt.khxd.thjm.dao;

import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorDetailSize;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName TitaniumAlloyDoorDetailSizeDao
 * @Author zqi
 * @Date 2019/7/9 13:31
 * @Version 1.0
 * @Description 钛合金门-基本信息、尺寸关联表
 */
public interface TitaniumAlloyDoorDetailSizeDao extends CrudRepository<TitaniumAlloyDoorDetailSize, String> {

  /**
   * 根据统计id查找记录
   *
   * @param tjid 统计id标识
   * @return lists
   */
  List<TitaniumAlloyDoorDetailSize> findByTjid(String tjid);
}
