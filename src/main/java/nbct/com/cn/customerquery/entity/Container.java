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
	private String ptds;//卸货港
	private String ctsz;//箱尺寸
	private String ctty;//箱类型
	private String ctgw;//净重
	private String ctsn;//铅封号

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
}

