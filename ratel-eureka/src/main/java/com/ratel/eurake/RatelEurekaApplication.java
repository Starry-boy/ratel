package com.ratel.eurake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author com.ratel
 * @date 2020/3/15
 */
@EnableEurekaServer
@SpringBootApplication
public class RatelEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(RatelEurekaApplication.class, args);
    }
}
