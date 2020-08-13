package com.bank.management.system.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("app")
public class AppProperties {
private String allAccount;
private String getAccount;
private String addAccount;
private String deleteAccount;
}