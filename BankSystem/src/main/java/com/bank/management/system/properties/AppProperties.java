package com.bank.management.system.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
//this class is for other microservices url
@ConfigurationProperties("app")
public class AppProperties {
private String allAccount;
private String getAccount;
private String addAccount;
private String deleteAccount;
private String getMutual;
}