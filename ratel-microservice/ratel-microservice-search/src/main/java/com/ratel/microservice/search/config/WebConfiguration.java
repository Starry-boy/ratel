package com.ratel.microservice.search.config;

import com.ratel.microservice.search.interceptor.HystrixCacheInterceptor;
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
