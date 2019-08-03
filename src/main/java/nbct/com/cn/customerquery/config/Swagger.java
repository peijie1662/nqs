package nbct.com.cn.customerquery.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.service.Parameter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置<br>
 * http://localhost/swagger-ui.html#!/
 *
 * @author PJ
 * @version 创建时间：2018年11月19日 上午11:04:53
 */
@Configuration
@EnableSwagger2
public class Swagger {
    @Bean
    public Docket api() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2) //
                .apiInfo(apiInfo()) //
                .useDefaultResponseMessages(false) //
                .select() //
                .apis(RequestHandlerSelectors.any()) //
                .paths(PathSelectors.regex("^(?!auth).*$")) //
                .paths(Predicates.not(PathSelectors.regex("/error.*"))) //
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("NBCT Web Query Service(NQS)").description("NBCT网站查询服务").version("0.1")
                .build();
    }

}
