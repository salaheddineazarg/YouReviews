package com.example.youreviews.service.Impl;


import com.example.youreviews.dto.Reviews.ReviewsDto;
import com.example.youreviews.dto.Reviews.ReviewsDtoResponse;
import com.example.youreviews.entities.Reviews;
import com.example.youreviews.entities.User;
import com.example.youreviews.repositories.ReviewsRepository;
import com.example.youreviews.repositories.UserRepository;
import com.example.youreviews.security.SecurityUtil;
import com.example.youreviews.service.Interfaces.IReviews;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReviewsService implements IReviews {

    private final ReviewsRepository reviewsRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository,
                          ModelMapper modelMapper,
                          UserRepository userRepository) {
        this.reviewsRepository = reviewsRepository;
        this.modelMapper = modelMapper;
        this.userRepository=userRepository;
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
        String email = SecurityUtil.getSessionUser();
        User user = userRepository.findByEmail(email).get();
        Reviews review = modelMapper.map(reviewsDto, Reviews.class);
        review.setUser(user);
        Reviews savedReview = reviewsRepository.save(review);
        return modelMapper.map(savedReview, ReviewsDtoResponse.class);
    }

    @Override
    public ReviewsDtoResponse updateReview(ReviewsDto reviewsDto,UUID id) {
        Optional<Reviews> optionalReview = reviewsRepository.findById(id);

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
    public int deleteReviewById(UUID id) {
        reviewsRepository.deleteById(id);
        return 1;
    }


    @Override
    public ReviewsDtoResponse getReviewById(UUID id) {
        return null;
    }
}
