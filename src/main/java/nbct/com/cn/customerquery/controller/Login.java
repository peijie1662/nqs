package nbct.com.cn.customerquery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.entity.CallResult;
import nbct.com.cn.customerquery.entity.User;
import nbct.com.cn.customerquery.service.LoginService;
import nbct.com.cn.customerquery.service.TokenService;

/**
 * 用户登录服务
 * 
 * @author PJ
 * @version 创建时间：2019年7月6日 下午4:57:26 用户登录
 */
@Api(value = "用户登录")
@RestController
public class Login {

	@Autowired
	LoginService loginService;
	
	@Autowired
	TokenService tokenService;

	@ApiOperation(value = "用户登录", notes = "用户密码验证")
	@ApiImplicitParam(name = "loginUser", value = "{userId:'xx',password:'xx'}", required = true, dataType = "User")
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult login(@RequestBody User loginUser) {
		CallResult r = new CallResult();
		User user = loginService.findUserById(loginUser);
		if (user != null) {
			r.setFlag(true);
			r.setData(tokenService.getToken(user));
		} else {
			r.setFlag(false);
			r.setErrMsg("用户或密码错误。");
		}
		return r;
	}

}
