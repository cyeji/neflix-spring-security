package com.fastcampus.deepdivesecurity;

import org.springframework.boot.SpringApplication;

public class TestDeepdiveSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.from(DeepdiveSecurityApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
