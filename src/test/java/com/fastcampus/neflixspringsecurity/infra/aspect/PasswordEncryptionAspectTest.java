package com.fastcampus.neflixspringsecurity.infra.aspect;

import com.fastcampus.neflixspringsecurity.infra.annotation.CustomEncryption;
import com.fastcampus.neflixspringsecurity.presentation.user.EncryptionService;
import com.fastcampus.neflixspringsecurity.presentation.user.HelloRequestBody;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PasswordEncryptionAspectTest {

    @Mock
    EncryptionService encryptionService;

    @Test
    @DisplayName("encryption 테스트")
    void test_case_1() throws Exception {
        // given
        HelloRequestBody from = HelloRequestBody.from("id", "password");
        when(encryptionService.encrypt(any())).thenReturn("encryption");
        // when
        this.fieldEncryption(from);
        // then
        assertEquals("encryption", from.getPassword());
    }

    private void fieldEncryption(Object o) {
        if (ObjectUtils.isEmpty(o)) {
            return;
        }

        FieldUtils.getAllFieldsList(o.getClass()).stream().filter(field -> !(Modifier.isFinal(field.getModifiers()) && Modifier.isStatic(
            field.getModifiers()))).forEach(field -> {
            try {
                boolean annotationPresent = field.isAnnotationPresent(CustomEncryption.class);
                if (!annotationPresent) {
                    return;
                }
                Object encryptionField = FieldUtils.readField(field, o, true);
                if (!(encryptionField instanceof String)) {
                    return;
                }
                String encrypt = encryptionService.encrypt((String)encryptionField);
                FieldUtils.writeField(field, o, encrypt);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

}