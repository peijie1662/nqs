package nbct.com.cn.customerquery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @ Author     ：lsh
 * @ Date       ：Created in 2019-09-16 22:50
 * @ Description：进口箱
 * @ Modified By：
 * @Version: 1.0
 */
public class ImContainer {
    @JsonIgnore
    private String vscd;//船名航次
    @JsonIgnore
    private String vsvy;
    @JsonIgnore
    private String vsdr;

    @JsonIgnore
    private String ctpf;//箱号
    @JsonIgnore
    private String ctnr;
    @JsonIgnore
    private String ctck;

    private String cntrid;
    private String ctsz;//尺寸箱型
    private String ctty;
    private String ctgw;//重量
    private String infe;//空重
    private String inog;//超限
    private String inth;//冷藏
    private String inhz;//危品
    private String indm;//残损
    private String intd;//内外贸标志
    private String ints;//中转标志
    private String lncd;//箱主
    private String ptds;//港口

    private String ctsn;//铅封号
    private String cabl;//提单号(只取第一个)
    private int cablnum;//提单总数
    private String hzclhz;//危品等级
    private String isportpass;//扣留／放行标志
    private String isnzwct;//内贸转外贸标志
    private String intime;//进场时间/卸船时间 20190101122356
    private String outtime;//出场时间 20190101122356

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

    public String getCtnr() {
        return ctnr;
    }

    public void setCtnr(String ctnr) {
        this.ctnr = ctnr;
    }

    public String getCtck() {
        return ctck;
    }

    public void setCtck(String ctck) {
        this.ctck = ctck;
    }

    public String getCntrid() {
        return cntrid;
    }

    public void setCntrid(String cntrid) {
        this.cntrid = cntrid;
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

    public String getCtgw() {
        return ctgw;
    }

    public void setCtgw(String ctgw) {
        this.ctgw = ctgw;
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

    public String getLncd() {
        return lncd;
    }

    public void setLncd(String lncd) {
        this.lncd = lncd;
    }

    public String getPtds() {
        return ptds;
    }

    public void setPtds(String ptds) {
        this.ptds = ptds;
    }

    public String getCtsn() {
        return ctsn;
    }

    public void setCtsn(String ctsn) {
        this.ctsn = ctsn;
    }

    public String getCabl() {
        return cabl;
    }

    public void setCabl(String cabl) {
        this.cabl = cabl;
    }

    public int getCablnum() {
        return cablnum;
    }

    public void setCablnum(int cablnum) {
        this.cablnum = cablnum;
    }

    public String getHzclhz() {
        return hzclhz;
    }

    public void setHzclhz(String hzclhz) {
        this.hzclhz = hzclhz;
    }

    public String getIsportpass() {
        return isportpass;
    }

    public void setIsportpass(String isportpass) {
        this.isportpass = isportpass;
    }

    public String getIsnzwct() {
        return isnzwct;
    }

    public void setIsnzwct(String isnzwct) {
        this.isnzwct = isnzwct;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }
}


