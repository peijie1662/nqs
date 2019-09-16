package nbct.com.cn.customerquery.entity;

/**
 * @ Author     ：lsh
 * @ Date       ：Created in 2019-09-16 10:37
 * @ Description：航次信息
 * @ Modified By：
 * @Version: 1.0
 */
public class Voyage {
    private String vscdvy;//船舶代码
    private String vsvyvy;//航次
    private String vsdrvy;//航向
    private String lncdvr;//箱主
    private String egnmvr;//英文船名
    private String cnnmvr;//中文船名

    public String getVscdvy() {
        return vscdvy;
    }

    public void setVscdvy(String vscdvy) {
        this.vscdvy = vscdvy;
    }

    public String getVsvyvy() {
        return vsvyvy;
    }

    public void setVsvyvy(String vsvyvy) {
        this.vsvyvy = vsvyvy;
    }

    public String getVsdrvy() {
        return vsdrvy;
    }

    public void setVsdrvy(String vsdrvy) {
        this.vsdrvy = vsdrvy;
    }

    public String getLncdvr() {
        return lncdvr;
    }

    public void setLncdvr(String lncdvr) {
        this.lncdvr = lncdvr;
    }

    public String getEgnmvr() {
        return egnmvr;
    }

    public void setEgnmvr(String egnmvr) {
        this.egnmvr = egnmvr;
    }

    public String getCnnmvr() {
        return cnnmvr;
    }

    public void setCnnmvr(String cnnmvr) {
        this.cnnmvr = cnnmvr;
    }
}
