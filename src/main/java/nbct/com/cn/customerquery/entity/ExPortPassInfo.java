package nbct.com.cn.customerquery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @ Author     ：lsh
 * @ Date       ：Created in 2019-07-30 8:47
 * @ Description：出口箱码头放行信息
 * @ Modified By：
 * @Version: 1.0
 */
public class ExPortPassInfo {
    //箱号
    private String cntrid;

    @JsonIgnore
    private String ctpf;
    @JsonIgnore
    private int ctnr;
    @JsonIgnore
    private String ctck;
    //中文船名
    private String vscn;
    //船舶代码
    private String vscd;
    //航次
    private String vsvy;
    //航向
    private String vsdr;
    //内外贸标志
    private String intd;
    //空重
    private String infe;

    //堆场位置
    @JsonIgnore
    private String ydst;
    @JsonIgnore
    private String ydrw;
    @JsonIgnore
    private String ydln;

    //提单号
    private String cabl;
    //中文场地位置
    private String yardcn;

    //卸货港
    private String ptds;
    //是否已码头放行
    private String isportpass;

    public String getCntrid() {
        return cntrid;
    }

    public void setCntrid(String cntrid) {
        this.cntrid = cntrid;
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

    public String getVscn() {
        return vscn;
    }

    public void setVscn(String vscn) {
        this.vscn = vscn;
    }

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

    public String getYdst() {
        return ydst;
    }

    public void setYdst(String ydst) {
        this.ydst = ydst;
    }

    public String getYdrw() {
        return ydrw;
    }

    public void setYdrw(String ydrw) {
        this.ydrw = ydrw;
    }

    public String getYdln() {
        return ydln;
    }

    public void setYdln(String ydln) {
        this.ydln = ydln;
    }

    public String getCabl() {
        return cabl;
    }

    public void setCabl(String cabl) {
        this.cabl = cabl;
    }

    public String getYardcn() {
        return yardcn;
    }

    public void setYardcn(String yardcn) {
        this.yardcn = yardcn;
    }

    public String getPtds() {
        return ptds;
    }

    public void setPtds(String ptds) {
        this.ptds = ptds;
    }

    public String getIsportpass() {
        return isportpass;
    }

    public void setIsportpass(String isportpass) {
        this.isportpass = isportpass;
    }
}
