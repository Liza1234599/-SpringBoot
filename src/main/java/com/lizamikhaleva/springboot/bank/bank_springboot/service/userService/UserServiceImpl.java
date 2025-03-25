package com.lizamikhaleva.springboot.bank.bank_springboot.service.userService;

import com.lizamikhaleva.springboot.bank.bank_springboot.dao.UserRepository;
import com.lizamikhaleva.springboot.bank.bank_springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteEmployee(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
