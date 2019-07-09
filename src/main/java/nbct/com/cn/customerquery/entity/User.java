package nbct.com.cn.customerquery.entity;

/**
 * 客户信息
 * 
 * @author PJ
 * @version 创建时间：2019年7月6日 下午6:25:33 用户
 */

public class User {

	private String userId;

	private String userName;

	private String password;
	
	/**
	 * 角色，简化版先这样了，应该会是一个功能字符串
	 */
	private String roleId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", roleId=" + roleId
				+ "]";
	}

}
