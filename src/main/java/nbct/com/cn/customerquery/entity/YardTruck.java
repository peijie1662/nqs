package nbct.com.cn.customerquery.entity;

/**
 * @author lsh
 * @date 2019-07-26 9:11
 * @description
 */
public class YardTruck {
    //车牌号
    private String trnrwk;
    //集卡号
    private String trcdwk;
    //进场时间
    private int dttrwk;

    private int tmtrwk;

    //停留时间
    private int DelayMinutes;

    public String getTrnrwk() {
        return trnrwk;
    }

    public void setTrnrwk(String trnrwk) {
        this.trnrwk = trnrwk;
    }

    public String getTrcdwk() {
        return trcdwk;
    }

    public void setTrcdwk(String trcdwk) {
        this.trcdwk = trcdwk;
    }

    public int getDttrwk() {
        return dttrwk;
    }

    public void setDttrwk(int dttrwk) {
        this.dttrwk = dttrwk;
    }

    public int getTmtrwk() {
        return tmtrwk;
    }

    public void setTmtrwk(int tmtrwk) {
        this.tmtrwk = tmtrwk;
    }

    public int getDelayMinutes() {
        return DelayMinutes;
    }

    public void setDelayMinutes(int delayMinutes) {
        DelayMinutes = delayMinutes;
    }
}
