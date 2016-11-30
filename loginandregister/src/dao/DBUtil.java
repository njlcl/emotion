package dao;
import java.io.*;
import java.sql.*;
import java.util.Properties;

import service.DaoFactory;

public class DBUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	private static Properties prop;
	static{
		prop=new Properties();
		InputStream is;
		try {
			ClassLoader cl = DaoFactory.class.getClassLoader();
			 is = cl.getResourceAsStream("config.properties");
			 prop.load(is);
			} catch (Exception e) {
			e .printStackTrace();
			}
		driver=prop.getProperty("driver");
		url=prop.getProperty("url");
		username=prop.getProperty("username");
		password=prop.getProperty("password");
}

	public static Connection open(){
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

