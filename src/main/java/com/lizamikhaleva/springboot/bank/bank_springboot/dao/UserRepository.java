package com.lizamikhaleva.springboot.bank.bank_springboot.dao;

import com.lizamikhaleva.springboot.bank.bank_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
