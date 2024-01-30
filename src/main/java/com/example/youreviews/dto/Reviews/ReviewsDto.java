package com.example.youreviews.dto.Reviews;


import com.example.youreviews.entities.User;
import com.example.youreviews.enumeration.TypeReaction;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsDto {


    private Long id;

    @NotBlank(message = "Title is required")
    private String titre;

    @NotBlank(message = "Message is required")
    private String message;

    @NotNull(message = "Date is required")
    @FutureOrPresent(message = "Date must be in the present or future")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @NotNull(message = "Reaction type is required")
    @Enumerated(EnumType.STRING)
    private TypeReaction reaction;

    @NotNull(message = "User ID is required")
    @Positive(message = "User ID must be a positive number")
    private Long user_id;
}
