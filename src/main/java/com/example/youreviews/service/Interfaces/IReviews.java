package com.example.youreviews.service.Interfaces;

import com.example.youreviews.dto.Reviews.ReviewsDtoResponse;

import java.util.List;

public interface IReviews {

    List<ReviewsDtoResponse> getAll();
}
