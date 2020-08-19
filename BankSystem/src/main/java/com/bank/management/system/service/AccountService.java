package com.bank.management.system.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.management.system.controller.JwtAuthenticationController;
import com.bank.management.system.model.Account;
import com.bank.management.system.model.Investment;
import com.bank.management.system.model.MutualFund;
import com.bank.management.system.model.UserDao;
import com.bank.management.system.properties.AppProperties;
import com.bank.management.system.repository.InvestmentRepository;
import com.bank.management.system.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AccountService {

	@Autowired
	AppProperties appProperties;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	InvestmentRepository investmentRepository;
	@Autowired
	UserRepository userRepository;
	
	//get all accounts this is for checking purpose only where app.properties contains url of another microservice
	public List<Account> getAllAccount(){
	    ResponseEntity<Account[]> responseEntity = restTemplate.getForEntity(""+appProperties.getAllAccount(), Account[].class);
		return Arrays.asList(responseEntity.getBody());
		}
	
	//to add account by using rest template where app.properties contains url of another microservice for adding account
	public HttpStatus addAccount(Account account) {
		ResponseEntity<HttpStatus> response = restTemplate.postForEntity(""+appProperties.getAddAccount(), account, HttpStatus.class);
		return response.getBody();
	}
	
	//to find by account by pan number where app.properties contains url of another microservice
	 @HystrixCommand(fallbackMethod="getfallfindbyPan")
	public List<Account> findByPan(String pan) {
		ResponseEntity<Account[]> response = restTemplate.getForEntity(""+appProperties.getGetAccount() +"/"+pan, Account[].class);
		return Arrays.asList(response.getBody());
	}
	
	public void delete(String acc) {
		restTemplate.delete(""+appProperties.getDeleteAccount()+"/"+acc);

	}
	
	//hystrix break
	public List<Account> getfallfindbyPan(String pan){
		return  null;
	}
}
