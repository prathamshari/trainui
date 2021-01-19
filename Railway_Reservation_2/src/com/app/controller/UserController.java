package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Trains;
import com.app.pojos.Users;
import com.app.service.IUserService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")GETGETGGETGETGETGETGETGETGETGETET
@RequestMapping("/users")
public class UserController {
	@Autowired
	private IUserService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	
	@PostMapping("/login")
	public ResponseEntity<?> processLoginForm(@RequestBody Users u)
	{
		String email = u.getEmail();
		String password = u.getPassword();
		System.out.println("inside login function");
		System.out.println(u.toString());
		
		Users loggedUser = service.validateUser(email, password);
		System.out.println(loggedUser.toString());
		
		if(loggedUser == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Users>(loggedUser,HttpStatus.OK);
	}
	// REST request handling method to get list of emps
	@GetMapping
	public ResponseEntity<?> listUsers() {
		System.out.println("in list users");
		List<Users> allEmps = service.getAllUsers();
		if (allEmps.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Users>>(allEmps, HttpStatus.OK);
	}

	
	
	@GetMapping("/adminlist")
	public ResponseEntity<?> listAdmins() {
		System.out.println("in list emps");
		List<Users> allEmps = service.getAllAdmins();
		if (allEmps.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Users>>(allEmps, HttpStatus.OK);
	}

	
	@PutMapping("/changepassword/{email}")
	public void changePassword(@PathVariable String email,@RequestBody Users u)                                               
	{
		System.out.println("email is :"+email);
		System.out.println("new password is "+u.getPassword());
		System.out.println("id is "+u.getUserId());
		service.cp(u.getUserId(),u.getPassword());
	}
	// REST request handling method to create new resourec : Emp
	@PostMapping
	public ResponseEntity<?> addAdmin(@RequestBody Users u) {
		System.out.println("in add emp dtls " + u);
		try {
			return new ResponseEntity<Users>(service.addAdminDetails(u), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/{userId}") 
	public ResponseEntity<?> getUserDetails(@PathVariable
			  int userId)
			  { System.out.println("in emp dtls " + userId); 
			  Users u =service.getUserByUserId(userId); 
			  if (u == null) 
				  return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
			  return new ResponseEntity<Users>(u, HttpStatus.OK); }
	 
		@PutMapping("/{id}")
		public ResponseEntity<?> updateUserDetails(@PathVariable int id,@RequestBody Users u) {
			u.setUserId(id);
			System.out.println("in add user dtls " + u);
			
			Users oldU=service.getUserByUserId(u.getUserId());
			       service.updateUser(oldU,u);
			
			return null;

		}
		
		@DeleteMapping("/{userId}")
		public void deleteUserDetails(@PathVariable int userId)
		{
			System.out.println("in delete emp "+userId);
			Users u=service.getUserByUserId(userId);
			service.deleteUserDetails(u);
		}
}
	
	/*
	// REST request handling method to delete existing resource : Emp
	@DeleteMapping("/{empId}")
	public void deleteEmpDetails(@PathVariable int empId)
	{
		System.out.println("in delete emp "+empId);
		service.deleteEmpDetails(empId);
	}
	
	
*/