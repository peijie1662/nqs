package nbct.com.cn.customerquery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author PJ
 * @version 创建时间：2019年9月26日 下午2:44:49
 */
@Configuration
public class CORSConfiguration extends WebMvcConfigurationSupport {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*");
		super.addCorsMappings(registry);
	}

}
