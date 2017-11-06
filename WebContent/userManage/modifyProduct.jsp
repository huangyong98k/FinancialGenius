<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>addUser</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript"
	src="https://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<!-- <script type="text/javascript" src="js/adduser.js"></script> -->
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="imgs/coin02.png" /><span>首页 - 产品管理> -</span> 修改产品
			</div>
		</div>
		<div class="page ">
			<!-- 修改产品页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>修改产品</span>
				</div>
				<form action="productAction!do_edit" method="post"
					onsubmit="return fun()")>
					<div class="baBody">
						<div class="bbD1 bbD">
							<input type="hidden" class="input3" value="${product.productId }"
								name="product.productId"> <input type="text"
								class="addUserInfo" value="产品名：" readonly> <input
								id="input-name" type="text" class="input3"
								name="product.productName" value="${product.productName }" /> <img
								id="img_ok" src="imgs/ok.png"><img id="img_no"
								src="imgs/no.png"> <span id="span-name"></span>
						</div>
						<div class="bbD">
							<input type="text" class="addUserInfo" value="产品利率：" readonly>
							<input id="input-rate" type="text" class="input3"
								name="product.productRate" value="${product.productRate }" /> <img
								id="img_ok" src="imgs/ok.png"><img id="img_no"
								src="imgs/no.png"> <span id="span-rate"></span>
						</div>
						<div class="bbD">
							<input type="text" class="addUserInfo" value="购买金额：" readonly>
							<input id="input-capital" type="text" class="input3"
								name="product.productCapital" value="${product.productCapital }" />
							<img id="img_ok" src="imgs/ok.png"><img id="img_no"
								src="imgs/no.png"> <span id="span-capital"></span>
						</div>
						<div class="bbD">
							<input type="text" class="addUserInfo" value="发行机构：" readonly>
							<input id="input-org" type="text" class="input3"
								name="product.productMechanism"
								value="${product.productMechanism }" /> <img id="img_ok"
								src="imgs/ok.png"><img id="img_no" src="imgs/no.png">
							<span id="span-org"></span>
						</div>
						<div class="bbD">
							<input type="text" class="addUserInfo" value="收益：" readonly>
							<input id="input-money" readonly type="text" class="input3"
								name="product.productMoney" value="${product.productMoney }" />
							<img id="img_ok" src="imgs/ok.png"><img id="img_no"
								src="imgs/no.png"> <span id="span-money"></span>
						</div>
						<div class="bbD">
							<p class="bbDP">
								<input id="input-submit" class="input3" type="submit"
									name="Submit" value="提交"
									style="width: 153px; color: Black; background-color: Aqua" />
								<a id="a-cancel" href="productAction!findProduct"> <input
									id="cancel" class="input3" type="button" name="Submit"
									value="取消" style="width: 153px;" />
								</a>
							</p>
						</div>
					</div>
				</form>
			</div>
			<!-- 修改产品页面样式end -->
		</div>
	</div>
	<script>
	$('#input-name').blur(function(){
		if($(this).val().trim()==""){
			$('#span-name').html("请输入产品名")
		}else{
			$.ajax({
				url : "/FinancialGenius/productAction!findProductByName?product.ProductName="+$(this).val().trim(),
				success:function(data){
						if(data=="0"){
							$('#span-name').html("ok")
							$('#span-rate').html("ok")
							$('#span-capital').html("ok")
							$('#span-org').html("ok")
							
						}else if(data=="1"){
							$('#span-name').html("已存在该产品")
						}
				}
			})
		}
	})
	
	$('#input-rate').blur(function(){
		if($(this).val().trim()==""){
			$('#span-rate').html("请输入产品利率")
		}else if((isNaN($(this).val()))) {
			$('#span-rate').html("请输入数字")
		}else{
			$('#span-rate').html("ok")
			var money=parseFloat($('#input-capital').val())
			var rate=parseFloat($('#input-rate').val())
			money=money*rate+money
			if(isNaN(money)){
				money=0
			}
			$('#input-money').val(money)
		}
	})
	$('#input-capital').blur(function(){
		if($(this).val().trim()==""){
			$('#span-capital').html("请输入购买金额")
		}else if((isNaN($(this).val()))) {
			$('#span-capital').html("请输入数字")
		}else{
			$('#span-capital').html("ok")
			var money=parseFloat($('#input-capital').val())
			var rate=parseFloat($('#input-rate').val())
			money=money*rate+money
			if(isNaN(money)){
				money=0
			}
			$('#input-money').val(money)
		}
	})
	$('#input-org').blur(function(){
		if($(this).val().trim()==""){
			$('#span-org').html("请输入发行机构")
		}else{
			$('#span-org').html("ok")
		}
		}
	)
	
function fun(){
		if($('#span-name').html()=="ok"&&$('#span-rate').html()=="ok"&&$('#span-capital').html()=="ok"&&$('#span-org').html()=="ok"){
			return true
		}else{
			alert("请输入有效数据")
			return false
		}
	}

	
	</script>
</body>
</html>