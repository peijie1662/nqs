package nbct.com.cn.customerquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author PJ
 * @version 创建时间：2019年7月6日 下午7:58:16
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableSwagger2
public class CustomerQueryServer {
	public static void main(String[] args) {
		SpringApplication.run(CustomerQueryServer.class, args);
	}
}
