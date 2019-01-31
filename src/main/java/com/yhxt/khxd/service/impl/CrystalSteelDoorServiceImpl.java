package com.yhxt.khxd.service.impl;

import com.yhxt.common.BaseMessage;
import com.yhxt.khxd.dao.CrystalSteelDoorOrderAndSizeDao;
import com.yhxt.khxd.dao.CrystalSteelDoorOrderDao;
import com.yhxt.khxd.dao.CrystalSteelDoorSizeDao;
import com.yhxt.khxd.entity.JGMCCXX;
import com.yhxt.khxd.entity.JGMXDXX;
import com.yhxt.khxd.entity.XDXXACCXX;
import com.yhxt.khxd.service.CrystalSteelDoorService;
import com.yhxt.khxd.vo.CrystalSteelDoorParamVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CrystalSteelDoorServiceImpl
 * @Author zqi
 * @Date 2019/1/17 11:44
 * @Version 1.0
 * @Description 晶钢门模块
 */
@Service
public class CrystalSteelDoorServiceImpl implements CrystalSteelDoorService {

  @Resource
  private CrystalSteelDoorOrderDao crystalSteelDoorOrderDao;

  @Resource
  private CrystalSteelDoorSizeDao crystalSteelDoorSizeDao;

  @Resource
  private CrystalSteelDoorOrderAndSizeDao crystalSteelDoorOrderAndSizeDao;

  /**
   * 添加
   *
   * @param crystalSteelDoorParamVO 参数
   * @return baseMessage 返回信息
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addData(CrystalSteelDoorParamVO crystalSteelDoorParamVO) {
    JGMXDXX jgmxdxx = crystalSteelDoorParamVO.getXdxx();
    JGMXDXX jgmxdxxNew = crystalSteelDoorOrderDao.save(jgmxdxx);
    if (jgmxdxxNew == null) {
      return BaseMessage.failed("添加下单信息失败！");
    }
    List<JGMCCXX> list = crystalSteelDoorParamVO.getCcxx();
    for (JGMCCXX jgmccxx : list) {
      JGMCCXX jgmccxxNew = crystalSteelDoorSizeDao.save(jgmccxx);
      if (jgmccxxNew == null) {
        return BaseMessage.failed("添加尺寸信息失败！");
      }
      XDXXACCXX xdxxaccxx = new XDXXACCXX();
      xdxxaccxx.setXdxxId(jgmxdxxNew.getId());
      xdxxaccxx.setCcxxId(jgmccxxNew.getId());
      XDXXACCXX xdxxaccxxNew = crystalSteelDoorOrderAndSizeDao.save(xdxxaccxx);
      if (xdxxaccxxNew == null) {
        return BaseMessage.failed("添加关联信息失败！");
      }
    }
    return BaseMessage.success();
  }
}
