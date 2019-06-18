package com.yhxt.khxd.jgm.dao;

import com.yhxt.khxd.jgm.entity.JGMXDXX;
import com.yhxt.khxd.jgm.vo.CrystalSteelDoorFindParamVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CrystalSteelDoorDao
 * @Author zqi
 * @Date 2019/1/17 11:45
 * @Version 1.0
 * @Description 晶钢门模块
 */
public interface CrystalSteelDoorOrderDao extends CrudRepository<JGMXDXX, String> {
  /**
   * 获取编号-排序后获取最新一条记录
   *
   * @return jgmxdxx 信息
   */
  JGMXDXX findFirstByOrderByBhDesc();

  /**
   * 根据编号查找记录
   *
   * @param bh 编号
   * @return jgmxdxx
   */
  JGMXDXX findByBh(String bh);

  /**
   * 根据状态查询今日已下单
   *
   * @param zt        状态
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @return list
   */
  List<JGMXDXX> findByZtAndCjsjBetweenOrderByCjsjDesc(Integer zt, Date startTime, Date endTime);

  /**
   * 根据订单状态查询记录
   *
   * @param zt 状态
   * @return list
   */
  List<JGMXDXX> findByZtOrderByCjsjDesc(Integer zt);

  /**
   * 历史记录-条件查询
   *
   * @param crystalSteelDoorFindParamVO 查询条件
   * @param pageable                    分页条件
   * @return page
   */
  Page<JGMXDXX> pageDataByCond(CrystalSteelDoorFindParamVO crystalSteelDoorFindParamVO, Pageable pageable);
}
