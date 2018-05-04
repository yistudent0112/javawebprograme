<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.imooc.utils.BookList"%>
<%@page import="com.imooc.domain.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 String basePath=request.getContextPath();
BookList booklist=(BookList)this.getServletContext().getAttribute("BookList");
List<Book>list=booklist.GetBooks();
if(request.getAttribute("list")==null){
	System.out.println("wrong");
	request.setAttribute("list", list);
}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书查询</title>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery-1.4.2.js"></script>
</head>
<body>
	<center>
		<h1>图书查询</h1>
		<form action="<%=basePath%>/FindBookServlet" method="post">
		<table>
		<p>
			图书ID：<input type="text" name="bookID">
			图书名：<input type="text" name="bookName">
			分类：<input type="text" name="catgoryName">
			<input type="submit" value="查询" id="search">
		</p>
		</table>
		</form>
		<hr>
		<table width="800px" cellspacing="0px" cellpadding="0px" border="1px">
			<thead>
				<tr>
					<th>图书ID</th>
					<th>书名</th>
					<th>分类</th>
					<th>价格</th>
					<th>描述</th>
				</tr>
			</thead>
			<tbody id="cont">
 		    <%
				if(list!=null){
					for(Book book:list){
				
				%>
					<tr>
						<td><%=book.getId() %></td>
						<td><%=book.getBookName() %></td>
						<td><%=book.getCatgoryName() %></td>
						<td><%=book.getPrice() %></td>
						<td><%=book.getDescription() %></td>
					</tr>
				<%
					}
				}
				%> 
				<%
			
				%>
<%-- 				<%=list %>
				<c:forEach items="${list }" var="Book" >
					<tr>
						<td>${Book.Id }</td>
						<td>${Book.BookName}</td>
						<td>${Book.CatgoryName }</td>
						<td>${Book.Price }</td>
						<td>${Book.Description }</td>
					</tr>
			   </c:forEach>  --%>
			</tbody>
		</table>
	</center>
	
</body>
</html>