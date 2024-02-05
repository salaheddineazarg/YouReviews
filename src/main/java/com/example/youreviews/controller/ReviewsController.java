package com.example.youreviews.controller;


import com.example.youreviews.dto.Reviews.ReviewsDto;
import com.example.youreviews.dto.User.UserDto;
import com.example.youreviews.enumeration.TypeReaction;
import com.example.youreviews.service.Interfaces.IReviews;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/api/reviews")
public class ReviewsController {


    private final IReviews service;

    public ReviewsController(IReviews service){

        this.service=service;
    }


    @GetMapping(path = "/hello")
    public String getAll(Model model){
        model.addAttribute("all",service.getAll());

        return "index";
    }

    @PostMapping("/addReview")
    public String addReview(@RequestParam("message") String message) {

        ReviewsDto reviewsDto = new ReviewsDto();
        reviewsDto.setMessage(message);
        reviewsDto.setTitre("Static Title");
        reviewsDto.setDate(LocalDateTime.now());
        reviewsDto.setReaction(TypeReaction.Like);

        service.addReview(reviewsDto);

        return "redirect:/index";
    }

    @PostMapping("/updateReview")
    public String updateReview(@Valid ReviewsDto reviewsDto, BindingResult result) {
        if (result.hasErrors()) {
            return "update-review";
        }
        service.updateReview(reviewsDto);
        return "index";
    }

    @PostMapping("/deleteReview/{id}")
    public String deleteReview(@PathVariable("id") Long id) {
        service.deleteReviewById(id);
        return "index";
    }


}
