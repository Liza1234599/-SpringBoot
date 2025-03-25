package com.lizamikhaleva.springboot.bank.bank_springboot.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
//    @Size(max = 51, message = "Логин превышает 50 символов")
//    @NotBlank(message = "Поле не должно быть пустым")
    private String username;

    @Column(name = "password")
//    @Size(min = 9, max = 51, message = "Пароль должен содержать " +
//            "не менее 10 и не более 50 символов")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$", message = "Пароль должен содержать один символ, одну большую и заглавную букву")
//    @NotBlank(message = "Поле не должно быть пустым")
    private String password;

    @Column(name = "balance")
    private BigDecimal balance = new BigDecimal("2000");

    public User() {

    }

    public User(String username, String password) {
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
}
