package servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DServletExtendsGenericServlet extends GenericServlet {

	@Override
	//覆盖GenericServlet中的抽象方法
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("哈哈，我来了");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("我出生了！");
	}
	@Override
	public void destroy() {
		System.out.println("我要拜拜了!");
	}

}
