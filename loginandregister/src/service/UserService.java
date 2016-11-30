package service;

import java.io.IOException;

import dao.UserDao;
import domin.User;

//User 业务层：校验用户名，用户名为null就添加，否则抛异常！
/*
 * void regist() throws UserException
 * 
 * */
public class UserService {
	//这里不直接使用UserDaoImpl创建对象，而使用一个工厂（封装了实现类，返回UserDao（接口）对象）
	//private UserDao userDaoImpl = new UserDaoImpl();
	private UserDao userDao=DaoFactory.getUserDao();

	public void regist(User user) throws UserException, IOException {
		// 使用用户名去查询，如果返回为null，完成添加
		User u = userDao.findByUsername(user.getName());
		if (u != null)// 如果不为null，说明注册的用户已存在数据库，则抛出异常信息
			throw new UserException("该用户已被注册!");
		userDao.add(user);
	}

	public User login(User form) throws UserException {
		User user = userDao.findByUsername(form.getName());
		System.out.println(user);

		if (user == null)
			throw new UserException("用户不存在!");
		if (!(form.getPassword().equals(user.getPassword()))) {
			throw new UserException("密码错误!");
		}
		return user;
	}
}
