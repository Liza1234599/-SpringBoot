package com.lizamikhaleva.springboot.bank.bank_springboot.service;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.BankTransactionEntity;

import java.util.List;

public interface BankTransactionService {

    void saveTransaction(BankTransactionEntity bankTransact);

    List<BankTransactionEntity> findAllByIdUser(int userId);

    List<BankTransactionEntity> findAllByIdUserAndType(int idUser, String type);
}
