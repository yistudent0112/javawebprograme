<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
public String getNow(){
	SimpleDateFormat s=new SimpleDateFormat("yyyy/MM/dd hh-mm-ss");
	return s.format(new Date());
}
%>
<%=getNow() %>
<%!
public void getList(){
	ArrayList<Integer> a=new ArrayList<Integer>();
	a.add(10);
	a.add(20);
	a.add(30);
	a.add(40);
	
}
%>
<%=getList() %>
<%!

%>
第一个jsp程序！
</body>
</html>