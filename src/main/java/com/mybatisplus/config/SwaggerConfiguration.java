package com.mybatisplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类
 * @author lml
 * @date 2021-10-25
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket docket(){
        Docket docket =new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo =new ApiInfoBuilder()
                .contact(new Contact("LML","xxxxx","aga@qq.com"))
                .build();

        docket.apiInfo(apiInfo);

       docket.select()  //获取选择器
                .apis(RequestHandlerSelectors.basePackage("com.mybatis_plus.controller.MyController"));

        return docket;
    }

}
