package com.lizamikhaleva.springboot.bank.bank_springboot.service.bankService;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.bankTransactionService.BankTransactionService;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private UserService userService;

    @Autowired
    private BankTransactionService bankTransactionService;


    public boolean cheklogintodb(String username, String password){
        userService.saveUser(new UserEntity(username, password));
        return true;
    }

    /**
     * Проверяем есть ли пользователь с таким логином в бд
     *
     * @param username логин
     * @return
     */
    @Override
    public boolean checkLoginToDb(String username) {
        return userService.checkLoginToDB(username);
    }

    @Override
    public boolean checkLoginAndPassword(String username, String password) {
        return userService.checkLoginAndPassword(username, password);
    }
}
