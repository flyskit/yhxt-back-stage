package com.yhxt.khxd.thjm.vo;

import com.yhxt.ddcl.vo.OrderAddDataBaseParamVO;
import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorSwingSize;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * @ClassName TitaniumAlloyDoorSwingAddParamVO
 * @Author zqi
 * @Date 2019/7/9 13:51
 * @Version 1.0
 * @Description 钛合金-平开门-添加订单字段
 */
public class TitaniumAlloyDoorSwingAddParamVO extends OrderAddDataBaseParamVO {

  /**
   * 合计平方
   */
  private BigDecimal hjpf;

  /**
   * 合计数量
   */
  private Integer hjsl;

  /**
   * 合计金额
   */
  private BigDecimal hjje;

  /**
   * 预计打包
   */
  private Integer yjdb;

  /**
   * 尺寸信息
   */
  private LinkedList<TitaniumAlloyDoorSwingSize> swingSizes;

  public TitaniumAlloyDoorSwingAddParamVO() {
  }

  public TitaniumAlloyDoorSwingAddParamVO(String ddbh, Integer ddly, Integer ddlx, Integer scsl, Integer gq, String khxm, String dz, String dh, String bz, Integer ddzt, BigDecimal hjpf, Integer hjsl, BigDecimal hjje, Integer yjdb, LinkedList<TitaniumAlloyDoorSwingSize> swingSizes) {
    super(ddbh, ddly, ddlx, scsl, gq, khxm, dz, dh, bz, ddzt);
    this.hjpf = hjpf;
    this.hjsl = hjsl;
    this.hjje = hjje;
    this.yjdb = yjdb;
    this.swingSizes = swingSizes;
  }

  public BigDecimal getHjpf() {
    return hjpf;
  }

  public void setHjpf(BigDecimal hjpf) {
    this.hjpf = hjpf;
  }

  public Integer getHjsl() {
    return hjsl;
  }

  public void setHjsl(Integer hjsl) {
    this.hjsl = hjsl;
  }

  public BigDecimal getHjje() {
    return hjje;
  }

  public void setHjje(BigDecimal hjje) {
    this.hjje = hjje;
  }

  public Integer getYjdb() {
    return yjdb;
  }

  public void setYjdb(Integer yjdb) {
    this.yjdb = yjdb;
  }

  public LinkedList<TitaniumAlloyDoorSwingSize> getSwingSizes() {
    return swingSizes;
  }

  public void setSwingSizes(LinkedList<TitaniumAlloyDoorSwingSize> swingSizes) {
    this.swingSizes = swingSizes;
  }

  @Override
  public String toString() {
    return "TitaniumAlloyDoorSwingAddParamVO{" +
            "hjpf=" + hjpf +
            ", hjsl=" + hjsl +
            ", hjje=" + hjje +
            ", yjdb=" + yjdb +
            ", swingSizes=" + swingSizes +
            '}';
  }
}
