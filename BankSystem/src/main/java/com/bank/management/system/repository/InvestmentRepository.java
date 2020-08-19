package com.bank.management.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bank.management.system.model.Investment;

public interface InvestmentRepository extends CrudRepository<Investment, Long> {
	
	List<Investment> findByPan(String name);
   
}