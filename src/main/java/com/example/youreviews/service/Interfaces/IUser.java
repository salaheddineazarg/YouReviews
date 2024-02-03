package com.example.youreviews.service.Interfaces;


import com.example.youreviews.dto.Reviews.ReviewsDto;
import com.example.youreviews.dto.Reviews.ReviewsDtoResponse;
import com.example.youreviews.dto.User.UserDto;
import com.example.youreviews.dto.User.UserDtoResponse;

import java.util.List;
import java.util.Optional;

public interface IUser {

    List<UserDtoResponse> getAll();

    Optional<UserDtoResponse> addUser(UserDto userDto);

   Optional<UserDtoResponse> updateUser(UserDto userDto);

    Optional<UserDtoResponse> getUserById(Long id);

    int deleteUserById(Long id);
}
