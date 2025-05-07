package com.lizamikhaleva.springboot.bank.bank_springboot.service.userService;

import com.lizamikhaleva.springboot.bank.bank_springboot.repository.UserRepository;
import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveOrUpdateUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public UserEntity findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findUserEntitiesByUsernameAndPassword(username, password);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
