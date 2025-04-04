package com.lizamikhaleva.springboot.bank.bank_springboot.model;

import jakarta.validation.constraints.Pattern;

public class BankTransactionModel {

    private String type;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "Строка должна содержать только цифры и первая не 0")
    private String amount;

    public BankTransactionModel() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
