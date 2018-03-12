<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.pn.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>javabean示例</title>
</head>
<body>
<h2>javabean示例</h2>

<%
//普通的声明一个类来使用Javabean的方式
    User u=new User();
    u.setName("yi");
    u.setPassword("1234");
  
    
%>
<!-- 根据表单自动匹配所有元素 -->
<!--<jsp:getProperty property="*" name="MyUser"/>-->

用户名:<%=u.getName() %><br>
密码:<%=u.getPassword() %><br>
<h2>使用usebean动作来创建javabean实例</h2>
<jsp:useBean id="MyUser" class="com.pn.User"/>
用户名:<%=MyUser.getName() %><br>
密码:<%=MyUser.getPassword() %><br>
</body>
</html>