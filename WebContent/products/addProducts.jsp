<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购买产品</title>
<link href="./css/demo.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/products.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var number = $("#number").val();
				var principal = $("#principal").val();
				var userBalance = $("#userBalance").val();
				var password = $("#password").val().trim();

				$("#submit").click(
						function() {
							var number = $("#number").val();
							var beginDate = $("#beginTime").val();
							var overDate = $("#overTime").val();
							var beginDate = $("#beginDate").val();
							var overDate = $("#overDate").val();
							var payPassword = $("#payPassword").val().trim();
							var patternPassword = /^\d{6}$/;
							if ((number == "" || number == undefined
									|| number == null || number <= 0)) {
								alert("数量有误！");
								return false;
							} else if ((beginDate == "" || undefined || null)) {
								alert("请选择日期！");
								return false;
							} else if ((overDate == "" || undefined || null)) {
								alert("请选择日期！");
								return false;
							} else if (overDate < beginDate) {
								alert("到期日期选择有误！")
								return false
							} else if (principal * number > userBalance) {
								alert("你的余额不足！")
								return false;
							} else if (payPassword == "" || undefined || null) {
								alert("请输入您的支付密码！")
								return false
							} else if (!patternPassword.test(payPassword)) {
								alert("请输入合法的支付密码！")
								return false
							} else if (password != payPassword) {
								alert("密码错误，请重新输入！")
								return false
							}

						});

				$("#payPassword").change(function() {
					var c = $(this);
					var payPassword = $("#payPassword").val().trim();
					var patternPassword = /^\d{6}$/;
					if (/[^\d]/.test(c.val())) {//替换非数字字符
						var temp_amount = c.val().replace(/[^\d]/g, '');
						$(this).val(temp_amount);
					} else if (payPassword == "" || undefined || null) {
						alert("请输入您的支付密码！");
						return false
					} else if (!patternPassword.test(payPassword)) {
						alert("请输入合法的支付密码！")
						return false
					} else if (password != payPassword) {
						alert("密码错误，请重新输入！")
						return false
					}
				})

				$("#number").keyup(function() {
					var c = $(this);
					if (/[^\d]/.test(c.val())) {//替换非数字字符
						var temp_amount = c.val().replace(/[^\d]/g, '');
						$(this).val(temp_amount);
					}
				});

				$("#number").change(function() {
					if ((principal * number) > userBalance) {
						alert("你的余额不足！")
						return false;
					}
				});
			});
</script>
</head>
<body>
	<section id="getintouch" class="fadeIn animated">
		<div class="container" style="border-bottom: 0;">
			<h1>
				<span>购买产品</span>
			</h1>
		</div>
		<div class="container">
			<form class="contact"
				action="investmentAction!add?productId=${product.productId }"
				method="post" id="form">
				<div class="row clearfix">
					<input type="hidden" id="userId" name="userId" value="${userId }">
					<input type="hidden" id="status" name="investment.investmentStatus"
						readonly value="0"> <input type="hidden" id="spend"
						name="spend"> <input type="hidden" id="userBalance"
						name="userBalance" value="${userBanlance }"> <input
						type="hidden" id="password" name="password"
						value="${payPassword }">
					<div class="lbl">
						<label for="name"> 产品名称</label>
					</div>
					<div class="ctrl">
						<input type="text" id="name" name="name" readonly
							value="${product.productName }">
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="rate"> 利率</label>
					</div>
					<div class="ctrl">
						<input type="text" id="rate" name="rate"
							value="${product.productRate }" readonly>
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="principal"> 起购金额</label>
					</div>
					<div class="ctrl">
						<input type="text" name="investment.principal" id="principal"
							value="${product.productMoney }" readonly>
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="number"> 购买份数</label>
					</div>
					<div class="ctrl">
						<input type="text" name="investment.number" id="number"
							placeholder="请输入你要购买的份数" maxlength="4" onchange="earn()">
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="earning"> 预计收益</label>
					</div>
					<div class="ctrl">
						<input type="text" name="investment.earning" id="earning" readonly>
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="beginTime"> 起购日期</label>
					</div>
					<div class="ctrl">
						<input type="date" id="beginTime" name="investment.beginTime"
							onchange="earn()">
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="overTime"> 结算日期</label>
					</div>
					<div class="ctrl">
						<input type="date" id="overTime" name="investment.overTime"
							onchange="earn()">
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="payPassword"> 支付密码：</label>
					</div>
					<div class="ctrl">
						<input type="password" id="payPassword" name="payPassword"
							maxlength="6" placeholder="请输入您的支付密码！" style="width: 100% ;height: 30px;border-radius: 4px">
					</div>
				</div>
				<div class="row  clearfix">
					<div class="span10 offset2">
						<input style="width: 100%" type="submit" name="submit" id="submit"
							class="submit" value="购买"> <input style="width: 100%"
							type="reset" name="reset" id="reset" class="submit" value="重置">
						<input style="width: 100%" type="button" name="back" id="back"
							class="submit" value="返回"
							onclick="location.href='javascript:history.go(-1);'">
					</div>
				</div>
			</form>
		</div>
	</section>
</body>
</html>
