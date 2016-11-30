<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
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
    <h1>注册</h1>
    <p style="color:red;font-weight:900">${msg }</p>
    <form action="<c:url value='/RegistServlet'/>" method="post">
    <span class="require">*</span>用户名：
    <input type="text" name="username" size="30" maxLength="30" value="${user.name}"/><br/><br/>
    <span class="require">*</span>密         码：</div>
    <input type="password" name="password" size="30" maxLength="30" value="${user.password}"/><br/>
     <input type="submit" value="提交">
    </form>
    
    
  </body>
</html>
