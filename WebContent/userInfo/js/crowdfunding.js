$(document).ready(function(event) {
	var isEmail = false;
	var isPhone = true;
	var userID = null;
	
	var UserName ;
	var UserPhone ;
	$.ajax({
		cache : true,
		type : "POST",
		url : "userAction!queryUserMessage.action",
		data : "",// 数据控件ID
		dataType : "json",
		async : true,
		success : function(data) {
			$("#userName").html(data[0].userName);
			$("#userID").val(data[0].userId);
			$("#name").val(data[0].userName);
			$("#E-mail").val(data[0].userEmail);
			$("#phoneNumber").val(data[0].userPhone);
			$("#IDCard").val(data[0].userCard);
			$("#userBanlance").html(data[0].userBanlance);
			$("#userBanlanceHindden").val(data[0].userBanlance);
			$("#userPassword").val(data[0].userPassword);
			$("#status").val(data[0].userStatus);
			
			
			UserName=data[0].userName;
			UserPhone=data[0].userPhone;
		},
		error : function(response) {
			console.log(response);
		}
	});
	$("#resetButton").click(function(event) {
		$.ajax({
			cache : true,
			type : "POST",
			url : "userAction!queryUserMessage.action",
			data : "",// 数据控件ID
			dataType : "json",
			async : true,
			success : function(data) {
				$("#userName").html(data[0].userName);
				$("#userID").val(data[0].userId);
				$("#name").val(data[0].userName);
				$("#E-mail").val(data[0].userEmail);
				$("#phoneNumber").val(data[0].userPhone);
				$("#IDCard").val(data[0].userCard);
				$("#userBanlance").html(data[0].userBanlance);
				$("#userBanlanceHindden").val(data[0].userBanlance);
				$("#userPassword").val(data[0].userPassword);
				$("#status").val(data[0].userStatus);
			},
			error : function(response) {
				console.log(response);
			}
		});
	})
	$("#registerButton").click(function(event) {
		var dataName = $("#name").val().trim();

		var dataPhoneNumber = $("#phoneNumber").val().trim();
		var patternPhoneNumber = /^[1][3,4,5,7,8][0-9]{9}$/;
		var strPhoneNumber = patternPhoneNumber.test(dataPhoneNumber);
		
		if ((dataName == "" || undefined || null)) {
			alert("用户名称不可为空");
			return false;
		} else if (dataName.length < 6) {
			alert("用户名小于六位字符");
			return false;
		} else if (dataPhoneNumber == "" || undefined || null) {
			alert("请输入您的手机号");
			return false;
		} else if (!strPhoneNumber) {
			alert("请输入合法的手机号");
			return false;
		} else if(UserName==dataName && UserPhone==dataPhoneNumber){
			alert("您的信息未做更改");
			return false;
		}
		else if (isPhone == false) {
			alert("此手机号已被注册，请重新输入");
			return false;
		} else {
			return true;
		}
	});
	$("#name").bind('input propertychange', function() {

		var length = $("#name").val().trim().length;
		if (length >= 6) {
			$("#userNameInfo").css("display", "none");
		} else {
			$("#userNnameInfo").css("display", "block");
		}

	});
	// 手机号验证
	$("#phoneNumber").bind('input propertychange', function(event) {
		var inputNumber = $("#phoneNumber").val().trim();
		var pattern = /^[1][3,4,5,7,8][0-9]{9}$/;
		if (pattern.test(inputNumber)) {
			$.ajax({
				cache : true,
				type : "POST",
				url : "userAction!registerCheckByphoneNumber.action",
				data : 'user.userPhone=' + $('#phoneNumber').val().trim(),// 数据控件ID
				async : true,
				success : function(data) {
					if (data == "未注册") {
						isPhone = true;
						$("#phoneNumberInfo").css("color", "green");
					} else {
						isPhone = false;
						$("#phoneNumberInfo").css("color", "red");
					}
					$("#phoneNumberInfo").html(data);
				},
				error : function(response) {
					console.log(response);
				}
			});
		} else {
			isPhone = false;
			$("#phoneNumberInfo").css("color", "red");
			$("#phoneNumberInfo").html("格式错误");
		}
	});
	$("#modifyByEmail").click(function(event) {
		// alert("123");
		$("#modifyByEmail").addClass("modifyChecked");
		$("#modifyByOlderPassword").removeClass("modifyChecked");
		$("#changePasswordMain2").css("display", "none");
		$("#changePasswordMain1").css("display", "block");
	});
	$("#modifyByOlderPassword").click(function(event) {
		// alert("456");
		$("#modifyByOlderPassword").addClass("modifyChecked");
		$("#modifyByEmail").removeClass("modifyChecked");
		$("#changePasswordMain1").css("display", "none");
		$("#changePasswordMain2").css("display", "block");
	});

	$.ajax({
		cache : true,
		type : "POST",
		url : "userAction!queryUserID.action",
		data : "",// 数据控件ID
		dataType : "json",
		async : true,
		success : function(data) {
			if (data == "请登录") {
				$("#modifyMessage").html("请登录");
			} else {
				userID = data;
			}
		},
		error : function(response) {
			console.log(response);
		}
	});

	// 点击修改密码提交按钮
	$("#submintByPassword").click(function(event) {
		var oldPassword = $("#oldPassword").val().trim();
		var Password = $("#Password").val().trim();
		var Password2 = $("#Password2").val().trim();

		if (oldPassword == "" || undefined || null) {
			alert("请输入您的原密码");
			return false;
		} else if (oldPassword.length < 6) {
			alert("原密码长度必须为六位");
			return false;
		} else if (Password == "" || undefined || null) {
			alert("请输入您的新密码");
			return false;
		} else if (Password2 == "" || undefined || null) {
			alert("请再次输入您的新密码");
			return false;
		} else if (Password.length < 6) {
			alert("新密码长度必须为六位");
			return false;
		}  else if (Password != Password2) {
			alert("两次输入的密码不一致");
			return false;
		} else if (userID == "" || undefined || null) {
			alert("请先登录");
			return false;
		} else {
			$.ajax({
				cache : true,
				type : "POST",
				url : "userAction!changePassword.action",
				data : {
					"user.userId" : userID,
					"user.userPassword" : oldPassword,
					"newUserPassword" : Password2
				},
				dataType : "json",
				async : true,
				success : function(data) {
					$("#modifyMessage").html(data)
				},
				error : function(response) {
					console.log(response);
				}
			});
		}

	});
});
/**
 * 用于众筹个人中心左侧竖型菜单的动态样式切换
 * 
 * @method listClick
 * @for 无
 * @param {int}
 *            value 标记所点击的菜单
 * @return {null} 无
 */
