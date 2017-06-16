<%@page pageEncoding="utf-8" import="java.util.*,entity.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户详情</title>
<!-- Bootstrap -->
<link href="resource/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet">
<script src="resource/jquery-2.1.1.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resource/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

</head>
<body>

	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">员工信息录入系统</a>
			</div>
			<div></div>
		</div>
	</nav>
	<div style="margin-left: 40px;">

		<form action="userUpdate" method="post">
			<table border="1" width="80%" cellspacing="0"
				style="vertical-align: middle; text-align: center;">
				<thead>用户详细信息
				</thead>
				<tr>
					<th style="vertical-align: middle; text-align: center;">项目</th>
					<th style="vertical-align: middle; text-align: center;">信息</th>

				</tr>
				<input type="hidden"   name="id" value="${user.id}">
				<tr>
					<td>姓名</td>
					<td><input name="name" value="${user.name}"></td>
				</tr>
				<tr>
					<td>身份证号</td>
					<td><input name="idCode" value="${user.idCode}"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>${user.sex}</td>
				</tr>
				<tr>
					<td>出生年月</td>
					<td>${user.brithday}</td>
				</tr>
				<tr>
					<td>民族</td>
					<td><input name="national" value="${user.national}"></td>
				</tr>
				<tr>
					<td>学历</td>
					<td><input name="education" value="${user.education}"></td>
				</tr>
				<tr>
					<td>职务</td>
					<td><input name="position" value="${user.position}"></td>
				</tr>
				<tr>
					<td>职称</td>
					<td><input name="title" value="${user.title}"></td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input name="note" value="${user.note}"></td>
				</tr>

			</table>
<br>
			<input type="submit" value="修改" />
		</form>

		 <br> <a href="userList">返回</a>
	</div>



</body>