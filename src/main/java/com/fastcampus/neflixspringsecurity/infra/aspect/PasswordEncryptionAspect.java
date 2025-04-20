package com.fastcampus.neflixspringsecurity.infra.aspect;

import com.fastcampus.neflixspringsecurity.infra.annotation.CustomEncryption;
import com.fastcampus.neflixspringsecurity.presentation.user.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Modifier;
import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class PasswordEncryptionAspect {

    private final EncryptionService encryptionService;

    @Around("execution(* com.fastcampus.neflixspringsecurity.presentation.user.controller.*.*(..))")
    public Object passwordEncryptionAspect(ProceedingJoinPoint pjp) throws Throwable {
        Arrays.stream(pjp.getArgs()).forEach(this::fieldEncryption);

        return pjp.proceed();
    }

    public void fieldEncryption(Object o) {
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
