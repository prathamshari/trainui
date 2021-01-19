package com.app.service;

import java.util.List;

import com.app.pojos.Trains;
import com.app.pojos.Users;

public interface IUserService {

	List<Users> getAllUsers();

	Users getUserById(String id);

	Users addAdminDetails(Users u);

	Users validateUser(String email, String password);

	Users getUserByUserId(int userId);

	void deleteUserDetails(Users u);

	Users updateUser(Users user);

	void updateUser(Users oldU, Users u);

	List<Users> getAllAdmins();

	void cp(Integer userId, String password);

}
