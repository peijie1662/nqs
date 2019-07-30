package nbct.com.cn.customerquery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @ Author     ：lsh
 * @ Date       ：Created in 2019-07-30 11:22
 * @ Description：查验箱移箱/归位情况查询
 * @ Modified By：
 * @Version: 1.0
 */
public class CheckMoveCtnrInfo {
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
    //private String intd;
    //空重
    //private String infe;

    //中文场地位置
    private String yardcn;

    //查验指令号
    private  String ckno;
    //查验场地
    private String ckyard;
    private String ckyardcn;
    //查验状态
    @JsonIgnore
    private String ckstatus;
    private String ckstatuscn;

    //查验收费确认次数
    @JsonIgnore
    private int feenum;

    //归位状态
    private String posstatuscn;

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

    public String getYardcn() {
        return yardcn;
    }

    public void setYardcn(String yardcn) {
        this.yardcn = yardcn;
    }

    public String getCkyard() {
        return ckyard;
    }

    public void setCkyard(String ckyard) {
        this.ckyard = ckyard;
    }

    public String getCkyardcn() {
        return ckyardcn;
    }

    public void setCkyardcn(String ckyardcn) {
        this.ckyardcn = ckyardcn;
    }

    public String getCkstatus() {
        return ckstatus;
    }

    public void setCkstatus(String ckstatus) {
        this.ckstatus = ckstatus;
    }

    public String getCkstatuscn() {
        return ckstatuscn;
    }

    public void setCkstatuscn(String ckstatuscn) {
        this.ckstatuscn = ckstatuscn;
    }

    public int getFeenum() {
        return feenum;
    }

    public void setFeenum(int feenum) {
        this.feenum = feenum;
    }

    public String getPosstatuscn() {
        return posstatuscn;
    }

    public void setPosstatuscn(String posstatuscn) {
        this.posstatuscn = posstatuscn;
    }

    public String getCkno() {
        return ckno;
    }

    public void setCkno(String ckno) {
        this.ckno = ckno;
    }
}
