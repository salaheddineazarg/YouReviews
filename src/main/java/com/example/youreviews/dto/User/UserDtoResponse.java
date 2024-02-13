package com.example.youreviews.dto.User;


import com.example.youreviews.dto.Reviews.ReviewsDto;
import com.example.youreviews.enumeration.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {

    private UUID id;

    private String fullName;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private List<ReviewsDto> reviews;

}
