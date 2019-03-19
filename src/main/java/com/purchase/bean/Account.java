package com.purchase.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name="accounts")
public class Account implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@Column(name="account_id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;	

@NotEmpty
@Column(name="account_firstname")
private String firstName;

@Column(name="account_midtname")
private String midName;

@NotEmpty
@Column(name="account_lasttname")
private String lastName;

@NotEmpty
@Email
@Column(name="account_email")
private String email;

@NotEmpty
@Column(name="account_password")
private String password;

@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="account_role")
private AccountRole accountRole;

@Column(name="account_state")
private int state;


//=================transient var
@Transient
private String fullName; //only used for display

@Transient
@NotEmpty
@Size(min=2)
private String code;

@Transient
@Positive
private int role;

public Account() {
}




public int getId() {
	return id;
}




public void setId(int id) {
	this.id = id;
}




public String getFirstName() {
	return firstName;
}




public void setFirstName(String firstName) {
	this.firstName = firstName;
}




public String getMidName() {
	return midName;
}




public void setMidName(String midName) {
	this.midName = midName;
}




public String getLastName() {
	return lastName;
}




public void setLastName(String lastName) {
	this.lastName = lastName;
}




public String getEmail() {
	return email;
}




public void setEmail(String email) {
	this.email = email;
}




public String getFullName() {
	return fullName;
}




public void setFullName(String fullName) {
	this.fullName = fullName;
}




public String getPassword() {
	return password;
}




public void setPassword(String password) {
	this.password = password;
}




public AccountRole getAccountRole() {
	return accountRole;
}




public void setAccountRole(AccountRole accountRole) {
	this.accountRole = accountRole;
}




public int getState() {
	return state;
}




public void setState(int state) {
	this.state = state;
}




public String getCode() {
	return code;
}




public void setCode(String code) {
	this.code = code;
}




public int getRole() {
	return role;
}




public void setRole(int role) {
	//System.out.println("ex set role!");
	this.role = role;
	if(accountRole==null) {
		accountRole=new AccountRole();
		
	}
	accountRole.setId(role);
	
}




@Override
public String toString() {
	return "Account [id=" + id + ", firstName=" + firstName + ", midName=" + midName + ", lastName=" + lastName
			+ ", email=" + email + ", fullName=" + fullName + ", password=" + password + ", accountRole=" + accountRole
			+ ", state=" + state + ", code=" + code + "]";
}



}
