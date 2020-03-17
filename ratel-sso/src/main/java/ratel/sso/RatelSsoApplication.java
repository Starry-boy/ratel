package ratel.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ratel
 * @date 2020/3/16
 */
@SpringBootApplication
@MapperScan("ratel.sso.mapper")
public class RatelSsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(RatelSsoApplication.class,args);
    }
}
