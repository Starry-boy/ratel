package com.ratel.microservice.order.config;

import com.ratel.microservice.search.api.fallback.SearchFeignApiFallBack;
import feign.Feign;
import feign.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author ratel
 * @date 2020/3/24
 */
//@Configuration
//public class FallBackConfiguration {
//
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //多例
//    @ConditionalOnProperty("feign.hystrix.enabled")
//    public Feign.Builder feignFallbackStrategy(FeignContext feignContext){
//        return new Feign.Builder().logLevel(Logger.Level.FULL).
//    }
//}
