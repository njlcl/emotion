package service;

import java.sql.SQLException;

import jdbc.JdbcUtils;
import dao.AccountDao;

public class Service {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AccountDao ad=new AccountDao();
		try {
			JdbcUtils.beginTransaction();//开启事务
			ad.update(1, -100);
			if(true) throw new RuntimeException("故意出错，回滚事务！");
			ad.update(2, 100);
			JdbcUtils.commitTransaction();//提交事务
			
		} catch (SQLException e) {
			try {
				JdbcUtils.rollbackTransaction();//回滚事务
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
