package ratel.sso.consumer.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @deprecated 自定义 actuator health端点 healthIndicator
 * @author ratel
 * @date 2020/3/15
 */
@Component
public class SsoHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().withDetail("msg","ovo").build();
    }
}
