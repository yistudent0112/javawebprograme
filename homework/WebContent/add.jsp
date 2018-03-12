<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公告板增加页面</title>
</head>
<body>
<h3 align="center">公告板增加页面</h3>
<form action="add_control.jsp">
  <table align="center"border="1"width="500px">
    <tr>
      <td>
      公告序号：
      </td>
      <td>
      公告概要：
      </td>
      <td>
      公告内容：
      </td>
    </tr>
    <tr>
      <td>
      <input type="text" name="number"/>
      </td>
      <td>
      <input type="text" name="name"/>
      </td>
      <td>
      <input type="text" name="context"/>
      </td>
    </tr>
    <tr>
      <td>
     <input type="submit" value="增加"/>
      </td>
      <td>
      <input type="button" name="submit" value="返回" onclick="javascript:history.go(-1)"/>
      </td>
    </tr>
  </table>
   
</form>
</body>
</html>