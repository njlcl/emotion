package cn.edu.njupt.service;

import java.io.IOException;
import java.util.List;

import cn.edu.njupt.dao.DataDao;
import cn.edu.njupt.domain.Data;
import cn.edu.njupt.domain.SelectData;


/*
 *业务层：添加数据，通过用户名查询数据
 * */
public class DataService {
	public String msg="";
	//这里不直接使用UserDaoImpl创建对象，而使用一个工厂（封装了实现类，返回UserDao（接口）对象）
	private DataDao dataDao=new DataDao();
    //添加数据
	public void addData(Data data) throws IOException {
			dataDao.add(data);
	}
	//查询数据
	public List<SelectData> findAllByUserName(String username) {
		return dataDao.findAllByUserName(username);
	}
	
}
