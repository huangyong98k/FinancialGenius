<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="https://www.rong360.com/favicon.ico" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/main.css" />
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
<script src="js/reg.js" type="text/javascript"></script>
</head>
<body>
	<div class="main-header wrap-base wrap-clear">
		<div class="logo wrap-left">
			<a href="/zhigou"> <img src="image/logoko.png">
			</a>
		</div>
		<p class="tit border-1-e5 wrap-left">登录</p>
	</div>
	<div class="login wrap-clear wrap-base" style="margin: 10px auto 80px;">
		<div class="login-lists">
			<ul id="loginTab" class="login-tab wrap-clear">
				<li class="wrap-left on">普通用户</li>
				<li class="wrap-left s2">手机验证码登录</li>
			</ul>
			<div id="loginTabCon">
				<div class="login-tab-con">
					<form action="userAction!login" method="post" id="pwdLoginForm">
						<div class="login-list">
							<div id="pwdLoginTip" class="tip-error"></div>
							<div class="item">
								<input type="text" name="email" class="txt"
									placeholder="手机号/用户名" />
							</div>
						</div>
						<div class="login-list">
							<div class="tip-error"></div>
							<div class="item">
								<input type="password" name="userPassword" class="txt"
									placeholder="密码" />
							</div>
						</div>
						<div class="login-list wrap-clear none" id="loginVcodeContain">
							<div class="tip-error"></div>
							<div class="wrap-clear vcode item">
								<input type="text" name="PwdVcode" class="txt" placeholder="验证码"
									maxlength="4" />
								<div class="vcode-area wrap-clear">
									<img id="loginVcodeImg" src="" /> <a id="loginFreshCode"
										href="javascript:;"><i class="sprite pngfix sprite-fresh"></i></a>
								</div>
							</div>
						</div>
						<div class="remeber-me wrap-clear">
							<div class="wrap-left">
								<label> <input type="checkbox" name="remember" />1个月内自动登录
								</label>
							</div>
							<div class="wrap-right">
								<a class="lost-pwd" href="">忘记密码？</a>
							</div>
						</div>
						<input type="submit" id="pwdLoginBtn" class="btn btn-red"
							value="登录" />
					</form>
					<div class="login-reg">
						<p class="p1">
							<a class="btn btn-unable" href="">注册理财精灵账户</a>
						</p>
						<p class="p5">
							原论坛用户请先<a href="">绑定手机号</a>&nbsp;<i
								data-tip="原论坛用户登录后可以完成账号升级。<a href='http://bbs.rong360.com/thread-42559-1.html' target='_blank'>需求更多帮/a>"
								class="sprite sprite-tip pngfix"></i>
						</p>
					</div>
				</div>
				<div class="login-tab-con none">
					<form action="/" method="post" id="vvcodeLoginForm">
						<div class="login-list">
							<div id="vvcodeLoginTip" class="tip-error"></div>
							<div class="item">
								<input type="text" name="vmobile" class="txt" placeholder="手机号" />
							</div>
						</div>
						<div class="login-list wrap-clear">
							<div class="tip-error"></div>
							<div class="wrap-clear vcode item">
								<input type="text" name="vvcode" class="txt" placeholder="验证码"
									maxlength="4" />
								<div class="vcode-area wrap-clear">
									<img id="vregVcodeImg" src="" /> <a id="vregFreshCode"
										href="javascript:;"><i class="sprite pngfix sprite-fresh"></i></a>
								</div>
							</div>
						</div>
						<div class="validate-phone">
							<div class="tip-error"></div>
							<div class="con">
								<div class="msg-vcode" id="vregCaptchaCon">
									<input type="text" name="vcaptcha" class="txt"
										placeholder="短信验证码" /> <span class="none"><i
										class="num">59</i>秒后重新获取</span> <a class="on" id="vregCaptchaBtn"
										href="javascript:;">获取短信验证码</a>
								</div>
								<div id="vregCaptchaTip" class="tip-error"></div>
							</div>
						</div>
						<input id="vvcodeLoginBtn" type="button" value="验证并登录"
							class="btn btn-red" />
					</form>
				</div>
			</div>
			<div class="login-reg">
				<div class="p2">
					<p class="p3">一个帐号，享受以下理财精灵服务</p>
					<div class="p4">
						<a href="javascript:;">信用卡</a><a href="javascript:;">理财</a><a
							href="javascript:;">论坛</a>
					</div>
					<p class="p3" style="margin-bottom: 0;">
						登录即表示您同意 <a style="color: #3366cc;" target="_blank"
							href="/zhigou/site/bbsregisteragreement">《理财精灵网站用户注册协议》</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="bottom clearfix">
		<div class="about-links">
			<a href="http://www.rong360.com/about" class="footer" rel="nofollow"
				target="_blank">关于理财精灵</a><span class="spliter">|</span> <a
				href="/zhigou/loan-questions" class="footer" rel="nofollow"
				target="_blank">常见问题</a><span class="spliter">|</span> <a
				href="http://www.rong360.com/about/contact.html" class="footer"
				rel="nofollow" target="_blank">联系我们</a><span class="spliter">|</span>
			<a href="javascript:void(0);" class="footer"
				id="showhide_footer_calc">贷款计算器</a><span class="spliter">|</span> <a
				href="javascript:void(0);" class="footer"
				id="showhide_footer_creditlist">热门信用卡申请</a><span class="spliter">|</span>
			<a href="http://www.rong360.com/about/joinus.html" class="footer"
				rel="nofollow" target="_blank">加入我们</a><span class="spliter">|</span>
			<a href="http://www.rong360.com/about/cooperation.html"
				class="footer" rel="nofollow" target="_blank">市场合作</a><span
				class="spliter">|</spa> <a
				href="http://www.rong360.com/about/disclaimer.html" class="footer"
				rel="nofollow" target="_blank">免责声明</a><span class="spliter">|</span>
				<a href="http://www.rong360.com/about/feedback.html" class="footer"
				rel="nofollow" target="_blank">建议与投诉</a><span class="spliter">|</span>
				<a href="http://www.rong360.com/sitemap" class="footer"
				target="_blank">网站地图</a>
		</div>
		<div class="block-a seo-block-footer" id="footer_calc"
			style="display: none;">
			<div class="seo-block">
				<div class="block-content">
					<ul class="hot_city_list clearfix">
					</ul>
				</div>
			</div>
		</div>
		<div class="block-a seo-block-footer" id="footer_citylist"
			style="display: none;">
			<div class="seo-block">
				<div class="block-title block-in" style="display: none;">热门城市贷款</div>
				<div class="block-content">
					<ul class="hot_city_list clearfix">
					</ul>
				</div>
			</div>
		</div>
		<div class="block-a seo-block-footer" id="footer_creditlist"
			style="display: none;">
			<div class="seo-block">
				<div class="block-title block-in" style="display: none;">热门信用卡申请</div>
				<div class="block-content">
					<ul class="hot_city_list clearfix">
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank16">中信银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank4">广发银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank14">招商银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank3">光大银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank10">平安银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank13">兴业银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank5">华夏银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank11">浦发银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank8">民生银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank1">北京银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank7">交通银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank31">花旗银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank6">建设银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank2">工商银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank15">中国银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank9">农业银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank28">广州银行信用卡申请</a></li>
						<li class="fl"><a target="_blank"
							href="http://www.rong360.com/credit/f-card-bank17">包商银行信用卡申请</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div>
			<span class="arial">Copyright &copy; 2015 Rong360.com Inc. All
				Rights Reserved. </span><a href="http://www.miibeian.gov.cn/"
				class="footer" target="_blank" rel="nofollow">京ICP备12000680号-1</a><span
				style="padding-left: 10px;">京公网安备110108008323号</span>
		</div>
		<div class="company">
			理财精灵<a href="http://www.rong360.com/" target="_blank">贷款</a> - 银行<a
				href="http://www.rong360.com/licai/" target="_blank">理财平台</a> 版权所有
		</div>
		<div class="footer-imgs clearfix view_b" style="width: 260px;">
			<a
				href="https://search.szfw.org/entry.php?action=queryLicenseResult&id=808"
				class="fl footer-img-wrap sprite-footer-chengxin pngfix"
				target="_blank" rel="nofollow"></a> <a
				href="https://trustsealinfo.verisign.com/splash?form_file=fdf/splash.fdf&dn=www.rong360.com&lang=zh_cn"
				class="fl footer-img-wrap sprite-footer-vs pngfix" target="_blank"
				rel="nofollow"></a>
		</div>
	</div>
</body>
</html>