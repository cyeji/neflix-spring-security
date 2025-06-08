package com.fastcampus.netflix;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRegisterCommand {
    private String username;
    private String encryptedPassword;
    private String email;
    private String phone;
}
