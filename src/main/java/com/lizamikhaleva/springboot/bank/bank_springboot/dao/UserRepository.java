package com.lizamikhaleva.springboot.bank.bank_springboot.dao;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsUserEntityByUsername(String username);

    boolean existsUserEntityByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    UserEntity findByUsername(String username);

}
