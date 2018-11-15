<%@page import="com.imooc.util.ConnectionUtil,java.util.*,com.imooc.util.Course"%>
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
  List<Course>courses=(List<Course>)request.getSession().getAttribute("courses");
 // Course temp=(Course)request.getSession().getAttribute("food");
 

%>
<center>	
		<h1>课程查询</h1>
		<table border="1px" cellspacing="0px" cellpadding="0px" width="800px">
			<thead>
				<tr>
					<th>课程名</th>
					<th>所属方向</th>
					<th>课程描述</th>
				</tr>
			</thead>
			<tbody>
			<%if(courses!=null){
				for(Course temp:courses){%>
		
				
				<tr>
					<td><%=temp.getCourseId() %></td>
					<td><%=temp.getCourseCategory() %></td>
					<td><%=temp.getCourseDesp() %></td>
				</tr>
				<%
					}
			}
				%>
			</tbody>
		</table>
	</center>
</body>
</html>