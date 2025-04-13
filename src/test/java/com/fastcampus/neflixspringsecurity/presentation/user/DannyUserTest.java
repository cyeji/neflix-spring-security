package com.fastcampus.neflixspringsecurity.presentation.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

class DannyUserTest {

    @Test
    @DisplayName("danny user ㅌㅔ스트")
    void test_case_1() throws Exception {
        // given
        DannyUser dannyUser = new DannyUser();
        // when

        assertEquals("danny.kim", dannyUser.getUsername());
        assertEquals("12345", dannyUser.getPassword());
        assertEquals(1, dannyUser.getAuthorities().size());
        // then
        Optional<? extends GrantedAuthority> read =
            dannyUser.getAuthorities().stream().filter(grantedAuthority -> grantedAuthority.getAuthority().equals("READT")).findFirst();

        read.ifPresent(each -> assertEquals("READ", each.getAuthority()));
    }

}