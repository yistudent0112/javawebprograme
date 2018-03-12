<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.text.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Session对象</title>
</head>
<body>
<%
SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
Date d=new Date(session.getCreationTime());
%>
Session创建时间:<%=format.format(d) %><br>
Session创建时间:<%=session.getCreationTime() %><br>
Session的ID编号:<%=session.getId() %><br>
</body>
</html>