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
		<h1>菜品添加</h1>
		<form action="./FoodAddServlet" method="post" enctype="multipart/form-data">
			<table border="1px" width="400px" cellspacing="0px" cellpadding="0px">
				<tr>
					<td>菜品&nbsp;ID</td>
					<td><input type="text" name="FoodId"></td>
				</tr>
				<tr>
					<td>菜&nbsp;&nbsp;名</td>
					<td><input type="text" name="FoodName"></td>
				</tr>
				<tr>
					<td>口&nbsp;&nbsp;味</td>
					<td>
						<input type="radio" name="Flavour" value="香辣">香辣
						<input type="radio" name="Flavour" value="微辣">微辣
						<input type="radio" name="Flavour" value="麻辣">麻辣
						<input type="radio" name="Flavour" value="不辣">不辣
					</td>
				</tr>
				<tr>
					<td>菜品图片</td>
					<td><input type="file" name="path"></td>
				</tr>
				<tr>
					<td>价&nbsp;&nbsp;格</td>
					<td><input type="text" name="FoodPrice"></td>
				</tr>
				<tr>
					<td>菜品描述</td>
					<td>
						<textarea name="FoodContext"></textarea>
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