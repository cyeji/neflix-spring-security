package com.fastcampus.netflix;

import com.fastcampus.netflix.user.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements RegisterUserUseCase {
    
    @Override
    public UserRegistrationResponse register(UserRegisterCommand request) {
        return null;
    }
}
