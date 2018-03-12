<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="homework.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公告板删除页面</title>
</head>
<body>
<%
Database.RemoveBoard(request.getParameter("number"));
%>
<h4 align="center">删除成功</h4>
<br>
<input type="button" name="submit" onclick="javascript:history.back(-1);"value="返回"/>
</body>
</html>