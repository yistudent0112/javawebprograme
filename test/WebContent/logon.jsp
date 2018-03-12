<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
</head>
<body>
<%
String name="";
String password="";
Cookie [] cookie=request.getCookies();
if(cookie!=null&&cookie.length>0){
	for(Cookie temp:cookie){
		if(temp.getName().equals("name")){
            name=temp.getValue();
		}
		else if(temp.getName().equals("password")){
			password=temp.getValue();
		}
		
	}
}
%>
<form action="forward.jsp"method="post">
  <table>
       <tr>
         <td>账户:</td>
         <td><input type="text" name="name" value=""/></td>
       </tr>
       <tr>
         <td>密码:</td>
         <td><input type="password" name="password"/></td>
       </tr>
       <tr>
         <td>
           <input type="checkbox" name="IsUseCookie" value="checked"/>十天内免登录
         </td>
       </tr>
       <tr>
         <td><input type="submit" value="登录"/></td>
       </tr>
  </table>
</form>
</body>
</html>