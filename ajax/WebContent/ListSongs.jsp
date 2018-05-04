<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String Path = request.getContextPath();
	String BasePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ Path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=BasePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用js调用ajax</title>
</head>
<body style="text-algin: center">
	<input type="button" value="流行歌曲" flag="1" onclick="show1()">
	<input type="button" value="经典歌曲" flag="2" onclick="show2()">
	<input type="button" value="摇滚歌曲" flag="3" onclick="show3()">
	<input type="button" value="test" onclick="show()">
	<div style="width: 300px; height: 400px" id="div1"></div>
</body>
<script type="text/javascript">
	function show() {

		this.location.href = "success.jsp";
	}
	function show1() {
		//1、创建一个 xmlhttpRequest对象
		var xmlhttp = new XMLHttpRequest();
		//2、规定请求的类型、URL 以及是否异步处理请求。
		xmlhttp.open("GET", "/ajax/ListSong?flag=1", true);
		//3、将请求发送到服务器。
		xmlhttp.send();
		//4、接收服务器端的响应(readyState=4表示请求已完成且响应已就绪    status=200表示请求响应一切正常)
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//responseText：表示的是服务器返回给ajax的数据
				document.getElementById("div1").innerHTML = xmlhttp.responseText;
				//alert(xmlhttp.responseText);
			}
		}
	}
	function show2() {
		//1、创建一个 xmlhttpRequest对象
		var xmlhttp = new XMLHttpRequest();
		//2、规定请求的类型、URL 以及是否异步处理请求。
		xmlhttp.open("GET", "/ajax/ListSong?flag=2", true);
		//3、将请求发送到服务器。
		xmlhttp.send();
		//4、接收服务器端的响应(readyState=4表示请求已完成且响应已就绪    status=200表示请求响应一切正常)
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//responseText：表示的是服务器返回给ajax的数据
				document.getElementById("div1").innerHTML = xmlhttp.responseText;
				//alert(xmlhttp.responseText);
			}
		}
	}
	function show3() {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("GET", "/ajax/ListSong?flag=3", true);
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("div1").innerHTML = xmlhttp.responseText;
			}
		}
	}
</script>
</html>