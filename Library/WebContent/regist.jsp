
<%@page import="com.imooc.utils.UserList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
 String basePath=request.getContextPath();
String fail=request.getParameter("flag");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册界面</title>
 <script type="text/javascript">
  var flag='<%=fail%>'
  if(flag=='1'){
	  alert("亲，你提交的数据没满足格式。")
  }

</script>
</head>
<body>
	<center>
		<h1>用户注册</h1>
		<form action="<%=basePath%>/RegistServlet" method="post">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" placeholder="用户名为3-12位字母数字或下划线组合" 
					pattern="[a-zA-Z0-9_]{3,12}" required="required"></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password" placeholder="密码长度为6-12位的纯数字"  
					id="password" pattern="[0-9]{6,12}" required="required"></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="checkPWD" placeholder="密码长度为6-12位的纯数字"
						 pattern="[0-9]{6,12}" required="required" ></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" name="phone" placeholder="请输入正确的手机号码格式" 
					pattern="1[3578]\d{9}" reuired="required"></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input type="text" name="email" placeholder="请输入正确邮箱格式" ></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="注册">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
	
</body>
</html>