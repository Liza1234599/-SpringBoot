package com.lizamikhaleva.springboot.bank.bank_springboot.service.bankService;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;

public interface BankService {

    boolean checkLoginToDb(String username);

    boolean checkLoginAndPassword(String username, String password);

    UserEntity findUserByUsernameAndPassword(String username, String password);

    void saveUser(UserEntity user);
}
