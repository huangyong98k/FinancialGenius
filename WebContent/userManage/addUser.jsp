<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
    <title>addUser</title>
    <link rel="stylesheet" type="text/css" href="css/css.css" />
    <script type="text/javascript" src="https://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/adduser.js"></script>
</head>
<body>
<div id="pageAll">
        <div class="pageTop">
            <div class="page">
                <img src="imgs/coin02.png" /><span>首页 - 用户管理> -</span> 添加用户
            </div>
        </div>
        <div class="page ">
            <!-- 添加用户页面样式 -->
            <div class="banneradd bor">
                <div class="baTopNo">
                    <span>添加用户</span>
                </div>
                <form action="" method="post">
                    <div class="baBody">
                        <div class="bbD1 bbD">
                             <input type="text" class="addUserInfo" value="用户名：" readonly>
                            <input type="text" class="input3" />  <img id="img_ok" src="imgs/ok.png"><img id="img_no" src="imgs/no.png">  <span id="text_no"></span>
                        </div>
                        <div class="bbD">
                             <input type="text" class="addUserInfo" value="密码：" readonly>
                            <input type="text" class="input3" />  <img id="img_ok" src="imgs/ok.png"><img id="img_no" src="imgs/no.png">  <span id="text_no"></span>
                        </div>
                        <div class="bbD">
                            <input type="text" class="addUserInfo" value="确认密码：" readonly>
                            <input type="password" class="input3" />  <img id="img_ok" src="imgs/ok.png"><img id="img_no" src="imgs/no.png">  <span id="text_no"></span>
                        </div>
                        <div class="bbD">
                             <input type="text" class="addUserInfo" value="邮箱：" readonly>
                            <input type="email" class="input3" />  <img id="img_ok" src="imgs/ok.png"><img id="img_no" src="imgs/no.png">  <span id="text_no"></span>
                        </div>
                        <div class="bbD">
                                    <input type="text" class="addUserInfo" value="性别：" readonly>
                            <input class="addUserCheck" type="radio" name="sex" checked/>男       
                            <input class="addUserCheck" type="radio" name="sex" />女
                        </div>
                        <div class="bbD">
                                 <input type="text" class="addUserInfo" value="电话号：" readonly>
                            <input type="phone" class="input3" />  <img id="img_ok" src="imgs/ok.png"><img id="img_no" src="imgs/no.png">  <span id="text_no"></span>
                        </div>
                         <div class="bbD">
                             <input type="text" class="addUserInfo" value="身份证号：" readonly>
                            <input type="text" class="input3" />  <img id="img_ok" src="imgs/ok.png"><img id="img_no" src="imgs/no.png">  <span id="text_no"></span>
                        </div>
                        <div class="bbD">
                            <p class="bbDP">
                                <input type="hidden" name="student.studentId" value="${student.studentId }" />
                                <input class="input3" type="submit" name="Submit" value="提交" style="width: 153px; color: Black; background-color: Aqua" />             
                                <a href="student!list.action">
                                    <input class="input3" type="submit" name="Submit" value="取消" style="width: 153px; " />
                                </a>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
            <!-- 添加用户页面样式end -->
        </div>
    </div>
</body>
</html>