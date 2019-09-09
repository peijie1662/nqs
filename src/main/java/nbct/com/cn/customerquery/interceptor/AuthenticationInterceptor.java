package nbct.com.cn.customerquery.interceptor;

import java.lang.reflect.Method;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import nbct.com.cn.customerquery.annotation.TokenCheck;
import nbct.com.cn.customerquery.config.ServerSecrity;
import nbct.com.cn.customerquery.entity.User;
import nbct.com.cn.customerquery.service.TokenService;

/**
 * 用户认证拦截
 * 
 * @author PJ
 * @version 创建时间：2019年7月6日 下午5:07:51
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

	@Autowired
	ServerSecrity secrity;

	@Autowired
	TokenService tokenService;

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj)
			throws JWTVerificationException {
		String token = req.getHeader("token");
		// 1.对象不是Controller方法
		if (!(obj instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) obj;
		Method method = handlerMethod.getMethod();
		// 2.检查
		if (method.isAnnotationPresent(TokenCheck.class)) {
			if (token == null) {
				throw new JWTVerificationException("未经过验证，请重新登录");
			}
			// 用户信息
			DecodedJWT jm = JWT.decode(token);
			User user = new User();
			user.setUserId(jm.getClaim("userId").toString());
			user.setUserType(jm.getClaim("userType").toString());
			user.setCompanyId(jm.getClaim("companyId").toString());
			user.setGroups(jm.getClaim("groups").toString());
			req.setAttribute("requester", user);
			// 验证
			String key = secrity.getKey();
			JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(key)).build();
			try {
				jwtVerifier.verify(token);
			} catch (JWTVerificationException e) {
				throw new JWTVerificationException("签名验证失败，请重新登录");
			}
			// 续签
			Date expireDate = jm.getExpiresAt();
			if (expireDate.getTime() - System.currentTimeMillis() < secrity.getExpireRefresh()) {
				String newToken = tokenService.getToken(user);
				res.setHeader("token", newToken);
			}
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3)
			throws Exception {

	}

}
