package nbct.com.cn.customerquery.mapper.web;

import org.apache.ibatis.annotations.Param;

import nbct.com.cn.customerquery.entity.User;

/**
* @author PJ 
* @version 创建时间：2019年7月6日 下午6:33:26
*/

public interface LoginMapper {
	
	/**
	 * 用户登录 
	 */
	User findUserById(@Param("userId") String userId,@Param("password") String password);
	

}
