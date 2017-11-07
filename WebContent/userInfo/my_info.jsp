<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>基本信息</title>
<!-- 引入 jQuery 库 -->
<script src="<%=request.getContextPath() %>/userInfo/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<!-- 引入自定义公用 js 库 -->
<script src="<%=request.getContextPath() %>/userInfo/js/crowdfunding.js"></script>
<link href="<%=request.getContextPath() %>/userInfo/css/crowdfunding.css" rel="stylesheet">
<style>
</style>
</head>
<body>
	<div id="user-register" class="user-register">
		<form class="uesrMessage" id="userMessage"
			action="userAction!modifyUserMessage.action" method="post">
			<input type="hidden" name="user.userId" id="userID"> <input
				type="hidden" name="user.userBanlance" id="userBanlanceHindden">
			<input type="hidden" name="user.userPassword" id="userPassword">
			<span>用户名称：</span><input class="name" id="name" name="user.userName"
				type="text" minlength="6" maxlength="20" value="${user.userName}">
			<p id="userNameInfo" class="info"></p>
			<br> <span>电子邮箱：</span><input class="E-mail" id="E-mail"
				type="email" name="user.userEmail" readonly="true " value="${user.userEmail}"> <br>
			<span>电话号码：</span><input class="phoneNumber" id="phoneNumber"
				type="text" name="user.userPhone" minlength="11" maxlength="11" value="${user.userPhone}">
			<p id="phoneNumberInfo" class="info"></p>
			<br> <span>身份证号：</span><input class="IDCard" id="IDCard"
				type="text" name="user.userCard" minlength="18" maxlength="18"
				readonly="true " value="${user.userCard}"> <br> <span>账号状态：</span><input
				id="status" class="status" type="text" name="user.userStatus"
				readonly="true " value="${user.userStatus}">
			<hr class="hr">
			<br> <input type="submit" class="registerButton"
				id="registerButton" value="保存"> <input type="button"
				class="resetButton" id="resetButton" value="重置">
		</form>
	</div>
</body>
</html>