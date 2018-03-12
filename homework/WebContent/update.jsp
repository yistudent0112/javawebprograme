<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公告板更新页面</title>
</head>
<%
request.setCharacterEncoding("utf-8");//状态码可以选择200-203
%>
<body>
<h2 align="center">公告板更新页面</h2>
<form action="update_control.jsp">
  <table align="center"width="500px"border="1">
    <tr>
      <td>
        公告序号：
      </td>
      <td>
       <input type="text" name="number"value="<%=request.getParameter("number") %>"/>
      </td>
    </tr>
    <tr>
      <td>
        公告概述：
      </td>
      <td>
       <input type="text" name="name"value="<%=request.getParameter("name") %>"/>
      </td>
    </tr>
    <tr>
      <td>
        公告内容：
      </td>
      <td>
       <input type="text" name="context"value="<%=request.getParameter("context") %>"/>
      </td>
    </tr>
    <tr>
      <td>
      <input type="submit" value="修改"/>
      </td>
    </tr>
  </table>
</form>
<input type="button" name="submit" value="返回" onclick="javascript:history.go(-1)"/>
</body>
</html>