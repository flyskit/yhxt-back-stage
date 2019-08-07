package com.yhxt.khxd.jgm.dao;

import com.yhxt.khxd.jgm.entity.CupboardDoorDetailSize;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName CupboardDoorDetailSizeDao
 * @Author zqi
 * @Date 2019/6/23 18:21
 * @Version 1.0
 * @Description 关联：橱柜门尺寸信息、商品信息
 */
public interface CupboardDoorDetailSizeDao extends CrudRepository<CupboardDoorDetailSize, String> {
  /**
   * 根据门板id查询记录
   *
   * @param mbid 门板id
   * @return cupboardDoorDetailSize
   */
  List<CupboardDoorDetailSize> findByMbid(String mbid);

  /**
   * 根据门板ID标识查询记录
   *
   * @param mbid ID标识
   * @param zt   状态
   * @return lists
   */
  List<CupboardDoorDetailSize> findByMbidAndZt(String mbid, Boolean zt);

  /**
   * 根据尺寸id查询记录
   *
   * @param id ID标识
   * @param zt 状态
   * @return cupboardDoorDetailSize
   */
  CupboardDoorDetailSize findByCcidAndZt(String id, Boolean zt);
}
