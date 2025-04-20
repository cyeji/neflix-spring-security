package com.fastcampus.deepdivesecurity.infra.security;

import com.fastcampus.deepdivesecurity.infra.security.filters.LoggingFilter;
import com.fastcampus.deepdivesecurity.infra.security.filters.RequestValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
            .addFilterAfter(new LoggingFilter(), BasicAuthenticationFilter.class)
            .authorizeHttpRequests(c -> c.anyRequest().permitAll());

        return httpSecurity.build();
    }

}
