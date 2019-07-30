package nbct.com.cn.customerquery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @ Author     ：lsh
 * @ Date       ：Created in 2019-07-29 11:25
 * @ Description：进口箱海关放行信息
 * @ Modified By：
 * @Version: 1.0
 */
public class ImCustomPassInfo {
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

    @JsonIgnore
    private String caps;
    //是否转关箱
    private String istp;

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

    public String getCaps() {
        return caps;
    }

    public void setCaps(String caps) {
        this.caps = caps;
    }

    public String getIstp() {
        return istp;
    }

    public void setIstp(String istp) {
        this.istp = istp;
    }
}
