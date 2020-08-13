package com.bank.management.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
    @RequestMapping({ "/greeting" })
    public String welcomePage() {
        return "Welcome!";
    }
}