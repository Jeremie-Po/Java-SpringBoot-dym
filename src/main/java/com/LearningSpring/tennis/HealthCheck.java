package com.LearningSpring.tennis;

import com.LearningSpring.tennis.web.ApplicationStatus;

public record HealthCheck(ApplicationStatus status, String message) {
}
