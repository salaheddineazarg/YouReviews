package com.example.youreviews.security.Auth;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthenticationController {



    @GetMapping
    public String loginPage(){

        return "login";
    }

   /* @PostMapping
    public String login(){

        return "redirect:/?secussful";
    }*/


}