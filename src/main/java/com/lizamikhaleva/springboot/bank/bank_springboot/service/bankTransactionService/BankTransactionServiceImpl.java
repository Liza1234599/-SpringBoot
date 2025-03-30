package com.lizamikhaleva.springboot.bank.bank_springboot.service.bankTransactionService;

import com.lizamikhaleva.springboot.bank.bank_springboot.dao.BankTransactionRepository;
import com.lizamikhaleva.springboot.bank.bank_springboot.entity.BankTransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    @Override
    public List<BankTransactionEntity> getAllTransaction() {
        return bankTransactionRepository.findAll();
    }

    @Override
    public void saveTransaction(BankTransactionEntity bankTransact) {
        bankTransactionRepository.save(bankTransact);
    }

    @Override
    public BankTransactionEntity getTransaction(int id) {
        BankTransactionEntity transaction = null;
        Optional<BankTransactionEntity> optional = bankTransactionRepository.findById(id);

        if (optional.isPresent()) {
            transaction = optional.get();
        }

        return transaction;
    }

    @Override
    public List<BankTransactionEntity> findAllByIdUser(int userId) {
        return bankTransactionRepository.findAllByIdUser(userId);
    }

    @Override
    public List<BankTransactionEntity> findAllByIdUserAndType(int idUser, String type) {
        return bankTransactionRepository.findAllByIdUserAndType(idUser, type);
    }

}
