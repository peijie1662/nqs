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
    private String vscdst;//船名航次
    @JsonIgnore
    private String vsvyst;
    @JsonIgnore
    private String vsdrst;

    @JsonIgnore
    private String ctpfst;//箱号
    @JsonIgnore
    private String ctnrst;
    @JsonIgnore
    private String ctckst;

    private String cntrid;
    private String ctszst;//尺寸箱型
    private String cttyst;
    private String ctgwst;//重量
    private String infest;//空重
    private String inogst;//超限
    private String inthst;//冷藏
    private String inhzst;//危品
    private String indmst;//残损
    private String intdst;//内外贸标志
    private String intsst;//中转标志
    private String lncdst;//箱主
    private String ptdsst;//港口

    private String ctsnmf;//铅封号
    private String cablmf;//提单号(多个用,分割)
    private String hzclhz;//危品等级
    private String isportpass;//扣留／放行标志
    private String isnzwct;//内贸转外贸标志
    private String intime;//进场时间/卸船时间 20190101122356
    private String outtime;//出场时间 20190101122356

    public String getVscdst() {
        return vscdst;
    }

    public void setVscdst(String vscdst) {
        this.vscdst = vscdst;
    }

    public String getVsvyst() {
        return vsvyst;
    }

    public void setVsvyst(String vsvyst) {
        this.vsvyst = vsvyst;
    }

    public String getVsdrst() {
        return vsdrst;
    }

    public void setVsdrst(String vsdrst) {
        this.vsdrst = vsdrst;
    }

    public String getCtpfst() {
        return ctpfst;
    }

    public void setCtpfst(String ctpfst) {
        this.ctpfst = ctpfst;
    }

    public String getCtnrst() {
        return ctnrst;
    }

    public void setCtnrst(String ctnrst) {
        this.ctnrst = ctnrst;
    }

    public String getCtckst() {
        return ctckst;
    }

    public void setCtckst(String ctckst) {
        this.ctckst = ctckst;
    }

    public String getCntrid() {
        return cntrid;
    }

    public void setCntrid(String cntrid) {
        this.cntrid = cntrid;
    }

    public String getCtszst() {
        return ctszst;
    }

    public void setCtszst(String ctszst) {
        this.ctszst = ctszst;
    }

    public String getCttyst() {
        return cttyst;
    }

    public void setCttyst(String cttyst) {
        this.cttyst = cttyst;
    }

    public String getCtgwst() {
        return ctgwst;
    }

    public void setCtgwst(String ctgwst) {
        this.ctgwst = ctgwst;
    }

    public String getInfest() {
        return infest;
    }

    public void setInfest(String infest) {
        this.infest = infest;
    }

    public String getInogst() {
        return inogst;
    }

    public void setInogst(String inogst) {
        this.inogst = inogst;
    }

    public String getInthst() {
        return inthst;
    }

    public void setInthst(String inthst) {
        this.inthst = inthst;
    }

    public String getInhzst() {
        return inhzst;
    }

    public void setInhzst(String inhzst) {
        this.inhzst = inhzst;
    }

    public String getIndmst() {
        return indmst;
    }

    public void setIndmst(String indmst) {
        this.indmst = indmst;
    }

    public String getIntdst() {
        return intdst;
    }

    public void setIntdst(String intdst) {
        this.intdst = intdst;
    }

    public String getIntsst() {
        return intsst;
    }

    public void setIntsst(String intsst) {
        this.intsst = intsst;
    }

    public String getLncdst() {
        return lncdst;
    }

    public void setLncdst(String lncdst) {
        this.lncdst = lncdst;
    }

    public String getPtdsst() {
        return ptdsst;
    }

    public void setPtdsst(String ptdsst) {
        this.ptdsst = ptdsst;
    }

    public String getCtsnmf() {
        return ctsnmf;
    }

    public void setCtsnmf(String ctsnmf) {
        this.ctsnmf = ctsnmf;
    }

    public String getCablmf() {
        return cablmf;
    }

    public void setCablmf(String cablmf) {
        this.cablmf = cablmf;
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


