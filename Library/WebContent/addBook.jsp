<%@page import="com.imooc.utils.BookCatgoryList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
 String basePath=request.getContextPath();
    String []Catgorys=(String [])this.getServletContext().getAttribute("Catgorys");
    //设计完了catgory的抽象类，需要在其中增加一个返回所有分类选项的函数，用于在书本添加的按钮中显示
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书添加</title>
</head>
<body>
	<center>
		<h1>图书添加</h1>
		<form action="<%=basePath%>/AddBookServlet" method="post">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>图书ID</td>
					<td><input type="text" name="id" placeholder="请输入数字" 
					pattern="\d+" required="required"></td>
				</tr>
				<tr>
					<td>图书名</td>
					<td><input type="text" name="bookName"></td>
				</tr>
				<tr>
					<td>图书分类</td>
					<td>
						<select name="catgoryName">
							<% 
							if(Catgorys!=null){
							for(String name:Catgorys){
							%>
								<option value="<%=name%>"><%=name%></option>
					        <% 
							}
							}
						    %>
						</select>
					</td>
				</tr>
				<tr>
					<td>价格</td>
					<td><input type="text" name="price" placeholder="请输入价格" ></td>
				</tr>
				<tr>
					<td>描述</td>
					<td><input type="text" name="description" placeholder="请输入描述信息"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="添加">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>