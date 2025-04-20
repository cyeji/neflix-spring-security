package com.fastcampus.neflixspringsecurity.presentation.user;

import com.fastcampus.neflixspringsecurity.infra.annotation.CustomEncryption;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HelloRequestBody {

    private String id;

    @CustomEncryption
    private String password;

    private HelloRequestBody(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public static HelloRequestBody from(String id, String password) {
        return new HelloRequestBody(id, password);
    }

}
