package com.lizamikhaleva.springboot.bank.bank_springboot.service.bankService;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.User;
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

    public void loggingToBank(String username, String password){
        userService.saveUser(new User(username, password));
    }

}
