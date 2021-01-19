package com.app.pojos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "users",uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Users {

@NotEmpty(message="email must be supplied")
@Email(message="email must be valid")	
private String email;
private Integer userId;
private String password;
private Role role;
private String fName;
private String lName;
private Gender gender;
@JsonFormat(pattern = "yyyy-MM-dd")
private Date dob;
private long mobile;
private String city;
private String state;
private int pincode;
private String question;
private String answer;
public Users() {
	// TODO Auto-generated constructor stub
}

@Column(length=35,unique = true)
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}

@Column(name = "question")
@NotNull(message = "Select Security Question")
public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}
@Column(name = "answer")
@NotNull(message = "Answer Is Requierd")
public String getAnswer() {
	return answer;
}

public void setAnswer(String answer) {
	this.answer = answer;
}

@Column(length=35)
@NotNull
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
@Enumerated(EnumType.STRING)
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
@Column(length=35)
@NotEmpty(message = "First Name Is Required")
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
@Column(length=35)
@NotEmpty(message = "Last Name Is Required")
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}

@Enumerated(EnumType.STRING)
public Gender getGender() {
	return gender;
}
public void setGender(Gender gender) {
	this.gender = gender;
}
@Temporal(TemporalType.DATE)
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
@NotNull
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
@Column(length=35)
@NotNull
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Column(length=35)
@NotNull
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
@NotNull
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}

@Override
public String toString() {
	return "Users [email=" + email + ", userId=" + userId + ", password=" + password + ", role=" + role + ", fName="
			+ fName + ", lName=" + lName + ", gender=" + gender + ", dob=" + dob + ", mobile=" + mobile + ", city="
			+ city + ", state=" + state + ", pincode=" + pincode + ", question=" + question + ", answer=" + answer
			+ "]";
}






}
