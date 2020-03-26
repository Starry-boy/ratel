package com.ratel.microservice.order.config;

import com.ratel.microservice.order.aop.HystrixCacheInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ratel
 * @date 2020/3/26
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HystrixCacheInterceptor()).addPathPatterns("/**");
    }
}
