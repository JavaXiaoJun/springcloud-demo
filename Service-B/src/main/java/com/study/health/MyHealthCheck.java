package com.study.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by lf52 on 2018/5/2.
 */
@Component
public class MyHealthCheck implements HealthIndicator{

    /**
     * 自定义监控指标
     * @return
     */
    @Override
    public Health health() {
        if(check()){
            return Health.down().withDetail("myhealthccheck","red").build();
        }
        return Health.up().withDetail("myhealthccheck","green").build();
    }

    private boolean check() {
        // check logic
        return false;
    }

}
