<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/all.css"/>
		<link rel="stylesheet" type="text/css" href="css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="css/main.css"/>
		<script type="text/javascript">
		function bodyInit(){
			if('${excel.message}'){
				alert('${excel.message}');
			}
		}
		</script>
	</head>
	<body style="background: #e1e9eb;" onload="bodyInit()">
		<form action="" id="mainForm" method="post">
			<div class="right">
				<div class="current">
					当前位置：<a href="#">导入/导出</a> &gt; 导入结果
				</div>
				<div class="rightCont">
					<p class="g_title fix">导入结果展示</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td align="right" width="80">标题：</td>
								<td>${excel.title }</td>
							</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
									<th>序号</th>
									<th>姓名</th>
									<th>年龄</th>
									<th>出生日期</th>
								</tr>
								<c:forEach items="${excel.list }" var="item" varStatus="s">
								<tr>
								  <th>${s.count }</th>
									<th>${item.name }</th>
									<th>${item.age }</th>
									<th>${item.time })</th>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>