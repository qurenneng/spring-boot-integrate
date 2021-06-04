package com.example.springbootactuatorintegrat.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/4 11:55
 * @time 11:55
 * 编写自定义健康指标
 *
 * DOWN 503
 * OUT_OF_SERVICE 503
 * UP 默认没有映射，所以 HTTP 状态是 200
 * UNKNOWN 默认没有映射，所以 HTTP 状态是 200
 *
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {
        // perform some specific health check
        return 1;
    }

}
