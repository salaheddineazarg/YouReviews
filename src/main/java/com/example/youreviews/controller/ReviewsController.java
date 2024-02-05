package com.example.youreviews.controller;


import com.example.youreviews.dto.Reviews.ReviewsDto;
import com.example.youreviews.dto.User.UserDto;
import com.example.youreviews.service.Interfaces.IReviews;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/reviews")
public class ReviewsController {


    private final IReviews service;

    public ReviewsController(IReviews service){

        this.service=service;
    }


    @GetMapping
    public String getAll(Model model){
        model.addAttribute("reviews",service.getAll());

        return "index";
    }

    @PostMapping
    public String addReview(@Valid ReviewsDto reviewsDto, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/";
        }
        service.addReview(reviewsDto);
        return "redirect:/";
  }

    @PostMapping
    public String updateReview(@Valid ReviewsDto reviewsDto, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/";
        }
        service.updateReview(reviewsDto);
        return "redirect:/";
    }

    @PostMapping("/deleteReview/{id}")
    public String deleteReview(@PathVariable("id") Long id) {
        service.deleteReviewById(id);
        return "redirect:/";
    }


}
