package nbct.com.cn.customerquery.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.auth0.jwt.exceptions.JWTVerificationException;

import nbct.com.cn.customerquery.entity.CallResult;
import org.springframework.http.HttpStatus;

/**
 * @author PJ
 * @version 创建时间：2019年7月7日 下午8:37:32
 */
@ControllerAdvice
public class GloablExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GloablExceptionHandler.class);

	@ExceptionHandler(value = JWTVerificationException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public CallResult handleJWTVerificationException(JWTVerificationException e) {
		CallResult r = new CallResult();
		r.setFlag(false);
		r.setErrMsg("签名验证失败，请重新登录");
		return r;
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public CallResult handleException(Exception e) {
		CallResult r = new CallResult();
		r.setFlag(false);
		r.setErrMsg(e.getMessage());
		logger.info("Exception:" + r.getErrMsg());
		e.printStackTrace();
		return r;
	}
}
