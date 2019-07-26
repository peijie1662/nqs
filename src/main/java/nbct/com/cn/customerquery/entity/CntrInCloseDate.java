package nbct.com.cn.customerquery.entity;

/**
 * @author lsh
 * @date 2019-07-26 12:16
 * @description
 * 集装箱进箱截箱时间公告
 */
public class CntrInCloseDate {
    //中文船名
    private String cnname;
    //英文船名
    private String engname;
    //船舶代码
    private String vscd;
    //出口航次  进箱只需出口航次
    private String exvsvy;
    //进箱开始时间
    private String startdate;
    //进箱截止时间
    private String enddate;

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getEngname() {
        return engname;
    }

    public void setEngname(String engname) {
        this.engname = engname;
    }

    public String getVscd() {
        return vscd;
    }

    public void setVscd(String vscd) {
        this.vscd = vscd;
    }

    public String getExvsvy() {
        return exvsvy;
    }

    public void setExvsvy(String exvsvy) {
        this.exvsvy = exvsvy;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}
