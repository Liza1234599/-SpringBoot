package com.lizamikhaleva.springboot.bank.bank_springboot.service.bankTransactionService;

import com.lizamikhaleva.springboot.bank.bank_springboot.dao.BankTransactionRepository;
import com.lizamikhaleva.springboot.bank.bank_springboot.entity.BankTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    @Override
    public List<BankTransaction> getAllTransaction() {
        return bankTransactionRepository.findAll();
    }

    @Override
    public void saveTransaction(BankTransaction bankTransact) {
        bankTransactionRepository.save(bankTransact);
    }

    @Override
    public BankTransaction getTransaction(int id) {
        BankTransaction transaction = null;
        Optional<BankTransaction> optional = bankTransactionRepository.findById(id);

        if (optional.isPresent()) {
            transaction = optional.get();
        }

        return transaction;
    }

    @Override
    public List<BankTransaction> findAllByIdUser(int userId) {
        return bankTransactionRepository.findAllByIdUser(userId);
    }

}
