package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import service.UserException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domin.User;


public class LoginServlet extends HttpServlet {

	/**
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//请求编码
		response.setContentType("text/html;charset=utf-8");//响应编码
		//依赖UserService
		UserService userservice=new UserService();
		
		User form=new User();
		String name=request.getParameter("user");
		String password=request.getParameter("password");
		form.setName(name);
		form.setPassword(password);
		
		try{
		User u=userservice.login(form);
		request.getSession().setAttribute("userssion",u);
		request.getRequestDispatcher("/user/welcome.jsp").forward(request, response);
		}catch (UserException e) {
			//获取异常信息保存到request域中
			request.setAttribute("msg", e.getMessage());
			//保存表单数据回显
			request.setAttribute("user", form);
			//转发到regist.jsp
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		}
		
		
	}
}
