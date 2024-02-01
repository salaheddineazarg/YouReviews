package com.example.youreviews.service.Interfaces;

import com.example.youreviews.dto.Reviews.ReviewsDto;
import com.example.youreviews.dto.Reviews.ReviewsDtoResponse;
import com.example.youreviews.entities.Reviews;

import java.util.List;

public interface IReviews {

    List<ReviewsDtoResponse> getAll();

    ReviewsDtoResponse addReview(ReviewsDto reviewsDto);

    ReviewsDtoResponse updateReview(ReviewsDto reviewsDto);

    ReviewsDtoResponse getReviewById(Long id);

    int deleteReviewById(Long id);
}

