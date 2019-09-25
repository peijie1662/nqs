package nbct.com.cn.customerquery.entity.satistics;
/**
* @author PJ 
* @version 创建时间：2019年9月23日 上午9:30:11
* 类说明
*/
public class CallSatistics {
	
	/**
	 * 访问用户
	 */
	private String userId;
	
	/**
	 * 访问功能
	 */
	private String fun;
	
	/**
	 * 访问时间
	 */
	private int callDt;
	
	/**
	 * 访问次数
	 */
	private int callNum;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFun() {
		return fun;
	}

	public void setFun(String fun) {
		this.fun = fun;
	}

	public int getCallDt() {
		return callDt;
	}

	public void setCallDt(int callDt) {
		this.callDt = callDt;
	}

	public int getCallNum() {
		return callNum;
	}

	public void setCallNum(int callNum) {
		this.callNum = callNum;
	}

}
