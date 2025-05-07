package com.lizamikhaleva.springboot.bank.bank_springboot.service.userService;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl();
        userService.setUserRepository(userRepository);
    }

    @Test
    void saveUserCallsSaveRepository() {
        UserEntity user = new UserEntity();
        userService.saveOrUpdateUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void findUserByUsernameAndPasswordCallsInRepository() {
        String username = "username";
        String password = "password";
        userService.findUserByUsernameAndPassword(username, password);
        verify(userRepository, times(1))
                .findUserEntitiesByUsernameAndPassword(username, password);
    }
}