<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp"
    pageEncoding="UTF-8" import="homework.*,java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告板主页面</title>
</head>
<body>
<%
String name=request.getParameter("name");
String password=request.getParameter("password");
User u=new User(password,name);

if(Database.SelectUserByPassword(u)){	
%>
<h3 align="center">公告板主界面</h3>
<br>
<form action="search.jsp">
<table align="center"border="1"width="500px">
  <tr>
    <td>
        查找序号：
    </td>
    <td>
    <input type="text" name="number"/>
    </td>
    <td>
    <input type="submit" value="查找"/>
    </td>
  </tr>
</table>
</form>
<form action="add.jsp">
<table align="center"border="1"width="500px">
  <tr>
    <td>
        增加公告
    </td>
    <td>
    <input type="submit" value="增加"/>
    </td>
  </tr>
</table>
</form>
<br>
<table align="center"border="1" width="500px">
   <tr>
     <td>
     公告序号
     </td> 
     <td>
     公告概述
     </td>
     <td>
     公告内容
     </td>
     <td>
     更改
     </td>
     <td>
     删除
     </td>
   </tr>
<%
for(String number:Database.board.keySet()){
	Board temp=Database.board.get(number);

%>
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
     <td>
    <a href="update.jsp?number=<%=temp.getNumber()%>&name=<%=temp.getName()%>&
context=<%=temp.getContext()%>">修改</a>
     </td>
     <td>
    <a href="delete.jsp?number=<%=temp.getNumber() %>">删除</a>
     </td>
   </tr>
<%} %>
</table>

<%}else{
throw new Exception("password is wrong.");	
}
%>

</body>
</html>