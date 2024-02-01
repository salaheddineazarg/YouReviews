package com.example.youreviews.service.Impl;


import com.example.youreviews.dto.Reviews.ReviewsDto;
import com.example.youreviews.dto.Reviews.ReviewsDtoResponse;
import com.example.youreviews.dto.User.UserDto;
import com.example.youreviews.dto.User.UserDtoResponse;
import com.example.youreviews.service.Interfaces.IReviews;
import com.example.youreviews.service.Interfaces.IUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUser {


    @Override
    public List<UserDtoResponse> getAll() {
        return null;
    }

    @Override
    public UserDtoResponse addUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDtoResponse updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDtoResponse getUserById(Long id) {
        return null;
    }

    @Override
    public int deleteUserById(Long id) {
        return 0;
    }
}
