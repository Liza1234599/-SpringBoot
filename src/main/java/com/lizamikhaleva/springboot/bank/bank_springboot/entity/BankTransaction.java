package com.lizamikhaleva.springboot.bank.bank_springboot.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction")
public class BankTransaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_operations")
    private String type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "id_user")
    private int idUser;

//    private String transaction;
//    private List<String> transactions;

    public BankTransaction() {
//        transactions = new ArrayList<>();
//        transactions.add("Пополнение счета");
//        transactions.add("Снятие со счета");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
