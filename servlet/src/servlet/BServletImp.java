package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * 模拟GenericServlet
 * */
public class BServletImp implements Servlet {
	private ServletConfig config;
	@Override
	public void destroy() {

	}
	//这个方法一定会在init方法后面执行
	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
	//Tomcat首先执行该方法
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 将Servlet配置信息赋值给本类变量，相当于保存，便于其他方法使用
		this.config=config;
		init();//方便子类覆盖
		
	}

	private void init() {
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("每次处理请求都会执行！");
	}
	//得到Servlet配置中参数p1的值
	public String getInitParameter(){
		return config.getInitParameter("p1");
	}
	//得到Servlet的名字
	public String getServletName(){
		return config.getServletName();
	}	
	//得到Servlet上下文对象
	public ServletContext getServletContext(){
		return  config.getServletContext();
	}

}
