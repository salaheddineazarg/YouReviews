package com.example.youreviews.service.Interfaces;


import com.example.youreviews.dto.User.UserDtoResponse;

import java.util.List;

public interface IUser {

    List<UserDtoResponse> getAll();
}
