package com.csdj.springbootsecurity.component;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;

public class HealComponent implements HealthIndicator {

    @Override
    public Health health() {
        if (1 == 2) {
            return Health.status(Status.UP).withDetail("Error Code","error").build();
        }
        return Health.status(Status.DOWN).build();
    }

    Health health = Health.status(Status.DOWN)
            .withDetail("msg","error service")
            .withDetail("Error Code","500")
            .withException(new RuntimeException())
            .build();
}
