<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="utf-8">
<title>交易记录</title>
<meta name="viewPort" content="width=device-width, initial-scale=1.0">
<meta name="author" content="小胖">
<link rel="stylesheet" href="./css/product.css">
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
</head>
<body>
	<div id="content">
		<h2>交易记录</h2>
		<hr />
		<table class="table" id="table">
			<thead>
				<tr id="trHead">
					<td align="center">交易编号</td>
					<td align="center">交易金额</td>
					<td align="center">交易时间</td>
					<td align="center">交易类型</td>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="temp">
					<tr>
						<td align="center">${temp.rechargeRecordId}</td>
						<td align="center">${temp.money}</td>
						<td align="center">${temp.rechargeTime}</td>
						<td align="center">${temp.rechargeType}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>