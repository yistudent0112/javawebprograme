<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录控制页面</title>
</head>
<body>
<%
 String username=request.getParameter("username");
 String password=request.getParameter("password");
 
  session.setAttribute("username", username);
 // request.getSession().setAttribute("username", username);
  response.sendRedirect(request.getContextPath()+"/message.jsp");
%>
</body>
</html>