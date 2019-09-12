package nbct.com.cn.customerquery.entity;
/**
* @author PJ 
* @version 创建时间：2019年9月12日 上午11:09:48
*/
public class CallSatisticsItem {
	
	/**
	 * 调用日期
	 */
	private String callDt;
	
	/**
	 * 次数
	 */
	private int count;
	
	public CallSatisticsItem(){
		
	}
	
	public CallSatisticsItem(String callDt,int count){
		this.callDt = callDt;
		this.count = count;
	}	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCallDt() {
		return callDt;
	}

	public void setCallDt(String callDt) {
		this.callDt = callDt;
	}

}
