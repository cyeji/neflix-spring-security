package com.example.sso.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/")
    public String main(OAuth2AuthenticationToken token) {
        OAuth2User principal = token.getPrincipal();
        log.info("token: {}", principal);
        return "main.html";
    }
}
