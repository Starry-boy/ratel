package ratel.sso.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ratel
 * @date 2020/3/15
 */
@EnableDiscoveryClient
@SpringBootApplication
//@MapperScan("ratel.sso.provider.mapper")
public class RatelSsoProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RatelSsoProviderApplication.class, args);
    }
}
