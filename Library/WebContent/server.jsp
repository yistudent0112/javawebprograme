<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
 String basePath=request.getContextPath();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理系统</title>
</head>
<frameset rows="20%,*">
	<frame src="<%=basePath%>/top.jsp"></frame>
	<frameset cols="10%,*">
		<frame src="<%=basePath%>/left.jsp"></frame>
		<frame name="main"></frame>
	</frameset>
</frameset>
</html>