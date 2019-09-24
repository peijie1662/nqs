package nbct.com.cn.customerquery.entity.satistics;
/**
 * 按用户统计
 * 
* @author PJ 
* @version 创建时间：2019年9月23日 下午12:33:31
*/
public class UserGroupSatistics {

	private String userId;
	
	private int callNum;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCallNum() {
		return callNum;
	}

	public void setCallNum(int callNum) {
		this.callNum = callNum;
	}
	
}
