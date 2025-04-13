package com.fastcampus.neflixspringsecurity.infra.config;

import com.fastcampus.neflixspringsecurity.presentation.user.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/hello").permitAll() // 여기는 허용
                .anyRequest().authenticated() // 나머지는 인증 필요
            )
            .httpBasic(Customizer.withDefaults()) // 기본 인증 유지
            .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails danny = User.withUsername("danny.kim").password("12345").build();
        UserDetails steve = User.withUsername("steve.kim").password("12345").build();
        UserDetails harris = User.withUsername("harris.kim").password("12345").build();

        List<UserDetails> users = List.of(danny, steve, harris);
        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
