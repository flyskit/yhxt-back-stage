package com.yhxt.sjgl.service.impl;

import com.yhxt.common.BaseMessage;
import com.yhxt.common.BaseStatus;
import com.yhxt.ddcl.dao.OrderAccessoryDao;
import com.yhxt.ddcl.dao.OrderDetailDao;
import com.yhxt.sjgl.dao.AccessoryDetailDao;
import com.yhxt.sjgl.dao.BoardPriceDetailDao;
import com.yhxt.sjgl.dao.CustomerDetailDao;
import com.yhxt.sjgl.dao.DoorHandleDetailDao;
import com.yhxt.sjgl.entity.AccessoryDetail;
import com.yhxt.sjgl.entity.BoardPriceDetail;
import com.yhxt.sjgl.entity.CustomerDetail;
import com.yhxt.sjgl.entity.DoorHandleDetail;
import com.yhxt.sjgl.service.DataManageService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DataManageServiceImpl
 * @Author zqi
 * @Date 2019/6/24 10:58
 * @Version 1.0
 * @Description 数据管理
 */
@Service
public class DataManageServiceImpl implements DataManageService {

  @Resource
  private OrderAccessoryDao orderAccessoryDao;

  @Resource
  private OrderDetailDao orderDetailDao;

  @Resource
  private DoorHandleDetailDao doorHandleDetailDao;

  @Resource
  private CustomerDetailDao customerDetailDao;

  @Resource
  private AccessoryDetailDao accessoryDetailDao;

  @Resource
  private BoardPriceDetailDao boardPriceDetailDao;

  private static Logger logger = Logger.getLogger(DataManageServiceImpl.class);

