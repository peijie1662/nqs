package nbct.com.cn.customerquery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
* @author PJ 
* @version 创建时间：2019年7月9日 上午8:57:39
* qrytest 没什么用
 * select vscdco,vsvyco,vsdrco,ctpfco,ctnrco,ctckco from tcmscop
 * 2019-09-17
 * 增加部分字段，用做在场箱类 lsh
*/
public class Container {
	private String vscd;
	private String vsvy;
	private String vsdr;

	private String vscn;//中文船名
	private String vseng;//英文船名
	private String crcd;//船舶承运人

	private String lncd;//箱主

	@JsonIgnore
	private String ctpf;
	@JsonIgnore
	private int ctnr;
	@JsonIgnore
	private String ctck;

	private String cntrId;//箱号

	private String ptld;//装箱港
	private String ptds;//卸货港
	private String fdcd;//目的港

	private String ctsz;//箱尺寸
	private String ctty;//箱类型
	private String ctgw;//箱子总重
	private String ctnw;//货物净重
	private String ctsn;//铅封号

	private String ydst;//场地位置
	private String ydln;
	private String ydrw;
	private String ydel;

	private String caag;//货代
	private String inst;//状态标志

	private String infe;//空重
	private String inog;//超限
	private String inth;//冷藏
	private String inhz;//危品
	private String hzclhz;//危品等级
	private String indm;//残损
	private String intd;//内外贸标志
	private String ints;//中转标志

	private String isnzwct;//内贸转外贸标志
	private String isck;//是否查验箱
	private String issrt;//是否海铁箱

	@JsonIgnore
	private String dtgi;//进场时间
	@JsonIgnore
	private String tmgi;
	private String intime;//进场时间/卸船时间 20190101122356

	private String cabl;//提单号(多个用,分割)
	private String isportpass;//扣留／放行标志 H/R

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

	public String getVscn() {
		return vscn;
	}

	public void setVscn(String vscn) {
		this.vscn = vscn;
	}

	public String getVseng() {
		return vseng;
	}

	public void setVseng(String vseng) {
		this.vseng = vseng;
	}

	public String getCrcd() {
		return crcd;
	}

	public void setCrcd(String crcd) {
		this.crcd = crcd;
	}

	public String getLncd() {
		return lncd;
	}

	public void setLncd(String lncd) {
		this.lncd = lncd;
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

	public String getPtds() {
		return ptds;
	}

	public void setPtds(String ptds) {
		this.ptds = ptds;
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

	public String getCtsn() {
		return ctsn;
	}

	public void setCtsn(String ctsn) {
		this.ctsn = ctsn;
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

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getCabl() {
		return cabl;
	}

	public void setCabl(String cabl) {
		this.cabl = cabl;
	}

	public String getIsportpass() {
		return isportpass;
	}

	public void setIsportpass(String isportpass) {
		this.isportpass = isportpass;
	}

	public String getPtld() {
		return ptld;
	}

	public void setPtld(String ptld) {
		this.ptld = ptld;
	}

	public String getFdcd() {
		return fdcd;
	}

	public void setFdcd(String fdcd) {
		this.fdcd = fdcd;
	}

	public String getCtnw() {
		return ctnw;
	}

	public void setCtnw(String ctnw) {
		this.ctnw = ctnw;
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

	public String getCaag() {
		return caag;
	}

	public void setCaag(String caag) {
		this.caag = caag;
	}

	public String getInst() {
		return inst;
	}

	public void setInst(String inst) {
		this.inst = inst;
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

	public String getHzclhz() {
		return hzclhz;
	}

	public void setHzclhz(String hzclhz) {
		this.hzclhz = hzclhz;
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
		if("".equals(ints.trim())){
			this.ints="N";
		}else{
			this.ints = ints;
		}
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
}

