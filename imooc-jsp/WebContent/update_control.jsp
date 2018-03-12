<%@ page language="java" contentType="text/html; charset=utf-8"
  errorPage="error.jsp"  pageEncoding="utf-8" import="com.imooc.bin.*,com.imooc.db.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>更新控制页面</title>
</head>
<body>
<%
Map<String,Emp>map=Dbutil.map;
Emp emp=map.get(request.getParameter("account"));
emp.setName(request.getParameter("name"));
emp.setEmail(request.getParameter("email"));
%>
<h3 align="center">修改成功</h3>
</body>
</html>