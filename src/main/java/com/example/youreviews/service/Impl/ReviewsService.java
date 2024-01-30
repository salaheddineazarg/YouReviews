package com.example.youreviews.service.Impl;


import com.example.youreviews.dto.User.UserDtoResponse;
import com.example.youreviews.service.Interfaces.IUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService implements IUser {


    @Override
    public List<UserDtoResponse> getAll() {
        return null;
    }
}
