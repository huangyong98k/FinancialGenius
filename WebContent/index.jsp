<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>理财精灵</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <!-- 引入 jQuery 库 -->
    <script src="jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <!-- 引入自定义公用 js 库 -->
    <script src="js/common.js" type="text/javascript"></script>
</head>
<body>
<div id="main">
    <div id="head"><img class="headlogo" src="image/logo.png" alt="">
        <div class="name">理财精灵</div>
        <div class="signature">-您的专属理财管家</div>
        <a href="login.jsp" target="top"><span class="help" id="help">登录</span></a><a href="register.html" target="top"><span class="quit" id="quit">注册</span></a>
        <a href="index.html"><span class="exit" id="exit">退出</span></a>
        <a href="userInfo/member_center.html" target="mainFrame"><span class="my_info" id="my_info">个人中心</span></a>
      </div>
    <div class="menu-card-2 topnav" id="topnav" style="position: relative;">
        <div style="overflow:auto;">
            <div class="menu-bar menu-left" style="width:100%;overflow:hidden;">
                <a class="menu-bar-item menu-button" title="理财首页" id="index" href="indexMain.html"
                target="mainFrame">理财首页</a>
                <a class="menu-bar-item menu-button " title="网贷投资" id="investment" href="statistics/dataStatistics.jsp" target="mainFrame">数据统计</a>
                <a class="menu-bar-item menu-button" title="理财产品" id="financial-product" href="productAction!findAllProducts" target="mainFrame">理财产品</a>
                <a class="menu-bar-item menu-button" title="已购产品" id="buy-product" href="userAction!getInvestmentById" target="mainFrame">已购产品</a>
            </div>
        </div>
    </div>
    <div id="maindiv">
     <iframe src="indexMain.html" frameborder="0" scrolling="no" name="mainFrame" height="100%" width="100%">
     </iframe>
     </div>
	
</div>
</body>
<script type="text/javascript">
$(document).ready(function (event) {
	var $userId = '<%=session.getAttribute("userId")%>';
	var $nickName = '<%=session.getAttribute("nickName")%>';
	console.log($userId);
	console.log($nickName);
	if($userId==1){
		$("#my_info").html($nickName);
		$("#help").css("display","block");
		$("#quit").css("display","block");
		$("#exit").css("display","none");
		$("span#my_info.my_info").click(function(){
				  return false;
		 })
	}else {
		$("#my_info").click(function(){
				$("span#my_info.my_info").unbind("click");
			 })
		$("#help").css("display","none");
		$("#quit").css("display","none");
		$("#exit").css("display","block");
	}
	//$("#my_info").html($nickName);
})
</script>
</html>