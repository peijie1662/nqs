package nbct.com.cn.customerquery.entity;

import java.util.Date;
import java.util.UUID;

/**
 * 用户登录日志
 * 
 * @author PJ
 * @version 创建时间：2019年9月7日 上午8:57:10
 */
public class UserLoginInfo {
	
	private String logId;
	
	private String userId;
	
	private Date loginDt;
	
	public UserLoginInfo(){
		
	}
	
	public UserLoginInfo(String userId){
		this.logId = UUID.randomUUID().toString();
		this.userId = userId;
		this.loginDt = new Date();
	}	

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getLoginDt() {
		return loginDt;
	}

	public void setLoginDt(Date loginDt) {
		this.loginDt = loginDt;
	} 

}
