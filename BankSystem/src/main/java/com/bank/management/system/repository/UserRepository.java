package com.bank.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.management.system.model.UserDao;

public interface UserRepository extends JpaRepository<UserDao, Integer> {
	
    UserDao findByUsername(String username);
    
    UserDao findByPan(String pan);
}