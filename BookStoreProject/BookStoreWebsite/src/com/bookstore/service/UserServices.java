package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.user.UserDao;
import com.bookstore.entity.Users;

public class UserServices {

	private UserDao userDao;

	public UserServices() {
		if (userDao == null) {
			this.userDao = new UserDao();
		}
	}

	public List<Users> listUsers() {
		return userDao.listAll();
	}

	public Users createUser(Users user) {
		return userDao.create(user);
	}

	public Users findByEmail(String paramValue) {
		return userDao.findByEmail(paramValue);
	}

	public Users getUser(int userId) {
		return userDao.get(userId);
	}

	public Users updateUser(Users user) {
		return userDao.update(user);
	}
	
	public void deleteUser(int userId) {
		userDao.delete(userId);
	}
	public boolean checkLogin(String email, String password) {
		Users loginUser = userDao.checkLogin(email, password);
		
		if(loginUser!=null) {
			return true;
		}		
		return false;
	}
	
	public long userCount() {
		return userDao.count();
	}
}