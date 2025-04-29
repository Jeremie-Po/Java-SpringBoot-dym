package com.LearningSpring.tennis.service;

import com.LearningSpring.tennis.rest.ApplicationStatus;
import com.LearningSpring.tennis.HealthCheck;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    public HealthCheck healthCheck() {
        return new HealthCheck(ApplicationStatus.OK, "welcome to tennis application");
    }

}
