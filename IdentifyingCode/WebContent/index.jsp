<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
 <%@page import="java.util.Date"%>   

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<img alt="" src="code.jsp" id="code">
<a  href="javascript:void(0);" onclick="changeCode()">看不清，换一张</a>
<script >
function changeCode() {
	//alert("test");
    //alert(new Date());
	document.getElementById("code").src="code.jsp?d="+new Date;
}
</script>
</body>
</html>