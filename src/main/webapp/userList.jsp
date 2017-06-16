<%@page pageEncoding="utf-8" import="java.util.*,entity.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
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
	<center>
		<a href="resource/excel/用户信息模板.xls">用户信息模板下载</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
			href="exportExcel">导出用户信息</a>
	</center>

	<div style="margin-left: 40px;">
		<table border="1" width="80%" cellspacing="0"  style="vertical-align:middle; text-align:center;">
			<thead>用户信息列表
			</thead>
			<tr >
				<th  style="vertical-align:middle; text-align:center;">id</th>
				<th  style="vertical-align:middle; text-align:center;">姓名</th>
				<th  style="vertical-align:middle; text-align:center;">身份证号</th>
				<th  style="vertical-align:middle; text-align:center;">性别</th>
				<th  style="vertical-align:middle; text-align:center;">出生年月</th>
				<th  style="vertical-align:middle; text-align:center;">民族</th>
				<th  style="vertical-align:middle; text-align:center;">学历</th>
				<th  style="vertical-align:middle; text-align:center;">职务</th>
				<th  style="vertical-align:middle; text-align:center;">职称</th>
				<th  style="vertical-align:middle; text-align:center;">备注</th>
				<th  style="vertical-align:middle; text-align:center;">操作</th>
			</tr>

			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.idCode }</td>
					<td>${user.sex }</td>
					<td>${user.brithday }</td>
					<td>${user.national }</td>
					<td>${user.education }</td>
					<td>${user.position }</td>
					<td>${user.title }</td>
					<td>${user.note }</td>
					<td><a href="userInfo?userId=${user.id }">查看</a> - <a
						href="userPreUpdate?userId=${user.id }">修改</a> - <a
						href="userDel?userId=${user.id }" onclick="return del()">删除</a></td>

				</tr>

			</c:forEach>

		</table>
	</div>
	<br>
	<div>
		<center style="color: red">${result.msg}</center>
	</div>
	<br>
	<div style="margin-left: 40px;">
		<form action="importExcel" enctype="multipart/form-data" method="post">
			选择文件： <input type="file" name="excelfilename"><br> <input
				type="submit" value="数据入库" />
		</form>
	</div>

	<div>
		<center><a href="index.jsp">首页</a> -
		 <a href="userList">刷新</a></center>
	</div>

	<script>

function del(){
	 var msg = "您真的确定要删除吗？\n\n请确认！"; 
	 if (confirm(msg)==true){ 
	  return true; 
	 }else{ 
	  return false; 
	 } 
}
</script>
</body>