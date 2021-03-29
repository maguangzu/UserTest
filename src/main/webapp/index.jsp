<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<title>人员</title>
<style type="text/css">
h1 {
	padding-left: 150px;
	color: #FF9900;
}

.collapse {
	border-collapse: collapse;
}

</style>
</head>

<body>
	<h1>人员列表！</h1>
	<table>
		<tr>
	<td>
		<form action="/servlet/userServlet" method="post">
			<input type="text" name="loginname">
			<input type="submit" value="查询">
		</form></td>
			<td>
				<form action="/servlet/userServletID" method="get">
					<input type="submit" value="ID排序">
				</form></td>
			<td>
			<td>
				<form action="/servlet/userServletName" method="get">
					<input type="submit" value="登录名排序">
				</form></td>
			<td>
	</tr>
	</table>
	<table border="1" class="collapse" >
		<tr bgcolor="#FAEBD7" align="center">
			<td>编号</td>
			<td>登录名</td>
			<td>姓名</td>
			<td>密码</td>
		</tr>
		<c:forEach items="${userList}" var="hl">
			<tr align="center">
				<td>${hl.id}</td>
				<td>${hl.loginname}</td>
				<td>${hl.name}</td>
				<td>${hl.password}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
