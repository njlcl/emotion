package cn.edu.njupt.service;

import java.io.IOException;

import cn.edu.njupt.dao.UserDao;
import cn.edu.njupt.domain.User;


//User 业务层：校验用户名，用户名为null就添加，否则抛异常！
/*
 * void regist() throws UserException
 * 
 * */
public class UserService {
	public String msg="";
	private UserDao userDao=new UserDao();//依赖

	public void regist(User user) throws IOException {
		// 使用用户名去查询，如果返回为null，完成添加
		User u = userDao.findByUsername(user.getName());
		if (u != null){// 如果不为null，说明注册的用户已存在数据库，则抛出异常信息
			//throw new UserException("该用户已被注册!");
			this.msg="2";
		}else{
			userDao.add(user);
		}
	}

	public User login(User form) throws UserException {
		User user = userDao.findByUsername(form.getName());
		if (user == null||!(form.getPassword().equals(user.getPassword()))){
			System.out.println("用户不存在或密码错误!");
			this.msg="0";
		}
		return user;
	}
}
