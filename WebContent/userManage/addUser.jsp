<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addUser</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript"
	src="https://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/adduser.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="imgs/coin02.png" /><span>首页 - 用户管理> -</span> 添加用户
			</div>
		</div>
		<div class="page ">
			<!-- 添加用户页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>添加用户</span>
				</div>
				<form action="userAction!addUser" method="post">
					<div class="baBody">
						<div class="bbD1 bbD">
							<input type="text" class="addUserInfo" value="用户名：" readonly>
							<input id="name-one" type="text" class="input3" name="user.userName" /> <img
								id="img_ok" src="imgs/ok.png"><img id="img_no"
								src="imgs/no.png"> <span id="text_no"></span>
						</div>
						<div class="bbD">
							<input type="text" class="addUserInfo" value="密码：" readonly>
							<input id="password-one" type="text" class="input3" /> <img id="img_ok"
								src="imgs/ok.png"><img id="img_no" src="imgs/no.png">
							<span id="text_no"></span>
						</div>
						<div class="bbD">
							<input type="text" class="addUserInfo" value="确认密码：" readonly>
							<input id="passwordAgain-one" type="password" class="input3" name="user.userPassword" />
							<img id="img_ok" src="imgs/ok.png"><img id="img_no"
								src="imgs/no.png"> <span id="text_no"></span>
						</div>
						<div class="bbD">
							<input type="text" class="addUserInfo" value="邮箱：" readonly>
							<input id="input-phone-email" type="email" class="input3" name="user.userEmail" value=""/><span hidden style="color:red" id="emailSpan">邮箱重复<span>
						</div>
						<div class="bbD">
							<input type="text" class="addUserInfo" value="性别：" readonly>
							<input class="addUserCheck" type="radio" name="sex" checked />男
							<input class="addUserCheck" type="radio" name="sex" />女
						</div>
						<div class="bbD">
							<input type="text" class="addUserInfo" value="电话号：" readonly>
							<input id="input-phone-no" type="phone" class="input3"
								name="user.userPhone" value="" /><span hidden style="color:red" id="phoneSpan">电话号码重复<span>
						</div>
						<div class="bbD">
							<input type="text" class="addUserInfo" value="身份证号：" readonly>
							<input id="input-phone-card" type="text" class="input3" name="user.userCard" value=""/><span hidden style="color:red" id="cardSpan">身份证号码重复<span>
						</div>
						<div class="bbD">
							<p class="bbDP">
								<input type="hidden" name="student.studentId"
									value="${student.studentId }" /> <input id="inputSub" class="input3"
									type="submit" name="Submit" value="提交"
									style="width: 153px; color: Black; background-color: Aqua" />
								<a href="student!list.action"> <input class="input3"
									type="submit" name="Submit" value="取消" style="width: 153px;" />
								</a>
							</p>
						</div>
					</div>
				</form>
			</div>
			<!-- 添加用户页面样式end -->
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function (event) {
		var isEmail=false;
		var isPhone=false;
		var isIDCard=false;
	$("#inputSub").click(function (event) {
	    var dataName = $("#name-one").val().trim();
	    var dataPassword = $("#password-one").val().trim();
	    var dataPasswordAgain = $("#passwordAgain-one").val().trim();
	    
	    var dataEmail = $("#input-phone-email").val().trim();
	    var patternEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	    var strEmail = patternEmail.test(dataEmail);
	    
	    var dataPhoneNumber=$("#input-phone-no").val().trim();
	    console.log(dataPhoneNumber);
	    var patternPhoneNumber=/^[1][3,4,5,7,8][0-9]{9}$/;
	    var strPhoneNumber=patternPhoneNumber.test(dataPhoneNumber);
	    
	    
	    var dataIDCard=$("#input-phone-card").val().trim();
	    var patternIDCard=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	    var strIDCard=patternIDCard.test(dataIDCard);
	    
	    
	    if ((dataName == "" || undefined || null)) {
	        alert("用户名称不可为空");
	        return false;
	    }
	    else if(dataName.length<6){
	    	alert("用户名小于六位字符");
	    	return false;
	    }
	    else if (dataPassword == "" || undefined || null) {
	        alert("密码不能为空");
	        return false;
	    }
	    else if(dataPassword.length<6){
	    	alert("密码小于六位字符");
	    	return false;
	    }
	    else if (dataPasswordAgain == "" || undefined || null) {
	        alert("请输入重复密码");
	        return false;
	    }
	    else if (dataEmail == "" || undefined || null) {
	        alert("请输入E-mail");
	        return false;
	    }
	    else if (!strEmail) {
	        alert("请输入合法的E-mail");
	        return false;
	    }
	    else if (dataPassword != dataPasswordAgain) {
	        alert("两次输入的密码不一致");
	        return false;
	    }
	    else if(dataPhoneNumber==""||undefined||null){
	    	alert("请输入您的手机号");
	    	return false;       
	    	}
	    else if(!strPhoneNumber){
	        console.log(strPhoneNumber);
	    	alert("请输入合法的手机号");
	    	return false;     
	    }
	    else if(dataIDCard==""||undefined||null){
	    	alert("请输入您的身份证号码");
	    	return false;       
	    	}
	    else if(!strIDCard){
	    	alert("请输入合法的身份证号码");
	    	return false;     
	    }
	    else if(isEmail==false){
	    	alert("此邮箱已被注册，请重新输入");
	    	return false;    
	    }
	    else if(isPhone==false){
	    	alert("此手机号已被注册，请重新输入");
	    	return false;    
	    }
	    else if(isIDCard==false){
	    	alert("此身份证号已被注册，请重新输入");
	    	return false;    
	    }
	    else {
	    	return true;
	    }
	});
		$("#input-phone-no").blur(function() {
			 $.ajax({
				url : "/FinancialGenius/userAction!findUserByPhone?user.userPhone="+$(this).val(),
               success:function(data){
            	   if(data=="0"){
            		   $("#phoneSpan").hide()
            		   isPhone=true;
            	   }
            	   else{
              		   $("#phoneSpan").show()
              		  isEmail=false;

            	   }
               }
			})
		})
		$("#input-phone-email").blur(function() {
			 $.ajax({
				url : "/FinancialGenius/userAction!findUserByEmail?user.userEmail="+$(this).val(),
               success:function(data){
            	   if(data=="0"){
            		   $("#emailSpan").hide()
            		   isEmail=true;
            	   }
            	   else{
              		   $("#emailSpan").show()
              		 isEmail=false;
            	   }
               }
			})
		})
		$("#input-phone-card").blur(function() {
			 $.ajax({
				url : "/FinancialGenius/userAction!findUserByCard?user.userCard="+$(this).val(),
               success:function(data){
            	   if(data=="0"){
            		   $("#cardSpan").hide()
            		   isIDCard=true;
            	   }
            	   else{
              		   $("#cardSpan").show()                		 
               		  isIDCard=false;
            	   }
               }
			})
		})
               })
	</script>
</body>
</html>