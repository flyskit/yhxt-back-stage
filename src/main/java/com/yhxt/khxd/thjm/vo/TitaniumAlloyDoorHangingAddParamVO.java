package com.yhxt.khxd.thjm.vo;

import com.yhxt.ddcl.vo.OrderAddDataBaseParamVO;
import com.yhxt.khxd.thjm.entity.TitaniumAlloyDoorHangingSize;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * @ClassName TitaniumAlloyDoorHangingAddParamVO
 * @Author zqi
 * @Date 2019/7/9 13:57
 * @Version 1.0
 * @Description 钛合金-吊趟门-添加订单字段
 */
public class TitaniumAlloyDoorHangingAddParamVO extends OrderAddDataBaseParamVO {

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
  private LinkedList<TitaniumAlloyDoorHangingSize> hangingSizes;

  public TitaniumAlloyDoorHangingAddParamVO() {
  }

  public TitaniumAlloyDoorHangingAddParamVO(String ddbh, Integer ddly, Integer ddlx, Integer scsl, Integer gq, String khxm, String dz, String dh, String bz, Integer ddzt, BigDecimal hjpf, Integer hjsl, BigDecimal hjje, Integer yjdb, LinkedList<TitaniumAlloyDoorHangingSize> hangingSizes) {
    super(ddbh, ddly, ddlx, scsl, gq, khxm, dz, dh, bz, ddzt);
    this.hjpf = hjpf;
    this.hjsl = hjsl;
    this.hjje = hjje;
    this.yjdb = yjdb;
    this.hangingSizes = hangingSizes;
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

  public LinkedList<TitaniumAlloyDoorHangingSize> getHangingSizes() {
    return hangingSizes;
  }

  public void setHangingSizes(LinkedList<TitaniumAlloyDoorHangingSize> hangingSizes) {
    this.hangingSizes = hangingSizes;
  }

  @Override
  public String toString() {
    return "TitaniumAlloyDoorHangingAddParamVO{" +
            "hjpf=" + hjpf +
            ", hjsl=" + hjsl +
            ", hjje=" + hjje +
            ", yjdb=" + yjdb +
            ", hangingSizes=" + hangingSizes +
            '}';
  }
}
