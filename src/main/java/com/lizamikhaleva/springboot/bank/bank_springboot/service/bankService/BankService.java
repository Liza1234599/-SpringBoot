package com.lizamikhaleva.springboot.bank.bank_springboot.service.bankService;

public interface BankService {

    boolean checkLoginToDb(String username);

    boolean checkLoginAndPassword(String username, String password);
}
