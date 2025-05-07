package com.lizamikhaleva.springboot.bank.bank_springboot.repository;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    /**
     * Проверка наличия пользователя с таким же логином и пароем в БД
     */
    UserEntity findUserEntitiesByUsernameAndPassword(String username, String password);

    /**
     * Проверка наличия пользователя с таким же логином в БД
     */
    boolean existsByUsername(String username);

    //Поиск пользователя по имени
    UserEntity findByUsername(String username);

}
