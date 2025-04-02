package com.lizamikhaleva.springboot.bank.bank_springboot.model;

import com.lizamikhaleva.springboot.bank.bank_springboot.validation.UniqueUsername;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class UserModelRegistration {

    @Size(min = 5, max = 26, message = "Логин должен быть от 5 до 25 имволов ")
    @NotBlank(message = "Поле не должно быть пустым")
    @UniqueUsername
    private String username;

    @Size(min = 9, max = 51, message = "Пароль должен содержать " +
            "не менее 10 и не более 50 символов")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$", message = "Пароль должен содержать один символ, одну большую и заглавную букву")
    @NotBlank(message = "Поле не должно быть пустым")
    private String password;

    private BigDecimal balance = new BigDecimal("2000");

    public UserModelRegistration() {

    }

    public UserModelRegistration(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                " username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

