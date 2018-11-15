<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加菜品</title>
<style type="text/css">

</style>
</head>
<body>
	<center>
		<h1>课程添加</h1>
		<form action="./FoodAddServlet" method="post" enctype="multipart/form-data">
			<table border="1px" width="400px" cellspacing="0px" cellpadding="0px">
				<tr>
					<td>课程名&nbsp;</td>
					<td><input type="text" name="CourseId"></td>
				</tr>
				<tr>
					<td>所属方向&nbsp;&nbsp;</td>
					<td><input type="text" name="CourseCategory"></td>
				</tr>
				<tr>
					<td>课程描述</td>
					<td>
						<textarea name="CourseDesc"></textarea>
					</td>
				</tr>
				<tr style="text-align:center;width:20px">
					<td colspan="2">
						<input type="submit" value="添加">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>