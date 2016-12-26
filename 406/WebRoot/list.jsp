<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户列表</title>

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
	<h3 align="center">客户列表</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>客户名</th>
			<th>时间</th>
			<th>加速度数据</th>
			<th>陀螺仪数据</th>
			<th>皮肤电数据</th>
			<th>心率数据</th>
			<th>操作</th>
		</tr>

		<%--<c:forEach items="${requestScope.customers}" var="cu">--%>
		<!-- 要遍历的beanlist中的内容 -->
		<c:forEach items="${pb.beanList}" var="cu">

			<tr>
				<td>${cu.cname}</td>
				<td>${cu.gender}</td>
				<td>${cu.birthday}</td>
				<td>${cu.cellphone}</td>
				<td>${cu.email}</td>
				<td>${cu.description}</td>
				<td><a href="<c:url value='/LoadServlet?cid=${cu.cid}'/>">编辑</a>
					<a href="<c:url value='/DeleteServlet?cid=${cu.cid}'/>">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<center>
		
		第${pb.pc }页/共${pb.tp }页 
		<a href="${pb.url}&pc=1">首页</a>
		<c:if test="${pb.pc > 1 }">
			<a href="${pb.url}&pc=${pb.pc-1}">上一页</a>
		</c:if>

		<%-- 计算begin、end --%>
		<c:choose>
			<%-- 如果总页数不足10页，那么把所有的页数都显示出来！ --%>
			<c:when test="${pb.tp <= 10 }">
				<c:set var="begin" value="1" />
				<c:set var="end" value="${pb.tp }" />
			</c:when>
			<c:otherwise>
				<%-- 当总页数>10时，通过公式计算出begin和end --%>
				<c:set var="begin" value="${pb.pc-5 }" />
				<c:set var="end" value="${pb.pc+4 }" />
				<%-- 头溢出 --%>
				<c:if test="${begin < 1 }">
					<c:set var="begin" value="1" />
					<c:set var="end" value="10" />
				</c:if>
				<%-- 尾溢出 --%>
				<c:if test="${end > pb.tp }">
					<c:set var="begin" value="${pb.tp - 9 }" />
					<c:set var="end" value="${pb.tp }" />
				</c:if>
			</c:otherwise>
		</c:choose>
		<%-- 循环遍历页码列表 --%>
		<c:forEach var="i" begin="${begin }" end="${end }">
			<c:choose>
				<c:when test="${i eq pb.pc }">
			        [${i }]
		        </c:when>
				<c:otherwise>
					<a href="${pb.url}&pc=${i}">[${i }]</a>
				</c:otherwise>
			</c:choose>

		</c:forEach>


		<c:if test="${pb.pc < pb.tp }">
			<a href="${pb.url}&pc=${pb.pc+1}">下一页</a>
		</c:if>
		<a href="${pb.url}&pc=${pb.tp}">尾页</a>
	</center>

</body>
</html>
