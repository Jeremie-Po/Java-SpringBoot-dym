package com.LearningSpring.tennis;

import com.LearningSpring.tennis.service.HealthCheckService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TennisApplicationTests {

    @Autowired
    private HealthCheckService healthCheckService;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(healthCheckService);
    }

}
