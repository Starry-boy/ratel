package com.ratel.log.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author com.ratel
 * @date 2020/3/21
 */
@SpringBootApplication
//@EnableDiscoveryClient
//@EnableEurekaClient
//@EnableFeignClients("com.ratel.search.api")
public class RatelLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(RatelLogApplication.class,args);
    }
}
