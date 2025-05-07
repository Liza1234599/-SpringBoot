package com.lizamikhaleva.springboot.bank.bank_springboot.validation.loginMatch;

import com.lizamikhaleva.springboot.bank.bank_springboot.repository.UserRepository;
import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import com.lizamikhaleva.springboot.bank.bank_springboot.model.UserModelAuthorization;
import com.lizamikhaleva.springboot.bank.bank_springboot.validation.LoginMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LoginMatchValidator implements ConstraintValidator<LoginMatch, UserModelAuthorization> {

    private final UserRepository userRepository;

    public LoginMatchValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(UserModelAuthorization userModelAuthorization, ConstraintValidatorContext constraintValidatorContext) {
        if (userModelAuthorization.getUsername() == null || userModelAuthorization.getPassword() == null) {
            return false;
        }

        UserEntity user = userRepository.findByUsername(userModelAuthorization.getUsername());
        if (user == null) {
            return false;
        }

        /**
         * Проверка совпадения пароля
         */
        return user.getPassword().equals(userModelAuthorization.getPassword());
    }
}
