package com.example.youreviews.service.Impl;


import com.example.youreviews.dto.Reviews.ReviewsDto;
import com.example.youreviews.dto.Reviews.ReviewsDtoResponse;
import com.example.youreviews.dto.User.UserDtoResponse;
import com.example.youreviews.entities.Reviews;
import com.example.youreviews.repositories.ReviewsRepository;
import com.example.youreviews.service.Interfaces.IReviews;
import com.example.youreviews.service.Interfaces.IUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewsService implements IReviews {

    private final ReviewsRepository reviewsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository, ModelMapper modelMapper) {
        this.reviewsRepository = reviewsRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ReviewsDtoResponse> getAll() {
       List<Reviews> reviewsList = reviewsRepository.findAll();
        List<ReviewsDtoResponse> dtoResponseList = reviewsList.stream()
                .map(review -> modelMapper.map(review, ReviewsDtoResponse.class))
                .collect(Collectors.toList());
        return dtoResponseList;
    }

    @Override
    public ReviewsDtoResponse addReview(ReviewsDto reviewsDto) {
        Reviews reviewToAdd = modelMapper.map(reviewsDto, Reviews.class);
        Reviews savedReview = reviewsRepository.save(reviewToAdd);
        return modelMapper.map(savedReview, ReviewsDtoResponse.class);
    }

    @Override
    public ReviewsDtoResponse updateReview(ReviewsDto reviewsDto) {
        Optional<Reviews> optionalReview = reviewsRepository.findById(reviewsDto.getId());

        if (optionalReview.isPresent()) {
            Reviews reviewToUpdate = optionalReview.get();
            reviewToUpdate.setTitre(reviewsDto.getTitre());
            reviewToUpdate.setMessage(reviewsDto.getMessage());
            reviewToUpdate.setDate(reviewsDto.getDate());
            reviewToUpdate.setReaction(reviewsDto.getReaction());

            Reviews updatedReview = reviewsRepository.save(reviewToUpdate);
            return modelMapper.map(updatedReview, ReviewsDtoResponse.class);
        } else {
            return null;
        }
    }


    @Override
    public int deleteReviewById(Long id) {
        reviewsRepository.deleteById(id);
        return 1;
    }


    @Override
    public ReviewsDtoResponse getReviewById(Long id) {
        return null;
    }
}
