(function($) {
    $.tab = function(config) {
        var defConfig = {
            tit: "#loginTab",
            titChild: "li",
            titClass: "on",
            con: "#loginTabCon",
            conchild: ".login-tab-con",
            handleEvent: "click" //click or hover
        }
        config = $.extend(defConfig, config);
        $(config.tit).find(config.titChild).on(config.handleEvent, function() {
            var i = $(this).index();
            $(config.tit).find(config.titChild).removeClass(config.titClass).eq(i).addClass(config.titClass);
            $(config.con).find(config.conchild).hide().eq(i).show();
        })
    }
}(jQuery));
$(function() {
    $("[data-tip]").live("mouseenter", function() {
        var _this = $(this),
            _dataTip,
            _html = "";
        $("#data-tip").remove();
        if (_this.attr('data-tip') != "") {
            _html += "<div class='data-tip border-e5' id='data-tip'><p class='txt'>" + _this.attr('data-tip') + "</p></div>";
            $("body").append(_html);
            _dataTip = $("#data-tip");
            _dataTip.live("click mouseleave", function(e) {
                if (e.type == "click") {
                    e.stopPropagation ? e.stopPropagation() : e.cancelBubble = true
                }
                if (e.type == "mouseleave") {
                    $(this).remove();
                }
            })
            //定位
            var _sTop = _this.offset().top,
                _sLeft = _this.offset().left,
                _sWidth = _this.outerWidth(),
                _sHeight = _this.outerHeight(),
                _tWidth = _dataTip.width() > 200 ? 200 : _dataTip.width(),
                _tHeight = _dataTip.height(),
                _tTop = _sTop;
            var _tLeft = _sLeft - (_tWidth - _sWidth) / 2;
            var _tipY = $(window).height() - (_sTop + _tHeight),
                _tipX = $(window).width() - (_sLeft + _tWidth);
            if (_tipY < 30) {
                _tTop = _tTop - _sHeight - _tHeight;
            } else {
                _tTop = _tTop + _sHeight + 5;
            }
            if (_tipX < 30) {
                //_tLeft=_tLeft - ()
            }
            _dataTip.css({
                position: "absolute",
                top: _tTop,
                left: _tLeft,
                width: _tWidth,
                zIndex: 100
            });
        }
    })
    $(document).click(function() {
        $("#data-tip").remove();
    })
    $.tab({
        tit: "#loginTab",
        titChild: "li",
        titClass: "on",
        con: "#loginTabCon",
        conchild: ".login-tab-con"
    });
    $("#loginTab li").click(function() {
        var index = $(this).index();
        if (index == 0) {
            comm.reVcode("#loginVcodeImg");
        } else {
            comm.reVcode("#vregVcodeImg");
        }
    })
    var comm = {
        def: {
            second: 60,
            sign: ""
        },
        checkNull: function(str) {
            if (str == "" || str == null) {
                return true;
            } else {
                return false;
            }
        },
        reVcode: function(oImg) {
            $(oImg).attr("src", "/passport/user/vcode?m=" + Math.random());
        },
        getVcode: function(o, u, c, t) { //p:phone,u:url,c:容器,t:提示区域
            //var u=u || "/zhigou/account/usersmscaptcha";
            var _this = this;
            $.post(u, o, function(result) {
                if (o.type == 1 && result.code == 1) {
                    $(t).html("此号码已被注册，您可以<a style='color:##3366cc;' href='/passport/user/login'>直接登录</a>");
                }
                if (result.code == 0) {
                    $(t).html("");
                    _this.countDown(c, _this.def.second, t);
                } else {
                    $(t).html(result.msg);
                }

            }, "json");

        },
        countDown: function(c, s, t) { //c容器 s倒计时秒数,t:提示区域
            var _this = this;
            $(c).find("a").addClass("none").removeClass("on").parent().find("span").removeClass("none").addClass("on");
            $(c).find(".num").text(s);
            this.def.sign = setInterval(function() {
                $(c).find(".num").text(s);
                s--;
                if (s < 0) {
                    clearInterval(_this.def.sign);
                    $(c).find("span").addClass("none").removeClass("on").parent().find("a").removeClass("none").addClass("on");
                    $(t).html("");
                }
            }, 1000)
        },
        clearCountDown: function() {
            clearInterval(this.def.sign);
        },
        getLength: function(str) {
            return str.replace(/([^\x00-\xFF])/g, '..').length;
        }
    }

    var pwdLogin = {
        user: $("[name=passname]"),
        pwd: $("[name=passwd]"),
        vcode: $("[name=PwdVcode]"),
        remember: $("[name=remember]"),
        tip: $("#pwdLoginTip"),
        vcodeCon: $("#loginVcodeContain"),
        init: function() {
            var _this = this;
            $("#pwdLoginBtn").click(function() {
                _this.submit();
            });
            this.user.focus(function() {
                _this.focus();
            })
            this.pwd.focus(function() {
                _this.focus();
            })
            this.vcode.focus(function() {
                _this.focus();
            })
            if (!_this.vcodeCon.hasClass("none")) {
                comm.reVcode("#loginVcodeImg");
            }
            $("#loginFreshCode,#loginVcodeImg").click(function() {
                comm.reVcode("#loginVcodeImg");
            })
        },
        submit: function() {
            var _this = this;
            var user = $.trim(_this.user.val());
            var pwd = $.trim(_this.pwd.val());
            var vcode = $.trim(_this.vcode.val());
            var data = {};
            if (comm.checkNull(user) || comm.checkNull(pwd)) {
                _this.tip.html("请输入正确的用户名密码");
                return false;
            }
            data.passname = user;
            data.passwd = pwd;
            if (!_this.vcodeCon.hasClass("none")) {
                if (comm.checkNull(vcode)) {
                    _this.tip.html("请输入验证码");
                    return false;
                }
                data.vcode = vcode;
            }
            data.remember = 0;
            if (_this.remember.attr("checked") == "checked") {
                data.remember = 1;
            }
            //提交
            $.post(window.location.href, data, function(result) {
                if (result.code == 0) {
                    window.location.href = window.returnUrl;
                    return false;
                } else if (result.code == 10) {
                    _this.vcodeCon.removeClass("none");
                }
                comm.reVcode("#loginVcodeImg");
                _this.vcode.val("");
                _this.tip.html(result.msg);
            }, "json")
        },
        focus: function() {
            this.tip.html("");
        }
    }
    pwdLogin.init();

    var vcodeLogin = {
        mobile: $("[name=vmobile]"),
        vcode: $("[name=vvcode]"),
        captcha: $("[name=vcaptcha]"),
        tip: $("#vvcodeLoginTip"),
        init: function() {
            var _this = this;
            $("#vvcodeLoginBtn").click(function() {
                _this.submit();
            })
            $("[name=vmobile]").focus(function() {
                $(this).parent().find(".tip-error").html("");
            })
            $("[name=vvcode],[name=vcaptcha]").focus(function() {
                $(this).parent().parent().find(".tip-error").html("");
            })
            $("#vregFreshCode,#vregVcodeImg").click(function() {
                comm.reVcode("#vregVcodeImg");
            })
            $("#vregCaptchaBtn").click(function() {
                var mobile = $.trim(_this.mobile.val());
                var vcode = $.trim(_this.vcode.val());
                var captcha = $.trim(_this.captcha.val());
                if (comm.checkNull(mobile) || mobile.length != 11 || comm.checkNull(vcode)) {
                    _this.tip.html("请输入正确的手机号和图片验证码");
                    return false;
                }
                comm.getVcode({ mobile: mobile, type: 2, vcode: vcode }, "/passport/user/captcha", "#vregCaptchaCon", "#vregCaptchaTip");
            })
            this.mobile.focus(function() {
                _this.focus();
            })
            this.vcode.focus(function() {
                _this.focus();
            })
            this.captcha.focus(function() {
                _this.focus();
            })
        },
        submit: function() {
            var _this = this;
            var mobile = $.trim(this.mobile.val());
            var vcode = $.trim(this.vcode.val());
            var captcha = $.trim(this.captcha.val());
            if (comm.checkNull(mobile) || comm.checkNull(vcode) || mobile.length != 11 || comm.checkNull(captcha)) {
                this.tip.html("请输入正确的手机号和验证码");
                return false;
            }
            $.post(window.location.href, { mobile: mobile, vcode: vcode, captcha: captcha }, function(result) {
                if (result.code == 0) {
                    window.location.href = window.returnUrl;
                    return false;
                } else {
                    comm.reVcode("#vregVcodeImg");
                    _this.vcode.val("");
                    _this.tip.html(result.msg);
                }
            }, "json")
        },
        focus: function() {
            this.tip.html("");
        }
    }
    if ($("#vcodeLoginForm")) {
        vcodeLogin.init();
    }


    var reg = {
        username: $("[name=username]"),
        mobile: $("[name=mobile]"),
        passwd: $("[name=passwd]"),
        rePasswd: $("[name=password-repeat]"),
        vcode: $("[name=vcode]"),
        captcha: $("[name=captcha]"),
        init: function() {
            var _this = this;
            var reg1 = /^(?![^a-zA-Z]+$)(?!\D+$).{6,16}$/,
                reg3 = /^\d+/;

            $("#regSubmit").click(function() {
                _this.submit();
            })
            $("[name=username],[name=mobile],[name=passwd],[name=password-repeat]").focus(function() {
                $(this).parent().find(".tip-error").html("");
            })

            $("[name=vcode],[name=captcha]").focus(function() {
                $(this).parent().parent().find(".tip-error").html("");
            })

            this.vcode.keyup(function() {
                var code = $.trim(_this.vcode.val());
                if (code.length == 4) {
                    $(".validate-phone").removeClass("none");
                }
            })
            this.passwd.focus(function() {
                $(this).parent().find(".tip-error").html("请设置6-16位密码，必须包含字母和数字").css("color", "#999");
            }).keyup(function() {
                var passwd = $.trim(_this.passwd.val());
                if (reg1.test(passwd)) {
                    $(this).parent().find(".tip-error").html("");
                }
            })
            this.username.focus(function() {
                $(this).parent().find(".tip-error").html("4-20个字符或2-10个汉字，不能以数字开头").css("color", "#999");
            }).keyup(function() {
                var username = $.trim(_this.username.val());
                if (!(comm.checkNull(username) || comm.getLength(username) < 4 || comm.getLength(username) > 20 || reg3.test(username))) {
                    $(this).parent().find(".tip-error").html("");
                }
            })
            comm.reVcode("#regVcodeImg");
            $("#regFreshCode,#regVcodeImg").click(function() {
                comm.reVcode("#regVcodeImg");
            })
            $("#regCaptchaBtn").click(function() {
                var mobile = $.trim(_this.mobile.val());
                var vcode = $.trim(_this.vcode.val());
                if (comm.checkNull(mobile) || mobile.length != 11) {
                    _this.mobile.parent().find(".tip-error").html("请输入正确的手机号");
                    return false;
                }
                if (comm.checkNull(vcode)) {
                    _this.vcode.parent().parent().find(".tip-error").html("请输入图片验证码");
                    return false;
                }
                comm.getVcode({ mobile: mobile, type: 1, vcode: vcode }, "/passport/user/captcha", "#regCaptchaCon", "#regCaptchaTip");
            })
        },
        submit: function() {
            var _this = this;
            var reg1 = /^(?![^a-zA-Z]+$)(?!\D+$).{6,16}$/,
                reg3 = /^\d+/;
            var username = $.trim(this.username.val());
            var mobile = $.trim(this.mobile.val());
            var passwd = $.trim(this.passwd.val());
            var rePasswd = $.trim(this.rePasswd.val());
            var vcode = $.trim(this.vcode.val());
            var captcha = $.trim(this.captcha.val());
            if (comm.checkNull(username) || comm.getLength(username) < 4 || comm.getLength(username) > 20 || reg3.test(username) || username == "用户名") {
                this.username.parent().find(".tip-error").html("用户名请设置4-20个字符或2-10个汉字，不能以数字开头").css("color", "#ff3333");
                return false;
            }
            if (comm.checkNull(mobile) || mobile.length != 11) {
                this.mobile.parent().find(".tip-error").html("请输入正确的手机号");
                return false;
            }
            if (!reg1.test(passwd)) {
                this.passwd.parent().find(".tip-error").html("请设置6-16位密码，必须包含字母和数字").css("color", "#ff3333");
                return false;
            }
            if (comm.checkNull(rePasswd)) {
                this.rePasswd.parent().find(".tip-error").html("请输入确认密码");
                return false;
            }
            if (passwd != rePasswd) {
                this.rePasswd.parent().find(".tip-error").html("两次输入的密码不一致");
                return false;
            }
            if (comm.checkNull(vcode)) {
                this.vcode.parent().parent().find(".tip-error").html("请输入图片验证码");
                return false;
            }
            if (comm.checkNull(captcha)) {
                this.captcha.parent().parent().find(".tip-error").html("请输入短信验证码");
                return false;
            }
            $.post(window.location.href, $("#regForm").serialize(), function(result) {
                if (result.code == 0) {
                    window.location.href = window.returnUrl;
                } else {
                    _this.captcha.parent().parent().find(".tip-error").html(result.msg);
                }
            }, "json")
        }
    }
    if ($("#regForm")) {
        reg.init();
    }


    var findPwd = {
        mobile: $("[name=mobile]"),
        vcode: $("[name=vcode]"),
        captcha: $("[name=captcha]"),
        passwd: $("[name=passwd]"),
        rePasswd: $("[name=password-repeat]"),
        init: function() {
            var _this = this;
            $("#findCaptchaBtn").click(function() {
                var mobile = $.trim(_this.mobile.val());
                var vcode = $.trim(_this.vcode.val());
                if (comm.checkNull(mobile) || mobile.length != 11) {
                    _this.mobile.parent().find(".tip-error").html("请输入正确的手机号");
                    return false;
                }
                if (comm.checkNull(vcode)) {
                    _this.vcode.parent().parent().find(".tip-error").html("请输入图片验证码");
                    return false;
                }
                comm.getVcode({ mobile: mobile, type: 2, vcode: vcode }, "/passport/user/captcha", "#findCaptchaCon", "#findCaptchaTip");
            })
            $("#findPwdBtn1").click(function() {
                _this.submitStep1();
            })
            $("#findPwdBtn2").click(function() {
                _this.submitStep2();
            })
        },
        submitStep1: function() {
            var _this = this;
            var mobile = $.trim(_this.mobile.val());
            var vcode = $.trim(_this.vcode.val());
            var captcha = $.trim(_this.captcha.val());
            if (comm.checkNull(mobile) || mobile.length != 11) {
                _this.mobile.parent().find(".tip-error").html("请输入正确的手机号");
                return false;
            }
            if (comm.checkNull(vcode)) {
                _this.vcode.parent().parent().find(".tip-error").html("请输入图片验证码");
                return false;
            }
            if (comm.checkNull(captcha)) {
                _this.captcha.parent().parent().find(".tip-error").html("请输入短信验证码");
                return false;
            }
            $.post(window.location.href, $("#findPwdForm1").serialize(), function(result) {
                if (result.code == 0) {
                    window.location.href = "/passport/user/forgotPassword?step=2";
                } else {
                    _this.captcha.parent().parent().find(".tip-error").html(result.msg);
                    return false;
                }
            }, "json")
        },
        submitStep2: function() {
            var _this = this;
            var passwd = $.trim(this.passwd.val());
            var rePasswd = $.trim(this.rePasswd.val());
            if (comm.checkNull(passwd) || passwd.length < 6) {
                this.passwd.parent().find(".tip-error").html("请设置6-16位密码，必须包含字母和数字").css("color", "#ff3333");
                return false;
            }
            if (comm.checkNull(rePasswd)) {
                this.rePasswd.parent().find(".tip-error").html("请输入确认密码");
                return false;
            }
            if (passwd != rePasswd) {
                this.rePasswd.parent().find(".tip-error").html("两次输入密码不一致");
                return false;
            }
            $.post(window.location.href, $("#findPwdForm2").serialize(), function(result) {
                if (result.code == 0) {
                    window.location.href = "/passport/user/forgotPassword?step=3";
                } else {
                    _this.rePasswd.parent().find(".tip-error").html(result.msg);
                }
            }, "json")
        }
    }
    findPwd.init();

    var modifyPwd = {
        oldPasswd: $("[name=old_password]"),
        passwd: $("[name=password]"),
        rePasswd: $("[name=password_repeat]"),
        init: function() {
            var _this = this;
            var reg1 = /^(?![^a-zA-Z]+$)(?!\D+$).{6,16}$/,
                reg3 = /^\d+/;
            this.passwd.focus(function() {
                $(this).parent().find(".tip-error").html("请设置6-16位密码，必须包含字母和数字").css("color", "#999");
            }).keyup(function() {
                var passwd = $.trim(_this.passwd.val());
                if (reg1.test(passwd)) {
                    $(this).parent().find(".tip-error").html("");
                }
            })
            $("#modifyPwdBtn").click(function() {
                _this.modifyPwdSubmit();
            })
        },
        modifyPwdSubmit: function() {
            var _this = this;
            var reg1 = /^(?![^a-zA-Z]+$)(?!\D+$).{6,16}$/,
                reg3 = /^\d+/;
            var oldPasswd = $.trim(this.oldPasswd.val());
            var passwd = $.trim(this.passwd.val());
            var rePasswd = $.trim(this.rePasswd.val());
            if (comm.checkNull(oldPasswd)) {
                this.oldPasswd.parent().find(".tip-error").html("请输入原密码").css("color", "#ff3333");
                return false;
            } else if (oldPasswd.length < 6) {
                this.oldPasswd.parent().find(".tip-error").html("原密码有误，请重新输入").css("color", "#ff3333");
                return false;
            } else {
                this.oldPasswd.parent().find(".tip-error").html("");
            }
            if (comm.checkNull(passwd) || passwd.length < 6 || !reg1.test(passwd)) {
                this.passwd.parent().find(".tip-error").html("请设置6-16位密码，必须包含字母和数字").css("color", "#ff3333");
                return false;
            }
            if (comm.checkNull(rePasswd)) {
                this.rePasswd.parent().find(".tip-error").html("请输入确认密码");
                return false;
            }
            if (passwd != rePasswd) {
                this.rePasswd.parent().find(".tip-error").html("两次输入密码不一致");
                return false;
            }
            $.post(window.location.href, $("#modifyPwd").serialize(), function(result) {
                if (result.code == 0) {
                    window.location.href = "/passport/user/login";
                } else {
                    _this.rePasswd.parent().find(".tip-error").html(result.msg);
                }
            }, "json")
        }
    }
    modifyPwd.init();
})