<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 String fail=request.getParameter("fail");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录页面</title>
 <script type="text/javascript">
  var flag='<%=fail%>'
  if(flag=='1'){
	  alert("您还没有登录用户")
  }
  if(flag=='-1'){
	  alert("您输入的密码错误")
  }
</script>
</head>
<body>
  <form action="login.jsp" method="post">
    <table>
       <tr>
         <td>用户名</td>
         <td><input type="text" name="username"></td>
       </tr>
       <tr>
         <td>密码:</td>
         <td><input type="password" name="password" /></td>
        </tr>
        <tr>
         <td>
             <input type="submit" value="提交" />
         </td>
       </tr>
    </table>    
  </form>
  <%
 /*  if(fail.equals("1")){
	  fail="";
  } */
  %>
</body>
</html>