<%@ page language="java" contentType="text/html; charset=utf-8" errorPage="error.jsp"
    pageEncoding="utf-8" import="homework.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公告板查找页面</title>
</head>
<body>
<h3 align="center">公告板查找页面</h3>
<%
String number=request.getParameter("number");

if(Database.SearchBoard(number)){
	Board  temp=Database.board.get(number);
%>
<table align="center"border="1"width="500px">
  <tr>
    <td>
      公告序号：
    </td>
    <td>
        公告概述：
    </td>
    <td>
        公告内容：
    </td>
  </tr>
  <tr>
    <td>
    <%=temp.getNumber() %>
    </td>
    <td>
     <%=temp.getName() %>
    </td>
    <td>
      <%=temp.getContext() %>
    </td>
  </tr>
</table>
<input type="button" name="submit" value="返回" onclick="javascript:history.go(-1)"/>
<%}else{ 
throw new Exception("search is not succced.");
}
%>


</body>
</html>