package dao;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtils;

import org.apache.commons.dbutils.QueryRunner;

public class AccountDao {
	public static void update(int id,double money) throws SQLException{
		QueryRunner qr=new QueryRunner();
		String sql="update user set money=money+? where id=?";
		Object[] p={money,id};
		
		Connection con=JdbcUtils.getConnection();//保证得到的是事务中的Connection
		qr.update(con,sql, p);
		
		JdbcUtils.releaseConnection(con);//释放连接
	}

}
