package com.bank.management.system.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description= "Details about the Users")
@Entity
@Table(name="UserBank")
public class UserDao {
	
	
	@ApiModelProperty(notes = "The User's ID which is unique")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	
	@ApiModelProperty(notes = "The User's username or user id which is unique")
    @Column
    @NotEmpty(message = "username must not be empty")
    private String username;
	
	
	@ApiModelProperty(notes = "The User's password")
    @Column
    @JsonIgnore
    private String password;
	
	
	@ApiModelProperty(notes = "The User's first name")
    @Column
    @NotEmpty(message = "First Name must not be empty")
	private String FirstName; 
	
	
	@ApiModelProperty(notes = "The User's Last Name")
    @Column
    @NotEmpty(message = "Last Name must not be empty")
	private String LastName; 
	
	
	@ApiModelProperty(notes = "The User's pancard which is unique")
    @Column
    @Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}",message = "Enter Valid Pan For Example BNZAA2318J")
    @NotEmpty(message = "PAN must not be empty")
    private String pan; 
	
	
    @ApiModelProperty(notes = "The User's ID email")
    @Column
    @Pattern(regexp="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$",message = "Enter Valid email")
    @NotEmpty(message = "Email must not be empty")
    private String Email; 
    
    
	@ApiModelProperty(notes = "The User's contact number")
    @Column
    @Size(min = 10, max = 10, message= "Contact Number Must of Size 10")
    @Pattern(regexp="[^A-Z,^a-z,?<>]*",message = "Alphabetic value not allowed,?,<,> as Contact Number")
    private String ConntactNumber; 
	
	
	@ApiModelProperty(notes = "The User's Dob")
    @Column
    @Pattern(regexp="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d",message = "Enter Valid Date For Example mm-dd-yyyy and year should be more than 1900")
    private String Dob;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getConntactNumber() {
		return ConntactNumber;
	}

	public void setConntactNumber(String conntactNumber) {
		ConntactNumber = conntactNumber;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	

	
   

}