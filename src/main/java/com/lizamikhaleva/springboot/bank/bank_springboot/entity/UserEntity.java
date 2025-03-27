package com.lizamikhaleva.springboot.bank.bank_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @Size(max = 51, message = "Логин превышает 50 символов")
    @NotBlank(message = "Поле не должно быть пустым")
    private String username;

    @Column(name = "password")
    @Size(min = 9, max = 51, message = "Пароль должен содержать " +
            "не менее 10 и не более 50 символов")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$", message = "Пароль должен содержать один символ, одну большую и заглавную букву")
    @NotBlank(message = "Поле не должно быть пустым")
    private String password;

    @Column(name = "balance")
    private BigDecimal balance = new BigDecimal("2000");

//    @OneToMany(mappedBy = "userEntity"
////            , cascade = CascadeType.ALL
////            , fetch = FetchType.EAGER)
////    private List<BankTransactionEntity> transactList;

    public UserEntity() {

    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

//    public List<BankTransactionEntity> getTransactList() {
//        return transactList;
//    }
//
//    public void setTransactList(List<BankTransactionEntity> transactList) {
//        this.transactList = transactList;
//    }
}
