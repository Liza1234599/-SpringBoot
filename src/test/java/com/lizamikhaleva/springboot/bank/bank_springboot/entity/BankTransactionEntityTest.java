package com.lizamikhaleva.springboot.bank.bank_springboot.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankTransactionEntityTest {

    BankTransactionEntity bankTransactionEntity;

    @BeforeEach
    void setUp() {
        bankTransactionEntity = new BankTransactionEntity("type", new BigDecimal("100"), 1);
    }

    @Test
    void setAndGetId() {
        bankTransactionEntity.setId(2);
        assertEquals(2, bankTransactionEntity.getId());
    }

    @Test
    void setAndGetType() {
        bankTransactionEntity.setType("type two");
        assertEquals("type two", bankTransactionEntity.getType());
    }

    @Test
    void setAndGetAmount() {
        bankTransactionEntity.setAmount(new BigDecimal("102"));
        assertEquals(new BigDecimal("102"), bankTransactionEntity.getAmount());
    }

    @Test
    void setAndGetIdUser() {
        bankTransactionEntity.setIdUser(2);
        assertEquals(2, bankTransactionEntity.getIdUser());
    }
}