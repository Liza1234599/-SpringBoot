package com.lizamikhaleva.springboot.bank.bank_springboot.controller;

import com.lizamikhaleva.springboot.bank.bank_springboot.enums.TypeTransaction;
import com.lizamikhaleva.springboot.bank.bank_springboot.entity.BankTransactionEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.model.BankTransactionModel;
import com.lizamikhaleva.springboot.bank.bank_springboot.model.UserModelAuthorization;
import com.lizamikhaleva.springboot.bank.bank_springboot.model.UserModelRegistration;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.BankTransactionService;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/bank")
public class MyController {

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
    public String checkFormAuthorization(@ModelAttribute("userAut") @Valid UserModelAuthorization user
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
    public String checkFormRegistration(@ModelAttribute("userReg") @Valid UserModelRegistration user
            , BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "after_button_registration_to_bank";
        }
        else {
            userEntity = new UserEntity(user.getUsername(), user.getPassword());
            userEntity.setBalance(new BigDecimal("2500"));
            userService.saveOrUpdateUser(userEntity);
            model.addAttribute("user", userEntity);

            return "lkk_user";
        }
    }

    /**
     * Модели класса BankTransactionModel присваивается имя transaction
     * Модели класса TypeTransaction.values присваивается имя typeTransaction
     * @param model объект транзакции
     * @return странца заполнения полей транзакии
     */
    @GetMapping("transaction")
    public String getModelTransaction(Model model) {
        model.addAttribute("transaction", new BankTransactionModel());
        model.addAttribute("typeTransaction", TypeTransaction.values());

        return "transaction_form";
    }

    /**
     * Метод получает BankTransactionModel и проверяет на валидность
     * @param transactionModel переданный объект из формы
     * @param result объект для проверки валидности
     * @param model модель для передачи иноформации далее
     * @return личный кабинет пользователя
     */
    @PostMapping("check_transaction")
    public String checkFormTransaction(@ModelAttribute("transaction") @Valid BankTransactionModel transactionModel
            , BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "transaction_form";
        }
        else {
            model.addAttribute("user", userEntity);

            bankTransactionService.saveTransaction(
                    new BankTransactionEntity(transactionModel.getType(),
                            new BigDecimal(transactionModel.getAmount()), userEntity.getId()));

            if(transactionModel.getType().equals("PUT")){
                userEntity.setBalance(userEntity.getBalance()
                        .add(new BigDecimal(transactionModel.getAmount())));
                userService.saveOrUpdateUser(userEntity);
                System.out.println("put if");
            }
            else {
                userEntity.setBalance(userEntity.getBalance()
                        .subtract(new BigDecimal(transactionModel.getAmount())));
                userService.saveOrUpdateUser(userEntity);
                System.out.println("take off else");
            }

            return "lkk_user";
        }
    }

    /**
     *
     * @param model модель пользователя
     * @return профиль пользователя
     */
    @GetMapping("profile")
    public String userProfile(Model model) {
        model.addAttribute("user", userEntity);

        return "user_profile";
    }

    @GetMapping("lkk_user")
    public String LkkUser(Model model) {
        model.addAttribute("user", userEntity);

        return "lkk_user";
    }

    /**
     * Метод получения транзакций пополнения
     * @param model модель транзакции
     * @return информация о транзакциях PUT
     */
    @GetMapping("transactionPut")
    public String transactionPut(Model model) {
        model.addAttribute("transactions",
                bankTransactionService.findAllByIdUserAndType(userEntity.getId(), "PUT"));
        return "transaction_put";
    }

    /**
     * Метод получения транзакций снятия со счета
     * @param model модель транзакции
     * @return информация о транзакциях TakeOff
     */
    @GetMapping("transactionTakeOff")
    public String transactionTakeOff(Model model) {
        model.addAttribute("transactions",
                bankTransactionService.findAllByIdUserAndType(userEntity.getId(), "TAKEOFF"));

        return "transaction_take_off";
    }

    /**
     * Метод получения всех операций по счету
     * @param model модель транзакции
     * @return информация о транзакциях
     */
    @GetMapping("transactionAll")
    public String transactionAll(Model model) {
        model.addAttribute("transactions",
                bankTransactionService.findAllByIdUser(userEntity.getId()));

        return "transaction_all";
    }
}
