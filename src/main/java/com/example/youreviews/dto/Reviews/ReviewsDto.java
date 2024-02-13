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
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsDto {


    private UUID id;


    private String titre;

    @NotBlank(message = "Message is required")
    private String message;

    private LocalDateTime date;


    private TypeReaction reaction;


    private Long user_id;
}
