<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.pn.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录控制界面</title>
</head>
<body>
<h2>登录界面</h2>
<jsp:useBean id="MyUser" class="com.pn.User"/>
<!-- 根据表单自动匹配所有元素 --> 
<%--<jsp:setProperty property="*" name="MyUser"/>--%>
<!-- 根据表单匹配部分的属性 -->
<%-- <jsp:setProperty property="name" name="MyUser"/>--%>
<!-- 根据表单无关，通过手工赋值的方式给元素赋值 -->
<%-- <jsp:setProperty property="name" name="MyUser" value="yi"/>
<jsp:setProperty property="password" name="MyUser" value="888888"/>--%>
<!-- 通过url传递参数的方式给元素赋值 -->
<jsp:setProperty property="password" name="MyUser" param="mypass"/>
<jsp:setProperty property="name" name="MyUser" param="mypass"/>
<!-- 使用传统的表达式方式来打印用户名和密码 -->
用户名:<%=MyUser.getName() %><br>
密码:<%=MyUser.getPassword() %><br>
<!-- 使用getProperty方式来打印用户名和密码 -->
用户名:<jsp:getProperty property="name" name="MyUser"/><br>
密码:<jsp:getProperty property="password" name="MyUser"/><br>
</body>
</html>