  /**
   * 添加拉手
   *
   * @param doorHandleDetail 拉手信息
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addHandle(DoorHandleDetail doorHandleDetail) {
    try {
      DoorHandleDetail doorHandleDetailOdd = doorHandleDetailDao.findByMcAndLxAndZt(doorHandleDetail.getMc(), doorHandleDetail.getLx(), BaseStatus.VALID.getValue());
      if (!StringUtils.isEmpty(doorHandleDetailOdd)) {
        return BaseMessage.failed("拉手名称已存在！");
      }
      doorHandleDetail.setZt(BaseStatus.VALID.getValue());
      doorHandleDetailDao.save(doorHandleDetail);
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 修改拉手信息
   *
   * @param doorHandleDetail 拉手信息
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage updateHandle(DoorHandleDetail doorHandleDetail) {
    try {
      DoorHandleDetail doorHandleDetailOdd = doorHandleDetailDao.findByIdAndZt(doorHandleDetail.getId(), BaseStatus.VALID.getValue());
      if (StringUtils.isEmpty(doorHandleDetailOdd)) {
        return BaseMessage.failed("无此记录！");
      }
      doorHandleDetailDao.save(doorHandleDetail);
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 删除拉手
   *
   * @param id id标识
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage delHandle(String id) {
    try {
      DoorHandleDetail doorHandleDetail = doorHandleDetailDao.findByIdAndZt(id, BaseStatus.VALID.getValue());
      if (StringUtils.isEmpty(doorHandleDetail)) {
        return BaseMessage.failed("无此记录！");
      }
      doorHandleDetail.setZt(BaseStatus.INVALID.getValue());
      doorHandleDetailDao.save(doorHandleDetail);
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 获取拉手列表
   *
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getHandleByType(Integer handleType) {
    List<DoorHandleDetail> list = doorHandleDetailDao.findByLxAndZt(handleType, BaseStatus.VALID.getValue());
    return BaseMessage.success().add(list);
  }

  /**
   * 根据客户姓名模糊查询客户
   *
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getCustomerByName(String customerName) {
    List<CustomerDetail> list = customerDetailDao.getCustomerByName(customerName);
    return BaseMessage.success().add(list);
  }

  /**
   * 添加配件
   *
   * @param accessoryDetail 配件信息
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addAccessory(AccessoryDetail accessoryDetail) {
    try {
      AccessoryDetail accessoryDetailOdd = accessoryDetailDao.findByMcOrBhAndZt(accessoryDetail.getMc(), accessoryDetail.getBh(), BaseStatus.VALID.getValue());
      if (!StringUtils.isEmpty(accessoryDetailOdd)) {
        return BaseMessage.failed("拉手名称已存在！");
      }
      accessoryDetail.setZt(BaseStatus.VALID.getValue());
      accessoryDetailDao.save(accessoryDetail);
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 修改配件信息
   *
   * @param accessoryDetail 拉手信息
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage updateAccessory(AccessoryDetail accessoryDetail) {
    try {
      AccessoryDetail accessoryDetailOdd = accessoryDetailDao.findByMcOrBhAndZt(accessoryDetail.getId(), accessoryDetail.getBh(), BaseStatus.VALID.getValue());
      if (StringUtils.isEmpty(accessoryDetailOdd)) {
        return BaseMessage.failed("无此记录！");
      }
      accessoryDetailDao.save(accessoryDetail);
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }


  /**
   * 删除配件
   *
   * @param id id标识
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage delAccessory(String id) {
    try {
      AccessoryDetail accessoryDetail = accessoryDetailDao.findById(id);
      if (StringUtils.isEmpty(accessoryDetail)) {
        return BaseMessage.failed("未找到记录！");
      }
      accessoryDetail.setZt(BaseStatus.INVALID.getValue());
      accessoryDetailDao.save(accessoryDetail);
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 根据配件名模糊查询配件列表
   *
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getAccessoryByName(String accessoryName) {
    List<AccessoryDetail> list = accessoryDetailDao.getAccessoryByName(accessoryName);
    return BaseMessage.success().add(list);
  }

  /**
   * 板材报价管理-添加报价
   *
   * @param boardPriceDetail 材料信息
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage addBoardPriceDetail(BoardPriceDetail boardPriceDetail) {
    try {
      BoardPriceDetail boardPriceDetailOdd = boardPriceDetailDao.findBySplxAndZtAndMcOrBh(boardPriceDetail.getSplx(), BaseStatus.VALID.getValue(), boardPriceDetail.getMc(), boardPriceDetail.getBh());
      if (!StringUtils.isEmpty(boardPriceDetailOdd)) {
        return BaseMessage.failed("材料名称或者编号已存在！");
      }
      boardPriceDetail.setZt(BaseStatus.VALID.getValue());
      boardPriceDetailDao.save(boardPriceDetail);
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 修改拉手信息
   *
   * @param boardPriceDetail 报价信息
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage updateBoardPriceDetail(BoardPriceDetail boardPriceDetail) {
    try {
      BoardPriceDetail boardPriceDetailOdd = boardPriceDetailDao.findByIdAndZt(boardPriceDetail.getId(), BaseStatus.VALID.getValue());
      if (StringUtils.isEmpty(boardPriceDetailOdd)) {
        return BaseMessage.failed("无此记录！");
      }
      boardPriceDetailDao.save(boardPriceDetail);
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 删除拉手
   *
   * @param id id标识
   * @return baseMessage
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public BaseMessage delBoardPriceDetail(String id) {
    try {
      BoardPriceDetail boardPriceDetail = boardPriceDetailDao.findByIdAndZt(id, BaseStatus.VALID.getValue());
      if (StringUtils.isEmpty(boardPriceDetail)) {
        return BaseMessage.failed("无此记录！");
      }
      boardPriceDetail.setZt(BaseStatus.INVALID.getValue());
      boardPriceDetailDao.save(boardPriceDetail);
      return BaseMessage.success();
    } catch (Exception e) {
      logger.error(e);
      return BaseMessage.failed();
    }
  }

  /**
   * 获取拉手列表
   *
   * @param splx 商品类型
   * @return baseMessage
   */
  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public BaseMessage getBoardPriceDetailByGoodsType(Integer splx) {
    List<BoardPriceDetail> list = boardPriceDetailDao.findBySplxAndZt(splx, BaseStatus.VALID.getValue());
    return BaseMessage.success().add(list);
  }
}
