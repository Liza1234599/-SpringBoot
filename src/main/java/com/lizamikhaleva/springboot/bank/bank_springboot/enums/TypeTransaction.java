package com.lizamikhaleva.springboot.bank.bank_springboot.enums;

public enum TypeTransaction {
    PUT("Положить деньги на счет"),
    TAKEOFF("Снять деньги со счета");

    private final String typeTransaction;

    TypeTransaction(String type) {
        this.typeTransaction = type;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }
}
