package com.fastcampus.keycloak.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SocialLoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWithoutAuth() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/hello")).andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void helloWithAuth() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/hello"))
                .andExpect(status().isOk());
    }

}