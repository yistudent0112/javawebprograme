<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>servlet程序</title>
</head>
<body>
<% 
String path=request.getContextPath();
%>
	<h2>第一个servlet程序</h2>
	<!-- 使用超链接是，第一个/表示的是服务器的根目录 -->
    <!-- 使用相对路径跳转 -->
	<a href="servlet/Helloservlet">Get方法请求Servlet</a>
	<!-- 使用相对路径跳转 -->
	<form action="<%=path %>/servlet/Helloservlet" method="post">
	  <input type="submit" value="Post方法请求Servlet"/>
	</form>
</body>
</html>