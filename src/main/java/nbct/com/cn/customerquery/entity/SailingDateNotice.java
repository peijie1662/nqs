package nbct.com.cn.customerquery.entity;

/**
 * @author lsh
 * @date 2019-07-26 13:53
 * @description 船舶预告
 */
public class SailingDateNotice {
    //船公司
    private String lncd;
    //中文船名
    private String cnvsname;
    //英文船名
    private String engvsname;
    //船舶代码
    private String vscd;
    //进口航次
    private String imvsvy;
    //出口航次
    private String exvsvy;

    //实际靠泊时间
    private String realberthdate;

    //实际离泊时间
    private String realunberthdate;

    //进箱时间
    private String cntrindate;

    //截箱时间
    private String cntroutdate;

    //计划靠泊时间
    private String estberthdate;

    //计划离泊时间
    private String estunberthdate;

    //发布时间
    private String pubdate;

    //泊位号
    private String btno;

    public String getlncd() {
        return lncd;
    }

    public void setlncd(String lncd) {
        this.lncd = lncd;
    }

    public String getCnvsname() {
        return cnvsname;
    }

    public void setCnvsname(String cnvsname) {
        this.cnvsname = cnvsname;
    }

    public String getEngvsname() {
        return engvsname;
    }

    public void setEngvsname(String engvsname) {
        this.engvsname = engvsname;
    }

    public String getVscd() {
        return vscd;
    }

    public void setVscd(String vscd) {
        this.vscd = vscd;
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

    public String getRealberthdate() {
        return realberthdate;
    }

    public void setRealberthdate(String realberthdate) {
        this.realberthdate = realberthdate;
    }

    public String getRealunberthdate() {
        return realunberthdate;
    }

    public void setRealunberthdate(String realunberthdate) {
        this.realunberthdate = realunberthdate;
    }

    public String getCntrindate() {
        return cntrindate;
    }

    public void setCntrindate(String cntrindate) {
        this.cntrindate = cntrindate;
    }

    public String getCntroutdate() {
        return cntroutdate;
    }

    public void setCntroutdate(String cntroutdate) {
        this.cntroutdate = cntroutdate;
    }

    public String getEstberthdate() {
        return estberthdate;
    }

    public void setEstberthdate(String estberthdate) {
        this.estberthdate = estberthdate;
    }

    public String getEstunberthdate() {
        return estunberthdate;
    }

    public void setEstunberthdate(String estunberthdate) {
        this.estunberthdate = estunberthdate;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getBtno() {
        return btno;
    }

    public void setBtno(String btno) {
        this.btno = btno;
    }
}
