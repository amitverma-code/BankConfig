package com.bank.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.management.system.model.UserDao;

public interface UserRepository extends JpaRepository<UserDao, Integer> {
	
    UserDao findByUsername(String username);
    
    UserDao findByPan(String pan);
    
    @Query(value= "select ub.pan from user_bank as ub where ub.username=?1",nativeQuery= true)
    String getpanNumber(String username);
    
}