package com.ratel.microservice.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author com.ratel
 * @date 2020/3/15
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced //Ribbon 客户端负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean //使用随机策略
    public IRule iRule(){
        return new RandomRule();
    }
}
