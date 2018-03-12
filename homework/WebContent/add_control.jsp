<%@ page language="java" contentType="text/html; charset=utf-8" errorPage="error.jsp"
    pageEncoding="utf-8" import="homework.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公告板增加处理页面</title>
</head>
<body>
<%
String number=request.getParameter("number");
String name=request.getParameter("name");
String context=request.getParameter("context");
Board b=new Board(number,name,context);
if(Database.AddBoard(b)){
%>
<h3 align="center">增加成功</h3>
<input type="button" name="submit" value="返回" onclick="javascript:history.go(-1)"/>
<%}else{
	throw new Exception("add is not succeed.");
}%>
</body>
</html>