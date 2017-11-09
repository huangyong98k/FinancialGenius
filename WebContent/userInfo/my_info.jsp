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
			<input type="hidden" name="user.userId" id="userID" value="${user.userId}"> <input
				type="hidden" name="user.userBanlance" id="userBanlanceHindden" value="${user.userBanlance}">
			<input type="hidden" name="user.userPassword" id="userPassword" value="${user.userPassword}">
			<input type="hidden" name="user.nickName"  value="${user.nickName}">
			<input type="hidden" name="user.userEmail" value="${user.userEmail}">
			<input type="hidden" name="user.userCard"  value="${user.userCard}">
			<input type="hidden" name="user.userStatus"  value="${user.userStatus}">
			<input type="hidden" name="user.headPortrait"  value="${user.headPortrait}">
			<input type="hidden" name="user.householdRegister"  value="${user.householdRegister}">
			<input type="hidden" name="user.payPassword"  value="${user.payPassword}">
			
			<span>用户名称：</span><input class="name" id="name" name="user.userName"
				type="text" minlength="6" maxlength="20" value="${user.userName}">
			<p id="userNameInfo" class="info"></p>
			<br> <span>电子邮箱：</span><input class="E-mail" id="E-mail"
				type="email" name="user.userEmail" disabled="disabled" value="${user.userEmail}"> <br>
			<span>电话号码：</span><input class="phoneNumber" id="phoneNumber"
				type="text" name="user.userPhone" minlength="11" maxlength="11" value="${user.userPhone}">
			<p id="phoneNumberInfo" class="info"></p>
			<br> <span>身份证号：</span><input class="IDCard" id="IDCard"
				type="text" name="user.userCard" minlength="18" maxlength="18"
				disabled="disabled" value="${user.userCard}"> <br> <span>账号状态：</span><input
				id="status" class="status" type="text" name="user.userStatus"
				disabled="disabled" value="${user.userStatus}">
			<hr class="hr">
			<br> <input type="submit" class="registerButton"
				id="registerButton" value="保存"> <input type="button"
				class="resetButton" id="resetButton" value="重置">
		</form>
	</div>
</body>
</html>