package com.bank.management.system.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.management.system.model.Account;
import com.bank.management.system.properties.AppProperties;
@Service
public class AccountService {

	@Autowired
	AppProperties appProperties;
	@Autowired
	RestTemplate restTemplate;
	
	
	public List<Account> getAllAccount(){
	    ResponseEntity<Account[]> responseEntity = restTemplate.getForEntity(""+appProperties.getAllAccount(), Account[].class);
		return Arrays.asList(responseEntity.getBody());
		}
	
	public HttpStatus addAccount(Account account) {
		ResponseEntity<HttpStatus> response = restTemplate.postForEntity(""+appProperties.getAddAccount(), account, HttpStatus.class);
		return response.getBody();
	}
	
	public List<Account> findByPan(String pan) {
		ResponseEntity<Account[]> response = restTemplate.getForEntity(""+appProperties.getGetAccount() +"/"+pan, Account[].class);
		return Arrays.asList(response.getBody());
	}
	
	public void delete(String acc) {
		restTemplate.delete(""+appProperties.getDeleteAccount()+"/"+acc);

	}
}
