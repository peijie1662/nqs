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

    //填充字符串
    public static String getFillSr(String sSrc, String sSign, Integer iLen, String sFill) {
        String sTemp = "";
        if(sSrc==null){
            return sTemp;
        }
        for (int i = 0; i < iLen - sSrc.length(); i++)
            sTemp = sTemp + sFill;
        if (iLen - sSrc.length() < 0)
            return sSrc.substring(0, iLen);
        if (sSign.toUpperCase().equals("L"))
            return sTemp + sSrc;
        if (sSign.toUpperCase().equals("R"))
            return sSrc + sTemp;
        return sSrc;
    }
}
