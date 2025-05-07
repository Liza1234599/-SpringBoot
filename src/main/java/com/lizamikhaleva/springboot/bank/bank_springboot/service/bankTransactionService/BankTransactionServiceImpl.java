package com.lizamikhaleva.springboot.bank.bank_springboot.service.bankTransactionService;

import com.lizamikhaleva.springboot.bank.bank_springboot.repository.BankTransactionRepository;
import com.lizamikhaleva.springboot.bank.bank_springboot.entity.BankTransactionEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    @Override
    public void saveTransaction(BankTransactionEntity bankTransact) {
        bankTransactionRepository.save(bankTransact);
    }

    @Override
    public List<BankTransactionEntity> findAllByIdUser(int userId) {
        return bankTransactionRepository.findAllByIdUser(userId);
    }

    @Override
    public List<BankTransactionEntity> findAllByIdUserAndType(int idUser, String type) {
        return bankTransactionRepository.findAllByIdUserAndType(idUser, type);
    }

    public void setBankTransactionRepository(BankTransactionRepository bankTransactionRepository) {
        this.bankTransactionRepository = bankTransactionRepository;
    }
}
