<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>绑定银行卡</title>
    <link href="./css/demo.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
        	var userPhone = $("#userPhone").val().trim();
        	
            //验证码
            var code;
            function createCode(){
                code="";
                var codeLength=4;//设置验证码长度
                //设置随机字符
                var random=new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');
                for(var i=0;i<codeLength;i++){
                    var index = Math.floor(Math.random()*36);
                    code+=random[index];
                }
                $("#code").text(code);
            }
            $("#code").ready(function(){
                createCode()
            })

            $("#checkNumber").change(function(){
                var check = $("#checkNumber").val().toUpperCase();
                $("#isCheck").html("");
                if(check==""){
                    $("#isCheck").html("<font color='red'>请输入验证码</font>");
                }else if(check!=code){
                    $("#isCheck").html("<font color='red'>验证码不正确，请重新输入</font>");
                    check="";
                    createCode();
                }else{
                    $("#isCheck").html("<font color='blue'>验证码正确</font>");
                }
            })

            $("#phone").change(function() {
                var c = $(this);
                var dataPhoneNumber = $("#phone").val().trim();
                var patternPhoneNumber = /^[1][3,4,5,7,8][0-9]{9}$/;
                var strPhoneNumber = patternPhoneNumber.test(dataPhoneNumber);
                if (/[^\d]/.test(c.val())) {//替换非数字字符
                    var temp_amount = c.val().replace(/[^\d]/g, '');
                    $(this).val(temp_amount);
                }else if(dataPhoneNumber==""||undefined||null){
                    alert("请输入你的手机号！");
                    return false
                }else if(!strPhoneNumber){
                    alert("请输入合法的手机号！")
                    return false
                }else if (dataPhoneNumber!=userPhone) {
					alert("手机号码错误，请重新输入！")
					return false
				}
            })

            $("#bankCardName").change(function(){
                var c = $(this);
                var bankNumber = $("#bankCardName").val().trim();
                var patternBankNumber =  /^\d{19}$/g;
                if(/[^\d]/.test(c.val())){
                    var temp_amount = c.val().replace(/[^\d]/g, '');
                    $(this).val(temp_amount);
                }else if(bankNumber==""||undefined||null){
                    alert("请输入您要绑定的银行卡号！")
                    return false
                }else if(!patternBankNumber.test(bankNumber)){
                    alert("请输入合法的银行卡号！")
                    return false
                }
            })
            
            $("#submit").click(function(){
            	var dataPhoneNumber = $("#phone").val().trim();
                var bankNumber = $("#bankCardName").val().trim();
                var check = $("#checkNumber").val().toUpperCase();
                var patternBankNumber =  /^\d{19}$/g;
                var patternPhoneNumber = /^[1][3,4,5,7,8][0-9]{9}$/;
                if(bankNumber==""||undefined||null){
                    alert("请输入您要绑定的银行卡号！")
                    return false
                }else if(!patternBankNumber.test(bankNumber)){
                	alert("请输入合法的银行卡号！")
                    return false
                }else if(dataPhoneNumber==""||undefined||null){
                    alert("请输入你的手机号！");
                    return false
                }else if(!patternPhoneNumber.test(dataPhoneNumber)){
                	alert("请输入合法的手机号！")
                    return false
                }else if (dataPhoneNumber!=userPhone) {
					alert("手机号码错误，请重新输入！")
					return false
				}else if(check==""){
                	alert("请输入验证码！")
                	return false
                }else if(check!=code){
                    alert("验证码错误，请重新输入！")
                    return false
                }
                
            })
        })
    </script>
</head>
<body>
<section id="getintouch" class="fadeIn animated">
     <div class="container" style="border-bottom: 0;">
        <h1>
            <span>绑定银行卡</span>
        </h1>
    </div>
    <div class="container">
        <form class="contact" action="bankCardAction!addBankCard" method="post" id="form">
        <input type="hidden" id="userId" name="userId" value="${userId }">
        <input type="hidden" id="userPhone" name="userPhone" value="${userPhone }">
        <input type="hidden" id="bankBalance" name="bankCard.bankBalance" value="100000">
            <div class="row clearfix">
                <div class="lbl">
                    <label for="bankCardName">
                        银行卡号：</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="bankCardName" name="bankCard.bankCardId" maxlength="19" placeholder="请输入您的银行卡号！">
                </div>
            </div>
            <div class="row clearfix">
                <div class="lbl">
                    <label for="phone">
                        手机号：</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="phone" name="phone" maxlength="11"  placeholder="请输入您的手机号！">
                </div>
            </div>
            <div class="row clearfix">
                <div class="lbl" id="getCode">
                    <label for="checkNumber">
                        验证码：<span id="code"></span></label>
                </div>
                <div class="ctrl">
                    <input type="text" id="checkNumber" name="checkNumber"  placeholder="请输入验证码！" style="width: 30%">
                    <label id="isCheck"></label>
                </div>
            </div>
            <div class="row  clearfix">
                <div class="span10 offset2">
                    <input style="width: 100%" type="submit" name="submit" id="submit"
                           class="submit" value="确认">
                    <input style="width: 100%"type="reset" name="reset" id="reset"
                           class="submit" value="重置">
                </div>
            </div>
        </form>
    </div>
</section>
</body>
</html>
