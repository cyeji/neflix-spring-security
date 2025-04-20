package com.fastcampus.neflixspringsecurity.infra.config;

import com.fastcampus.neflixspringsecurity.infra.exceptions.CustomEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.httpBasic(c -> c.realmName("REALM_1").authenticationEntryPoint(new CustomEntryPoint()));
        security.authorizeHttpRequests(a -> a.anyRequest().authenticated());
        return security.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
