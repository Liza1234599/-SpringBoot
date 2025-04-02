package com.lizamikhaleva.springboot.bank.bank_springboot.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction")
public class BankTransactionEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_operations")
//    @Enumerated(EnumType.STRING)
    private String type;

    @Column(name = "amount")
    private BigDecimal amount;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_user")
//    private UserEntity userEntity;

    @Column(name = "id_user")
    private int idUser;

    public BankTransactionEntity() {
    }

    public BankTransactionEntity(String type, BigDecimal amount, int idUser) {
        this.type = type;
        this.amount = amount;
        this.idUser = idUser;
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

    @Override
    public String toString() {

        String typeOper = "";
        if(type.equals("PUT"))
            typeOper = "пополнение";
        else typeOper = "снятие со счета";

        return "Тип трансакции = " + typeOper + ", \t" +
                " сумма = " + amount;
    }
}
