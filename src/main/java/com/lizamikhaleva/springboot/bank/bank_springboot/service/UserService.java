package com.lizamikhaleva.springboot.bank.bank_springboot.service;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;

public interface UserService {

    void saveOrUpdateUser(UserEntity user);

    UserEntity findUserByUsernameAndPassword(String username, String password);
}
