package com.springboot.securitymybatisjsonverifycode.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConf {
    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.securitymybatisjsonverifycode"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().title("管理系统").description("运输管理系统")
                                .version("1.0.0")
/*.contact(new Contact("hong","127.0.0.1","asd@d.com"))*/
/* .license("licence")
.licenseUrl("www.baidu.com")*/
                                .build()
                );
    }
}
