/*!
 * jRaiser 2 Javascript Library
 * Yaolongfei - v1.0.0 (2015-07-28T17:30:00+0800)
 */

$(document).ready(function(event) {
    $("#registerButton").click(function(event) {
        var dataName = $("#name").val();
        var dataPassword = $("#password").val();
        var dataPasswordAgain = $("#passwordAgain").val();

        var dataEmail = $("#E-mail").val();
        var patternEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        var strEmail = patternEmail.test(dataEmail);

        var dataPhoneNumber = $("#phoneNumber").val();
        console.log(dataPhoneNumber);
        var patternPhoneNumber = /^[1][3,4,5,7,8][0-9]{9}$/;
        var strPhoneNumber = patternPhoneNumber.test(dataPhoneNumber);


        var dataIDCard = $("#IDCard").val();
        var patternIDCard = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        var strIDCard = patternIDCard.test(dataIDCard);

        if ((dataName == "" || undefined || null)) {
            alert("用户名称不可为空！");
            return false;
        } else if (dataPassword == "" || undefined || null) {
            alert("密码不能为空！");
            return false;
        } else if (dataPasswordAgain == "" || undefined || null) {
            alert("请输入重复密码！");
            return false;
        } else if (dataEmail == "" || undefined || null) {
            alert("请输入E-mail！");
            return false;
        } else if (!strEmail) {
            alert("请输入合法的E-mail！");
            return false;
        } else if (dataPassword != dataPasswordAgain) {
            alert("两次输入的密码不一致！");
            return false;
        } else if (dataPhoneNumber == "" || undefined || null) {
            alert("请输入您的手机号");
            return false;
        } else if (!strPhoneNumber) {
            console.log(strPhoneNumber);
            alert("请输入合法的手机号");
            return false;
        } else if (dataIDCard == "" || undefined || null) {
            alert("请输入您的身份证号码");
            return false;
        } else if (!strIDCard) {
            alert("请输入合法的身份证号码");
            return false;
        } else {
            return true;
            /* $.ajax({
                    cache: true,
                    type: "POST",
                    url:"userAction!register.action",
                    data:$('#userMessage'),// formID 
                    async: false,
                    error: function(request) {
                        alert("Connection error");
                    },
                    success:function(data,textStatus,jqXHR){
                    },
                }); */
        }
    });
    $("#name").bind('input propertychange', function() {

        var length = $("#name").val().length;
        if (length >= 6) {
            $.ajax({
                cache: true,
                type: "POST",
                url: "userAction!registerCheck.action",
                data: $('#name'), // 数据控件ID 
                async: false,
                error: function(request) {
                    alert("Connection error");
                },
                success: function(data, textStatus, jqXHR) {
                    data.
                    $("#nameInfo").css("display", "none");
                }
            })
        } else {
            $("#nameInfo").css("display", "block");
        }
    });
    $("#password").bind('input propertychange', function(event) {
        var length = $("#password").val().length;
        if (length >= 6) {
            $("#passwordInfo").css("display", "none");
        } else {
            $("#passwordInfo").css("display", "block");
        }
    });
    $("#passwordAgain").bind('input propertychange', function(event) {
        var length1 = $("#password").val().length;
        var length2 = $("#passwordAgain").val().length;
        if (length2 == length1) {
            $("#passwordAgainInfo").css("display", "none");
        } else {
            $("#passwordAgainInfo").css("display", "block");
        }
    });
    $("#E-mail").bind('input propertychange', function(event) {
        var email = $("#E-mail").val();
        var pattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        var strEmail = pattern.test(email);
        if (strEmail) {
            $("#E-mailInfo").css("display", "none");
        } else {
            $("#E-mailInfo").css("display", "block");
        }
    });
    //手机号验证
    $("#phoneNumber").bind('input propertychange', function(event) {
        var inputNumber = $("#phoneNumber").val();
        var pattern = /^[1][3,4,5,7,8][0-9]{9}$/;
        if (pattern.test(inputNumber)) {
            $("#phoneNumberInfo").css("display", "none");
        } else {
            $("#phoneNumberInfo").css("display", "block");
        }
    });
    //身份证号码验证
    $("#IDCard").bind('input propertychange', function(event) {
        var inputNumber = $("#IDCard").val();
        var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if (pattern.test(inputNumber)) {
            $("#IDCardInfo").css("display", "none");
        } else {
            $("#IDCardInfo").css("display", "block");
        }
    });
    $("userMessage").submit(function(e) {});

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