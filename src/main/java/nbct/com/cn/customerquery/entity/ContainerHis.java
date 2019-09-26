package nbct.com.cn.customerquery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @ Author     ：lsh
 * @ Date       ：Created in 2019-09-20 15:38
 * @ Description：历史集装箱实体类
 * @ Modified By：
 * @Version: 1.0
 */
public class ContainerHis {
    private String dttr;//20190919
    private String tmtr;//121212
    private String accd;//作业号
    private String jbnr;
    private String jbns;
    private String opcd;

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
    private String ctgw;//箱子总重
    private String ctnw;//货物净重
    private String ctsn;//铅封号

    private String ydst;//场地位置
    private String ydln;
    private String ydrw;
    private String ydel;

    private String vsba;//船仓位(贝列层)
    private String vscl;
    private String vsel;

    private String ptld;//装箱港
    private String ptds;//卸货港
    private String fdcd;//目的港
    private String ctfr;//装箱地点

    private String opuser;//操作用户
    private String usr2;//操作用户2

    private String infe;//空重
    private String indm;//残损
    private String inhz;//危品
    private String hzclhz;//危品等级
    private String inth;//冷藏
    private String inog;//超限
    private String intd;//内外贸标志
    private String ints;//中转标志

    private String inst;//INSTEM 状态标志

    private String isnzwct;//内贸转外贸标志
    private String isck;//是否查验箱
    private String issrt;//是否海铁箱

    private String trcd;//集卡车牌号/集卡港区作业号
    private String ydeq;//龙门吊编号
    private String wtlm;//龙门吊测重重量值
    private String rmks;//备注

    private String dtld;//装船日期时间 20190101
    private String tmld;//122356

    private String dtds;//卸船日期时间 20190101
    private String tmds;//122356

    private String dtpe;//预进日期时间 20190101
    private String tmpe;//122356

    private String dtgi;//集卡进门日期时间 20190101
    private String tmgi;//122356

    private String dtrg;//龙门吊作业日期时间 20190101
    private String tmrg;//122356

    private String dtgo;//集卡出门日期时间 20190101
    private String tmgo;//122356

    private String imuser;//海关放行者
    private String imctps;//海关放行号
    private String imdt;//海关放行日期和时间
    private String imtm;//

    //中文转换----begin
    private String cninfe;//中文-空重拼
    private String cnindm;//中文-坏箱-是否
    private String cninhz;//中文-危品-是否
    private String cninth;//中文-温控-是否
    private String cninog;//中文-超限-是否
    private String cnintd;//中文-内外贸-内贸/外贸
    private String inway;//中文-进箱方式 铁路/公路/水路

    private String cncaag;//中文-货代公司名称
    private String cnctfr;//中文-装箱地点名称
    //中文转换----end

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

    public String getAccd() {
        return accd;
    }

    public void setAccd(String accd) {
        this.accd = accd;
    }

    public String getJbnr() {
        return jbnr;
    }

    public void setJbnr(String jbnr) {
        this.jbnr = jbnr;
    }

    public String getJbns() {
        return jbns;
    }

    public void setJbns(String jbns) {
        this.jbns = jbns;
    }

    public String getOpcd() {
        return opcd;
    }

