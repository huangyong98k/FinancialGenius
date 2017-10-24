<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
<link rel="stylesheet" type="text/css" href="css/css.css">
<script type="text/javascript"
	src="https://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="imgs/coin02.png" /><span>首页&nbsp;-&nbsp;用户管理&nbsp;-</span>&nbsp;
				删除用户信息
			</div>
		</div>
		<div class="page ">
			<!--  删除用户页面样式 -->
			<!--  用户 表格 显示 -->
			<div class="conShow">
				<table border="1" cellspacing="0" cellpadding="0">
					<tr>
						<td width="435px" class="tdColor">用户名</td>
						<td width="400px" class="tdColor">身份证号码</td>
						<td width="630px" class="tdColor">邮箱</td>
						<td width="435px" class="tdColor">性别</td>
						<td width="435px" class="tdColor">电话</td>
						<td width="230px" class="tdColor">操作</td>
					</tr>
					<tr height="40px">
						<td>小咸鱼</td>
						<td>123456789123456789</td>
						<td>huangyong.nsu@qq.com</td>
						<td>男</td>
						<td>13404075637</td>
						<td><a href="modifyUser.html"><img class="operation"
								src="imgs/update.png"></a> <img class="operation delban"
							src="imgs/delete.png"></td>
					</tr>
				</table>
				<div class="paging">此处是分页</div>
			</div>
			<!--  用户 表格 显示 end-->

			<!--  删除用户页面样式end -->
		</div>
	</div>
</body>
</html>