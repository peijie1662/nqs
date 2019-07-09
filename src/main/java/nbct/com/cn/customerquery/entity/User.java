package nbct.com.cn.customerquery.entity;

import java.util.Date;

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
	 * 用户类型 A(管理员),C(海关),D(堆场),H(货代),V(船公司)
	 */
	private String userType;
	
	/**
	 * 用户角色 10(普通用户),90(内部用户),99(管理员)
	 */
	private String userRole;
	
	private String telephone;
	
	private Date addTime;
	
	private String address;
	
	private String company;
	
	/**
	 * 代码
	 */
	private String cpyco;

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCpyco() {
		return cpyco;
	}

	public void setCpyco(String cpyco) {
		this.cpyco = cpyco;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userType=" + userType + ", userRole=" + userRole
				+ "]";
	}
	
}
