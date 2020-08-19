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
import com.bank.management.system.model.Investment;
import com.bank.management.system.model.MutualFund;
import com.bank.management.system.service.AccountService;
import com.bank.management.system.service.InvestmentService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {
	
	@Autowired
    RestTemplate restTemplate;
	@Autowired
	InvestmentService investmentService;
	
	@Autowired
	AccountService accountService;
	@ApiOperation(value= "authentication",
			notes="user can check he is authenticated or not",
			response = UserDao.class)
	//only for checking user authenticated or not by this url
    @RequestMapping({ "/greeting" })
    public String welcomePage() {
        return "Welcome!";
    }
	
	//no use of this url but added to get all the account details
	@ApiOperation(value= "get all account details",
			notes="to get all accounts details basically its not for user but i added this",
			response = Account.class)
    @RequestMapping(value = "/Accounts", method = RequestMethod.GET)
    public List<Account> getMutuals(){
     return accountService.getAllAccount();
    }
	
//to get all the present mutualfund for buy
	@ApiOperation(value= "get all mutual details",
			notes="to get all accounts details basically its not for user but i added this",
			response = MutualFund.class)
    @RequestMapping(value = "/Mutuals", method = RequestMethod.GET)
    public List<MutualFund> getRestaurants(){
     return investmentService.getAllMutualFund();
    }
    
	//for invsetment where user have to pass their username and fund name in which user want to invest
	@PostMapping("/invest/{username}/{mName}")
	public void invest(@Valid @RequestBody Investment invest,@PathVariable String username,@PathVariable String mName) {
		investmentService.addInvestment(invest,username,mName);
	}
	
	//by this user will get all the investment details by using pan
	@ApiOperation(value= "Find Link Account",
			notes="User can find how many accounts are linked",
			response = Account.class)
    @RequestMapping(value = "/invByPan/{pan}", method = RequestMethod.GET)
	public List<Investment> getallInvestmentDetails(@PathVariable String pan) {
		return investmentService.findByPan(pan) ;
	}
	
	//this url is for adding account but user can add unique and maximum 4 accounts
	@ApiOperation(value= "Add Account",
			notes="user can add Account But only four accound can user add",
			response = Account.class)
    @PostMapping("/addAccount")
	public void addAccount(@Valid @RequestBody Account account) {
		accountService.addAccount(account);
	}
    
	//all the accounts added by the user.
	//user can se by using pan number
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
    @RequestMapping(value = "/delAccount", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestBody String acc) {
    	accountService.delete(acc);
		return "deleted";
	}
}