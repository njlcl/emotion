package dao;

import java.io.IOException;

import org.junit.Test;

import domin.User;

//测试UserDao
public class UserDaoTeat {
@Test
public void testFindByUsername(){
	UserDao userDao=new UserDaoImpl();
	
	User u=userDao.findByUsername("q");
	System.out.println(u);
	
}
@Test
public void testAdd() throws IOException{
	UserDao userDao=new UserDaoImpl();
	
	User user=new User();
	user.setName("哈哈");
	user.setPassword("111");
	
	userDao.add(user);
	
}
	
}
