package com.app.dao;

import java.util.List;

import com.app.pojos.Trains;
import com.app.pojos.Users;

public interface IUserDao {
	Users getUserById (String id);

	List<Users> getAllUsers ();

	Users validateUser(String email, String pass);

	Users addAdminDetails(Users u);

	Users getUser(int userId);

	void deleteUserDetails(Users u);

	Users updateUser(Users user);

	void updateUser(Users oldU, Users u);

	List<Users> getAllAdmins();

	void changePassword(Integer userId, String password);
}
