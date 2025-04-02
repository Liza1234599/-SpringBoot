package com.lizamikhaleva.springboot.bank.bank_springboot.validation.loginMatch;

import com.lizamikhaleva.springboot.bank.bank_springboot.dao.UserRepository;
import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.model.UserModelAuthorization;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class LoginMatchValidatorTest {

    @Mock
    UserRepository userRepository;

    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    LoginMatchValidator validator;

    UserModelAuthorization userModelAuthorization;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        validator = new LoginMatchValidator(userRepository);
        userModelAuthorization = new UserModelAuthorization();
    }

    @Test
    void userPasswordIsNull() {
        userModelAuthorization.setUsername("name");
        userModelAuthorization.setPassword(null);

        assertFalse(validator.isValid(userModelAuthorization, constraintValidatorContext));
    }

    @Test
    void userUsernameIsNull() {
        userModelAuthorization.setUsername(null);
        userModelAuthorization.setPassword("password");

        assertFalse(validator.isValid(userModelAuthorization, constraintValidatorContext));
    }

    @Test
    void notFoundUser(){
        userModelAuthorization.setUsername("name");
        userModelAuthorization.setPassword("password");

        when(userRepository.findByUsername("name")).thenReturn(null);
        assertFalse(validator.isValid(userModelAuthorization, constraintValidatorContext));
    }

    @Test
    void dontMatchPasswordUser(){
        userModelAuthorization.setUsername("name");
        userModelAuthorization.setPassword("wordpassword");

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("name");
        userEntity.setPassword("password");

        when(userRepository.findByUsername("name")).thenReturn(userEntity);
        assertFalse(validator.isValid(userModelAuthorization, constraintValidatorContext));
    }

    @Test
    void foundUser(){
        userModelAuthorization.setUsername("name");
        userModelAuthorization.setPassword("password");

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("name");
        userEntity.setPassword("password");

        when(userRepository.findByUsername("name")).thenReturn(userEntity);
        assertTrue(validator.isValid(userModelAuthorization, constraintValidatorContext));
    }
}