<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>统计报表</title>
<link rel="stylesheet" href="css/data.css" />
<script src='./js/jquery-3.2.1.min.js'></script>
<script src='./js/ichart.1.2.min.js'></script>
<script src="./js/echarts.js"></script>
<script src='./js/data.js'></script>
</head>
<body>
	<!--  统计图-->
	<div class="header">
		<!-- ç»è®¡å¾-->
		<div id="total">
			<div id="main"></div>

			<div id="sub"></div>

			<div id="aside"></div>
		</div>

		<!--  数据报表-->
		<div class="main-flow">
			<div class="map">
				<div class="map-l fl" id="map-l"></div>
				<div class="map-r fl">
					<table>
						<thead>
							<tr>
								<th>产品名称</th>
								<th>投资人数</th>
								<th>总</th>
								<th>完成度</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="map-r-tbody">

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>