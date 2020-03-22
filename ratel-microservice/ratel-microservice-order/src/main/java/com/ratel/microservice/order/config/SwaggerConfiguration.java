package com.ratel.microservice.order.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author com.ratel
 * @date 2020/3/2
 */
@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfiguration {
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.basePackage(swagger2Property.getBasePackage()))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title(String.format("%s api 测试",applicationName))
                        .description(String.format("%s api 测试",applicationName))
                        .version("1.0")
                        .contact(new Contact("ratel", "blog.com.ratel.com", "jxc19960306@outlook.com"))
                        .license("The Apache License")
                        .licenseUrl("http://blog.ratel.com")
                        .build());
    }
}
