package nbct.com.cn.customerquery.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * AS400DL DB
 * 
 * @author SDW
 * @version 创建时间：2019年9月17日 下午20:33:23
 */
@Configuration
@MapperScan(basePackages = As400dlDataSourceConfiger.PACKAGE, sqlSessionFactoryRef = "as400dlSqlSessionFactory")
public class As400dlDataSourceConfiger {

  static final String PACKAGE = "nbct.com.cn.customerquery.mapper.as400dl";
  static final String MAPPER_LOCATION = "classpath:mapper/as400dl/*.xml";

  @Bean("as400dlDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.as400dl")
  public DataSource as400dlDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean("as400dlTransactionManager")
  public DataSourceTransactionManager as400dlTransactionManager() {
    return new DataSourceTransactionManager(as400dlDataSource());
  }

  @Bean("as400dlSqlSessionFactory")
  public SqlSessionFactory qrySqlSessionFactory(@Qualifier("as400dlDataSource") DataSource as400dlDataSource)
      throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(as400dlDataSource);
    sessionFactory.setMapperLocations(
        new PathMatchingResourcePatternResolver().getResources(As400dlDataSourceConfiger.MAPPER_LOCATION));
    return sessionFactory.getObject();
  }
}
