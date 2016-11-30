package dao;

import java.io.IOException;

import domin.User;
//接口
public interface UserDao {
	public User findByUsername(String username);
	public void add(User user) throws IOException;

}
