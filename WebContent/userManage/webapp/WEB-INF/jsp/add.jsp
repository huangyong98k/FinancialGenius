<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	请输入添加信息：
	<br>
	<form action="userAction!addUser" method="get">
		年龄：<input type="text" name="userModel.age"><br> 姓名：<input
			type="text" name="userModel.name"><br>
		<input type="submit" value="保存">
	</form>	
	        <button onclick="javascript:history.go(-1)">返回</button>			
</body>
</html>