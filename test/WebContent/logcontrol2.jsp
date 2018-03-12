<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录控制界面</title>
</head>
<body>
 <jsp:useBean id="User" class="com.pn.User"/>
 <jsp:useBean id="UserControl" class="com.pn.UserControl"/>
<jsp:setProperty property="*" name="User"/>
<%
if(UserControl.SelectByUserName(User)){
	session.setAttribute("username", User.getName());
	request.getRequestDispatcher("logon_success.jsp").forward(request, response);
}
else{
	response.sendRedirect("logon_fail.jsp");
}
%>
</body>
</html>