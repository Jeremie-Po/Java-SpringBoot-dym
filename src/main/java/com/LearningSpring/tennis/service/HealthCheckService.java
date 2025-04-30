package com.LearningSpring.tennis.service;

import com.LearningSpring.tennis.repository.HealthCheckRepository;
import com.LearningSpring.tennis.ApplicationStatus;
import com.LearningSpring.tennis.HealthCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    @Autowired
    private HealthCheckRepository healthCheckRepository;

    public HealthCheck healthCheck() {
        Long activeSessions = healthCheckRepository.countApplicationConnections();

        if (activeSessions > 0) {
            return new HealthCheck(ApplicationStatus.OK, "welcome to tennis application");
        }
        return new HealthCheck(ApplicationStatus.KO, "no active connections");
    }

}
