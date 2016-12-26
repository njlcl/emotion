package cn.edu.njupt.web.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.domain.Data;
import cn.edu.njupt.domain.Login1;
import cn.edu.njupt.domain.PhysiologyComm1;
import cn.edu.njupt.domain.PhysiologyComm2;
import cn.edu.njupt.domain.Register1;
import cn.edu.njupt.domain.User;
import cn.edu.njupt.service.DataService;
import cn.edu.njupt.service.UserException;
import cn.edu.njupt.service.UserService;

import com.google.gson.Gson;



public class AServlet extends HttpServlet {

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ip=request.getRemoteHost();
		System.out.println("ip:"+ip);	
		request.setCharacterEncoding("utf-8");//请求编码
		response.setContentType("text/html;charset=utf-8");//响应编码
		System.out.println(request);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//请求编码
		response.setContentType("text/html;charset=utf-8");//响应编码
		
		// 依赖UserService
		UserService userservice = new UserService();
		DataService dataservice=new  DataService ();
		// 获取表单信息，封装到User对象中
		User form = new User();
		// 获取表单信息，封装到Data对象中
		Data data=new Data();
		
		//判断手机端发送的是登录还是注册请求
		String data_type=request.getHeader("Data_Type");
		
		// 1.如果是注册请求，将用户名，密码，昵称保存数据库中
		if ("Register1".equals(data_type)) {
			// 获取手机端ip，测试通信连接状态
			String ip = request.getRemoteHost();
			System.out.println("注册用户的ip:" + ip);
			// 读取手机端的注册信息
			Reader r = request.getReader();
			BufferedReader br = new BufferedReader(r);
			String mydata;
			mydata = br.readLine();
			// 解析手机端发送的json格式数据
			Gson gson = new Gson();
			Register1 r1 = gson.fromJson(mydata, Register1.class);
			String name = r1.userName;
			String password = r1.password;
			String nickname = r1.nickname;
			// 将解析的用户名、密码放入User中
			form.setName(name);
			form.setPassword(password);
			form.setNikename(nickname);
			// 测试手机端是否收到注册信息
			System.out.println("注册用户名:" + name);
			System.out.println("注册用户密码:" + password);
			System.out.println("注册用户昵称:" + nickname);
			// 将用户名、密码存放数据库中
			userservice.regist(form);
			// 对手机端反馈“注册成功”标示
			response.setHeader("Data_Type", "Register2");
			if (userservice.msg.equals("")) {
				response.getWriter()
						.write("{\"isRegister\":true,\"comment\":\"Register success\"}");
			} else {
				response.getWriter().write(
						"{\"isRegister\":false,\"comment\":\"该用户已存在！请重新注册！\"}");
			}
		}
		// 2.登录逻辑处理
		if ("Login1".equals(data_type)) {// 如果是登录请求，判断用户名和密码是否匹配
			// 读取手机端的注册信息
			Reader r = request.getReader();
			BufferedReader br = new BufferedReader(r);
			String mydata = br.readLine();
			System.out.println("登录时请求体：" + mydata);
			// 解析手机端发送的json格式数据
			Gson gson = new Gson();
			Login1 l1 = gson.fromJson(mydata, Login1.class);
			String name = l1.userName;
			String password = l1.password;
			// 将解析的用户名、密码放入User中
			form.setName(name);
			form.setPassword(password);
			form.setNikename("");
			// 测试手机端是否收到登录信息
			System.out.println("登录名:" + name);
			System.out.println("登录密码:" + password);
			// 用户登录
			try {
				userservice.login(form);
				//System.out.println("我看看:" + userservice.msg);
				// 对手机端反馈“登录”标示
				response.setHeader("Data_Type", "Login2");
				if (userservice.msg.equals("")) {
					response.getWriter().write(
							"{\"isLogin\":true,\"comment\":\"登陆成功\"}");
				} else {
					response.getWriter().write(
							"{\"isLogin\":false,\"comment\":\"用户不存在或密码错误!\"}");
				}
			} catch (UserException e) {
				e.printStackTrace();
			}

		}
		int index=1;
		int count=1;
		// 3.传感器数据逻辑处理
		if ("PhysiologyComm1".equals(data_type)) {
			
			// 读取手机端发送的传感器数据信息
			Reader r = request.getReader();
			BufferedReader br = new BufferedReader(r);
			String mydata = br.readLine();
			//System.out.println("手机端发送传感器数据的请求体：" + mydata);
//			System.out.println("请求数据长度为："+mydata.length());
			// 解析手机端发送的json格式数据
			Gson gson = new Gson();
			PhysiologyComm1 p1 = gson.fromJson(mydata, PhysiologyComm1.class);
			String userName = p1.userName;
			long timeStamp=p1.timeStamp;
			
			float[] acclData=p1.acclData;
			float[] gyroData=p1.gyroData;
			
			int[] skinResData=p1.skinResData;
			int[] heartRateData=p1.heartRateData;
					
			// 将解析的数据放入Data中
			data.setUserName(userName);
			data.setTimeStamp(timeStamp);
			data.setAcclData(acclData);
			data.setGyroData(gyroData);
			data.setSkinResData(skinResData);
			data.setHeartRateData(heartRateData);
			
			 //测试手机端是否收到登录信息
			Calendar c=Calendar.getInstance();
			c.setTimeInMillis(timeStamp);
			int second=c.get(Calendar.SECOND);
			
			count++;
			try {
				dataservice.addData(data);
				// 对手机端反馈“接收传感器数据成功”标示
				response.setHeader("Data_Type", PhysiologyComm2.SERVICE_TYPE);
				
				PhysiologyComm2 p2=new PhysiologyComm2();
				p2.isSuccess=true;
				String str = gson.toJson(p2);
				OutputStream os=response.getOutputStream();
				OutputStreamWriter osr=new OutputStreamWriter(os);
				
				osr.write(str);
				osr.flush();
				System.out.println("-----------------------------------------当前是第："+second+"秒"+"-------"+timeStamp);
				System.out.println(data.getUserName());
				Date date=new Date(data.getTimeStamp());
				
				
				System.out.println("接收时间："+date);
				System.out.println("加速度数据："+data.getAcclData().length+"个：") ;//+ Arrays.toString(data.getAcclData()));
				System.out.println("陀螺仪数据："+data.getGyroData().length+"个：" );//+ Arrays.toString(data.getGyroData()));
				System.out.println("皮肤电数据："+data.getSkinResData().length+"个");//+Arrays.toString(data.getSkinResData()));
				System.out.println("心率数据："+data.getHeartRateData().length+"个：");// +Arrays.toString(data.getHeartRateData()));
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
