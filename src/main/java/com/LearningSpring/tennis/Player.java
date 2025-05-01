package com.LearningSpring.tennis;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record Player(
//        @NotBlank(message = "First name is mandator") String firstName, // to customize message
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotNull @PastOrPresent LocalDate birthDate,
        @Valid Rank rank
) {
}
