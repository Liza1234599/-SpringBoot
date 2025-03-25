package com.lizamikhaleva.springboot.bank.bank_springboot.controller;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.model.UserModel;
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

    @GetMapping
    public String getLkkUser(){

        return "first_view";
    }

    @GetMapping("/authorization")
    public String loggingToBank(Model model) {
        model.addAttribute("userAut", new UserModel());
        return "after_button_logging_to_bank";
    }

    @GetMapping("/lkk_authorization")
    public String lkkA(@ModelAttribute("userAut") @Valid UserModel user, BindingResult result) {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println("result.hasErrors() = " + result.hasErrors());
        System.out.println("bankService.checkLoginToDb(username) = " + bankService.checkLoginToDb(username));

        if(result.hasErrors()) { //Валидация не работает???
            System.out.println("lkk_authorization hasErrors()");
            return "after_button_logging_to_bank";
        }
        else if(bankService.checkLoginAndPassword(username, password)){
            System.out.println("lkk_authorization checkLoginAndPassword()");
            return "lkk_user";
        }
        else {
            System.out.println("lkk_authorization else");
            return "after_button_logging_to_bank";
        }
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("userReg", new UserModel());

        return "after_button_registration_to_bank";
    }

    @GetMapping("/lkk_registration")
    public String lkk(@ModelAttribute("userReg") @Valid UserModel user, BindingResult result) {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println("result.hasErrors() = " + result.hasErrors());
        System.out.println("!bankService.checkLoginToDb(username) = " + !bankService.checkLoginToDb(username));

        if(result.hasErrors()) { //Валидация не работает???
            System.out.println("lkk_registration hasErrors()");
            return "after_button_registration_to_bank";
        }
        else if(!bankService.checkLoginToDb(username)){
            System.out.println("lkk_registration checkLoginToDb()");
            userService.saveUser(new UserEntity(username, password));
            return "lkk_user";
        }
        else {
            System.out.println("lkk_registration else");
            return "after_button_registration_to_bank";
        }
    }
}
