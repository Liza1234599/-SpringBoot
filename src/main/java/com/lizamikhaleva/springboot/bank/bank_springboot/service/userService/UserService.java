package com.lizamikhaleva.springboot.bank.bank_springboot.service.userService;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;

import java.util.List;

public interface UserService {

    void saveUser(UserEntity user);

    void deleteEmployee(int id);

    List<UserEntity> findAll();

    boolean checkLoginToDB(String username);

    boolean checkLoginAndPassword(String username, String password);
}
