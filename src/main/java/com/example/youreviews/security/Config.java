package com.example.youreviews.security;

import com.example.youreviews.exception.EmailNotFoundException;
import com.example.youreviews.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Config  {

    @Autowired
    public Config(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private final UserRepository userRepository;
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());

        return authenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService()  {
        return email -> {
            try {
                return userRepository.findByEmail(email)
                        .orElseThrow(() -> new EmailNotFoundException("User not found"));
            } catch (EmailNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
