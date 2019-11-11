package nbct.com.cn.customerquery.utils;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ Author ：lsh @ Date ：Created in 2019-07-30 8:01
 * 
 * @ Description：公共类 @ Modified By：
 * @Version: 1.0
 */
public class Utils {
  // 是否有效的箱号
  public static boolean isCntrId(String cntrId) {
    cntrId = cntrId.trim();
    // 箱号字符串只有字母和数字
    boolean bTmp = cntrId.matches("^[a-zA-Z0-9]+$");

    return bTmp;
  }

  // 填充字符串
  public static String getFillStr(String sSrc, String sSign, Integer iLen, String sFill) {
    String sTemp = "";
    if (sSrc == null || sSrc.isEmpty()) {
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

  /**
   * 判断是否为数字格式不限制位数
   * 
   * @param o 待校验参数
   * @return 如果全为数字，返回true；否则，返回false
   */
  public static boolean isNumber(Object o) {
    return (Pattern.compile("[0-9]*")).matcher(String.valueOf(o)).matches();
  }

  // 拆分集装箱号
  public static Map<String, String> breakCntr(String cntrId) {
    Map<String, String> resultMap = new HashMap<String, String>();
    String ctpf = cntrId.substring(0, 4);

    String ctnr = cntrId.substring(4, 10);
    if (!isNumber(ctnr)) {
      ctnr = "0";
    }

    String ctck = cntrId.substring(10);
    if ("".equals(ctck.trim())) {
      ctck = "  ";
    }
    ctck = getFillStr(ctck, "R", 2, " ");

    resultMap.put("ctpf", ctpf);
    resultMap.put("ctnr", ctnr);
    resultMap.put("ctck", ctck);

    return resultMap;
  }

  public static String textToMD5L32(String plainText) {
    String result = null;
    try {
      // 首先进行实例化和初始化
      MessageDigest md = MessageDigest.getInstance("MD5");
      // 得到一个操作系统默认的字节编码格式的字节数组
      byte[] btInput = plainText.getBytes();
      // 对得到的字节数组进行处理
      md.update(btInput);
      // 进行哈希计算并返回结果
      byte[] btResult = md.digest();
      // 进行哈希计算后得到的数据的长度
      StringBuffer sb = new StringBuffer();
      for (byte b : btResult) {
        int bt = b & 0xff;
        if (bt < 16) {
          sb.append(0);
        }
        sb.append(Integer.toHexString(bt));
      }
      result = sb.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return result;
  }

}
