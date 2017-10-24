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
function firm() {
    if (confirm("你确定要退订吗？")) {
        alert("点击了确定");
    }
    else {
        alert("点击了取消");
    }
}
</script>
</head>
<body>
	<div id="content">
		<h2>已购产品</h2>
		<hr/>
		<button class="btn1" name="array">按起购金额↓</button>
		<button class="btn2" name="array">按预计收益 ↓</button>
		<button class="btn3" name="array">按月利率 ↓</button>
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
				<c:forEach items="investments" var="temp">
					<tr>
						<td align="center">${temp.investmentId }</td>
						<td align="center">${temp.beginTime }</td>
						<td align="center">${temp.overTime }</td>
						<td align="center">${temp.earning }</td>
						<td align="center">${temp.number }</td>
						<td align="center">${temp.principal }</td>
						<td align="center"><a href="investmentAction!deleteInvestById?investment.investmentId=${temp.investmentId }" class="buy" onclick="firm()">退订</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>