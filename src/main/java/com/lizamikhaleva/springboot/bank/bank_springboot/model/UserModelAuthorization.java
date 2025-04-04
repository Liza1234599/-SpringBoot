package com.lizamikhaleva.springboot.bank.bank_springboot.model;

import com.lizamikhaleva.springboot.bank.bank_springboot.validation.LoginMatch;

import java.math.BigDecimal;

@LoginMatch
public class UserModelAuthorization {

    private String username;

    private String password;

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
}
