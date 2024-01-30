package com.example.youreviews.controller;


import com.example.youreviews.service.Interfaces.IReviews;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class ReviewsController {


    private final IReviews service;

    public ReviewsController(IReviews service){

        this.service=service;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("all",service.getAll());

        return "index";
    }
}
