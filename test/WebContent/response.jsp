<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>response响应页面</title>
</head>
<body>
<%
response.setContentType("text/html; charset=utf-8");//设置响应的MIME类型
out.println("1");
out.println("<br>");
out.flush();
PrintWriter outer=response.getWriter();
outer.println("2");
response.sendRedirect("test.jsp");
%>
</body>
</html>