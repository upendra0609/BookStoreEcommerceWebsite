package com.bookstore.dao.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.dao.GenericDao;
import com.bookstore.dao.JpaDao;
import com.bookstore.entity.Users;

public class UserDao extends JpaDao<Users> implements GenericDao<Users> {

	@Override
	public Users create(Users users) {
		return super.create(users);
	}

	@Override
	public Users update(Users entity) {
		return super.update(entity);
	}

	@Override
	public Users get(Object userId) {
		return super.find(Users.class, userId);
	}

	@Override
	public void delete(Object userId) {
		super.delete(Users.class, userId);
	}

	@Override
	public List<Users> listAll() {
		return super.findWithNameQuery("users.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("users.countAll");
	}

	public Users findByEmail(Object paramValue) {
		List<Users> listUser = super.findWithNameQuery("users.findByEmail","email", paramValue);
		if(listUser!=null && listUser.size()==1) {
			return listUser.get(0);
		}
		return null;
	}
	

	public Users checkLogin(String email, String password) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("email", email);
		parameter.put("password", password);
		List<Users> listUser = super.findWithNameQuery("users.checkLogin", parameter);
		
		if(listUser.size()==1) {
			return listUser.get(0);
		}
		return null;
	}
}