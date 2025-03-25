package com.lizamikhaleva.springboot.bank.bank_springboot.service.bankTransactionService;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.BankTransaction;

import java.util.List;

public interface BankTransactionService {

    List<BankTransaction> getAllTransaction();

    void saveTransaction(BankTransaction bankTransact);

    BankTransaction getTransaction(int id);

    List<BankTransaction> findAllByIdUser(int userId);

}
