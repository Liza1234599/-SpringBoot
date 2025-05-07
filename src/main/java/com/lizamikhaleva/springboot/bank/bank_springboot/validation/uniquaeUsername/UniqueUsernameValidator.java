package com.lizamikhaleva.springboot.bank.bank_springboot.validation.uniquaeUsername;

import com.lizamikhaleva.springboot.bank.bank_springboot.repository.UserRepository;
import com.lizamikhaleva.springboot.bank.bank_springboot.validation.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return username != null && !userRepository.existsByUsername(username);
    }
}
