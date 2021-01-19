package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.Trains;
import com.app.pojos.Users;

@Transactional
@Service
public class UserService implements IUserService
{

	@Autowired
	private IUserDao dao;
	
	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}

	@Override
	public Users getUserById(String id) {
		// TODO Auto-generated method stub
		return dao.getUserById(id);
	}

	@Override
	public Users addAdminDetails(Users u) {
		// TODO Auto-generated method stub
		return dao.addAdminDetails(u);
	}

	@Override
	public Users validateUser(String email, String password) {
		return dao.validateUser(email,password);
	}

	@Override
	public Users getUserByUserId(int userId) {
		// TODO Auto-generated method stub
		System.out.println("in user service :"+userId);
		return dao.getUser(userId);
	}

	@Override
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public void deleteUserDetails(Users u) {
		// TODO Auto-generated method stub
		dao.deleteUserDetails(u);
		
	}

	@Override
	public void updateUser(Users oldU, Users u) {
		dao.updateUser(oldU,u);
		
	}

	@Override
	public List<Users> getAllAdmins() {
		// TODO Auto-generated method stub
		return dao.getAllAdmins();
	}

	@Override
	public void cp(Integer userId, String password) {
		dao.changePassword(userId,password);
		
	}

}
