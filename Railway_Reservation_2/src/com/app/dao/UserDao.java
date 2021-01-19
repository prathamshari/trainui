package com.app.dao;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Role;
import com.app.pojos.Trains;
import com.app.pojos.Users;

@Repository // To tell SC , whatever follows is a DAO layer
//apply exception translation mechanism(translates hibernate specific excs
//to spring's un chekced excs --for uniform handling across multiple JPA vendors
//(DataAccessException)
public class UserDao implements IUserDao {
	@Autowired 
	private SessionFactory sf;
	
	@Override
	public Users validateUser(String email, String password) {
		System.out.println("in dao of login");
		System.out.println("email : "+email);
		System.out.println("password : "+password);
		String jpql = "select u from Users u where u.email=:em and u.password=:pass";
		Users user=new Users();
		user= sf.getCurrentSession().createQuery(jpql, Users.class).setParameter("em", email)
				.setParameter("pass", password).getSingleResult();
		System.out.println("after query execution");
		System.out.println(user.toString());
		return user;
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> u;
		String jpql="select u from Users u where u.role='USER'";
		return sf.getCurrentSession().createQuery(jpql,Users.class).getResultList();
	}

	@Override
	public Users getUserById(String id) {
		String jpql="select u from Users u where u.email=:ID";
		return sf.getCurrentSession().createQuery(jpql,Users.class).setParameter("ID",id).getSingleResult();
	}

	@Override
	public Users addAdminDetails(Users u) {
		if(u.getRole()==null)
		{
			u.setRole(Role.USER);
			sf.getCurrentSession().persist(u);
		}
		else
		{
			sf.getCurrentSession().persist(u);	
		}
		return u;
	}

	@Override
	public Users getUser(int userId) {
		Users u=new Users();
		u=sf.getCurrentSession().get(Users.class, userId);
		System.out.println("in dao :"+u.toString());
		return u;
	}

	@Override
	public Users updateUser(Users user) {
		
		return null;
	}

	@Override
	public void deleteUserDetails(Users u) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(u);
		
	}

	@Override
	public void updateUser(Users oldU, Users u) {
		oldU.setCity(u.getCity());
		  oldU.setDob(u.getDob());
		  oldU.setEmail(u.getEmail());
		  oldU.setfName(u.getfName());
		  oldU.setlName(u.getlName());
		  oldU.setMobile(u.getMobile());
		  oldU.setPincode(u.getPincode());
		  oldU.setRole(u.getRole());
		  oldU.setState(u.getState());
           sf.getCurrentSession().update(oldU);
		
	}
	

	@Override
	public void changePassword(Integer id, String pass1) {
		Users u=new Users();
		System.out.println("in dao : "+id+"  "+pass1);
		String jpql1="Select u from Users u where u.userId=:id";
		u=sf.getCurrentSession().createQuery(jpql1,Users.class).setParameter("id", id).getSingleResult();
		System.out.println(u.getUserId());
		u.setPassword(pass1);
		System.out.println(u.getPassword());	
	}
	@Override
	public List<Users> getAllAdmins() {
		List<Users> u;
//	String	r="ADMIN";
		String jpql="select u from Users u where u.role='ADMIN'";
		return sf.getCurrentSession().createQuery(jpql,Users.class).getResultList();
	}
	
	

}
