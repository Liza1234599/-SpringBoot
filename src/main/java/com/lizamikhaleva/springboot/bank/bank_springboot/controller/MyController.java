package com.lizamikhaleva.springboot.bank.bank_springboot.controller;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.User;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.bankService.BankService;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.bankTransactionService.BankTransactionService;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class MyController {

    @Autowired
    private BankService bankService;

    @Autowired
    private UserService userService;

    @Autowired
    private BankTransactionService bankTransactionService;

    @GetMapping
    public String getLkkUser(){

        return "first_view";
    }

    @GetMapping("/logging")
    public String loggingToBank(String username, String password) {
        if(!bankService.checkLoginToDb(username)){
            userService.saveUser(new User(username, password));
            return "lkk_user";
        } else {
            return "redirect:/logging";
        }
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());

        return "after_button_registration_to_bank";
    }

    @GetMapping("/lkk_registration")
    public String lkk(@ModelAttribute("user") User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        if(!bankService.checkLoginAndPassword(username, password)){
            userService.saveUser(new User(username, password));
            return "lkk_user";
        } else {
            return "redirect:/registration";
        }
    }
}
