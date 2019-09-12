package nbct.com.cn.customerquery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import nbct.com.cn.customerquery.interceptor.AuthenticationInterceptor;
import nbct.com.cn.customerquery.interceptor.CallSatisticsInterceptor;

/**
 * 配置拦截器
 * 
 * @author PJ
 * @version 创建时间：2019年7月7日 上午9:28:14
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(callSatisticsInterceptor()).addPathPatterns("/**");
	}

	@Bean
	public AuthenticationInterceptor authenticationInterceptor() {
		return new AuthenticationInterceptor();
	}

	@Bean
	public CallSatisticsInterceptor callSatisticsInterceptor() {
		return new CallSatisticsInterceptor();
	}

}
