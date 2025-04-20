package com.fastcampus.neflixspringsecurity.presentation.user;

import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    public String encrypt(String before) {
        return String.join("encrpyted_", before);
    }

}
