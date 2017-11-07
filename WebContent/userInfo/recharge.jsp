<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值</title>
<link href="./css/demo.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var password = $("#password").val().trim();
						//验证码
						var code;
						function createCode() {
							code = "";
							var codeLength = 4;//设置验证码长度
							//设置随机字符
							var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8,
									9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
									'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
									'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
									'Y', 'Z');
							for (var i = 0; i < codeLength; i++) {
								var index = Math.floor(Math.random() * 36);
								code += random[index];
							}
							$("#code").text(code);
						}
						$("#code").ready(function() {
							createCode()
						})

						$("#checkNumber")
								.change(
										function() {
											var check = $("#checkNumber").val()
													.toUpperCase();
											$("#isCheck").html("");
											if (check == "") {
												$("#isCheck")
														.html(
																"<font color='red'>请输入验证码</font>");
											} else if (check != code) {
												$("#isCheck")
														.html(
																"<font color='red'>验证码不正确，请重新输入</font>");
												check = "";
												createCode();
											} else {
												$("#isCheck")
														.html(
																"<font color='blue'>验证码正确</font>");
											}
										})

						$("#payPassword").change(
								function() {
									var c = $(this);
									var payPassword = $("#payPassword").val()
											.trim();
									var patternPassword = /^\d{6}$/;
									if (/[^\d]/.test(c.val())) {//替换非数字字符
										var temp_amount = c.val().replace(
												/[^\d]/g, '');
										$(this).val(temp_amount);
									} else if (payPassword == "" || undefined
											|| null) {
										alert("请输入您的支付密码！");
										return false
									} else if (!patternPassword
											.test(payPassword)) {
										alert("请输入合法的支付密码！")
										return false
									} else if (password != payPassword) {
										alert("密码错误，请重新输入！")
										return false
									}
								})

						$("#recharge")
								.change(
										function() {
											var c = $(this);
											var recharge = $("#recharge").val()
													.trim();
											var patternRecharge = /^[1-9]\d*$/;
											if (/[^\d]/.test(c.val())) {
												var temp_amount = c.val()
														.replace(/[^\d]/g, '');
												$(this).val(temp_amount);
											} else if (recharge == ""
													|| undefined || null) {
												alert("请输入您要充值的金额！")
												return false
											} else if (!patternRecharge
													.test(recharge)) {
												alert("请输入合法的金额！")
												return false
											}
										})

						$("#submit").click(function() {
							var recharge = $("#recharge").val().trim();
							var payPassword = $("#payPassword").val().trim();
							var check = $("#checkNumber").val().toUpperCase();
							var patternPassword = /^\d{6}$/;
							if (recharge == "" || undefined || null) {
								alert("请输入您要充值的金额！")
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
							} else if (check == "") {
								alert("请输入验证码！")
								return false
							} else if (check != code) {
								alert("验证码错误，请重新输入！")
								return false
							}
							//日期
							var date = new Date();
							var year = date.getFullYear(); //获取当前年份
							var month = date.getMonth() + 1; //获取当前月份
							var day = date.getDate(); //获取当前日
							if (date.getMonth() < 10) {
								month = "0" + month
							}
							if (date.getDate() < 10) {
								day = "0" + day
							}
							var rechargeTime = year + "-" + month + "-" + day
							$("#rechargeTime").val(rechargeTime)

							//金额

						})

					})
</script>
</head>
<body>
	<section id="getintouch" class="fadeIn animated">
		<div class="container" style="border-bottom: 0;">
			<h1>
				<span>充值</span>
			</h1>
		</div>
		<div class="container">
			<form class="contact" action="rechargeAction!addRechargeRecode"
				method="post" id="form">
				<input type="hidden" id="password" name="password"
					value="${payPassword }"> <input type="hidden"
					id="rechargeTime" name="rechargeRecord.rechargeTime"> <input
					type="hidden" id="type" name="rechargeRecord.rechargeType"
					value="充值">
				<div class="row clearfix">
					<div class="lbl">
						<label for="recharge"> 充值金额：</label>
					</div>
					<div class="ctrl">
						<input type="text" id="recharge" name="rechargeRecord.money"
							maxlength="8" placeholder="请输入您要充值的金额！">
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="payPassword"> 支付密码：</label>
					</div>
					<div class="ctrl">
						<input type="text" id="payPassword" name="payPassword"
							maxlength="6" placeholder="请输入您的支付密码！">
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl" id="getCode">
						<label for="checkNumber"> 验证码：<span id="code"></span></label>
					</div>
					<div class="ctrl">
						<input type="text" id="checkNumber" name="checkNumber"
							placeholder="请输入验证码！" style="width: 30%"> <label
							id="isCheck"></label>
					</div>
				</div>
				<div class="row  clearfix">
					<div class="span10 offset2">
						<input style="width: 100%" type="submit" name="submit" id="submit"
							class="submit" value="确认"> <input style="width: 100%"
							type="reset" name="reset" id="reset" class="submit" value="重置">
					</div>
				</div>
			</form>
		</div>
	</section>
</body>
</html>
