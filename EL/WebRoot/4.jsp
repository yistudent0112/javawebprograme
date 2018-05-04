<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>通过jstl+el模式来迭代List集合</title>
</head>
<body>
 <table align="center" border="1px">
 <tr>
   <th>产品名字</th>
   <th>产地</th>
   <th>价格</th>
 </tr>
  <c:forEach items="${list }" var="Map" >
  <tr>
  <td>${Map.BrandName }</td>
  <td>${Map.location }</td>
  <td>${Map.price }</td>
  </tr>
  </c:forEach>
 </table>
</body>
</html>