package com.yhxt.sjgl.dao;

import com.yhxt.sjgl.entity.DoorHandleDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName DoorHandleDetailDao
 * @Author zqi
 * @Date 2019/6/24 11:06
 * @Version 1.0
 * @Description 拉手信息
 */
public interface DoorHandleDetailDao extends CrudRepository<DoorHandleDetail, String> {
  /**
   * 根据类型获取拉手
   *
   * @param handleType 类型
   * @param zt         状态
   * @return list
   */
  List<DoorHandleDetail> findByLxAndZt(Integer handleType, Boolean zt);

  /**
   * 条件查询信息
   *
   * @param mc 名称
   * @param lx 类型
   * @param zt 状态
   * @return doorHandleDetail
   */
  DoorHandleDetail findByMcAndLxAndZt(String mc, Integer lx, Boolean zt);

  /**
   * 根据id查询记录
   *
   * @param id id标识
   * @param zt 状态
   * @return doorHandleDetail
   */
  DoorHandleDetail findByIdAndZt(String id, Boolean zt);
}
