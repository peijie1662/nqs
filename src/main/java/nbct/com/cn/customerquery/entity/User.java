package nbct.com.cn.customerquery.entity;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 客户信息
 * 
 * @author PJ
 * @version 创建时间：2019年7月6日 下午6:25:33 用户
 */
public class User {

	private String userId;

	private String userName;

	@JSONField(serialize = false)
	private String password;

	/**
	 * 用户类型 A(管理员),C(海关),D(堆场),H(货代),V(船公司)
	 */
	private String userType;

	/**
	 * 用户对应功能组
	 */
	private String groups;

	private String telephone;

	private String address;

	private String company;

	private String companyId;

	private String opUser;

	private Date opDate;

	public User ignorePassword() {
		String origin = JSON.toJSONString(this);
		return JSON.parseObject(origin, User.class);
	}

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getOpUser() {
		return opUser;
	}

	public void setOpUser(String opUser) {
		this.opUser = opUser;
	}

	public Date getOpDate() {
		return this.opDate;
	}

	public void setOpDate(Date opDate) {
		this.opDate = opDate;
	}

}
