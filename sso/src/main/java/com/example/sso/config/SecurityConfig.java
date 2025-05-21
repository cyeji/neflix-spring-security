package com.example.sso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2Login(c -> c.clientRegistrationRepository(clientRegistrationRepository()));
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated());
        return http.build();
    }

    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration c = CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("Ov23liHZ1Km108lTUdNL").clientSecret("7b9bdea18dde9c1eadf7f59f753a1eb1bd377d31").build();

        return new InMemoryClientRegistrationRepository(c);
    }
}
