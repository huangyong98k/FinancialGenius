<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="utf-8">
<title>产品大全</title>
<meta name="viewPort" content="width=device-width, initial-scale=1.0">
<meta name="author" content="小胖">
<link rel="stylesheet" href="./css/product.css">
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
</head>
<body>
	<div id="content">
		<h2>产品大全</h2>
		<hr />
		<table class="table" id="table">
			<thead>
				<tr id="trHead">
					<td align="center">产品号</td>
					<td align="center">产品名称</td>
					<td align="center">目前资金规模/万元</td>
					<td align="center">月利率</td>
					<td align="center">起购金额</td>
					<td align="center">发行机构</td>
					<td align="center">产品类型</td>
					<td align="center">操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="temp">
					<tr>
						<td align="center">${temp.productId }</td>
						<td align="center">${temp.productName }</td>
						<td align="center">${temp.productCapital }</td>
						<td align="center">${temp.productRate }</td>
						<td align="center">${temp.productMoney }</td>
						<td align="center">${temp.productMechanism }</td>
						<td align="center">${temp.productType }</td>
						<td align="center"><a target="mainFrame"
							href="productAction!addInvestment?product.productId=${temp.productId }&product.productMoney=${temp.productMoney }&product.productName=${temp.productName }&product.productRate=${temp.productRate }"
							class="buy">购买</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="paging">
			<a href="productAction!prevFrontPage"><input type="button"
				name="" class="prey" value="上一页"></a> <a
				href="productAction!nextFrontPage"><input type="button" name=""
				class="next" value="下一页"></a>
		</div>
	</div>
</body>
</html>