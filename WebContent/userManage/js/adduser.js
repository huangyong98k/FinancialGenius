//用户名判断 JS
$(function() {
    $(".bbD:eq(0) .input3").blur(function() {
        if (this.value == "") {
            $(".bbD:eq(0) #img_no").show();
            $(".bbD:eq(0) #text_no").show();
            $(".bbD:eq(0) #text_no").html("用户名为空");
        } else if (this.value.length < 6 || this.value.length > 20) {
            $(".bbD:eq(0) #img_no").show();
            $(".bbD:eq(0) #img_ok").hide();
            $(".bbD:eq(0) #text_no").show();
            $(".bbD:eq(0) #text_no").html("用户名必须是6-20个字符！");
        } else {
            $(".bbD:eq(0) #img_no").hide();
            $(".bbD:eq(0) #img_ok").show();
        }

    });
    $(".bbD:eq(0) .input3").focus(function() {
        $(".bbD:eq(0) #img_no").hide();
        $(".bbD:eq(0) #text_no").hide();
        $(".bbD:eq(0) #img_ok").hide();
    });

})
//用户名判断 JS end！

//password名判断 JS
$(function() {
    $(".bbD:eq(1) .input3").blur(function() {
        if (this.value == "") {
            $(".bbD:eq(1) #img_no").show();
            $(".bbD:eq(1) #text_no").show();
            $(".bbD:eq(1) #text_no").html("密码为空！");
        } else if (this.value == $(".bbD:eq(0) .input3").val()) {
            $(".bbD:eq(1) #img_no").show();
            $(".bbD:eq(1) #img_ok").hide();
            $(".bbD:eq(1) #text_no").show();
            $(".bbD:eq(1) #text_no").html("密码不能和用户名相同！！！");
        } else if (this.value.length < 6 || this.value.length > 20) {
            $(".bbD:eq(1) #img_no").show();
            $(".bbD:eq(1) #img_ok").hide();
            $(".bbD:eq(1) #text_no").show();
            $(".bbD:eq(1) #text_no").html("密码必须是6-20个字符！");
        } else {
            $(".bbD:eq(1) #img_no").hide();
            $(".bbD:eq(1) #img_ok").show();
        }

    });
    $(".bbD:eq(1) .input3").focus(function() {
        $(".bbD:eq(1) #img_no").hide();
        $(".bbD:eq(1) #text_no").hide();
        $(".bbD:eq(1) #img_ok").hide();
    });

})
//password判断 JS end！

//conformpassword名判断 JS
$(function() {
    $(".bbD:eq(2) .input3").blur(function() {
        if ($(".bbD:eq(1) .input3").val() != this.value) {
            $(".bbD:eq(2) #img_no").show();
            $(".bbD:eq(2) #img_ok").hide();
            $(".bbD:eq(2) #text_no").show();
            $(".bbD:eq(2) #text_no").html("两次密码输入不一致！！！");
        } else {
            $(".bbD:eq(2) #img_no").hide();
            $(".bbD:eq(2) #img_ok").show();
        }

    });
    $(".bbD:eq(2) .input3").focus(function() {
        $(".bbD:eq(2) #img_no").hide();
        $(".bbD:eq(2) #text_no").hide();
        $(".bbD:eq(2) #img_ok").hide();
    });

})
//conformpassword判断 JS end！

//email判断 JS
$(function() {
    $(".bbD:eq(3) .input3").blur(function() {
        var atpos = this.value.indexOf("@");
        var dotpos = this.value.indexOf(".");
        if (this.value == "") {
            $(".bbD:eq(3) #img_no").show();
            $(".bbD:eq(3) #text_no").show();
            $(".bbD:eq(3) #text_no").html("email为空");
        } else if(atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= this.value.length){
            $(".bbD:eq(3) #img_no").show();
            $(".bbD:eq(3) #text_no").show();
            $(".bbD:eq(3) #text_no").html("不是有效的email地址！！！");
        }   else {
            $(".bbD:eq(3) #img_no").hide();
            $(".bbD:eq(3) #img_ok").show();
        }

    });
    $(".bbD:eq(3) .input3").focus(function() {
        $(".bbD:eq(3) #img_no").hide();
        $(".bbD:eq(3) #text_no").hide();
        $(".bbD:eq(3) #img_ok").hide();
    });

})
//email判断 JS end！

//phone判断 JS
$(function() {
    $(".bbD:eq(6) .input3").blur(function() {
        //alert(parseInt(this.value))    
        if (checknumber(this.value)) {
            $(".bbD:eq(6) #img_no").show();
            $(".bbD:eq(6) #text_no").show();
            $(".bbD:eq(6) #text_no").html("请输入正确的电话号码！");
       }else {
            $(".bbD:eq(6) #img_no:eq(0)").hide();
            $(".bbD:eq(6) #img_ok:eq(0)").show();
       }

    });
    $(".bbD:eq(6) .input3").focus(function() {
        $(".bbD:eq(6) #img_no").hide();
        $(".bbD:eq(6) #text_no").hide();
        $(".bbD:eq(6) #img_ok").hide();
    });

})
function checknumber(phone) { 
　　　　var Letters = "1234567890"; 
　　　　var i; 
　　　　var c; 
　　　　for( i = 0; i < phone.length  ; i ++ )   {   //Letters.length() ->>>>取字符长度
　　　　　　c = phone.charAt( i ); 
　　　　　　if (Letters.indexOf( c ) ==-1)   { //在"Letters"中找不到"c"   见下面的此函数的返回值
　　　　　　　　return true; 
　　　   　　} 
　　　　} 
　　　　return false; 
}
//phone判断 JS end！

//表单提交submit JS
$("form").submit(function(){
    alert($("#img_ok").css('display'))
})
//表单提交submit JS END !