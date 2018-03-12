<%@page import="com.imooc.utils.FoodDaolmpl,java.util.*,com.imooc.domain.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<base href="">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品信息展示</title>
<style type="text/css">

</style>
</head>
<body>
<%
  Food temp=(Food)request.getSession().getAttribute("food");
 int index=temp.getPath().lastIndexOf("\\");
  String FileName=temp.getPath().substring(index+1);
  
  //String FileName=temp.getPath();
%>
	<center>
	
		<h1>菜品查询</h1>
		<table border="1px" cellspacing="0px" cellpadding="0px" width="800px">
			<thead>
				<tr>
					<th>菜品ID</th>
					<th>菜名</th>
					<th>口味</th>
					<th>菜品图片</th>
					<th>价格</th>
					<th>菜品描述</th>
				</tr>
			</thead>
			<tbody>
				<%if(temp!=null){ %>
				<tr>
					<td><%=temp.getFoodId() %></td>
					<td><%=temp.getFoodName() %></td>
					<td><%=temp.getFlavour() %></td>
					<td align="center"><img src="\FoodManager\upload\<%= FileName %>" /></td>
					<td><%=temp.getFoodPrice() %></td>
					<td><%=temp.getFoodContext() %></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</center>
</body>
</html>