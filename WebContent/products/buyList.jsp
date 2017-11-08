<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="utf-8">
<title>已购产品</title>
<meta name="viewPort" content="width=device-width, initial-scale=1.0">
<meta name="author" content="小胖">
<link rel="stylesheet" href="./css/product.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/common.js"></script>
<script type="text/javascript">
	function checkDelete() {
		if (confirm("你确定要退订吗？")) {
			alert("退订成功！");
			return true
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<div id="content">
		<h2>已购产品</h2>
		<hr />
		<table class="table" id="table">
			<thead>
				<tr id="trHead">
					<td align="center">投资号</td>
					<td align="center">起购时间</td>
					<td align="center">到期时间</td>
					<td align="center">预计收益</td>
					<td align="center">购买份数</td>
					<td align="center">起购金额</td>
					<td align="center">操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${investments }" var="temp">
					<tr>
						<td align="center">${temp.investmentId }</td>
						<td align="center">${temp.beginTime }</td>
						<td align="center">${temp.overTime }</td>
						<td align="center">${temp.earning }</td>
						<td align="center">${temp.number }</td>
						<td align="center">${temp.principal }</td>
						<td align="center"><a
							href="investmentAction!deleteInvestById?investment.investmentId=${temp.investmentId }"
							class="buy" onclick="return checkDelete()">退订</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>