function listClick(value) {
	if (value == 1) {
		$("#crowdfunding_iframe").attr("src", "my_info.html");
		$("#crowdfunding_iframe").attr("height", "520");
		$("#vertical_navigation").css("height", "520px");

		$("#listClick1").attr("class", "menu_list_on");
		$("#listClick2").attr("class", "");
		$("#listClick3").attr("class", "");
		$("#listClick4").attr("class", "");
	}
	if (value == 2) {

		$("#crowdfunding_iframe").attr("src", "modifyPassword.html");
		$("#crowdfunding_iframe").attr("height", "520");
		$("#vertical_navigation").css("height", "520px");

		$("#listClick1").attr("class", "");
		$("#listClick2").attr("class", "menu_list_on");
		$("#listClick3").attr("class", "");
		$("#listClick4").attr("class", "");
	}
	if (value == 3) {
		$("#crowdfunding_iframe").attr("src",
				"crowdfunding.center/my_account.html");
		$("#crowdfunding_iframe").attr("height", "520");
		$("#vertical_navigation").css("height", "520px");

		$("#listClick1").attr("class", "");
		$("#listClick2").attr("class", "");
		$("#listClick3").attr("class", "menu_list_on");
		$("#listClick4").attr("class", "");
	}
	if (value == 4) {
		$("#crowdfunding_iframe").attr("src",
				"crowdfunding.center/investment_inquiry.html");
		$("#crowdfunding_iframe").attr("height", "520");
		$("#vertical_navigation").css("height", "520px");

		$("#listClick1").attr("class", "");
		$("#listClick2").attr("class", "");
		$("#listClick3").attr("class", "");
		$("#listClick4").attr("class", "menu_list_on");
	}
	if (value == 5) {
		$("#crowdfunding_iframe").attr("src",
				"head-portrait.html");
		$("#crowdfunding_iframe").attr("height", "520");
		$("#vertical_navigation").css("height", "520px");

		$("#listClick1").attr("class", "");
		$("#listClick2").attr("class", "");
		$("#listClick3").attr("class", "");
		$("#listClick4").attr("class", "menu_list_on");
	}
}