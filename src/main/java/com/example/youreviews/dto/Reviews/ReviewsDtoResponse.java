package com.example.youreviews.dto.Reviews;

import com.example.youreviews.dto.User.UserDto;
import com.example.youreviews.enumeration.TypeReaction;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsDtoResponse {


    private Long id;

    private String titre;

    private String message;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private TypeReaction reaction;

    private UserDto user;
}
