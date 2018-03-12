<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String Path=request.getContextPath();
String BasePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+Path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录页面</title>
<script type="text/javascript"
	src="/ajax/WebContent/resources/js/jquery-1.4.2.js"></script>
</head>
<body>
	<form action="/logon.servlet">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" value="请输入你的用户名"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password" value="密码的长度为6~12"></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"></td>
			</tr>
		</table>
	</form>
</body>
</html>