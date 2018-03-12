<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录页面</title>
</head>
<body>
<form action="response.jsp" method="post">
  <table>
    <tr>
      <td>账户:</td>
      <td><input type="text" name="username"/></td>
    </tr>
    <tr>
      <td>爱好:</td>
      <td>
      <input type="checkbox" name="favourite" value="read"/>读书
      <input type="checkbox" name="favourite" value="music"/>音乐
      <input type="checkbox" name="favourite" value="exercise"/>锻炼
      <input type="checkbox" name="favourite" value="play"/>玩耍
      </td>
    </tr>
    <tr> 
      <td><input type="submit" value="登录"/></td>
    </tr>
  </table>
</form>
<a href="request.jsp?username=顾毅">url传递参数</a>
</body>
</html>