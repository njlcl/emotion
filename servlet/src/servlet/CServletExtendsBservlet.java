package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CServletExtendsBservlet extends BServletImp {
	//直接覆盖父类中的init(ServletConfig config)方法得不到config
//	public void init(ServletConfig config) throws ServletException {
//		// 将Servlet配置信息赋值给本类变量，相当于保存，便于其他方法使用
//		this.config=config;
//	}
	private void init() {
		System.out.println("我是服务器C中的方法！我覆盖父类中无参的init方法！");
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		String servlet_name=super.getServletName();
	}

}
