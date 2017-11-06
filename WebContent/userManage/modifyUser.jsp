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
				<img src="imgs/coin02.png" /><span>首页&nbsp;-&nbsp;用户管理&nbsp;-</span>&nbsp;修改用户信息
			</div>
		</div>
		<div class="page ">
			<!-- 修改用户页面样式 -->
			<br>
			<form action="userAction!do_edit" method="get">
				<div class="baBody">
					<div class="bbD1 bbD">
						<input type="hidden" class="input3" name="user.userId"
							value="${user.userId }" > <input type="text"
							class="addUserInfo" value="用户名：" readonly> <input
							id="name-two" type="text" class="input3" name="user.userName"
							value="${user.userName }"/> <img id="img_ok" src="imgs/ok.png"><img
							id="img_no" src="imgs/no.png"> <span id="text_no"></span>
					</div>
					<div class="bbD">
						<input type="text" class="addUserInfo" value="密码：" readonly>
						<input id="password-two" type="text" class="input3"  value="${user.userPassword }"/> <img id="img_ok"
							src="imgs/ok.png"><img id="img_no" src="imgs/no.png">
						<span id="text_no"></span>
					</div>
					<div class="bbD">
						<input type="text" class="addUserInfo" value="确认密码：" readonly>
						<input id="passwordAgain-two" type="password" class="input3" name="user.userPassword"
				/> <img id="img_ok"
							src="imgs/ok.png"><img id="img_no" src="imgs/no.png">
						<span id="text_no"></span>
					</div>
					<div class="bbD">
						<input type="text" class="addUserInfo" value="邮箱：" readonly>
						<input id="input-phone-emailTwo" type="email" class="input3" name="user.userEmail"
						 value="${user.userEmail }"/> <span id="emailSpanTwo" style="color:red" hidden>邮箱已被注册</span>
					</div>
					<div class="bbD">
						<input type="text" class="addUserInfo" value="性别：" readonly>
						<input class="addUserCheck" type="radio" name="sex" checked />男 <input
							class="addUserCheck" type="radio" name="sex" />女
					</div>
					<div class="bbD">
						<input type="text" class="addUserInfo" value="电话号：" readonly>
						<input id="input-phone-noTwo" type="phone" class="input3" name="user.userPhone"
						value="${user.userPhone }"/> <span id="phoneSpanTwo" style="color:red" hidden>电话已被注册</span>
					</div>
					<div class="bbD">
						<input type="text" class="addUserInfo" value="身份证号：" readonly>
						<input id="input-phone-cardTwo" type="text" class="input3" name="user.userCard"
						 value="${user.userCard }"/> <span id="cardSpanTwo" style="color:red" hidden>电话已被注册</span>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<input type="hidden" name="student.studentId"/> <input id="updateSub" class="input3"
								type="submit" name="Submit" value="提交"
								style="width: 153px; color: Black; background-color: Aqua" /> 
	
							<a href="userAction!findUser">
							<input class="input3"
								type="button" name="Submit" value="取消" style="width: 153px;" /></a>
						</p>
					</div>
				</div>
			</form>

			<!-- 修改用户页面样式end -->
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function (event) {
		var isEmail=false;
		var isPhone=false;
		var isIDCard=false;
	$("#updateSub").click(function (event) {
	    var dataName = $("#name-two").val().trim();
	    var dataPassword = $("#password-two").val().trim();
	    var dataPasswordAgain = $("#passwordAgain-two").val().trim();
	    
	    var dataEmail = $("#input-phone-emailTwo").val().trim();
	    var patternEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	    var strEmail = patternEmail.test(dataEmail);
	    
	    var dataPhoneNumber=$("#input-phone-noTwo").val().trim();
	    console.log(dataPhoneNumber);
	    var patternPhoneNumber=/^[1][3,4,5,7,8][0-9]{9}$/;
	    var strPhoneNumber=patternPhoneNumber.test(dataPhoneNumber);
	    
	    
	    var dataIDCard=$("#input-phone-cardTwo").val().trim();
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
	var phoneOldVale=${user.userPhone };
	var emailOldVale=${user.userEmail };
	var cardOldVale=${user.userCard };
		$("#input-phone-noTwo").blur(function() {
			if($("#input-phone-noTwo").val()!=phoneOldVale){
			 $.ajax({
				url : "/FinancialGenius/userAction!findUserByPhone?user.userPhone="+$(this).val(),
               success:function(data){
            	   if(data=="0"){
            		   $("#phoneSpanTwo").hide()
            		   isIDCard=true;
            	   }
            	   else{
              		   $("#phoneSpanTwo").show()
              		  isIDCard=false;
            	   }
               }
			})
			}
			else{
				 $("#phoneSpanTwo").hide()
      		   isIDCard=true;
			}
		})
		$("#input-phone-emailTwo").blur(function() {
			if($("#input-phone-noTwo").val()!=emailOldVale){
			 $.ajax({
				url : "/FinancialGenius/userAction!findUserByEmail?user.userEmail="+$(this).val(),
               success:function(data){
            	   if(data=="0"){
            		   $("#emailSpanTwo").hide()
            		   isEmail=true;
            	   }
            	   else{
              		   $("#emailSpanTwo").show()
              		   isEmail=false;
            	   }
               }
			})
			}
			else{
			   $("#emailSpanTwo").hide()
     		   isEmail=true;
			}
		})
		$("#input-phone-cardTwo").blur(function() {
			if($("#input-phone-noTwo").val()!=cardOldVale){
			 $.ajax({
				url : "/FinancialGenius/userAction!findUserByCard?user.userCard="+$(this).val(),
               success:function(data){
            	   if(data=="0"){
            		   $("#cardSpanTwo").hide()
            		    isPhone=true;
            	   }
            	   else{
              		   $("#cardSpanTwo").show()
              		  isPhone=false;
            	   }
               }
			})
			}
			else{
				$("#cardSpanTwo").hide()
    		    isPhone=true;
			}
		})
               })
	</script>
</body>
</html>