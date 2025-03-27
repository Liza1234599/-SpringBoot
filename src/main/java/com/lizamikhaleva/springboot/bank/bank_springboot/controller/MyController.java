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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequestMapping("/bank")
//@Validated
public class MyController {

//    @Autowired
//    private BankService bankService;

    @Autowired
    private UserService userService;

    @Autowired
    private BankTransactionService bankTransactionService;

    private UserEntity userEntity;


    /**
     * Метод открытия первой страницы
     */
    @GetMapping
    public String getLkkUser(){

        return "first_view";
    }


    /**
     * В методе модели класса UserModelAuthorization присваивается имя атрибута userAut
     * @param model новосозданная модель для передачи в html
     * @return страница входа в сервис
     */
    @GetMapping("/authorization")
    public String loggingToBank(Model model) {
        model.addAttribute("userAut", new UserModelAuthorization());

        return "after_button_logging_to_bank";
    }

    /**
     * Метод проверки полей на соответствие условиям валидации при отсутствии ошибок
     * объекту userEntity присваиваются значения из формы
     * @param user полученный объект из html формы
     * @param result объект класса для проверки валидации полей формы
     * @param model новосозданная модель для передачи в html lkk_user
     */
    @PostMapping("/lkk_authorization")
    public String lkk(@ModelAttribute("userAut") @Valid UserModelAuthorization user
            , BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "after_button_logging_to_bank";
        }
        else {
            userEntity = userService.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
            model.addAttribute("user", userEntity);

            return "lkk_user";
        }
    }


    /**
     * В методе модели класса UserModelRegistration присваивается имя атрибута userReg
     * @param model новосозданная модель для передачи в html
     * @return страница регистрации в сервисе
     */
    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("userReg", new UserModelRegistration());

        return "after_button_registration_to_bank";
    }

    /**
     * Метод проверки полей на соответствие условиям валидации, при отсутствии ошибок
     * объекту userEntity присваиваются значения из формы и userEntity сохраняется в БД
     * @param user полученный объект из html формы
     * @param result объект класса для проверки валидации полей формы
     * @param model новосозданная модель для передачи в html lkk_user
     */
    @PostMapping("/lkk_registration")
    public String lkk(@ModelAttribute("userReg") @Valid UserModelRegistration user
            , BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "after_button_registration_to_bank";
        }
        else {
            userEntity = new UserEntity(user.getUsername(), user.getPassword());
            userService.saveUser(userEntity);
            model.addAttribute("user", userEntity);

            return "lkk_user";
        }
    }
}
