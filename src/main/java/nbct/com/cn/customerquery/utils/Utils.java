package nbct.com.cn.customerquery.utils;

/**
 * @ Author     ：lsh
 * @ Date       ：Created in 2019-07-30 8:01
 * @ Description：公共类
 * @ Modified By：
 * @Version: 1.0
 */
public class Utils {
    //是否有效的箱号
    public static boolean isCntrId(String cntrId){
        cntrId=cntrId.trim();
        //箱号字符串只有字母和数字
        boolean bTmp=cntrId.matches("^[a-zA-Z0-9]+$");

        return bTmp;
    }
}
