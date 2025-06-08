package com.fastcampus.netflix.controller;

import com.fastcampus.netflix.RegisterUserUseCase;
import com.fastcampus.netflix.UserRegisterCommand;
import com.fastcampus.netflix.user.request.UserRegisterRequest;
import com.fastcampus.netflix.user.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final RegisterUserUseCase registerUserUseCase;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/api/v1/user/register")
    public ResponseEntity<UserRegistrationResponse> register(@RequestBody UserRegisterRequest request) {
        UserRegistrationResponse register = registerUserUseCase.register(UserRegisterCommand.builder().username(request.getUsername()).email(request.getEmail()).encryptedPassword(passwordEncoder.encode(request.getPassword())).phone(request.getPhone()).build());
        return ResponseEntity.ok(register);
    }

}
