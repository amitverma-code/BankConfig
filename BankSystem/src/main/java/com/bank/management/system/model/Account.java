package com.bank.management.system.model;



public class Account {
	 private long id;
     private String accountNumber;
     private String ifscCode;
     private String accountName;
     private String micrCode;
     private String pan;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getMicrCode() {
		return micrCode;
	}
	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Account(long id, String accountNumber, String ifscCode, String accountName, String micrCode, String pan) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.accountName = accountName;
		this.micrCode = micrCode;
		this.pan = pan;
	}
	public Account() {
	
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + ", accountName="
				+ accountName + ", micrCode=" + micrCode + ", pan=" + pan + "]";
	}
     
     
}
