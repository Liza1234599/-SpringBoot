package com.lizamikhaleva.springboot.bank.bank_springboot.controller;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.model.UserModelAuthorization;
import com.lizamikhaleva.springboot.bank.bank_springboot.model.UserModelRegistration;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.bankService.BankService;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.bankTransactionService.BankTransactionService;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.userService.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    private UserEntity userEntity;

    @GetMapping
    public String getLkkUser(){

        return "first_view";
    }

    @GetMapping("/authorization")
    public String loggingToBank(Model model) {
        model.addAttribute("userAut", new UserModelAuthorization());
        return "after_button_logging_to_bank";
    }

    @PostMapping("/lkk_authorization")
    public String lkk(@ModelAttribute("userAut") @Valid UserModelAuthorization user
            , BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "after_button_logging_to_bank";
        }
        else {
            model.addAttribute("user", user);
            return "lkk_user";
        }
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("userReg", new UserModelRegistration());

        return "after_button_registration_to_bank";
    }

    @PostMapping("/lkk_registration")
    public String lkk(@ModelAttribute("userReg") @Valid UserModelRegistration user
            , BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "after_button_registration_to_bank";
        }
        else {
            userService.saveUser(new UserEntity(user.getUsername(), user.getPassword()));
            model.addAttribute("user", user);
            return "lkk_user";
        }
    }
}
