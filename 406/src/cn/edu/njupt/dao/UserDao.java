package cn.edu.njupt.dao;



import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.njupt.domain.User;
import cn.itcast.jdbc.JdbcUtils;


public class UserDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());// 依赖
	//根据用户名查询该用户的所有信息
	public User findByUsername(String username) {
		try {
			String sql="select * from user where name=?";
			return qr.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	//想数据库中的user表中添加用户
	public void add(User user) {
		try {
			// 1，SQL模板
			String sql="insert into user values(?,?,?)";
			// 2，参数
			Object[] params = {user.getName(),user.getPassword(),user.getNikename()};
			// 3,执行数据库添加操作
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
