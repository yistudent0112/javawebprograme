<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String Path = request.getContextPath();
	String BasePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ Path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录页面</title>
<script type="text/javascript" src="resources/js/jquery-1.4.2.js"></script>
</head>
<body>

	<!-- < form action="<%=BasePath%>/LoginServlet">-->
	<table>
		<tr>
			<td><span class="tip" style="color: red"></span></td>
		</tr>
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="username" value="请输入你的用户名"></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" name="password" value="密码的长度为6~12"></td>
		</tr>
		<tr>
			<!-- 				 <td><input type="submit" value="登录"></td> -->

			<td><input type="button" value="登录" id="login"></td>
		</tr>
	</table>
	<!-- </form> -->
</body>
<script type="text/javascript">
$("#login").click(function(){
	//单击登录按钮的时候触发ajax机制
	$.ajax({
		url:"<%=BasePath%>
	/LoginServlet",
			type : "post",
			data : {
				username : $("input[name=username]").val(),
				password : $("input[name=password]").val()
			},
			dataType : "json",
			success : function(result) {
				var flag = result.flag;
				if (flag) {
					//则跳转到登陆成功页面去
					window.location.href = "/ajax/success.jsp";
				} else {
					//则刷新页面，并给用户一个友好的提示
					$(".tip").text("您输入的用户名或者密码不正确");
				}
			}
		});
	});
</script>
</html>