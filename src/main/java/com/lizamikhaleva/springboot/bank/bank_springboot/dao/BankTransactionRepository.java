package com.lizamikhaleva.springboot.bank.bank_springboot.dao;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.BankTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankTransactionRepository extends JpaRepository<BankTransactionEntity, Integer> {
    public List<BankTransactionEntity> findAllByIdUser(int userId);


}
