package nbct.com.cn.customerquery.annotation;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * 功能定义
 * 
 * @author PJ
 * @version 创建时间：2019年9月10日 上午9:22:38
 */
public enum NBCTWebFunction {

  LOGIN("LOGIN", "用户登录"), //
  LOGOUT("LOGOUT", "用户退出"), //
  PERIODLOG("PERIODLOG", "访问日志"), //
  ORDERRECEIVE("ORDERRECEIVE", "接单公告"), //
  CONTAINERINFO("CONTAINERINFO", "单箱信息"), //
  EXCONTAINERLIST("EXCONTAINERLIST", "出口箱信息"), //
  IMCONTAINERLIST("IMCONTAINERLIST", "进口箱信息"), //
  EXYARDCONTAINERLIST("EXYARDCONTAINERLIST", "货代在场出口箱列表"), //
  YARDCONTAINERINFO("YARDCONTAINERINFO", "在场单箱信息"), //
  YARDTRUCK("YARDTRUCK", "在场集卡列表"), //
  CNTRINCLOSEDATE("CNTRINCLOSEDATE", "集装箱进箱截箱时间公告"), //
  SAILINGDATENOTICE("SAILINGDATENOTICE", "船期预告"), //
  IMCUSTOMPASSINFO("IMCUSTOMPASSINFO", "进口箱海关放行信息查询"), //
  EXPORTPASSINFO("EXPORTPASSINFO", "出口箱码头放行信息查询"), //
  CHECKMOVECNTRINFO("CHECKMOVECNTRINFO", "查验箱移箱归位情况查询"), //
  EMPTYCONTAINER("EMPTYCONTAINER", "在场空箱实时查询"), //
  GETUSERCOMPANYHADCODES("GETUSERCOMPANYHADCODES", "获得用户公司关联代码"), //
  VOYAGELIST("VOYAGELIST", "船舶列表"), //
  CONTAINERHISDETAIL("CONTAINERHISDETAIL", "单箱历史详情"), //
  CONTAINERHISLIST("CONTAINERHISLIST", "单箱历史列表"), //
  CONTAINERHISCABL("CONTAINERHISCABL", "单箱提单信息列表"), //
  GETEMPTYCONTAINERINYARDHIS("GETEMPTYCONTAINERINYARDHIS", "获得集装箱在场空箱历史"), //
  GETEFINREPORTS("GETEFINREPORTS", "获得EFINREPORT报表列表"), //
  DOWNLOADEFINREPORT("DOWNLOADEFINREPORT", "下载EFIN报表文件"), //
  ADDUSER("ADDUSER", "用户新增"), //
  EDITUSER("EDITUSER", "用户修改"), //
  CHANGEPWUSER("CHANGEPWUSER", "用户修改密码"), //
  RESETPWUSER("RESETPWUSER", "用户重置密码"), //
  DELETEUSER("DELETEUSER", "用户删除"), //
  GETUSER("GETUSER", "获得单一用户信息"), //
  GETUSERS("GETUSERS", "获得所有用户信息"), //
  UPDATENOTICE("UPDATENOTICE", "更新公告"), //
  GETNOTICES("GETNOTICES", "获得所有公告"), //
  NODEFINED("NODEFINED", "未定义");

  private final String functionId;

  private final String functionName;

  private NBCTWebFunction(String functionId, String functionName) {
    this.functionId = functionId;
    this.functionName = functionName;
  }

  public String getFunctionId() {
    return functionId;
  }

  public String getName() {
    return functionName;
  }

  public static List<JSONObject> toList() {
    List<JSONObject> r = new ArrayList<JSONObject>();
    for (NBCTWebFunction item : NBCTWebFunction.values()) {
      JSONObject j = new JSONObject();
      j.put("id", item.getFunctionId());
      j.put("name", item.getName());
      r.add(j);
    }
    return r;
  }

}
