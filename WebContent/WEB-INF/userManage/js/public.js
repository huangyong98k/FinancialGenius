//head.html 的弹出框 JS
$(".goOut").click(function() {
    $(".closeOut").show();
});
$(".p1").click(function() {
    $(".closeOut").hide();
});
$(".no").click(function() {
    $(".closeOut").hide();
});
//head.html 的弹出框 JS  end


//userList.html 删除的弹出框 JS
$(".delban").click(function() {
    $(".banDel").show();
});
$(".close").click(function() {
    $(".banDel").hide();
});
$(".no").click(function() {
    $(".banDel").hide();
});
//userList.html 删除的弹出框 JS  end

// left.html 的切换节点  JS
$(function() {
    // 点击展开事件，切换图片
    $(".leftsidebar_box dt").click(function() {
        // 先处理掉所有存在的节点,再判断是否存在
        $('.icon1').hide();
        $('.icon2').show();
        $(".leftsidebar_box dt").removeClass('menu_chioce1');
        if ($(this).parent().find('dd').is(":hidden")) {
            $(this).parent().find('.icon1').show();
            $(this).parent().find('.icon2').hide();
            $(this).parent().find('.icon3').show();
            $(this).parent().find('.icon4').hide();
            $(this).addClass('menu_chioce1');
        } else {
            $(this).parent().find('.icon1').hide();
            $(this).parent().find('.icon2').show();
            $(this).parent().find('.icon3').hide();
            $(this).parent().find('.icon4').show();
            $(this).removeClass('menu_chioce1');
        }
        $(this).parent().find('dd').removeClass("menu_chioce");
        $(".menu_chioce").slideUp();
        $(this).parent().find('dd').slideToggle();
        $(this).parent().find('dd').addClass("menu_chioce");


    });
    $(".cks").click(function() {
        // 先处理掉所有存在的节点,再判断是否存在
        $(".icon5").hide();
        $('.coin11').hide();
        $('.coin22').show();
        $(this).parent().find('.coin11').show();
        $(this).parent().find('.coin22').hide();
        $(".leftsidebar_box .cks").removeClass('menu_chioce2');
        if ($(this).parent().find('.icon5').is(":hidden")) {
            $(this).addClass('menu_chioce2');
            $(this).parent().find('.icon5').show();
        } else {
            $(this).removeClass('menu_chioce2');
            $(this).parent().find('.icon5').hide();
        }


    });
})
// left.html 的切换节点  JS end

//用户名判断 JS
$(function() {
    $("#userName").blur(function() {
        if (this.value == "") {
            $("#img_no:eq(0)").show();
            $("#text_no:eq(0)").show();
            $("#text_no:eq(0)").html("用户名为空");
        } else if (this.value.length < 6 || this.value.length > 20) {
            $("#img_no:eq(0)").show();
            $("#img_ok:eq(0)").hide();
            $("#text_no:eq(0)").show();
            $("#text_no:eq(0)").html("用户名必须是6-20个字符！");
        } else {
            $("#img_no:eq(0)").hide();
            $("#img_ok:eq(0)").show();
        }

    });
    $("#userName").focus(function() {
        $("#img_no:eq(0)").hide();
        $("#text_no:eq(0)").hide();
        $("#img_ok:eq(0)").hide();
    });

})
//用户名判断 JS end！

//phone判断 JS
$(function() {
    $("#phone").blur(function() {
        //alert(parseInt(this.value))    
        if (checknumber(this.value)) {
            $(".bbD:eq(4) #img_no").show();
            $(".bbD:eq(4) #text_no").show();
            $(".bbD:eq(4) #text_no").html("请输入正确的电话号码！");
       }else {
            $(".bbD:eq(4) #img_no:eq(0)").hide();
            $(".bbD:eq(4) #img_ok:eq(0)").show();
       }

    });
    $("#phone").focus(function() {
        $(".bbD:eq(4) #img_no").hide();
        $(".bbD:eq(4) #text_no").hide();
        $(".bbD:eq(4) #img_ok").hide();
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

//email判断 JS
$(function() {
    $("#email").blur(function() {
        var atpos = this.value.indexOf("@");
        var dotpos = this.value.indexOf(".");
        if (this.value == "") {
            $(".bbD:eq(5) #img_no").show();
            $(".bbD:eq(5) #text_no").show();
            $(".bbD:eq(5) #text_no").html("email为空");
        } else if(atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= this.value.length){
            $(".bbD:eq(5) #img_no").show();
            $(".bbD:eq(5) #text_no").show();
            $(".bbD:eq(5) #text_no").html("不是有效的email地址！！！");
        }   else {
            $(".bbD:eq(5) #img_no").hide();
            $(".bbD:eq(5) #img_ok").show();
        }

    });
    $("#email").focus(function() {
        $(".bbD:eq(5) #img_no").hide();
        $(".bbD:eq(5) #text_no").hide();
        $(".bbD:eq(5) #img_ok").hide();
    });

})
//email判断 JS end！



