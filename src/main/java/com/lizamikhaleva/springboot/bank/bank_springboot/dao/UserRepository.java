package com.lizamikhaleva.springboot.bank.bank_springboot.dao;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    //Проверка наличия пользователя с таким же логином в БД
    boolean existsUserEntityByUsername(String username);

    //Проверка наличия пользователя с таким же логином и паролем
    boolean existsUserEntityByUsernameAndPassword(String username, String password);

    //Получение пользователя по логину и паролю
    UserEntity findUserEntitiesByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    //Поиск пользователя по имени
    UserEntity findByUsername(String username);

}
