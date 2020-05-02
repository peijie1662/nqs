package nbct.com.cn.customerquery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 单箱信息
 * 
 * @author PJ
 * @version 创建时间：2019年7月22日 下午3:16:46
 */
public class ContainerInfo {

  private String cntrId;

  private String lncd;

  private String ctsz;

  private String ctty;

  private String imvsvy;

  private String exvsvy;

  private String curvscd;

  private String curvsvy;

  private String curvsdr;

  private String intd;

  private String infe;

  private String inog;

  private String inth;

  private String inhz;

  private String indm;

  /**
   * 进场时间
   */
  private String inYardDt;

  /**
   * 出场时间
   */
  private String outYardDt;

  /**
   * 进港类型
   */
  private String inPortType;

  /**
   * 装卸港
   */
  private String port;

  /**
   * 堆存天数
   */
  private String storageDays;

  /**
   * 输单重量
   */
  private String weight;

  /**
   * 是否装船
   */
  private String loaded;

  /**
   * 海关放行
   */
  private String customRelease;

  /**
   * 码头放行
   */
  private String terminalRelease;

  /**
   * 提单号
   */
  private String cabl;

  private String caag;

  /**
   * VGM称重方式
   */
  private String weighingWayVGM;

  /**
   * VGM重量
   */
  private String weightVGM;

  /**
   * VGM签名
   */
  private String signVGM;

  public String getCntrId() {
    return cntrId;
  }

  public void setCntrId(String cntrId) {
    this.cntrId = cntrId;
  }

  public String getLncd() {
    return lncd;
  }

  public void setLncd(String lncd) {
    this.lncd = lncd;
  }

  public String getCtsz() {
    return ctsz;
  }

  public void setCtsz(String ctsz) {
    this.ctsz = ctsz;
  }

  public String getCtty() {
    return ctty;
  }

  public void setCtty(String ctty) {
    this.ctty = ctty;
  }

  public String getImvsvy() {
    return imvsvy;
  }

  public void setImvsvy(String imvsvy) {
    this.imvsvy = imvsvy;
  }

  public String getExvsvy() {
    return exvsvy;
  }

  public void setExvsvy(String exvsvy) {
    this.exvsvy = exvsvy;
  }

  public String getIntd() {
    return intd;
  }

  public void setIntd(String intd) {
    this.intd = intd;
  }

  public String getInfe() {
    return infe;
  }

  public void setInfe(String infe) {
    this.infe = infe;
  }

  public String getInog() {
    return inog;
  }

  public void setInog(String inog) {
    this.inog = inog;
  }

  public String getInth() {
    return inth;
  }

  public void setInth(String inth) {
    this.inth = inth;
  }

  public String getInhz() {
    return inhz;
  }

  public void setInhz(String inhz) {
    this.inhz = inhz;
  }

  public String getIndm() {
    return indm;
  }

  public void setIndm(String indm) {
    this.indm = indm;
  }

  public String getInYardDt() {
    return inYardDt;
  }

  public void setInYardDt(String inYardDt) {
    this.inYardDt = inYardDt;
  }

  public String getOutYardDt() {
    return outYardDt;
  }

  public void setOutYardDt(String outYardDt) {
    this.outYardDt = outYardDt;
  }

  public String getInPortType() {
    return inPortType;
  }

  public void setInPortType(String inPortType) {
    this.inPortType = inPortType;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getStorageDays() {
    return storageDays;
  }

  public void setStorageDays(String storageDays) {
    this.storageDays = storageDays;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getLoaded() {
    return loaded;
  }

  public void setLoaded(String loaded) {
    this.loaded = loaded;
  }

  public String getCustomRelease() {
    return customRelease;
  }

  public void setCustomRelease(String customRelease) {
    this.customRelease = customRelease;
  }

  public String getTerminalRelease() {
    return terminalRelease;
  }

  public void setTerminalRelease(String terminalRelease) {
    this.terminalRelease = terminalRelease;
  }

  public String getCabl() {
    return cabl;
  }

  public void setCabl(String cabl) {
    this.cabl = cabl;
  }

  public String getCaag() {
    return caag;
  }

  public void setCaag(String caag) {
    this.caag = caag;
  }

  public String getWeightVGM() {
    return weightVGM;
  }

  public void setWeightVGM(String weightVGM) {
    this.weightVGM = weightVGM;
  }

  public String getSignVGM() {
    return signVGM;
  }

  public void setSignVGM(String signVGM) {
    this.signVGM = signVGM;
  }

  public String getCurvscd() {
    return curvscd;
  }

  public void setCurvscd(String curvscd) {
    this.curvscd = curvscd;
  }

  public String getCurvsvy() {
    return curvsvy;
  }

  public void setCurvsvy(String curvsvy) {
    this.curvsvy = curvsvy;
  }

  public String getCurvsdr() {
    return curvsdr;
  }

  public void setCurvsdr(String curvsdr) {
    this.curvsdr = curvsdr;
  }

  public String getWeighingWayVGM() {
    return weighingWayVGM;
  }

  public void setWeighingWayVGM(String weighingWayVGM) {
    this.weighingWayVGM = weighingWayVGM;
  }

}