    public void setOpcd(String opcd) {
        this.opcd = opcd;
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

    public String getCtgw() {
        return ctgw;
    }

    public void setCtgw(String ctgw) {
        this.ctgw = ctgw;
    }

    public String getCtnw() {
        return ctnw;
    }

    public void setCtnw(String ctnw) {
        this.ctnw = ctnw;
    }

    public String getCtsn() {
        return ctsn;
    }

    public void setCtsn(String ctsn) {
        this.ctsn = ctsn;
    }

    public String getYdst() {
        return ydst;
    }

    public void setYdst(String ydst) {
        this.ydst = ydst;
    }

    public String getYdln() {
        return ydln;
    }

    public void setYdln(String ydln) {
        this.ydln = ydln;
    }

    public String getYdrw() {
        return ydrw;
    }

    public void setYdrw(String ydrw) {
        this.ydrw = ydrw;
    }

    public String getYdel() {
        return ydel;
    }

    public void setYdel(String ydel) {
        this.ydel = ydel;
    }

    public String getVsba() {
        return vsba;
    }

    public void setVsba(String vsba) {
        this.vsba = vsba;
    }

    public String getVscl() {
        return vscl;
    }

    public void setVscl(String vscl) {
        this.vscl = vscl;
    }

    public String getVsel() {
        return vsel;
    }

    public void setVsel(String vsel) {
        this.vsel = vsel;
    }

    public String getPtld() {
        return ptld;
    }

    public void setPtld(String ptld) {
        this.ptld = ptld;
    }

    public String getPtds() {
        return ptds;
    }

    public void setPtds(String ptds) {
        this.ptds = ptds;
    }

    public String getFdcd() {
        return fdcd;
    }

    public void setFdcd(String fdcd) {
        this.fdcd = fdcd;
    }

    public String getCtfr() {
        return ctfr;
    }

    public void setCtfr(String ctfr) {
        this.ctfr = ctfr;
    }

    public String getOpuser() {
        return opuser;
    }

    public void setOpuser(String opuser) {
        this.opuser = opuser;
    }

    public String getUsr2() {
        return usr2;
    }

    public void setUsr2(String usr2) {
        this.usr2 = usr2;
    }

    public String getInfe() {
        return infe;
    }

    public void setInfe(String infe) {
        this.infe = infe;
    }

    public String getIndm() {
        return indm;
    }

    public void setIndm(String indm) {
        this.indm = indm;
    }

    public String getInhz() {
        return inhz;
    }

    public void setInhz(String inhz) {
        this.inhz = inhz;
    }

    public String getHzclhz() {
        return hzclhz;
    }

    public void setHzclhz(String hzclhz) {
        this.hzclhz = hzclhz;
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

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }

    public String getIsnzwct() {
        return isnzwct;
    }

    public void setIsnzwct(String isnzwct) {
        this.isnzwct = isnzwct;
    }

    public String getIsck() {
        return isck;
    }

    public void setIsck(String isck) {
        this.isck = isck;
    }

    public String getIssrt() {
        return issrt;
    }

    public void setIssrt(String issrt) {
        this.issrt = issrt;
    }

    public String getTrcd() {
        return trcd;
    }

    public void setTrcd(String trcd) {
        this.trcd = trcd;
    }

    public String getYdeq() {
        return ydeq;
    }

    public void setYdeq(String ydeq) {
        if(ydeq==null){
            ydeq="";
        }
        this.ydeq = ydeq;
    }

    public String getWtlm() {
        return wtlm;
    }

    public void setWtlm(String wtlm) {
        if(wtlm==null){
            wtlm="0";
        }
        this.wtlm = wtlm+" (KG)";
    }

    public String getRmks() {
        return rmks;
    }

    public void setRmks(String rmks) {
        this.rmks = rmks;
    }

    public String getDtld() {
        return dtld;
    }

    public void setDtld(String dtld) {
        this.dtld = dtld;
    }

    public String getTmld() {
        return tmld;
    }

    public void setTmld(String tmld) {
        this.tmld = tmld;
    }

    public String getDtds() {
        return dtds;
    }

    public void setDtds(String dtds) {
        this.dtds = dtds;
    }

    public String getTmds() {
        return tmds;
    }

    public void setTmds(String tmds) {
        this.tmds = tmds;
    }

    public String getDtpe() {
        return dtpe;
    }

    public void setDtpe(String dtpe) {
        this.dtpe = dtpe;
    }

    public String getTmpe() {
        return tmpe;
    }

    public void setTmpe(String tmpe) {
        this.tmpe = tmpe;
    }

    public String getDtgi() {
        return dtgi;
    }

    public void setDtgi(String dtgi) {
        this.dtgi = dtgi;
    }

    public String getTmgi() {
        return tmgi;
    }

    public void setTmgi(String tmgi) {
        this.tmgi = tmgi;
    }

    public String getDtrg() {
        return dtrg;
    }

    public void setDtrg(String dtrg) {
        this.dtrg = dtrg;
    }

    public String getTmrg() {
        return tmrg;
    }

    public void setTmrg(String tmrg) {
        this.tmrg = tmrg;
    }

    public String getDtgo() {
        return dtgo;
    }

    public void setDtgo(String dtgo) {
        this.dtgo = dtgo;
    }

    public String getTmgo() {
        return tmgo;
    }

    public void setTmgo(String tmgo) {
        this.tmgo = tmgo;
    }

    public String getImuser() {
        return imuser;
    }

    public void setImuser(String imuser) {
        this.imuser = imuser;
    }

    public String getImctps() {
        return imctps;
    }

    public void setImctps(String imctps) {
        this.imctps = imctps;
    }

    public String getImdt() {
        return imdt;
    }

    public void setImdt(String imdt) {
        this.imdt = imdt;
    }

    public String getImtm() {
        return imtm;
    }

    public void setImtm(String imtm) {
        this.imtm = imtm;
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

    public String getCnindm() {
        if("Y".equals(indm)){
            cnindm="是";
        }
        else if("N".equals(indm)){
            cnindm="否";
        }else{
            cnindm="";
        }
        return cnindm;
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

    public String getInway() {
        if("R".equals(opcd.substring(0,1))){
            if("1".equals(inst.substring(8,9))){//instem第九位: 1=表示铁路进提箱作业
                inway="铁路";
            }else{
                inway="公路";
            }
        }else{
            inway="";
        }

        if("IE".equals(opcd)||"IF".equals(opcd)){
            inway="水路";
        }
        return inway;
    }

    //===============

    public String getCncaag() {
        return cncaag;
    }

    public void setCncaag(String cncaag) {
        this.cncaag = cncaag;
    }

    public String getCnctfr() {
        return cnctfr;
    }

    public void setCnctfr(String cnctfr) {
        this.cnctfr = cnctfr;
    }
}
