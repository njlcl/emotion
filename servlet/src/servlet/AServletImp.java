package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AServletImp implements Servlet {
	/*
	 * 生命周期方法
	 * 在Servlet销毁之前被Tomcat调用，只能调用一次！（临死之前——留遗言）
	 * */
	@Override
	public void destroy() {
		System.out.println("destory()..........");
	}
	/*
	 * 获取Servlet的配置信息
	 * */
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("ServletConfig()..........");
		return null;
	}
	/*
	 * 获取Servlet信息，几乎不用
	 * */
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo()..........");
		return null;
	}
	/*
	 * 生命周期方法
	 * Servlet对象创建(Tomcat创建)后马上执行，只执行一次！（出生之后——剪脐带）
	 * */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		//获取web.xml中有关Servlet的初始化配置信息
		System.out.println("init方法开始运行！");
		System.out.println("servlet的名称为："+arg0.getServletName());//获取Servlet的name
		System.out.println(arg0.getInitParameter("p1"));//获取初始化参数p1对应的值
		System.out.println(arg0.getInitParameter("p2"));//获取初始化参数p2对应的值
		
		Enumeration e=arg0.getInitParameterNames();//迭代器中存储了所有的初始化参数
		while(e.hasMoreElements()){//遍历所有初始化参数
			System.out.println(e.nextElement());//获取每个初始化参数
		}
	}
	/*
	 * 生命周期方法
	 * 它会被调用多次
	 * 每次处理请求都调用该方法
	 * */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("service()..........");
	}

}
