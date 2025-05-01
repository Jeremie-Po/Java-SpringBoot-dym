package com.LearningSpring.tennis;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PlayerToRegister(
        @NotBlank(message = "FirstName is mandatory") String firstName,
        @NotBlank(message = "LastName is mandatory") String lastName,
        @NotNull(message = "Birth Date is mandatory") @PastOrPresent(message = "Birth date must be past or Present") LocalDate birthDate,
        @PositiveOrZero(message = "Points must be more than zero") int points
) {
}
