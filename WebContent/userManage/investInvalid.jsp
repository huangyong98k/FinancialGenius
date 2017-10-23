<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="css/css.css">
    <script type="text/javascript" src="https://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/public.js"></script>
   <script type="text/javascript">
       $(function(){
       	$(".delban").click(function() {
           $(".banDel").show();
       }),
       $(".close").click(function() {
           $(".banDel").hide();
       }),
       $(".no").click(function() {
           $(".banDel").hide();
       })
       
       })
   </script>
</head>

<body>
    <div id="pageAll">
        <div class="pageTop">
            <div class="page">
                <img src="imgs/coin02.png" /><span>首页&nbsp;-&nbsp;投资管理&nbsp;-</span>&nbsp;投资失效查询
            </div>
        </div>
        <div class="page">
            <!-- 学生页面样式 -->
            <div class="connoisseur">
                <div class="conform">
                    <form>
                        <div class="cfD">
                            <input class="addUser" type="text" placeholder="输入投资名" />
                            <button class="button">搜索</button>
                        </div>
                    </form>
                </div>
                <!-- 学生 表格 显示 -->
                <div class="conShow">
                    <table border="1" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="435px" class="tdColor">投资编号</td>
                            <td width="400px" class="tdColor">用户名</td>
                            <td width="630px" class="tdColor">用户编号</td>
                            <td width="435px" class="tdColor">产品名</td>
                            <td width="435px" class="tdColor">产品编号</td>
                            <td width="435px" class="tdColor">起始时间</td>
                            <td width="435px" class="tdColor">结束时间</td>
                            <td width="435px" class="tdColor">预计收益</td>
                            <td width="230px" class="tdColor">操作</td>
                        </tr>
                        <tr height="40px">
                            <td>1</td>
                            <td>user1</td>
                            <td>001</td>
                            <td>product1</td>
                            <td>001</td>
                            <td>起始时间</td>
                            <td>结束时间</td>
                            <td>1000</td>
                            <td><input type="button" name="" value="失效"></td>
                        </tr>
                    </table>
                    <div class="paging">此处是分页</div>
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
                <a href="#" class="ok yes">确定</a><a class="ok no">取消</a>
            </p>
        </div>
    </div>
    <!-- 删除弹出框  end-->
</body>
</html>