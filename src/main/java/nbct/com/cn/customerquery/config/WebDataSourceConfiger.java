package nbct.com.cn.customerquery.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * WEB DB
 * 
 * @author PJ
 * @version 创建时间：2019年7月8日 下午3:42:23
 */
@Configuration
@MapperScan(basePackages = WebDataSourceConfiger.PACKAGE, sqlSessionFactoryRef = "webSqlSessionFactory")
public class WebDataSourceConfiger {

	static final String PACKAGE = "nbct.com.cn.customerquery.mapper.web";
	static final String MAPPER_LOCATION = "classpath:mapper/web/*.xml";

	@Primary
	@Bean("webDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.web")
	public DataSource webDataSource() {
		return new DruidDataSource();
	}

	@Primary
	@Bean("webTransactionManager")
	public DataSourceTransactionManager webTransactionManager() {
		return new DataSourceTransactionManager(webDataSource());
	}

	@Primary
	@Bean("webSqlSessionFactory")
	public SqlSessionFactory webSqlSessionFactory(@Qualifier("webDataSource") DataSource webDataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(webDataSource);
		sessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(WebDataSourceConfiger.MAPPER_LOCATION));
		return sessionFactory.getObject();
	}
}
