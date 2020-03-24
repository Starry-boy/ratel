package com.ratel.microservice.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ratel
 * @date 2020/3/22
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.ratel.microservice")
@ComponentScan("com.ratel.microservice")
@EnableHystrix
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
