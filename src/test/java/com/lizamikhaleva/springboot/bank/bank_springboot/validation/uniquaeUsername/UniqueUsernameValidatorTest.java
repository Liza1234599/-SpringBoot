package com.lizamikhaleva.springboot.bank.bank_springboot.validation.uniquaeUsername;

import com.lizamikhaleva.springboot.bank.bank_springboot.repository.UserRepository;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class UniqueUsernameValidatorTest {

    @Mock
    UserRepository repository;

    @Mock
    ConstraintValidatorContext context;

    UniqueUsernameValidator validator;

    String username;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        validator = new UniqueUsernameValidator(repository);
        username = "";
    }

    @Test
    void userNameIsNull() {
        username = null;

        assertFalse(validator.isValid(username, context));
    }

    @Test
    public void usernameNotUnique() {
        username = "username";

        when(repository.existsByUsername(username)).thenReturn(true);

        //return username != null (true) && !true (false);
        assertFalse(validator.isValid(username, context));
    }

    @Test
    public void usernameUniqueAndNotNull() {
        username = "username";

        when(repository.existsByUsername(username)).thenReturn(false);

        //return username != null && !userRepository.existsByUsername(username);
        assertTrue(validator.isValid(username, context));
    }
}