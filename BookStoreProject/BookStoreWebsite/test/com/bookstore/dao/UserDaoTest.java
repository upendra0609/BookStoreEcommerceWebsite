package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;

import com.bookstore.dao.user.UserDao;
import com.bookstore.entity.Users;

public class UserDaoTest {

	@Test
	public void testCreateUsers() {
		UserDao userDAo = new UserDao();

		Users user = new Users();
//			user.setUserId(1);
		user.setEmail("aaa@gamil.com");
		user.setFullName("fff");
		user.setPassword("fff@123");
		user = userDAo.create(user);

		assertTrue(user.getUserId() > 0);
	}

//	@Test
//	public void testUpdateUsers() {
//		 UserDao userDAo = new UserDao();
//			
//			Users user = new Users();
////			user.setUserId(1);
//			user.setEmail("eeee@gamil.com");
//			user.setFullName("eee");
//			user.setPassword("eee@123");
//			user = userDAo.update(user);
//			 
//			assertTrue(user.getUserId()>0);
//	}

//	@Test
//	public void testGetUsers() {
//		 UserDao userDAo = new UserDao();
//			
//		 Users users = userDAo.get(2);
//		 System.out.println(users.getFullName());
//		 assertNotNull(users);
//			
//	}
//	
//	@Test
//	public void testGetUsersNotFound() {
//		 UserDao userDAo = new UserDao();
//			
//		 Users users = userDAo.get(23);
//		 System.out.println(users.getFullName());
//		 assertNull(users);
//			
//	}

//	@Test
//	public void testDeleteUsers() {
//		 UserDao userDAo = new UserDao();
//			
//		 userDAo.delete(2);
//		 Users users = userDAo.get(2);
//			 System.out.println(users.getFullName());
//			 assertNull(users);
//	}
//	
//	@Test(expected = EntityNotFoundException.class)
//	public void testDeleteUsersNotFound() {
//		 UserDao userDAo = new UserDao();
//			
//		 userDAo.delete(22);
//		 Users users = userDAo.get(22);
//			 System.out.println(users.getFullName());
//			 assertNull(users);
//	}

//	@Test
//	public void testListAllUsers() {
//		 UserDao userDAo = new UserDao();
//			
//		 List<Users> listAll = userDAo.listAll();
//		 
//		 for(Users u: listAll) {
//			 System.out.println(u.getFullName());
//		 }
//		 
//			 assertNotNull(listAll);
//	}

//	@Test
//	public void testListCountAllUsers() {
//		UserDao userDAo = new UserDao();
//
//		long count = userDAo.count();
//
//		System.out.println(count);
//
//		assertNotNull(count);
//	}

}
