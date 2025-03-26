package com.lizamikhaleva.springboot.bank.bank_springboot.validation.loginMatch;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginMatchValidator.class)
public @interface LoginMatch {

    String message() default "Неверный логин или пароль";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
