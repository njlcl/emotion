<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 
  
 
	<form action="/loginandregister/LoginServlet" method="post">
		<table width="400" align="center">
		
			<tr>
				<td align="center" colspan="2"><font size=4><b>情感计算研究中心</b>
				</font>
				</td>
			</tr>
			<tr>
				<td align="right">用户名：</td>
				<td><input type="text" name="user" value="${user.name}" />
				</td>
			</tr>

			<tr>
				<td align="right">密码：</td>
				<td><input type="password" name="password" value="${user.password}"/></td>
			
			</tr>
			<tr>
			<td align="center" colspan="2"> <p style="color:red;font-weight:900">${msg }</p> </td>
			
			</tr>
			<tr>
				<td align="center" colspan="2" ><input type="submit" value="登录">
			   <a href="/loginandregister/user/regist.jsp">注册</a>
				</td>
			</tr>
			
		</table>

	</form>

</body>
</html>
