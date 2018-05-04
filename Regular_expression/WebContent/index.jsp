<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String jspflag=request.getParameter("flag");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册页面</title>
<script type="text/javascript">
  var flag='<%=jspflag%>'
  if(flag=='0'){
	  alert("您还没有登录")
  }
</script>
</head>
<body>
  <form action="/Regular_expression/RegistServlet" method="get">
     <table>
       <tr>
         <td>用户名<input type="text" name="username" pattern="[a-zA-Z]{6,12}" 
         required="required" value="请输入长度为6至12位的英文字母"/></td>
       </tr>
       <tr>
         <td>密&nbsp;码<input type="password" name="password" pattern="[0-9]{6,}" 
         required="required" value="请输入长度至少为6位的数字"/></td>
       </tr>
       <tr>
         <td>手&nbsp;机<input type="text" name="phone" pattern="1[3578]\d{9}" 
         required="required" value="请输入手机号"/></td>
       </tr>
       <tr>
         <td>邮&nbsp;箱<input type="email" name="email"  
         required="required" value="请输入邮箱"/></td>
       </tr>
       <tr>
         <input type="submit" value="提交"/>
       </tr>
       <tr>
         <input type="reset" value="重置"/>
       </tr>
     </table>
  </form>
</body>
</html>