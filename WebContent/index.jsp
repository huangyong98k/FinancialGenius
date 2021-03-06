	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <head>
        <meta charset="utf-8">
        <title>理财精灵</title>
        <link rel="stylesheet" type="text/css" href="css/public.css">
        <link rel="stylesheet" type="text/css" href="css/test.css">
        <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
</head>

<body>
<div id="home">
    <!-- 头部 begin -->
    <div class="header">
        <div class="inner">
            <ul class="service">
                <li class="hotline"><i class="icons"></i><b>客服热线</b><em>123 456 7890</em></li>
                <li class="concerns"><b>关注我们</b><a href="http://e.weibo.com/yoolicom" target="_blank" class="icons weibo" rel="nofollow">有利网新浪官方微博</a><a href='javascript:;' target="_blank" class="icons weixin">有利网官方微信</a></li>
            </ul>
            <div class="loginbar">
                <div class="for">
                    <a href="#" class="concerns" style="color:#a2acb3; margin-right:10px;">理财精灵俱乐部</a>
                    <a data-hm="navigation, nav_my_download" href="http://e.yooli.com/static/download/" style="color:#a2acb3;">关于我们<i class="icons app-yl"></i></a>
                    <a  data-hm="navigation, nav_register" href="loginAction!quit.action" style="color:#fc8936" rel="nofollow">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a data-hm="navigation, nav_login" href="userInfo/member_center.jsp" target="mainFrame" style="color:#349cd8">${nickName }</a></div>
                <!-- <a data-hm="navigation, nav_login" href='/secure/login/' style="color:#349cd8;display: none;">个人中心</a></div> -->
            </div>
            <div id="bg">
                <img src="image/bg.png" width="300" height="90" style="margin-top: 50px">
            </div>
            <div class="userbar">
                <!-- 导航栏 -->
                <ul class="nav nav-pills">
                    <li id="li_1" class="active"><a href="indexMain.html" target="mainFrame">首页</a></li>
                    <li id="li_2"><a href="statistics/dataStatistics.jsp" target="mainFrame">数据统计</a></li>
                    <li id="li_3"><a href="productAction!findAllProducts" target="mainFrame">理财产品</a></li>
                    <li id="li_4"><a href="xinshou.html" target="mainFrame">新手指引</a></li>
                    <li id="li_5"><a href="userAction!getInvestmentById" target="mainFrame">已购产品</a></li>
                </ul>
            </div>
        </div>
        <div class="b"></div>
    </div>
    <!-- 头部 end! -->
    <!-- 中间iframe -->
    <div id="myFrame">
        <iframe src="indexMain.html" name="mainFrame" id="mainFrame" frameborder="false" scrolling="no" style="border:none;" width="100%" height="100%" allowtransparency="true">
        </iframe>
    </div>
    <!-- 中间iframe end!-->
    <!-- 合作伙伴 -->
    <div class="zscf_con px1000">
        <div class="zscf_partner mt30">
            <h2 class="block3_tit clearfix ">
                    <span class="block3_curspan">合作伙伴</span>
                </h2>
            <div class="partner_con">
                <div id="demo">
                    <div id="indemo">
                        <div id="demo1">
                            <a href="javascript:;"><img
                                    src="http://www.whzxcf.com/statics/home/images/zxcf_i1.png"
                                    border="0" /></a> <a href="javascript:;"><img
                                    src="http://www.whzxcf.com/statics/home/images/zxcf_i2.png"
                                    border="0" /></a> <a href="javascript:;"><img
                                    src="http://www.whzxcf.com/statics/home/images/zxcf_i3.png"
                                    border="0" /></a> <a href="javascript:;"><img
                                    src="http://www.whzxcf.com/statics/home/images/zxcf_i4.png"
                                    border="0" /></a> <a href="javascript:;"><img
                                    src="http://www.whzxcf.com/statics/home/images/zxcf_i5.png"
                                    border="0" /></a> <a href="javascript:;"><img
                                    src="http://www.whzxcf.com/statics/home/images/zxcf_i6.png"
                                    border="0" /></a> <a href="javascript:;"><img
                                    src="http://www.whzxcf.com/statics/home/images/zxcf_i7.png"
                                    border="0" /></a> <a href="javascript:;"><img
                                    src="http://www.whzxcf.com/statics/home/images/zxcf_i8.png"
                                    border="0" /></a> <a href="javascript:;"><img
                                    src="http://www.whzxcf.com/statics/home/images/zxcf_i9.png"
                                    border="0" /></a> <a href="javascript:;"><img
                                    src="http://www.whzxcf.com/statics/home/images/zxcf_i10.png"
                                    border="0" /></a>
                        </div>
                        <div id="demo2"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 合作伙伴 end!-->
     <footer>
        <div class="container">
            <div class="row">
                <div class="col-sm-2">
                    <h6>Copyright &copy;新浪体育</h6>
                </div>
                
                <div class="col-sm-4">
                    <h6>关于我们</h6>
                    <p>
                        中国上海/2014年8月14日 — 服务于中国及全球华人社群的领先在线媒体公司新浪公司(NASDAQ GS: SINA)今日公布了截至2014年6月30日的第二季度未经审计的财务报告。
                    </p>
                </div>
                
                <div class="col-sm-2">
                    <h6>导航</h6>
                    <ul class="unstyled">
                        <li><a href="">主页</a></li>
                        <li><a href="">服务</a></li>
                        <li><a href="">链接</a></li>
                        <li><a href="">联系我们</a></li>
                    </ul>
                </div>
                
                <div class="col-sm-2">
                    <h6>Follow us</h6>
                    <ul class="unstyled">
                        <li><a href="">微博</a></li>
                        <li><a href="">微信</a></li>
                        <li><a href="">来往</a></li>
                    </ul>                    
                </div>
                
                <div class="col-sm-2">
                    <h6>本网站由<span class="glyphicon glyphicon-heart"></span>Darren制作</h6>
                </div>
            </div>
        </div>
    </footer><!--页脚结束-->
    </div>
    <!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
    <script>
    var speed = 10;
    var tab = document.getElementById("demo");
    var tab1 = document.getElementById("demo1");
    var tab2 = document.getElementById("demo2");
    tab2.innerHTML = tab1.innerHTML;

    function Marquee() {
        if (tab2.offsetWidth - tab.scrollLeft <= 0)
            tab.scrollLeft -= tab1.offsetWidth
        else {
            tab.scrollLeft++;
        }
    }
    var MyMar = setInterval(Marquee, speed);
    tab.onmouseover = function() {
        clearInterval(MyMar)
    };
    tab.onmouseout = function() {
        MyMar = setInterval(Marquee, speed)
    };
    </script>
    <!-- 可选: 包含 jQuery 库 -->
    <script type="text/javascript" src="js/test.js"></script>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
    <script src="https://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>

</html>