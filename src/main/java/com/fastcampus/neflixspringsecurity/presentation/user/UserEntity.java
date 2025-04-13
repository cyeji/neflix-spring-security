package com.fastcampus.neflixspringsecurity.presentation.user;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private String username;
    private String password;
    private String authority;

}
