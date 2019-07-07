package com.yhxt.sjgl.dao;

import com.yhxt.sjgl.entity.BoardPriceDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName BoardPriceDetailDao
 * @Author zqi
 * @Date 2019/7/4 14:33
 * @Version 1.0
 * @Description 材质报价
 */
public interface BoardPriceDetailDao extends CrudRepository<BoardPriceDetail, String> {
  /**
   * 根据名称、编号、商品类型查询记录
   *
   * @param mc   板材名称
   * @param bh   编号
   * @param splx 商品类型
   * @param zt   状态
   * @return boardPriceDetail
   */
  BoardPriceDetail findBySplxAndZtAndMcOrBh(Integer splx, Boolean zt, String mc, String bh);

  /**
   * 根据ID标识和状态查询记录
   *
   * @param id id标识
   * @param zt 状态
   * @return boardPriceDetail
   */
  BoardPriceDetail findByIdAndZt(String id, Boolean zt);

  /**
   * 根据商品类型查询记录
   *
   * @param splx 商品类型
   * @param zt   状态
   * @return list
   */
  List<BoardPriceDetail> findBySplxAndZt(Integer splx, Boolean zt);
}
