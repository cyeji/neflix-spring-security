package com.fastcampus.neflixspringsecurity.presentation.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@RequiredArgsConstructor
public class InMemoryUserDetailsService implements UserDetailsService {

    private final List<UserDetails> users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream().filter(users -> users.getUsername().equals(username)).findFirst().orElseThrow(() -> new UsernameNotFoundException(
            "User not founds"));
    }

}
