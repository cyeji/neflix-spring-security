package com.fastcampus.keycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialLoginController {

    @GetMapping("/api/v1/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/api/v2/hello")
    public String hello2() {
        return "Hello World!";
    }
    
    @GetMapping("/api/v1/login/kakao")
    public String kakaoLogin(@RequestParam String code) {
        return "hello kakao, code = " + code;
    }

}
