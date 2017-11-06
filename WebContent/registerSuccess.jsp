<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<div align="center" id="errorMessage" value=""></div>
	<br>
	<h4 align="center">
		<a href="http://localhost:8080/FinancialGenius/index.html">立即返回</a>
	</h4>
	<script language="JavaScript" type="text/javascript">
		var time = 5;
		var mi = setInterval("errorOut()", 1000);
		document.getElementById("errorMessage").innerHTML = "注册成功，" + time
				+ "秒后返回首页";
		function errorOut() {
			//alert(time);
			if (time > 0) {
				time--;
				document.getElementById("errorMessage").innerHTML = "注册成功，"
						+ time + "秒后返回首页";
			} else {
				window.clearInterval(mi);
				mi = null;
				window.open('http://localhost:8080/FinancialGenius/index.html', '_self');
			}

		}
	</script>
</body>
</html>