package ratel.sso.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author ratel
 * @date 2020/3/15
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient //Eureka 负载均衡
@RibbonClient //自定义Ribbon负载均衡策略
public class RatelSsoConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RatelSsoConsumerApplication.class,args);
    }
}
