package nbct.com.cn.customerquery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.exceptions.JWTVerificationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.service.QryService;
import nbct.com.cn.customerquery.service.RedisService;

/**
 * @author PJ
 * @version 创建时间：2019年7月7日 下午2:20:10 类说明
 */
@Api(value = "测试")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class Test {

	@Autowired
	QryService qryService;

	@Autowired
	RedisService redisService;

	//@TokenCheck
	@ApiOperation(value = "测试", notes = "令牌测试")
	@RequestMapping(value = "/tokentest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public void needToken() {
		//CallResult r = new CallResult();
		//r.setFlag(false);
		//r.setErrMsg("error!");
		//return r;
		
		throw new JWTVerificationException("jwt error!");
	}

	@ApiOperation(value = "测试", notes = "QRY测试")
	@RequestMapping(value = "/qrytest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Object YardContainer() {
		return qryService.getYardContainers();
	}

	@ApiOperation(value = "Redis测试 ", notes = "Redis测试")
	@RequestMapping(value = "/redistest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public void redisTest() {
		redisService.saveFunctionCallLog("AA", "BB");
	}

}
