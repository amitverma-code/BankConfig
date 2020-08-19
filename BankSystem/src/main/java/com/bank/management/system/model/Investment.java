package com.bank.management.system.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description= "Details about the Investement")
@Entity
@Table(name="Investment")
public class Investment {
	
	@ApiModelProperty(notes = "trabsaction unique id which is auto generation")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
	
	@ApiModelProperty(notes = "mutual fund name during post it will auto capture user dont have to fill")
	@Column
	private String mFund;
	
	@ApiModelProperty(notes = "users account number during post user have to use own account number else user is not able to invest")
	@Column
	 @NotEmpty(message = "Account number must not be empty")
	private String accountNumber;
	
	@ApiModelProperty(notes = "users pan number which have to be same which user used during registration")
	@Column
	private String pan;
	
	@ApiModelProperty(notes = "investment user can invest 2 digit only")
	@Column
	@Pattern(regexp="[^A-Z,^a-z,?<>]*",message = "Alphabetic value,?,<,> as Investment ammount is not allowed")
    @NotEmpty(message = "Investment must not be empty")
	@Size(max = 2, message= "two digit allowed only")
	private String amountToInvest;
	
	@ApiModelProperty(notes = "it will auto extract local machines date and time")
	Instant instant = Instant.now();
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getmFund() {
		return mFund;
	}
	public void setmFund(String mFund) {
		this.mFund = mFund;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAmountToInvest() {
		return amountToInvest;
	}
	public void setAmountToInvest(String amountToInvest) {
		this.amountToInvest = amountToInvest;
	}
	public Instant getInstant() {
		return instant;
	}
	public void setInstant(Instant instant) {
		this.instant = instant;
	}
	public Investment(long transactionId, String mFund, String accountNumber, String pan, String amountToInvest,
			Instant instant) {
		super();
		this.transactionId = transactionId;
		this.mFund = mFund;
		this.accountNumber = accountNumber;
		this.pan = pan;
		this.amountToInvest = amountToInvest;
		this.instant = instant;
	}
	public Investment() {
	
	}
	


}
