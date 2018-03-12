<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公告板登录页面</title>
</head>
<body>
<h3 align="center">公告板系统登录页面</h3>
<br>
<form action="control.jsp">
  <table align="center">
    <tr>
      <td>
         账号：
      </td>
      <td>
      <input type="text" value="请输入你的账户" name="name"/>
      </td>
    <tr>
      <td>
         密码：
      </td>
      <td>
      <input type="password" name="password"/>
      </td>
    </tr>
    <tr>
      <td>
      <input type="submit" value="登录" />
      </td>
    </tr>
  </table>
</form>
</body>
</html>