package nbct.com.cn.customerquery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @ Author     ：lsh
 * @ Date       ：Created in 2019-09-21 12:46
 * @ Description：提单信息实体类
 * @ Modified By：
 * @Version: 1.0
 */
public class BLInfo {
    private String vscd;
    private String vsvy;
    private String vsdr;

    @JsonIgnore
    private String ctpf;
    @JsonIgnore
    private int ctnr;
    @JsonIgnore
    private String ctck;

    private String cntrId;//箱号

    private String lncd;//箱主
    private String caag;//货代

    private String ctsz;//箱尺寸
    private String ctty;//箱类型

    private String cabl;//提单号
    private String ctsn;//铅封号

    private String cacd;//货类
    private String cacm;//箱内某一票货的体积CARGO CUBIC MEASUREMET (CUBIC METRES
    private String capq;//箱内某一票货的件数CARGO PIECE COUNT (NUMBER OF  PACKAGES)
    private String cawt;//箱内某一票货的毛重
    private String cadp;//货物描述

    private String infe;//空重
    private String inhz;//危品
    private String inth;//冷藏
    private String inog;//超限
    private String intd;//内外贸标志
    private String ints;//中转标志

    //中文转换----begin
    private String cninfe;//中文-空重拼
    private String cninhz;//中文-危品-是否
    private String cninth;//中文-温控-是否
    private String cninog;//中文-超限-是否
    private String cnintd;//中文-内外贸-内贸/外贸
    //中文转换----end

    public String getVscd() {
        return vscd;
    }

    public void setVscd(String vscd) {
        this.vscd = vscd;
    }

    public String getVsvy() {
        return vsvy;
    }

    public void setVsvy(String vsvy) {
        this.vsvy = vsvy;
    }

    public String getVsdr() {
        return vsdr;
    }

    public void setVsdr(String vsdr) {
        this.vsdr = vsdr;
    }

    public String getCtpf() {
        return ctpf;
    }

    public void setCtpf(String ctpf) {
        this.ctpf = ctpf;
    }

    public int getCtnr() {
        return ctnr;
    }

    public void setCtnr(int ctnr) {
        this.ctnr = ctnr;
    }

    public String getCtck() {
        return ctck;
    }

    public void setCtck(String ctck) {
        this.ctck = ctck;
    }

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

    public String getCaag() {
        return caag;
    }

    public void setCaag(String caag) {
        this.caag = caag;
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

    public String getCabl() {
        return cabl;
    }

    public void setCabl(String cabl) {
        this.cabl = cabl;
    }

    public String getCtsn() {
        return ctsn;
    }

    public void setCtsn(String ctsn) {
        this.ctsn = ctsn;
    }

    public String getCacd() {
        return cacd;
    }

    public void setCacd(String cacd) {
        this.cacd = cacd;
    }

    public String getCacm() {
        return cacm;
    }

    public void setCacm(String cacm) {
        this.cacm = cacm;
    }

    public String getCapq() {
        return capq;
    }

    public void setCapq(String capq) {
        this.capq = capq;
    }

    public String getCawt() {
        return cawt;
    }

    public void setCawt(String cawt) {
        this.cawt = cawt;
    }

    public String getCadp() {
        return cadp;
    }

    public void setCadp(String cadp) {
        this.cadp = cadp;
    }

    public String getInfe() {
        return infe;
    }

    public void setInfe(String infe) {
        this.infe = infe;
    }

    public String getInhz() {
        return inhz;
    }

    public void setInhz(String inhz) {
        this.inhz = inhz;
    }

    public String getInth() {
        return inth;
    }

    public void setInth(String inth) {
        this.inth = inth;
    }

    public String getInog() {
        return inog;
    }

    public void setInog(String inog) {
        this.inog = inog;
    }

    public String getIntd() {
        return intd;
    }

    public void setIntd(String intd) {
        this.intd = intd;
    }

    public String getInts() {
        return ints;
    }

    public void setInts(String ints) {
        this.ints = ints;
    }

    //===============
    public String getCninfe() {
        if("F".equals(infe)){
            cninfe="重";
        }
        else if("E".equals(infe)){
            cninfe="空";
        }
        else if("L".equals(infe)){
            cninfe="拼";
        }else{
            cninfe="";
        }
        return cninfe;
    }

    public String getCninhz() {
        if("Y".equals(inhz)){
            cninhz="是";
        }
        else if("N".equals(inhz)){
            cninhz="否";
        }else{
            cninhz="";
        }
        return cninhz;
    }
    public String getCninth() {
        if("Y".equals(inth)){
            cninth="是";
        }
        else if("N".equals(inth)){
            cninth="否";
        }else{
            cninth="";
        }
        return cninth;
    }

    public String getCninog() {
        if("Y".equals(inog)){
            cninog="是";
        }
        else if("N".equals(inog)){
            cninog="否";
        }else{
            cninog="";
        }
        return cninog;
    }

    public String getCnintd() {
        if("W".equals(intd)){
            cnintd="W 外贸";
        }
        else if("N".equals(intd)){
            cnintd="N 内贸";
        }else{
            cnintd="";
        }
        return cnintd;
    }
}
