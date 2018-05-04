<%@page import="com.imooc.utils.UserList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
 String basePath=request.getContextPath();
 String Username=(String)session.getAttribute("Username");
 if(Username==null){
	 Username="";
 }
 String fail=request.getParameter("wrong");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理登录界面</title>
</head>
 <script type="text/javascript">
  var flag='<%=fail%>'
  if(flag=='1'){
	  alert("亲，你的密码错误")
  }
  else if(flag=='2'){
	  alert("亲，你还没有登录")
  }

</script>
<body>
	<center>
		<h1>登录 | <a href="<%=basePath%>/regist.jsp">注册</a></h1>
		<form action="<%=basePath%>/LoginServlet" method="post">
			<table width="350px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" value="<%=Username%>"
					 placeholder="用户名为3-12位字母数字或下划线组合"></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password" placeholder="长度为6-12位的纯数字" ></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="登录">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>