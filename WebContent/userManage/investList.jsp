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
        $(".list2 tr").slice(1).each(function() {
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
                })
            })
        })
        $("#btn2").click(function() {
            if ($("#btn2").prop("checked")) {
                $(".check-all2").prop('checked', true)
            } else {
                $(".check-all2").prop('checked', false)
            }
        })
    })
    </script>
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="imgs/coin02.png" /><span>首页&nbsp;-&nbsp;投资管理&nbsp;-</span>&nbsp;投资查询
			</div>
		</div>
		<div class="page">
			<!-- 学生页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<form action="investmentAction!findInvestmentId" method="get">
						<div class="cfD">
							<input class="addUser" type="text" placeholder="输入投资名" 
							name="investment.investmentId"/>
							<input type="submit" class="button" id="search2lol33" value="搜索">
						</div>
					</form>
				</div>
				<!-- 学生 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0" class="list2">
						<tr>

							<td width="435px" class="tdColor">投资编号</td>
							<td width="435px" class="tdColor">起始时间</td>
							<td width="435px" class="tdColor">结束时间</td>
							<td width="435px" class="tdColor">数量</td>
							<td width="435px" class="tdColor">预计收益</td>
							<td width="435px" class="tdColor">状态</td>
							<td width="435px" class="tdColor">本金</td>
							<td width="230px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${list }" var="temp" varStatus="vs">

							<tr height="40px">
								<td>${temp.investmentId}</td>
								<td>${temp.beginTime}</td>
								<td>${temp.overTime }</td>
								<td>${temp.number}</td>
								<td>${temp.earning }</td>
								<td>${temp.investmentStatus}</td>
								<td>${temp.principal}</td>
								<td><img class="operation delban img-delete"
									src="image/delete.png"></td>
							</tr>
						</c:forEach>
						<tr id="one-data" height="40px">
								<td>${investment.investmentId}</td>
								<td>${investment.beginTime}</td>
								<td>${investment.overTime }</td>
								<td>${investment.number}</td>
								<td>${investment.earning }</td>
								<td>${investment.investmentStatus}</td>
								<td>${investment.principal}</td>
								<td><img class="operation delban img-delete"
									src="image/delete.png"></td>
									<tr>
					</table>
					<div class="paging">
						<a href="investmentAction!prevPage"><input type="button"
							name="" id="prey" value="上一页"></a> <a
							href="investmentAction!nextPage"><input type="button" name=""
							id="prop" value="下一页"></a>
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
		var lol="${list}";
		console.log(lol.length)
		if(lol!=null&&lol.length!=0){
			$('#one-data').hide()
		}
		/* else if(lol.length==0){
			$('#one-data').show()
		} */
        $('.img-delete').click(function(){
        $('.a-delete').prop('href','investmentAction!deleteById?investment.investmentId='+$(this).parent().siblings().filter(":eq(0)").html())       

        })
        
        $('#search2lol').click(function(){
        	
					 console.log($('tr:last').index())
					if($('tr:last').index()!==0){
						alert("投资项目不存在 ")
						return false;
					} 
				})
				
				$(document).ready(function(){
					if($('tr:last').index()==0){
						alert("投资项目不存在 ")
						window.history.back(-1); 
					}
				})
        
        
    $('tr').filter(':lt(0)').hide();
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
	})

    </script>
</body>
</html>