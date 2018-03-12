<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello world!</h1>
<form action="logcontrol.jsp?mypass=999999"method="post">
  <table>
       <tr>
         <td>账户:</td>
         <td><input type="text" name="name"/></td>
       </tr>
       <tr>
         <td>密码:</td>
         <td><input type="password" name="password"/></td>
       </tr>
       <tr>
         <td><input type="submit" value="登录"/></td>
       </tr>
  </table>
</form>
<a href="out.jsp?username=lisi">跳转</a>
</body>
</html>