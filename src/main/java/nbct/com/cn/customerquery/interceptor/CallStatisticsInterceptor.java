package nbct.com.cn.customerquery.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import nbct.com.cn.customerquery.annotation.CallStatistics;
import nbct.com.cn.customerquery.service.RedisService;

/**
 * 调用次数统计
 * 
 * @author PJ
 * @version 创建时间：2019年9月10日 上午9:39:15
 */
public class CallStatisticsInterceptor implements HandlerInterceptor {

	@Autowired
	private RedisService redisService;

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		// 1.对象不是Controller方法
		if (!(obj instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) obj;
		Method method = handlerMethod.getMethod();
		// 2.检查
		String userId = req.getHeader("userId");
		userId = userId == null ? "guest" : userId;
		if (method.isAnnotationPresent(CallStatistics.class)) {
			CallStatistics cs = method.getAnnotation(CallStatistics.class);
			String functionId = cs.value().toString();
			redisService.saveFunctionCallLog(userId, functionId);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
