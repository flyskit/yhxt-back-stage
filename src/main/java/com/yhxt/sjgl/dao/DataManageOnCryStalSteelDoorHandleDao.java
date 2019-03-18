package com.yhxt.sjgl.dao;

import com.yhxt.sjgl.entity.JGMLSXX;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName DataManageOnCryStalSteelDoorHandle
 * @Author zqi
 * @Date 2019/3/18 9:41
 * @Version 1.0
 * @Description 数据管理-晶钢门拉手信息
 */
public interface DataManageOnCryStalSteelDoorHandleDao extends CrudRepository<JGMLSXX, String> {
  /**
   * 根据编号查找尺寸信息
   *
   * @param bh 编号
   * @return jgmlsxx 晶钢门拉手信息
   */
  JGMLSXX findByBh(Integer bh);
}
