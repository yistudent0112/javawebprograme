<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jstl中if标签与choose标签的使用</title>
</head>
<body>
  <c:set var="user" value="zhangsan" scope="request"></c:set>
  <c:set var="age" value="18" scope="request"></c:set>
  <!-- if标签的使用 -->
  <c:if test="${age==18 }">

   <c:out value="user">  test</c:out>
   是成年人
  </c:if>
  <c:choose>
    <c:when test="${age==18 }">true</c:when>
    <c:otherwise>false</c:otherwise>
  </c:choose>
</body>
</html>