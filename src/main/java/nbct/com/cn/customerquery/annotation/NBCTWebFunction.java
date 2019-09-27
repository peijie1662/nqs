package nbct.com.cn.customerquery.annotation;

/**
 * 功能定义
 * 
 * @author PJ
 * @version 创建时间：2019年9月10日 上午9:22:38
 */
public enum NBCTWebFunction {

	LOGIN("用户登录"),//
	LOGOUT("用户退出"),//
	PERIODLOG("访问日志"),//
	ORDERRECEIVE("接单公告"), //
	CONTAINERINFO("单箱信息"), //
	EXCONTAINERLIST("出口箱信息"), //
	IMCONTAINERLIST("进口箱信息"), //
	EXYARDCONTAINERLIST("货代在场出口箱列表"), //
	YARDCONTAINERINFO("在场单箱信息"),//
	YARDTRUCK("在场集卡列表"),//
	CNTRINCLOSEDATE("集装箱进箱截箱时间公告"),//
	SAILINGDATENOTICE("船期预告"),//
	IMCUSTOMPASSINFO("进口箱海关放行信息查询"),//
	EXPORTPASSINFO("出口箱码头放行信息查询"),//
	CHECKMOVECNTRINFO("查验箱移箱归位情况查询"),//
	EMPTYCONTAINER("在场空箱实时查询"),//
	GETUSERCOMPANYHADCODES("获得用户公司关联代码"),//
	VOYAGELIST("船舶列表"),//
	CONTAINERHISDETAIL("单箱历史详情"),//
	CONTAINERHISLIST("单箱历史列表"),//
	CONTAINERHISCABL("单箱提单信息列表"),//
	GETEMPTYCONTAINERINYARDHIS("获得集装箱在场空箱历史"),//
	GETEFINREPORTS("获得EFINREPORT报表列表"),//
	DOWNLOADEFINREPORT("下载EFIN报表文件"),//
	ADDUSER("用户新增"),//
	EDITUSER("用户修改"),//
	CHANGEPWUSER("用户修改密码"),//
	RESETPWUSER("用户重置密码"),//
	DELETEUSER("用户删除"),//
	GETUSER("获得单一用户信息"),//
	GETUSERS("获得所有用户信息"),//
	NODEFINED("未定义");

	private final String functionName;

	private NBCTWebFunction(String functionName) {
		this.functionName = functionName;
	}

	public String getName() {
		return functionName;
	}
}
