package com.lizamikhaleva.springboot.bank.bank_springboot.controller;

import com.lizamikhaleva.springboot.bank.bank_springboot.service.bankService.BankService;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.bankTransactionService.BankTransactionService;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class MyController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public String getLkkUser(){

        return "first_view";
    }

    @GetMapping("/logging")
    public String loggingToBank(String username, String password) {
        bankService.loggingToBank(username, password);

        return "after_button_logging_to_bank";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {

        return "after_button_registration_to_bank";
    }

    @GetMapping("/lkk")
    public String lkk(Model model) {
        return "lkk_user";
    }
}
