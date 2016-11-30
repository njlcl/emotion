package dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domin.User;

public class JDBCUserImpl implements UserDao {

	@Override
	public User findByUsername(String username) {
		
		Connection conn=DBUtil.open() ;
		String sel="select * from user where name=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sel);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			User u=new User();
			if(rs.next()){
				String name=rs.getString(1);
				String password=rs.getString(2);
				u.setName(name);
				u.setPassword(password);
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public void add(User user) throws IOException {
		Connection conn=DBUtil.open() ;
		String sel="insert into user values(?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sel);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}

	}

}
