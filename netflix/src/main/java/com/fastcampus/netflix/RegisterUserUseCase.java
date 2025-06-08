package com.fastcampus.netflix;

import com.fastcampus.netflix.user.response.UserRegistrationResponse;

public interface RegisterUserUseCase {
    UserRegistrationResponse register(UserRegisterCommand request);
}
