<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购买产品</title>
<link href="./css/demo.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/products.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
        $("#submit").click(function(){
            var number = $("#number").val();
            var beginDate = $("#beginDate").val();
            var overDate = $("#overDate").val();
            if((number == "" || undefined || null)){
                alert("数量不能为空！");
                return false;
            }else if ((beginDate == "" || undefined || null)) {
                alert("请选择日期！");
                return false;
            }else if ((overDate == "" || undefined || null)) {
                alert("请选择日期！");
                return false;
            }else if(overDate<beginDate){
                alert("到期日期选择有误！")
                return false
            }else if(beginDate==overDate){
                alert("两个日期不能相同");
                return false;
            }
        });

        $("#number").keyup(function(){
            var c=$(this);
            if(/[^\d]/.test(c.val())){//替换非数字字符
                var temp_amount=c.val().replace(/[^\d]/g,'');
                $(this).val(temp_amount);
            }
        });
    });
</script>
</head>
<body>
	<section id="getintouch" class="fadeIn animated">
		<div class="container" style="border-bottom: 0;">
			<h1>
				<span>购买产品</span>
			</h1>
		</div>
		<div class="container">
			<form class="contact" action="investmentAction" method="post"
				id="form">
				<div class="row clearfix">
					<input type="hidden" id="productId" name="productId" readonly
						value="${product.productId }"> <input type="hidden"
						id="status" name="investment.investmentStatus" readonly value="1">
					<div class="lbl">
						<label for="name"> 产品名称</label>
					</div>
					<div class="ctrl">
						<input type="text" id="name" name="name" readonly
							value="${product.productName }">
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="rate"> 利率</label>
					</div>
					<div class="ctrl">
						<input type="text" id="rate" name="rate"
							value="${product.productRate }" readonly>
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="principal"> 起购金额</label>
					</div>
					<div class="ctrl">
						<input type="text" name="investment.principal"
							id="principal" value="${product.productMoney }" readonly>
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="number"> 购买份数</label>
					</div>
					<div class="ctrl">
						<input type="text" name="investment.number" id="number"
							placeholder="请输入你要购买的份数" onchange="earn()">
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="earning"> 预计收益</label>
					</div>
					<div class="ctrl">
						<input type="text" name="investment.earning" id="earning" value=""
							readonly>
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="beginDate"> 起购时间</label>
					</div>
					<div class="ctrl">
						<input type="month" id="beginDate" name="investment.beginDate"
							onchange="earn()">
					</div>
				</div>
				<div class="row clearfix">
					<div class="lbl">
						<label for="overDate"> 到期时间</label>
					</div>
					<div class="ctrl">
						<input type="month" id="overDate" name="investment.overDate"
							onchange="earn()">
					</div>
				</div>
				<div class="row  clearfix">
					<div class="span10 offset2">
						<input style="width: 100%" type="submit" name="submit" id="submit"
							class="submit" value="购买"> <input style="width: 100%"
							type="reset" name="reset" id="reset" class="submit" value="重置">
						<input style="width: 100%" type="button" name="back" id="back"
							class="submit" value="返回"
							onclick="location.href='javascript:history.go(-1);'">
					</div>
				</div>
			</form>
		</div>
	</section>
</body>
</html>