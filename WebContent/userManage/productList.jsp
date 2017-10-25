<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="css/css.css">
<script type="text/javascript"
	src="https://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<script type="text/javascript">
    $(function() {
        $(".delban").click(function() {
                $(".banDel").show();
            }),
            $(".close").click(function() {
                $(".banDel").hide();
            }),
            $(".no").click(function() {
                $(".banDel").hide();
            })
        $(".list tr").slice(1).each(function() {

            var p = this;

            $(this).children().slice(1).click(function() {

                $($(p).children()[0]).children().each(function() {

                    if (this.type == "checkbox") {

                        if (!this.checked) {

                            this.checked = true;

                        } else {

                            this.checked = false;

                        }

                    }

                });

            });

        });
       
       $('#btn1').on('click',function(){
       if ($("#btn1").prop('checked')) {
        $(".checkes-all").prop('checked',true)
       }else{
        $(".checkes-all").prop('checked',false)
       }

       })
    })
    </script>
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="imgs/coin02.png" /><span>首页&nbsp;-&nbsp;产品管理&nbsp;-</span>&nbsp;产品查询
			</div>
		</div>
		<div class="page">
			<!-- 学生页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<form>
						<div class="cfD">
							<input class="addUser" type="text" placeholder="输入产品名" />
							<button class="button">搜索</button>
						</div>
					</form>
				</div>
				<!-- 学生 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td hidden width="435px" class="tdColor"><input
								type="checkbox" name="checkbox" id="btn1"></td>
							<td width="435px" class="tdColor">产品编号</td>
							<td width="400px" class="tdColor">产品名</td>
							<td width="630px" class="tdColor">产品利率</td>
							<td width="435px" class="tdColor">购买金额</td>
							<td width="435px" class="tdColor">发行机构</td>
							<td width="435px" class="tdColor">收益</td>
							<td width="230px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${list }" var="temp" varStatus="vs">
							<tr height="40px">
								<td hidden><input type="checkbox" name="checkbox"
									class="checkes-all"></td>
								<td>${temp.productId}</td>
								<td>${temp.productName}</td>
								<td>${temp.productRate}</td>
								<td>${temp.productCapital}</td>
								<td>${temp.productMechanism}</td>
								<td>${temp.productMoney}</td>
								<td><a
									href="productAction!to_edit?product.productId=${temp.productId }"><img
										class="operation" src="imgs/update.png"></a><img
									class="operation delban img-delete" src="imgs/delete.png"></td>

							</tr>
						</c:forEach>
					</table>
					<div class="paging">此处是分页<input type="submit" name="" id="prey" value="上一页"> <input
							type="submit" name="" id="prop" value="下一页"></div>
				</div>
				<!-- 学生 表格 显示 end-->
			</div>
			<!-- 学生页面样式end -->
		</div>
	</div>
	<!-- 删除弹出框 -->
	<div class="banDel">
		<div class="delete">
			<div class="close">
				<a><img src="imgs/shanchu.png" /></a>
			</div>
			<p class="delP1">你确定要删除此条记录吗？</p>
			<p class="delP2">
				<a href="#" class="ok yes a-delete">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div>
	<!-- 删除弹出框  end-->
	<script type="text/javascript">
        $('.img-delete').click(function(){
        $('.a-delete').prop('href','productAction!deleteById?product.productId='+$(this).parent().siblings().filter(":eq(1)").html())       

        })
/* $('tr').filter(':lt(0)').hide();
	$('tr').filter(':gt(5)').hide();
	var one = 1;
	var two = 5;
	var max = $('tr:last').index();
	$('#prey').click(function() {
		if (one > 1) {
			one -= 5;
			two -= 5;
			$('tr').show();
			$('tr').filter(':lt(' + one + ')').hide();
			$('tr').filter(':gt(' + two + ')').hide();
			$('tr').filter(':eq(0)').show();
		}
	})
	$('#prop').click(function() {
		if (two < max) {
			one += 5;
			two += 5;
			$('tr').show();
			$('tr').filter(':lt(' + one + ')').hide();
			$('tr').filter(':gt(' + two + ')').hide();
			$('tr').filter(':eq(0)').show();
		}
	}) */
    </script>
</body>
</html>