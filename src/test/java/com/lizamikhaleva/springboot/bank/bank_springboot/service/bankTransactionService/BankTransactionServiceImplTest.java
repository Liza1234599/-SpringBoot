package com.lizamikhaleva.springboot.bank.bank_springboot.service.bankTransactionService;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.BankTransactionEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.repository.BankTransactionRepository;
import com.lizamikhaleva.springboot.bank.bank_springboot.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class BankTransactionServiceImplTest {

    @Mock
    BankTransactionRepository bankTransactionRepository;

    BankTransactionServiceImpl bankTransactionService;
    int id = 1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bankTransactionService = new BankTransactionServiceImpl();
        bankTransactionService.setBankTransactionRepository(bankTransactionRepository);
    }

    @Test
    void saveTransactionCallsSaveRepository() {
        BankTransactionEntity bankTransactionEntity = new BankTransactionEntity();
        bankTransactionService.saveTransaction(bankTransactionEntity);
        verify(bankTransactionRepository, times(1)).save(bankTransactionEntity);
    }

    @Test
    void findAllByIdUserCallsInRepository() {
        bankTransactionService.findAllByIdUser(id);
        verify(bankTransactionRepository, times(1)).findAllByIdUser(id);
    }

    @Test
    void findAllByIdUserAndTypeCallsInRepository() {
        String type = "type";
        bankTransactionService.findAllByIdUserAndType(id, type);
        verify(bankTransactionRepository, times(1)).findAllByIdUserAndType(id, type);
    }
}