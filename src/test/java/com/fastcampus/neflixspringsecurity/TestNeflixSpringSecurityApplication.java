package com.fastcampus.neflixspringsecurity;

import org.springframework.boot.SpringApplication;

public class TestNeflixSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.from(NeflixSpringSecurityApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
