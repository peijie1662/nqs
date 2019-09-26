package nbct.com.cn.customerquery.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class EfinReport {
  private String fnPyCocd;// 货代代码

  private String inTd;// 内外贸标记

  private String inVa;// 是否有效(Y/N;有效/无效)

  private String dtBg;// 开始时间8位

  private String dtEd;// 结束时间8位

  private String userId;// 用户ID

  private String dttr;// 操作日期

  private String tmtr;// 操作时间

  private String inIE;// I:提箱出门;E:装船出口

  private String fileType;// 文件类型

  private String skey;// 文件编号

  public JSONObject ignoreProtectionFields() {
    String origin = JSON.toJSONString(this);
    return JSON.parseObject(origin, JSONObject.class);
  }

  public String getFnPyCocd() {
    return fnPyCocd;
  }

  public void setFnPyCocd(String fnPyCocd) {
    this.fnPyCocd = fnPyCocd.trim();
  }

  public String getInTd() {
    return inTd;
  }

  public void setInTd(String inTd) {
    this.inTd = inTd;
  }

  public String getInVa() {
    return inVa;
  }

  public void setInVa(String inVa) {
    this.inVa = inVa;
  }

  public String getDtBg() {
    return dtBg;
  }

  public void setDtBg(String dtBg) {
    this.dtBg = dtBg;
  }

  public String getDtEd() {
    return dtEd;
  }

  public void setDtEd(String dtEd) {
    this.dtEd = dtEd;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getDttr() {
    return dttr;
  }

  public void setDttr(String dttr) {
    this.dttr = dttr;
  }

  public String getTmtr() {
    return tmtr;
  }

  public void setTmtr(String tmtr) {
    this.tmtr = tmtr;
  }

  public String getInIE() {
    return inIE;
  }

  public void setInIE(String inIE) {
    this.inIE = inIE;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType.trim();
  }

  public String getSkey() {
    return skey;
  }

  public void setSkey(String skey) {
    this.skey = skey;
  }

  public String getFileName() {
    return this.fnPyCocd + "-" + this.getInIECN() + "(" + this.dtBg + "-" + this.dtEd + ")." + this.fileType;
  }

  private String getInIECN() {

    if ("K".equals(this.inIE)) {
      return "应收账款 ";
    }
    if ("I".equals(this.inIE)) {
      return "对账单(I)";
    }
    if ("E".equals(this.inIE)) {
      return "对账单(E)";
    }
    return "";
  }

  public void setFileName(String fileName) {
  }

}
