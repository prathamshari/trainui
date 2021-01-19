package com.app.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IUserDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IUserDao dao;

	public AdminController() {
		System.out.println("in ctor of " + getClass().getName());
		
	}

	// req handling method for listing vendor dtls
	
	
//	@GetMapping("/list")
//	public String listVendors(Model map) {
//		System.out.println("in list vndrs");
//		map.addAttribute("vendor_list", dao.listVendors());
//		return "/admin/list";
//	}
	
	@GetMapping("/adminlogin")
	public String adminLogin(Model map)
	{
		System.out.println("in admin login");
		return "/admin/adminlogin";
	}
	
	
	@GetMapping("/trainList")
	public String trainList()
	{
		System.out.println("in train list");
		return "/admin/trainList";
	}

	
	//req handling method to show vendor reg form
	@GetMapping("/register")
	public String showRegForm()
	{
		System.out.println("in show reg form");
		return "/admin/register";
	}
	//req handling method to process vendor reg form
		@PostMapping("/register")
		public String processregForm()
		{
			//To be continued.....
			//dao.registerNewVendor(v);
			return "redirect:/admin/register";
		}
	
	
	
}