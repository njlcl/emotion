package cn.edu.njupt.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.edu.njupt.domain.Data;
import cn.edu.njupt.domain.SelectData;
import cn.edu.njupt.service.DataService;

//从数据库中调取用户加速度等数据进行处理

public class BServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");// 请求编码
		response.setContentType("text/html;charset=utf-8");// 响应编码

		DataService dataservice = new DataService();
		String username = request.getParameter("userName");
		System.out.println("请求的用户名是：" + username);

		List<SelectData> count = dataservice.findAllByUserName(username);
		System.out.println("List中对象个数:"+count.size());//98

		Iterator it = count.iterator();

		while (it.hasNext()) {
			SelectData s = (SelectData) it.next();

			String userName = s.getUserName();// 用户名
			String time = s.getTimeStamp();// 时间

			String accData = s.getAcclData();
			String gyroData = s.getGyroData();
			String skinData = s.getSkinResData();
			String hearData = s.getHeartRateData();

			Gson gson = new Gson();
			float[] acc = gson.fromJson(accData, float[].class);
			float[] gyro = gson.fromJson(gyroData, float[].class);
			int[] skin = gson.fromJson(skinData, int[].class);
			int[] hear = gson.fromJson(hearData, int[].class);

			//x轴加速度
			List<Float> acc_x=new ArrayList<Float>();
			for(int i=0;i<acc.length;i=i+3){
				acc_x.add(acc[i]);
			}
			//y轴加速度
			List<Float> acc_y=new ArrayList<Float>();
			for(int i=1;i<acc.length;i=i+3){
				acc_y.add(acc[i]);
			}
			//z轴加速度
			List<Float> acc_z=new ArrayList<Float>();
			for(int i=2;i<acc.length;i=i+3){
				acc_z.add(acc[i]);
			}
			//x轴角度
			List<Float> gyro_x=new ArrayList<Float>();
			for(int i=0;i<gyro.length;i=i+3){
				gyro_x.add(gyro[i]);
			}
			//y轴角度
			List<Float> gyro_y=new ArrayList<Float>();
			for(int i=1;i<gyro.length;i=i+3){
				gyro_y.add(gyro[i]);
			}
			//z轴角度
			List<Float> gyro_z=new ArrayList<Float>();
			for(int i=2;i<gyro.length;i=i+3){
				gyro_z.add(gyro[i]);
			}
			
			System.out.println("z轴加速度个数："+acc_z.size());
			
			
		
			
		}

	}

}

