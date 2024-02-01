package com.example.youreviews.service.Interfaces;


import com.example.youreviews.dto.Reviews.ReviewsDto;
import com.example.youreviews.dto.Reviews.ReviewsDtoResponse;
import com.example.youreviews.dto.User.UserDto;
import com.example.youreviews.dto.User.UserDtoResponse;

import java.util.List;

public interface IUser {

    List<UserDtoResponse> getAll();

    UserDtoResponse addUser(UserDto userDto);

    UserDtoResponse updateUser(UserDto userDto);

    UserDtoResponse getUserById(Long id);

    int deleteUserById(Long id);
}
