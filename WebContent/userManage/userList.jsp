<%@page import="org.aspectj.apache.bcel.util.ClassPath"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/css.css">
<script type="text/javascript"
	src="https://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/public.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delban").click(function() {
			$(".banDel").show();
		}), $(".close").click(function() {
			$(".banDel").hide();
		}), $(".no").click(function() {
			$(".banDel").hide();
		})
	})
</script>
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="userManage/imgs/coin02.png" /><span>首页&nbsp;-&nbsp;用户管理&nbsp;-</span>&nbsp;用户查询
			</div>
		</div>
		<div class="page">
			<!--  用户页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<form action="userAction!findByName" method="get">
						<div class="cfD">
							<input class="addUser" type="text" placeholder="请输入用户名"
								name="user.userName" value="" /> <input id="search"
								type="submit" class="button" value="搜索">
						</div>
					</form>
				</div>
				<!--  用户 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td hidden width="435px" class="tdColor"><input
								type="checkbox" name=""></td>
							<td hidden="hidden">id</td>
							<td width="435px" class="tdColor">用户名</td>
							<td width="400px" class="tdColor">身份证号码</td>
							<td width="630px" class="tdColor">邮箱</td>
							<td width="435px" class="tdColor">余额</td>
							<td width="435px" class="tdColor">电话</td>
							<td width="230px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${list }" var="temp" varStatus="vs">
							<tr height="40px">
								<td hidden width="435px" class="tdColor"><input
									type="checkbox" name=""></td>
								<td hidden>${temp.userId}</td>
								<td>${temp.userName}</td>
								<td>${temp.userCard }</td>
								<td>${temp.userEmail }</td>
								<td>${temp.userBanlance }</td>
								<td>${temp.userPhone }</td>
								<td><a
									href="userAction!to_edit?user.userId=${temp.userId }"><img
										class="operation"
										src="<%=request.getContextPath() %>/image/update.png"></a> <img
									class="operation delban img-delete"
									src="<%=request.getContextPath() %>/image/delete.png"></td>
							</tr>
						</c:forEach>
					</table>
					<div class="paging">
						此处是分页<a href="userAction!prevPage"><input type="button"
							name="" id="prey" value="上一页"></a> <a
							href="userAction!nextPage"><input type="button" name=""
							id="prop" value="下一页"></a>
					</div>
				</div>
				<!--  用户 表格 显示 end-->
			</div>
			<!--  用户页面样式end -->
		</div>
	</div>
	<!-- 删除弹出框 -->
	<div class="banDel">
		<div class="delete">
			<div class="close">
				<a><img src="userManage/imgs/shanchu.png" /></a>
			</div>
			<p class="delP1">你确定要删除此条记录吗？</p>
			<p class="delP2">
				<a href="#" class="ok yes a-delete">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div>
	<!-- 删除弹出框  end-->
	<script type="text/javascript">
		$('.img-delete').click(
				function() {
					$('.a-delete').prop(
							'href',
							'userAction!deleteById?user.userId='
									+ $(this).parent().siblings().filter(
											":hidden").filter(":eq(1)").html())
				})
				$('#search').click(function(){
					console.log($('tr:last').index())
					if($('tr:last').index()==0){
						alert("用户不存在 ")
						return false;
					}
				})
				$(document).ready(function(){
					if($('tr:last').index()==0){
						alert("用户不存在 ")
						window.history.back(-1); 
					}
				})
		
				
				
				
	/* 
	前端分页
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
	}) */
	</script>
</body>
</html>