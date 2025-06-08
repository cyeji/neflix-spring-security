package com.fastcampus.netflix.user.request;

import lombok.Getter;


@Getter
public class UserRegisterRequest {
    private String email;
    private String password;
    private String username;
    private String phone;
}
