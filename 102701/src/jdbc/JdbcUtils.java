package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/*
 * 修改JdbcUtils，进行事务处理
 * */
public class JdbcUtils {
	private static 	ThreadLocal<Connection> tl=new ThreadLocal<Connection>();//事务中专有的Connection
	
	//根据配置文件(c3p0-config.xml)的默认c3p0配置信息得到数据库连接信息，创建连接池实例
	private static ComboPooledDataSource datasource=new ComboPooledDataSource();
	//返回一个连接对象
	public static Connection getConnection() throws SQLException{
		Connection con=tl.get();//获取当前线程的Connection
		if(con!=null)return con;//当con不为null时，说明已经开启了事务，因为只有beginTransaction给con赋值
		return datasource.getConnection();
	}
	//返回连接池对象
	public static DataSource getDataSource(){
		return datasource;
	}
	//获取一个Connection，开启事务(手动)
	public static void beginTransaction() throws SQLException{
		Connection con=tl.get();//获取当前线程的Connection
		if(con!=null) throw new RuntimeException("事务已开启，不要重复开启！");//防止重复开启事务
		con=getConnection();
		con.setAutoCommit(false);
		tl.set(con);//保存当前线程的连接
		
	}
	//获取beginTransaction的Connection，提交事务
	public static void commitTransaction() throws SQLException{
		Connection con=tl.get();//获取当前线程的Connection
		if(con==null) throw new RuntimeException("事务未开启，不能提交！");//防止未开启事务（这时候con=null）就提交事务
		con.commit();
		con.close();
//		con=null;//因为事务已经结束，为了使得下次获得新的con
		tl.remove();//移除连接
		
	}
	//获取beginTransaction的Connection，回滚事务
	public static void rollbackTransaction() throws SQLException{
		Connection con=tl.get();//获取当前线程的Connection
		if(con==null) throw new RuntimeException("事务未开启，不能回滚！");//防止未开启事务（这时候con=null）就回滚事务
		con.rollback();
		con.close();
//		con=null;//因为事务已经结束，为了使得下次获得新的con
		tl.remove();//移除连接
	}
	
	public static void releaseConnection(Connection connection) throws SQLException{
		Connection con=tl.get();//获取当前线程的Connection
		//如果con=null，说明没有事务，那么可以关闭连接
		if(con==null) connection.close();
		if(con!=connection) connection.close();
	}
}
