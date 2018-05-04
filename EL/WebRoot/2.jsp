<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jstl常用标签</title>
</head>
<body>
<!-- set.out.remove标签 -->
<!-- set标签主要是往指定的域中存放数据 -->
  <c:set var="username" value="zhangsan" scope="request"/>
<!-- out标签负责将数据输出 -->
  <c:out value="${username}"/><tr>
  <!-- remove标签负责将数据删除 -->
  <c:remove var="username" scope="request"/>
  <c:out value="${username }"></c:out>
</body>
</html>