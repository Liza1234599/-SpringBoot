package com.lizamikhaleva.springboot.bank.bank_springboot.service.userService;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void deleteEmployee(int id);

    List<User> findAll();

    boolean checkLoginToDB(String username);

    boolean checkLoginAndPassword(String username, String password);
}
