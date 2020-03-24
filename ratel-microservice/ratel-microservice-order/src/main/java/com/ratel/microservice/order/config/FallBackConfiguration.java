package com.ratel.microservice.order.config;

import com.ratel.microservice.search.api.fallback.SearchFeignApiFallBack;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ratel
 * @date 2020/3/24
 */
//@Configuration
public class FallBackConfiguration {

    @Bean
    public SearchFeignApiFallBack searchFeignApiFallBack(){
        return new SearchFeignApiFallBack();
    }
}
