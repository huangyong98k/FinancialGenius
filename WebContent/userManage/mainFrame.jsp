<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<link rel="stylesheet" type="text/css" href="css/public.css">
<script type="text/javascript" src="https://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/public.js"></script>

<script type="text/javascript">
$(function() {
    $(".goOut").click(function() {
        $(".closeOut").show();
    }),
    $(".p1").click(function() {
        $(".closeOut").hide();
    }),
    $(".no").click(function() {
        $(".closeOut").hide();
    })

})
</script>

<body>
	<!-- 头部head -->
	<header class="head">
	<div class="headL">
		<img class="headLogo" src="" />
	</div>
	<div class="headT">
		<h1>后 台 管 理 系 统</h1>
	</div>
	<div class="headR">
		<p class="p1">当前：</p>
		<p class="p2">
			<span class="resetPWD">帮助</span>&nbsp;&nbsp;<span class="goOut">退出</span>
		</p>
	</div>
	<!-- onclick="{if(confirm(&quot;确定退出吗&quot;)){return true;}return false;}" -->
	<div class="closeOut">
		<div class="coDiv">
			<p class="p1">
				<span>X</span>
			</p>
			<p class="p2">确定退出当前用户？</p>
			<P class="p3">
				<a class="ok yes" href="#">确定</a><a class="ok no" href="#">取消</a>
			</p>
		</div>
	</div>
	</header>
	<!-- 头部head END!!! -->

	<!-- 左边导航栏！ -->
	<div class="container">

		<div class="leftsidebar_box">
			<a href="main.jsp" target="main"><div class="line">
					<img src="imgs/coin01.png" />&nbsp;&nbsp;首页
				</div></a>
			<!-- <dl class="system_log">
			<dt><img class="icon1" src="../img/coin01.png" /><img class="icon2"src="../img/coin02.png" />
				首页<img class="icon3" src="../img/coin19.png" /><img class="icon4" src="../img/coin20.png" /></dt>
		</dl> -->
			<dl class="system_log">
				<dt>
					<img class="icon1" src="imgs/coin07.png" /><img class="icon2"
						src="imgs/coin08.png" />用户管理<img class="icon3"
						src="imgs/coin19.png" /><img class="icon4" src="imgs/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="imgs/coin111.png" /><img class="coin22"
						src="imgs/coin222.png" /><a href="userAction!findUser"
						target="main" d class="cks">用户查询</a><img class="icon5"
						src="imgs/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="imgs/coin111.png" /><img class="coin22"
						src="imgs/coin222.png" /><a href="addUser.jsp" target="main"
						class="cks">用户新增</a><img class="icon5" src="imgs/coin21.png" />
				</dd>
			</dl>
			<!-- 投资管理 -->
			<dl class="system_log">
				<dt>
					<img class="icon1" src="imgs/coin07.png" /><img class="icon2"
						src="imgs/coin08.png" />投资管理<img class="icon3"
						src="imgs/coin19.png" /><img class="icon4" src="imgs/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="imgs/coin111.png" /><img class="coin22"
						src="imgs/coin222.png" /><a
						href="InvestmentAction!findInvestment" target="main" d class="cks">投资查询</a><img
						class="icon5" src="imgs/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="imgs/coin111.png" /><img class="coin22"
						src="imgs/coin222.png" /><a
						href="InvestmentAction!findInvestment2" target="main" class="cks">投资失效</a><img
						class="icon5" src="imgs/coin21.png" />
				</dd>
			</dl>
			<!-- 投资管理 -->

			<!-- 产品管理 -->
			<dl class="system_log">
				<dt>
					<img class="icon1" src="imgs/coin07.png" /><img class="icon2"
						src="imgs/coin08.png" />产品管理<img class="icon3"
						src="imgs/coin19.png" /><img class="icon4" src="imgs/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="imgs/coin111.png" /><img class="coin22"
						src="imgs/coin222.png" /><a href="productAction!findProduct"
						target="main" d class="cks">产品查询</a><img class="icon5"
						src="imgs/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="imgs/coin111.png" /><img class="coin22"
						src="imgs/coin222.png" /><a href="addProduct.jsp" target="main"
						class="cks">产品新增</a><img class="icon5" src="imgs/coin21.png" />
				</dd>
			</dl>
			<!-- 产品管理 -->
		</div>

	</div>
	<!-- 左边导航栏END！ -->

	<!-- 右边主要内容 -->
	<div id="main">
		<iframe src="main.jsp" frameborder="0" scrolling="no" name="main"
			height="100%" width="100%"> </iframe>
	</div>
	<!-- 右边主要内容END！ -->
</body>
</html>