package com.example.youreviews.controller;


import com.example.youreviews.entities.User;
import com.example.youreviews.enumeration.UserRole;
import com.example.youreviews.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
  @GetMapping
    public String createUser()
  {
      User user = new User();
      user.setPassword(passwordEncoder.encode("12345"));
      user.setUserRole(UserRole.Client);
      user.setFullName("salaheddine");
      user.setEmail("salah@gmail.com");
      userRepository.save(user);
      return "login";
  }




}
