package com.example.youreviews.service.Impl;


import com.example.youreviews.dto.Reviews.ReviewsDto;
import com.example.youreviews.dto.Reviews.ReviewsDtoResponse;
import com.example.youreviews.dto.User.UserDto;
import com.example.youreviews.dto.User.UserDtoResponse;
import com.example.youreviews.entities.User;
import com.example.youreviews.repositories.UserRepository;
import com.example.youreviews.service.Interfaces.IReviews;
import com.example.youreviews.service.Interfaces.IUser;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUser {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserDtoResponse> getAll() {
        return Arrays.asList(modelMapper.map(userRepository.findAll(), UserDtoResponse.class));
    }

    @Override
    public Optional<UserDtoResponse> addUser(UserDto userDto) {
        User user=modelMapper.map(userDto,User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user = userRepository.save(user);
        return Optional.ofNullable(modelMapper.map(user, UserDtoResponse.class));
    }

    @Override
    public Optional<UserDtoResponse> updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public Optional<UserDtoResponse> getUserById(Long id) {
        return null;
    }

    @Override
    public int deleteUserById(Long id) {
        return 0;
    }
}
