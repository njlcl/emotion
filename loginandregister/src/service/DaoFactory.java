package service;

import dao.UserDao;

import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;
public class DaoFactory {
	private static Properties prop;
	static{
		prop=new Properties();
		InputStream is;
		try {
			ClassLoader cl = DaoFactory.class.getClassLoader();
			 is = cl.getResourceAsStream("dao.properties");
			prop.load(is);
			} catch (Exception e) {
			e .printStackTrace();
			}
	    }

	public static UserDao getUserDao(){
		//通过配置文件创建UserDaoImpl实现类(为了不出现实现类的名称!实现类的名称在配置文件中！)
		String userdao_name=prop.getProperty("userDao");//值为dao.UserDaoImpl或dao.JDBCUserImpl
		try {
			Class c=Class.forName(userdao_name);
			return (UserDao)c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
