package com.fastcampus.deepdivesecurity.presentation.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello World";
    }

}
