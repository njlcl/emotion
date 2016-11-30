package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domin.User;

import service.UserException;
import service.UserService;

public class RegistServlet extends HttpServlet {

	/**
	 * 1.封装表单数据到Use对象中
	 * 2.使用UserService的regist()方法
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//请求编码
		response.setContentType("text/html;charset=utf-8");//响应编码
		
		//依赖UserService
		UserService userservice=new UserService();
		//获取表单信息，封装到User对象中
		User form=new User();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		form.setName(name);
		form.setPassword(password);
		
		
		
		try {
			if(name.equals("")||password.equals("")){
			    request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
			}
			userservice.regist(form);
			response.getWriter().print("注册成功！");
			response.getWriter().print("<a href="+"/loginandregister/user/login.jsp"+">登录</a>");
		} catch (UserException e) {
			//获取异常信息保存到request域中
			request.setAttribute("msg", e.getMessage());
			//保存表单数据回显
			request.setAttribute("user", form);
			//转发到regist.jsp
			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
		}
		
		
	}

}
