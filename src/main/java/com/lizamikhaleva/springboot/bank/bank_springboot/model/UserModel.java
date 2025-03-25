package com.lizamikhaleva.springboot.bank.bank_springboot.model;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class UserModel {

    @Size(max = 51, message = "Логин превышает 50 символов")
    @NotBlank(message = "Поле не должно быть пустым")
    private String username;

    @Size(min = 9, max = 51, message = "Пароль должен содержать " +
            "не менее 10 и не более 50 символов")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$", message = "Пароль должен содержать один символ, одну большую и заглавную букву")
    @NotBlank(message = "Поле не должно быть пустым")
    private String password;

    private BigDecimal balance = new BigDecimal("2000");

    public UserModel() {

    }

    public UserModel(String username, String password) {
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

    public @Size(max = 51, message = "Логин превышает 50 символов") @NotBlank(message = "Поле не должно быть пустым") String getUsername() {
        return username;
    }

    public void setUsername(@Size(max = 51, message = "Логин превышает 50 символов") @NotBlank(message = "Поле не должно быть пустым") String username) {
        this.username = username;
    }

    public @Size(min = 9, max = 51, message = "Пароль должен содержать " +
            "не менее 10 и не более 50 символов") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$", message = "Пароль должен содержать один символ, одну большую и заглавную букву") @NotBlank(message = "Поле не должно быть пустым") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 9, max = 51, message = "Пароль должен содержать " +
            "не менее 10 и не более 50 символов") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$", message = "Пароль должен содержать один символ, одну большую и заглавную букву") @NotBlank(message = "Поле не должно быть пустым") String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

