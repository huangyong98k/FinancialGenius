<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">

<meta name="description" content="个人信息" />
<!-- 网站简介 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>个人中心</title>

<!-- CSS公共部分 开始 -->
<link href="<%=request.getContextPath() %>/userInfo/css/bootstrap.min.css" rel="stylesheet">
<!-- CSS公共部分 结束 -->
<link href="<%=request.getContextPath() %>/userInfo/css/crowdfunding.css" rel="stylesheet">

</head>
<body>
	<!-- 核心 开始 -->
	<div class="container ">
		<div id="vertical_navigation"
			class="col-lg-3 background831312 nopadding">
			<div class="dead_pic">
			<input type="hidden" id="userHeadPortrait" value="<%=request.getContextPath() %>/userInfo/img/investor_page/${headPortrait}">
				<img id="mysnap" src="<%=request.getContextPath() %>/userInfo/img/investor_page/${headPortrait}"
					onClick="listClick(5)" title="点击更换头像"><br> <span
					class="username">用户名:${userName}</span>
			</div>
			<span id="userName"></span>
			<div class="usertype">
				用户类型： 普通用户<br> 账户余额： <span id="userBanlance">${userBanlance}</span>
			</div>
			<div class="menu">
				<div class="menu_title">我的信息</div>
				<div class="menu_list">
					<ul class="list-unstyled">
						<li id="listClick1" class="menu_list_on" onClick="listClick(1)"><img
							src="img/member_center/left_icon_1.png"> 基本信息</li>
						<li id="listClick2" class="" onClick="listClick(2)"><img
							src="img/member_center/left_icon_3.png"> 修改密码</li>
					</ul>
				</div>
			</div>
			<div class="menu">
				<div class="menu_title">我的资金管理</div>
				<div class="menu_list">
					<ul class="list-unstyled">
						<li id="listClick3" class="" onClick="listClick(3)"><img
							src="img/member_center/left_icon_9.png"> 绑定银行卡</li>
						<li id="listClick4" class="" onClick="listClick(4)"><img
							src="img/member_center/left_icon_8.png"> 充值</li>
						<li id="listClick6" class="" onClick="listClick(6)"><img
							src="img/member_center/left_icon_8.png"> 提现</li>
						<li id="listClick7" class="" onClick="listClick(7)"><img
							src="img/member_center/left_icon_9.png"> 交易账单</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-lg-9">
			<iframe name="left" id="crowdfunding_iframe" src="personalAction!getUserInfo"
				frameborder="false" scrolling="no" style="border: none;"
				width="100%" height="600" allowtransparency="true"></iframe>
		</div>
	</div>
	<!-- 核心 结束 -->

	<!-- 结束 -->
	<!-- JS公共部分 开始 -->
	<script src="<%=request.getContextPath() %>/userInfo/js/jquery-3.2.1.min.js"></script>
	<script src="<%=request.getContextPath() %>/userInfo/js/bootstrap.min.js"></script>
	<!-- JS公共部分 结束 -->
	<script src="<%=request.getContextPath() %>/userInfo/js/crowdfunding.js"></script>
</body>
</html>