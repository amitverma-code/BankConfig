package com.bank.management.system.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bank.management.system.model.UserDao;
import com.bank.management.system.model.Account;
import com.bank.management.system.service.AccountService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {
	
	@Autowired
    RestTemplate restTemplate;
	
	
	@Autowired
	AccountService accountService;
	@ApiOperation(value= "authentication",
			notes="user can check he is authenticated or not",
			response = UserDao.class)
    @RequestMapping({ "/greeting" })
    public String welcomePage() {
        return "Welcome!";
    }
	
	
	@ApiOperation(value= "get all account details",
			notes="to get all accounts details basically its not for user but i added this",
			response = Account.class)
    @RequestMapping(value = "/Accounts", method = RequestMethod.GET)
    public List<Account> getRestaurants(){
     return accountService.getAllAccount();
    }
    
	
	@ApiOperation(value= "Add Account",
			notes="user can add Account But only four accound can user add",
			response = Account.class)
    @PostMapping("/addAccount")
	public void addAccount(@Valid @RequestBody Account account) {
		accountService.addAccount(account);
	}
    
	
	@ApiOperation(value= "Find Link Account",
			notes="User can find how many accounts are linked",
			response = Account.class)
    @RequestMapping(value = "/AccByPan/{pan}", method = RequestMethod.GET)
	public List<Account> getallAccountdetails(@PathVariable String pan) {
		return accountService.findByPan(pan) ;
	}
   
	
	@ApiOperation(value= "For deletion of account",
			notes="User can delete Account",
			response = Account.class)
    @RequestMapping(value = "/restaurants", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestBody String acc) {
    	accountService.delete(acc);
		return "deleted";
	}
}