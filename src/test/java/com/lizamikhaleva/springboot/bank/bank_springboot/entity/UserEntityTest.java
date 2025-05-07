package com.lizamikhaleva.springboot.bank.bank_springboot.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    UserEntity userEntity;

    @BeforeEach
    public void setUp() {
        userEntity = new UserEntity("username", "password");
    }

    @Test
    void setAndGetId() {
        int id = 1;
        userEntity.setId(id);
        assertEquals(id, userEntity.getId());
    }

    @Test
    void setAndGetUsername() {
        userEntity.setUsername("username");
        assertEquals("username", userEntity.getUsername());
    }

    @Test
    void setAndGetBalance() {
        BigDecimal balance = BigDecimal.valueOf(100);
        userEntity.setBalance(balance);
        assertEquals(balance, userEntity.getBalance());
    }
}