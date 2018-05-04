<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String username=request.getParameter("username");
String password=request.getParameter("password");
System.out.println(username+" "+password);
System.out.println(username.equals("admin"));
System.out.println(password.equals("1234"));
if(username.equals("admin")&&password.equals("1234")){
session.setAttribute("LoginUser", username);
response.sendRedirect(request.getContextPath()+"/main.jsp");
}
else{
	response.sendRedirect(request.getContextPath()+"/index.jsp?fail=-1");
	
}
%>


