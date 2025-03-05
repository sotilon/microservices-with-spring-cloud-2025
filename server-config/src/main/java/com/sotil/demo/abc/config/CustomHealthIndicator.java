package com.sotil.demo.abc.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Custom logic to check health
        boolean isHealthy = checkCustomHealth();
        if (isHealthy) {
            return Health.up().withDetail("Custom Health", "Service is running smoothly").build();
        } else {
            return Health.down().withDetail("Custom Health", "Service has issues").build();
        }
    }

    private boolean checkCustomHealth() {
        // Implement your custom health check logic here
        return true;
    }
}