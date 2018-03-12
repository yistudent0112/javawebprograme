<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录控制界面</title>
</head>
<body>
<%
String check=(String)request.getParameter("IsUseCookie");
if(check!=null&&check.length()>0){
 String name=(String)request.getParameter("name");
 String password=(String)request.getParameter("password");
 Cookie nameCookie=new Cookie("name",name);
 Cookie passwordCookie=new Cookie("password",password);
 nameCookie.setMaxAge(864000);
 passwordCookie.setMaxAge(864000);//设置cookie的最大生存时间
 response.addCookie(nameCookie);
 response.addCookie(passwordCookie);
}else{
	Cookie [] cookie=request.getCookies();
	if(cookie!=null&&cookie.length>0){
		for(Cookie temp:cookie){
			if(temp.getName().equals("name")||temp.getName().equals("password")){
			   temp.setMaxAge(0);//设置Cookie失效
			   response.addCookie(temp);//重新设置Cookie
			}
			
		}
	}
}
%>
<br>
<a href="out.jsp">跳转</a>
</body>
</html>