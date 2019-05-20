package com.yhxt.khxd.jgm.dao;

import com.yhxt.khxd.jgm.entity.XDXXACCXX;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName CrystalSteelDoorOrderAndSizeDao
 * @Author zqi
 * @Date 2019/1/18 16:16
 * @Version 1.0
 * @Description
 */
public interface CrystalSteelDoorOrderAndSizeDao extends CrudRepository<XDXXACCXX, String> {
  /**
   * 根据下单信息ID查找所有记录
   *
   * @param id 下单信息ID
   * @return list
   */
  List<XDXXACCXX> findByXdxxId(String id);
}
