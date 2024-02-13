package com.example.youreviews.entities;


import com.example.youreviews.enumeration.TypeReaction;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reviews {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Title is required")
    private String titre;

    @NotBlank(message = "Message is required")
    private String message;

    @NotNull(message = "Date is required")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @NotNull(message = "Reaction type is required")
    @Enumerated(EnumType.STRING)
    private TypeReaction reaction;

    @ManyToOne
    @NotNull(message = "User is required")
    private User user;
}
