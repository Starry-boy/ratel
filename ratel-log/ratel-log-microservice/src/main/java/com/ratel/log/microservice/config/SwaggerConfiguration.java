package com.ratel.log.microservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author com.ratel
 * @date 2020/3/2
 */
//@Configuration
//@EnableSwagger2
//@Slf4j
//public class SwaggerConfiguration {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
////                .apis(RequestHandlerSelectors.basePackage(swagger2Property.getBasePackage()))
//                .paths(PathSelectors.any())
//                .build().apiInfo(new ApiInfoBuilder()
//                        .title("Ratel sso api test")
//                        .description("sso 单点登录服务 测试")
//                        .version("1.0")
//                        .contact(new Contact("ratel", "blog.com.ratel.com", "jxc19960306@outlook.com"))
//                        .license("The Apache License")
//                        .licenseUrl("http://blog.ratel.com")
//                        .build());
//    }
//
//}
