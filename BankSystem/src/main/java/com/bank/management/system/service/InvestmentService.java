package com.bank.management.system.service;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.bank.management.system.controller.JwtAuthenticationController;
import com.bank.management.system.model.Account;
import com.bank.management.system.model.Investment;
import com.bank.management.system.model.MutualFund;
import com.bank.management.system.model.UserDao;
import com.bank.management.system.properties.AppProperties;
import com.bank.management.system.repository.InvestmentRepository;
import com.bank.management.system.repository.UserRepository;
@Service
public class InvestmentService {

	@Autowired
	AppProperties appProperties;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	InvestmentRepository investmentRepository;
	@Autowired
	UserRepository userRepository;
	
	//from here user will get list of mutualfund available
	//appproperties contains the url of other microservice
	public List<MutualFund> getAllMutualFund(){
	    ResponseEntity<MutualFund[]> responseEntity1 = restTemplate.getForEntity(""+appProperties.getGetMutual(), MutualFund[].class);
		return Arrays.asList(responseEntity1.getBody());
		}
	
	//for investment
	//where method will first another microservice to check user is inserting correct account or not
	//if account is correct then data will insert only for invsetment
	//user will not insert other details as pan card mutualfund name it will auto fetch from past info
	public void addInvestment(Investment investment, String username,String mfund){
		String uname=username;
		String fund= mfund;
		String anum=investment.getAccountNumber();
		String pannumber= userRepository.getpanNumber(uname);
		ResponseEntity<Account[]> response = restTemplate.getForEntity(""+appProperties.getGetAccount() +"/"+pannumber, Account[].class);
	    List<Account> acc= Arrays.asList(response.getBody()); 
		for(Account a:acc ) {
		if(a.getAccountNumber().equals(anum))
		{
		investment.setPan(userRepository.getpanNumber(uname));
		investment.setmFund(""+fund);
		investment.setAccountNumber(a.getAccountNumber());
		investmentRepository.save(investment);
			}
		else {
			System.out.println("check account number");
		}
	}
	}
	@Transactional
	public List<Investment> findByPan(String pan) {
		
		return investmentRepository.findByPan(pan);
	}
}
