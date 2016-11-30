package factory;

import org.junit.Test;

import service.UserServiceImpl;


public class TestCglib {
	@Test
	public void test(){
		MyBeanFactory myBeanFactory=new MyBeanFactory();
		UserServiceImpl u=myBeanFactory.createService();
		u.addUser();
		System.out.println("--------------");
		u.updateUser();
		System.out.println("--------------");
		u.deleteUser();
	}

}
