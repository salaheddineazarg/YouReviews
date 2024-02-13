package com.example.youreviews.controller;


import com.example.youreviews.dto.Reviews.ReviewsDto;
import com.example.youreviews.dto.User.UserDto;
import com.example.youreviews.enumeration.TypeReaction;

import com.example.youreviews.dto.User.UserDto;
import com.example.youreviews.enumeration.TypeReaction;

import com.example.youreviews.security.SecurityUtil;
import com.example.youreviews.service.Interfaces.IReviews;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.UUID;

import java.time.LocalDateTime;



@Controller
@RequestMapping("/")
public class ReviewsController {


    private final IReviews service;

    private final SecurityUtil securityUtil;
    public ReviewsController(IReviews service,SecurityUtil securityUtil){

        this.service=service;
        this.securityUtil=securityUtil;

    }


    @GetMapping
    public String getAll(Model model, Principal principal){

        model.addAttribute("reviews",service.getAll());
        model.addAttribute("reviewDto", new ReviewsDto());
        model.addAttribute("currentUserName",principal.getName());

        return "index";
    }



    @PostMapping("/add-review")
    public String addReview(@Valid @ModelAttribute ReviewsDto reviewsDto, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "redirect:/?fail";
        } else {
            service.addReview(reviewsDto);

            return "redirect:/?seccussful";
        }
    }


    @PostMapping("/update/{id}")
    public String updateReview(@Valid @ModelAttribute ReviewsDto reviewsDto, @PathVariable UUID id,BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/error";
        }
        service.updateReview(reviewsDto,id);
        return "redirect:/?update=successfully";
    }

    @GetMapping("delete/{id}")
    public String deleteReview( @Valid @PathVariable("id") UUID id) {
        service.deleteReviewById(id);
        return "redirect:/?delete=seccussfully";
    }


}
