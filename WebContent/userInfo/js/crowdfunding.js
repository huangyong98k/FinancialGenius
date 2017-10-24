$(document).ready(function(event) {
	var isEmail=false;
	var isPhone=false;
	
$("#registerButton").click(function (event) {
    var dataName = $("#name").val().trim();
  
    var dataPhoneNumber=$("#phoneNumber").val().trim();
    var patternPhoneNumber=/^[1][3,4,5,7,8][0-9]{9}$/;
    var strPhoneNumber=patternPhoneNumber.test(dataPhoneNumber);
       
    if ((dataName == "" || undefined || null)) {
        alert("用户名称不可为空");
        return false;
    }
    else if(dataName.length<6){
    	alert("用户名小于六位字符");
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
$("#name").bind('input propertychange', function () {
	
    var length = $("#name").val().trim().length;
    if (length >= 6) {
    	 $("#userNameInfo").css("display", "none");
    } else {
        $("#userNnameInfo").css("display", "block");
    }
    
});
    //手机号验证
    $("#phoneNumber").bind('input blur', function (event) {
        var inputNumber = $("#phoneNumber").val().trim();
        var pattern=/^[1][3,4,5,7,8][0-9]{9}$/;
        if(pattern.test(inputNumber)){
        	$.ajax({
                cache: true,
                type: "POST",
                url:"userAction!registerCheckByphoneNumber.action",
                data:'user.userPhone='+$('#phoneNumber').val().trim(),// 数据控件ID 
                async: true,
                success:function(data){
                	console.log(data);
                	if(data=="未注册"){
                		isPhone=true;
                		$("#phoneNumberInfo").css("color","green");
                	}
                	else{
                		isPhone=false;
                		$("#phoneNumberInfo").css("color","red");
                	}
                	$("#phoneNumberInfo").html(data);
                },
                error: function(response) {
                	console.log(response);
                }
                });
        } 
        else{
        	isPhone=false;
    		$("#phoneNumberInfo").css("color","red");
    		$("#phoneNumberInfo").html("格式错误");
        }
    });
    $("#modifyByEmail").click(function(event) {
        //alert("123");
        $("#modifyByEmail").addClass("modifyChecked");
        $("#modifyByOlderPassword").removeClass("modifyChecked");
        $("#changePasswordMain2").css("display", "none");
        $("#changePasswordMain1").css("display", "block");
    });
    $("#modifyByOlderPassword").click(function(event) {
        //alert("456");
        $("#modifyByOlderPassword").addClass("modifyChecked");
        $("#modifyByEmail").removeClass("modifyChecked");
        $("#changePasswordMain1").css("display", "none");
        $("#changePasswordMain2").css("display", "block");
    });
});
/**
 * 用于众筹个人中心左侧竖型菜单的动态样式切换
 * @method listClick
 * @for 无
 * @param {int} value 标记所点击的菜单
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
        $("#crowdfunding_iframe").attr("src", "crowdfunding.center/my_account.html");
        $("#crowdfunding_iframe").attr("height", "520");
        $("#vertical_navigation").css("height", "520px");

        $("#listClick1").attr("class", "");
        $("#listClick2").attr("class", "");
        $("#listClick3").attr("class", "menu_list_on");
        $("#listClick4").attr("class", "");
    }
    if (value == 4) {
        $("#crowdfunding_iframe").attr("src", "crowdfunding.center/investment_inquiry.html");
        $("#crowdfunding_iframe").attr("height", "520");
        $("#vertical_navigation").css("height", "520px");

        $("#listClick1").attr("class", "");
        $("#listClick2").attr("class", "");
        $("#listClick3").attr("class", "");
        $("#listClick4").attr("class", "menu_list_on");
    }
}