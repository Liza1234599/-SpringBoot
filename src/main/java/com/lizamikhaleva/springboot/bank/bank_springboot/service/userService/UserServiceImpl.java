package com.lizamikhaleva.springboot.bank.bank_springboot.service.userService;

import com.lizamikhaleva.springboot.bank.bank_springboot.dao.UserRepository;
import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public UserEntity findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findUserEntitiesByUsernameAndPassword(username, password);
    }

    @Override
    public void updateUser(UserEntity user) {
        userRepository.save(user);
    }
}
