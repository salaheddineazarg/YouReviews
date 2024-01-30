package com.example.youreviews.service.Impl;


import com.example.youreviews.dto.Reviews.ReviewsDtoResponse;
import com.example.youreviews.service.Interfaces.IReviews;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IReviews {


    @Override
    public List<ReviewsDtoResponse> getAll() {
        return null;
    }
}
