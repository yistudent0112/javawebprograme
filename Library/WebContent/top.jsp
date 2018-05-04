<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
 String basePath=request.getContextPath();
 String username=(String)session.getAttribute("LoginUser");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<center>
		<h1>
			图书后台管理系统<span   style="font-size:30px;color:red">您好，<%=username %></span>
		</h1>
	</center>
</body>
</html>