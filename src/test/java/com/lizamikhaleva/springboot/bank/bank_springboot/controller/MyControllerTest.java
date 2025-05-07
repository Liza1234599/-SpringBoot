package com.lizamikhaleva.springboot.bank.bank_springboot.controller;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.enums.TypeTransaction;
import com.lizamikhaleva.springboot.bank.bank_springboot.model.BankTransactionModel;
import com.lizamikhaleva.springboot.bank.bank_springboot.model.UserModelAuthorization;
import com.lizamikhaleva.springboot.bank.bank_springboot.model.UserModelRegistration;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.BankTransactionService;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(MyController.class)
class MyControllerTest {

    MyController myController;
    UserModelAuthorization userModelAuthorization = new UserModelAuthorization();
    UserModelRegistration userModelRegistration = new UserModelRegistration();

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @MockitoBean
    private BankTransactionService bankTransactionService;

    @MockitoBean
    UserEntity userEntity;

    @BeforeEach
    public void setUp(){
        myController = new MyController();
    }

    @Test
    void getLkkUser() throws Exception {
        mockMvc.perform(get("/bank"))
                .andExpect(view().name("first_view"));
    }

    @Test
    void loggingToBank() throws Exception {
        mockMvc.perform(get("/bank/authorization"))
                .andExpect(view().name("after_button_logging_to_bank")) // Проверяем, что возвращается правильное имя представления
                .andExpect(model().attributeExists("userAut")) // Проверяем, что атрибут "userAut" добавлен в модель
                .andExpect(model().attribute("userAut", instanceOf(UserModelAuthorization.class))); // Проверяем, что "userAut" является экземпляром UserModelAuthorization    }
    }

//    @Test
//    void checkFormAuthorization() {
////        mockMvc.perform(post("/bank/lkk_authorization"))
////                .andDo()
//    }

    @Test
    void registrationForm() throws Exception {
        mockMvc.perform(get("/bank/registration"))
                .andExpect(view().name("after_button_registration_to_bank"))
                .andExpect(model().attributeExists("userReg"))
                .andExpect(model().attribute("userReg", instanceOf(UserModelRegistration.class)));
    }

//    @Test
//    void checkFormRegistration() {
//    }

    @Test
    void getModelTransaction() throws Exception {
        mockMvc.perform(get("/bank/transaction"))
                .andExpect(view().name("transaction_form"))
                .andExpect(model().attributeExists("transaction"))
                .andExpect(model().attribute("transaction", instanceOf(BankTransactionModel.class)))
                .andExpect(model().attributeExists("typeTransaction"))
                .andExpect(model().attribute("typeTransaction", arrayContaining(TypeTransaction.PUT,
                        TypeTransaction.TAKEOFF)));
    }

//    @Test
//    void checkFormTransaction() {
//    }

//    @Test
//    void userProfile() throws Exception {
//
//        mockMvc.perform(get("/bank/profile"))
//                .andExpect(view().name("user_profile"))
//                .andExpect(model().attributeExists("user"))
//                .andExpect(model().attribute("user", userEntity));
//    }

//    @Test
//    void lkkUser() {
//    }
//
//    @Test
//    void transactionPut() {
//    }
//
//    @Test
//    void transactionTakeOff() {
//    }
//
//    @Test
//    void transactionAll() {
//    }
}