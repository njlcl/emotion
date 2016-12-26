package cn.edu.njupt.dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.google.gson.Gson;

import cn.edu.njupt.domain.Data;
import cn.edu.njupt.domain.SelectData;
import cn.itcast.jdbc.JdbcUtils;

/*
 * 对数据库中data表进行数据添加操作和根据用户名查找用户操作
 * */
public class DataDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());// 依赖

	public Data findByUsername(String username) {

		try {
			String sql = "select * from data where name=?";
			return qr.query(sql, new BeanHandler<Data>(Data.class), username);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void add(Data data) {
		try {
			// 1，SQL模板
			String sql = "insert into data values(?,?,?,?,?,?)";
			// 2，参数
			Gson gson=new Gson();
			//int[] b=gson.fromJson(s, int[].class);
			
			
			
			Object[] params = { data.getUserName(), data.getTimeStamp(),
					gson.toJson(data.getAcclData()), gson.toJson(data.getGyroData()),
					gson.toJson(data.getSkinResData()), gson.toJson(data.getHeartRateData()) };
			// 3,执行数据库添加操作
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<SelectData> findAllByUserName(String userName){
		
		try {
			String sql = "select * from data where userName=?";
			return qr.query(sql, new BeanListHandler<SelectData>(SelectData.class),userName);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
