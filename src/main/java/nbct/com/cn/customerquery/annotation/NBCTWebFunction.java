package nbct.com.cn.customerquery.annotation;

/**
 * 功能定义
 * 
 * @author PJ
 * @version 创建时间：2019年9月10日 上午9:22:38
 */
public enum NBCTWebFunction {

	ORDERRECEIVE("接单公告"), CONTAINERINFO("单箱信息"), NODEFINED("未定义");

	private final String functionName;

	private NBCTWebFunction(String functionName) {
		this.functionName = functionName;
	}

	public String getName() {
		return functionName;
	}
}