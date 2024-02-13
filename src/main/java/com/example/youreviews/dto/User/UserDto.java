package com.example.youreviews.dto.User;

import com.example.youreviews.enumeration.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private UUID id;

    @NotBlank(message = "Full name is required")
    @Size(max = 255, message = "Full name must be less than or equal to 255 characters")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]+$", message = "Password must contain at least one letter, one number, and may include special characters")
    private String password;

    @NotNull(message = "User role is required")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
