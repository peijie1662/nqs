package nbct.com.cn.customerquery.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * QRY DB
 * 
 * @author PJ
 * @version 创建时间：2019年7月8日 下午3:42:23
 */
@Configuration
@MapperScan(basePackages = QryDataSourceConfiger.PACKAGE, sqlSessionFactoryRef = "qrySqlSessionFactory")
public class QryDataSourceConfiger {

	static final String PACKAGE = "nbct.com.cn.customerquery.mapper.qry";
	static final String MAPPER_LOCATION = "classpath:mapper/qry/*.xml";

	@Bean("qryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.qry")
	public DataSource qryDataSource() {
		return new DruidDataSource();
	}

	@Bean("qryTransactionManager")
	public DataSourceTransactionManager qryTransactionManager() {
		return new DataSourceTransactionManager(qryDataSource());
	}

	@Bean("qrySqlSessionFactory")
	public SqlSessionFactory qrySqlSessionFactory(@Qualifier("qryDataSource") DataSource qryDataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(qryDataSource);
		sessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(QryDataSourceConfiger.MAPPER_LOCATION));
		return sessionFactory.getObject();
	}
}
