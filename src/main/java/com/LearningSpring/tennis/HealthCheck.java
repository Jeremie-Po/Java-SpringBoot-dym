package com.LearningSpring.tennis;

import com.LearningSpring.tennis.rest.ApplicationStatus;

public record HealthCheck(ApplicationStatus status, String message) {
}
