<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>修改密码</title>
<link href="" rel="stylesheet" type="text/css">
<!-- 引入 jQuery 库 -->
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/crowdfunding.js"></script>
<link href="css/crowdfunding.css" rel="stylesheet">
<!-- 引入自定义公用 js 库 -->
</head>
<body>
	<div id="main">
		<div id="userPassword">
			<div id="changePasswordHeard">
				<input type="button" id="modifyByEmail"
					class="menuButton modifyChecked" value="通过邮箱更改"> <input
					type="button" id="modifyByOlderPassword" class="menuButton"
					value="通过原密码修改">
			</div>
			<div id="changePasswordMain1">
				<input type="password" class="form-control" id="email"
					name="user.userEmail" placeholder="Your email"> <input
					type="password" class="form-control" id="newPassword"
					name="user.userPassword" placeholder="Your newpassword"> <input
					type="password" class="form-control" id="emailCode"
					name="user.userEmailCode" placeholder="Your emailcode"> <input
					type="submit" value="Submit" class="btn-submit" id="submintByEmail">
			</div>
			<div id="changePasswordMain2">
			<input type="hidden" name="user.userId" id="userIDM" value="${userId}">
				<input type="password" class="form-control" id="oldPassword"
					name="user.userPassword" placeholder="Your old password"> 
				<input
					type="password" class="form-control" id="Password"
					name="oldPassword" placeholder="Your new password"> 
				<input type="password" class="form-control" id="Password2"
					name="newPassword" placeholder="Your new password again">
				<input type="submit" value="Submit" class="btn-submit"
					id="submintByPassword">
			</div>
			<div id="modifyMessage"></div>
		</div>
	</div>
</body>
</html>