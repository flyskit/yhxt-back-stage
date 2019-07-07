package com.yhxt.sjgl.dao;

import com.yhxt.sjgl.entity.AccessoryDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName AccessoryDetailDao
 * @Author zqi
 * @Date 2019/6/29 14:57
 * @Version 1.0
 * @Description 配件管理
 */
public interface AccessoryDetailDao extends CrudRepository<AccessoryDetail, String> {

  /**
   * 根据编号查询配件
   *
   * @param bh 编号
   * @return accessoryDetail
   */
  AccessoryDetail findByBh(String bh);

  /**
   * 根据配件名模糊查询配件列表
   *
   * @param accessoryName 配件名称
   * @return list
   */
  List<AccessoryDetail> getAccessoryByName(String accessoryName);

  /**
   * 根据名称、编号查询记录
   *
   * @param mc 名称
   * @param bh 编号
   * @param zt 记录状态
   * @return accessoryDetail
   */
  AccessoryDetail findByMcOrBhAndZt(String mc, String bh, Boolean zt);

  /**
   * 根据ID查询记录
   *
   * @param id id标识
   * @return accessoryDetail
   */
  AccessoryDetail findById(String id);
}
