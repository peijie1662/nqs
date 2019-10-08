package nbct.com.cn.customerquery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.annotation.CallStatistics;
import nbct.com.cn.customerquery.annotation.NBCTWebFunction;
import nbct.com.cn.customerquery.entity.CallResult;
import nbct.com.cn.customerquery.entity.User;
import nbct.com.cn.customerquery.entity.UserLoginInfo;
import nbct.com.cn.customerquery.service.LoginService;
import nbct.com.cn.customerquery.service.RedisService;
import nbct.com.cn.customerquery.service.TokenService;

/**
 * 用户登录服务
 * 
 * @author PJ
 * @version 创建时间：2019年7月6日 下午4:57:26 用户登录
 */
@Api(value = "用户登录")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Login {

	private static final Logger logger = LoggerFactory.getLogger(Login.class);

	@Autowired
	LoginService loginService;

	@Autowired
	TokenService tokenService;

	@Autowired
	RedisService redisService;

	@CallStatistics(NBCTWebFunction.LOGIN)
	@ApiOperation(value = "用户登录", notes = "用户密码验证")
	@ApiImplicitParam(name = "loginUser", required = true, dataType = "User")
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult login(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		String userId = p.getString("userId");
		String password = p.getString("password");
		User user = loginService.findUserById(userId, password);
		if (user != null) {
			String token = tokenService.getToken(user);
			JSONObject data = new JSONObject();
			data.put("token", token);
			data.put("user", user.ignoreProtectionFields());
			r.setData(data);
			r.setFlag(true);
			loginService.userLoginInfo(new UserLoginInfo(user.getUserId()));
			logger.info(userId + " login success.");
		} else {
			r.setFlag(false);
			r.setErrMsg("用户或密码错误。");
			logger.info(userId + " login fail.");
		}
		return r;
	}

	@CallStatistics(NBCTWebFunction.LOGOUT)
	@ApiOperation(value = "用户退出", notes = "用户退出")
	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult logout() {
		CallResult r = new CallResult();
		r.setFlag(true);
		return r;
	}

	@CallStatistics(NBCTWebFunction.PERIODLOG)
	@ApiOperation(value = "访问日志", notes = "查询时间范围内访问日志")
	@RequestMapping(value = "/periodlog", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult periodFunctionCallLog(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		r.setFlag(true);
		int bg = p.getInteger("bg");
		int ed = p.getInteger("ed");
		String option = p.getString("option");
		if ("ORIGIN".equals(option)) {
			r.setData(redisService.periodFunctionCallLog(bg, ed));
		} else if ("GROUPBYUSER".equals(option)) {
			r.setData(redisService.groupByUser(bg, ed));
		} else if ("GROUPBYFUNCTION".equals(option)) {
			r.setData(redisService.groupByFunction(bg, ed));
		} else if ("GROUPBYDATE".equals(option)) {
			r.setData(redisService.groupByCallDt(bg, ed));
		} else {
			r.setFlag(false);
			r.setErrMsg("指定选项无效。");
		}
		return r;
	}

	@ApiOperation(value = "接口描述", notes = "系统接口描述")
	@RequestMapping(value = "/sysinterface", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult sysInterface() {
		CallResult r = new CallResult();
		r.setFlag(true);
		r.setData(NBCTWebFunction.toList());
		return r;
	}

}
