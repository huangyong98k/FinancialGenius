/**
 * Created by JieSheng-CZZ on 2017/9/5.
 */
$(function () {
    resizeWindow();

    // 浏览器窗口大小调整时，触发 resize 事件，之后重新调整界面高度
    $(window).resize(function () {
        resizeWindow();
    });

});

function resizeWindow() {
    // 浏览器窗口高度 - header高度 = 内容区高度
    var contentHeight = $(window).height() - 80;
    $("#left").height(contentHeight);
    $("#right").height(contentHeight);
}
$(document).ready(function (event) {
	$.ajax({
        cache: true,
        type: "POST",
        url:"userAction!queryUserName.action",
        data:"",// 数据控件ID 
        async: true,
        success:function(data){
        	if(data=="请登录"){
        		$("#my_info").html(data);
        		$("#help").css("display","block");
        		$("#quit").css("display","block");
        		$("#exit").css("display","none");
        			$("span#my_info.my_info").click(function(){
        				  return false;
    			 })
        	}
        	if(data!="请登录"){
        		$("#my_info").click(function(){
        				$("span#my_info.my_info").unbind("click");
        			 })
        		$("#help").css("display","none");
        		$("#quit").css("display","none");
        		$("#exit").css("display","block");
        	}
        	$("#my_info").html(data);
        },
        error: function(response) {
        	console.log(response);
        }
        });
	$("#exit").click(function(){
		$.ajax({
	        cache: true,
	        type: "POST",
	        url:"userAction!quitSystem.action",
	        data:"",// 数据控件ID 
	        async: true,
	        success:function(data){
	        	alert(data);
	        	console.log(data);
	        },
	        error: function(response) {
	        	console.log(response);
	        }
	        });
	})
    $("#money").bind('input propertychange', function () {
            var money =  parseFloat($("#money").val());
            var month = $("input[name='select-states']:checked").val();
            num=money*0.11*month;
            if (money >= 0) {
                $("#get").html(parseFloat(num));
            }
            num=money+num;
            $("#all").html(parseFloat(num));
        });
    $("input[name='select-states']:checked").bind('input propertychange', function () {
            alert("666");
            var money = $("#money").val();
            var month = $("input[name='select-states']:checked").val();
            num=money*0.11*month;
            if (money >= 0) {
                $("#get").html(parseFloat(num));
            }
            num=num+money;
            $("#all").html(parseFloat(num));
        });
});
$.cookie = function(name, value, options) {
    if (typeof value != 'undefined') { // name and value given, set cookie
        options = options || {};
        if (value === null) {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
        }
        var path = options.path ? '; path=' + options.path : '; path=/';
        var domain = options.domain ? '; domain=' + options.domain : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else { // only name given, get cookie
        var reg = new RegExp("(?:^| )" + name + "=([^;]*)(;|$)"),
            result = reg.exec(document.cookie);
        return decodeURIComponent((result && result[1]) || '');
    }
}


/**
 * 通用蒙版,用于遮罩页面; 
 * 使用方法: 
 *  打开: mask.on(); 关闭: mask.off()
 *  
 * 注意: 蒙版的z-index默认为1000,可以通过mask.zIndex来修改;
 */

$.centerSize = function(size) {
    var view = {
            width: $(window).width(),
            height: $(window).height()
        },
        scrollTop = $(window).scrollTop();
    return {
        top: Math.max(scrollTop + (view.height - size.height) / 2, 0),
        left: Math.max((view.width - size.width) / 2, 0)
    };
};
$.center = function(el) {
    el = $(el);
    el.css('position', 'absolute')
        .css($.centerSize({
            width: el.outerWidth(),
            height: el.outerHeight()
        }));
};

var mask = {
    isOpen: false,
    zIndex: 2000,
    on: function() {
        if (mask.isOpen) {
            return false;
        };
        mask.isOpen = true;
        var dom = mask.dom = $('#theMask');
        if (!dom[0]) {
            dom = mask.dom = $('<div id="theMask"></div>')
                .css({
                    position: 'absolute',
                    top: 0,
                    left: 0,
                    width: '100%',
                    background: '#000',
                    opacity: 0.3,
                    display: 'none'
                });
            dom.appendTo($(document.body));
            $(window).resize(function() {
                mask._resize();
            });
        };
        this._resize();
        mask.isIe6 && $('select').hide();
        dom.show();
    },
    _resize: function() {
        mask.dom.css({
            width: $(document).width(),
            height: $(document).height(),
            zIndex: mask.zIndex
        });
    },
    off: function() {
        var dom = $('#theMask')
        if (!dom[0]) {
            return false;
        }
        mask.isOpen = false;
        mask.isIe6 && $('select').show();
        dom.hide();
    }
};


var PopLayer = function(options) {
    options = options || {};
    var me = this,
        defaultFn = function() { return true; };
    me.options = $.extend({
        beforeOpen: defaultFn,
        beforeClose: defaultFn,
        afterClose: defaultFn,
        ok: defaultFn,
        cancel: defaultFn,
        iframe: false
    }, options);
    options.trigger && (me.trigger = $(options.trigger));
    options.target && (me.target = $(options.target));

    me.init();
    //me.trigger = $(trigger);
    //me.target = $(target);
};

$.extend(PopLayer.prototype, {
    init: function() {
        this._initEvent();
    },
    _initEvent: function() {
        var me = this,
            o = me.options,
            root, isIframe;
        me.trigger && me.trigger.click(function(evt) {
            me.open();
            evt.preventDefault();
            //evt.stopPropagation();    
        });
        if (me.target) {
            isIframe = o.iframe && me.target[0].tagName.toLowerCase() == 'iframe';
            //去掉Iframe模式的支持, 因为IE6下会报告权限错误.
            if (isIframe) {
                return;
            }

            function bindAction() {
                //root = isIframe ? $(me.target[0].contentWindow.document) : me.target;
                root = me.target;
                root.find('.close, .cancel').click(function(evt) {
                    o.cancel();
                    me.close();
                    evt.preventDefault();
                });
                root.find('.ok').click(function(evt) {
                    o.ok();
                    me.close();
                    evt.preventDefault();
                });
            }
            //isIframe ? me.target.load(bindAction) : bindAction();
            bindAction();
        }
    },
    open: function() {
        var me = this,
            o = me.options;
        if (o.beforeOpen()) {
            me.update();
        }
    },
    close: function() {
        var me = this,
            o = me.options;
        if (o.beforeClose()) {
            mask.off();
            me.target.hide();
            var target = me.target.get(0);
            if (target && target.tagName && target.tagName.toUpperCase() == 'IFRAME') {
                me.target.remove();
            }
            o.afterClose();
            try {
                me.loading.remove();
            } catch (e) {}
            PopLayer.current = null;
        }
    },
    update: function() {
        PopLayer.current = this;
        mask.on();
        this.target.show();
        $.center(this.target);
    }
});

PopLayer.iframe = function(url) {
    var rtn,
        loading = $('<img width="48" src="/static/img/loading.gif?v=1">').css("zIndex", mask.zIndex + 1),
        frame = $('<iframe class="dialog" frameborder="0" scrolling="no"></iframe>')
        .css({ position: 'absolute', left: -9999, top: -9999, zIndex: 9999, width: 1, height: 1 })
        .appendTo(document.body)
        .attr('src', url);
    rtn = new PopLayer({ target: frame, iframe: true });

    frame.load(function() {
        var size,
            win = frame[0].contentWindow,
            oriSize = {
                width: frame.width(),
                height: frame.height()
            };
        frame.css({ width: 1, height: 1 });
        //去掉0和1的影响
        function fixSize(a, b) {
            return a > 1 ? a : b;
        }
        size = {
            //body.scrollWidth 用来解决ie下document与浏览器大小相同的问题
            width: fixSize($(win.document.body)[0].scrollWidth, $(win.document).outerWidth()),
            height: fixSize($(win.document.body)[0].scrollHeight, $(win.document).outerHeight())
        };
        frame.css(oriSize);
        frame.animate($.extend(size, $.centerSize(size)), { duration: 200 });
        loading.remove();
    });

    rtn.open();
    $.center(loading.appendTo(document.body));
    PopLayer.current.loading = loading;
    return rtn;
};
PopLayer.close = function() {
    PopLayer.current && PopLayer.current.close();
    if (PopLayer.afterClose) {
        PopLayer.afterClose();
    }
};
/**
 * @param size: {width:VAL, height:VAL}
 */
PopLayer.resize = function(size) {
    if (PopLayer.current) {
        PopLayer.current.target.animate($.extend(size, $.centerSize(size)), { duration: 200 });
        PopLayer.current.loading.remove();
    }
}

/*jquery.placeholder*/
//判断浏览器是否支持 placeholder属性  
function isPlaceholder() {
    var input = document.createElement('input');
    return 'placeholder' in input;
}

if (!isPlaceholder()) { //不支持placeholder 用jquery来完成  
    $(document).ready(function() {
        if (!isPlaceholder()) {
            $("input").not("input[type='password']").each( //把input绑定事件 排除password框  
                function() {
                    if ($(this).val() == "" && $(this).attr("placeholder") != "") {
                        $(this).val($(this).attr("placeholder"));
                        $(this).focus(function() {
                            if ($(this).val() == $(this).attr("placeholder")) $(this).val("");
                        });
                        $(this).blur(function() {
                            if ($(this).val() == "") $(this).val($(this).attr("placeholder"));
                        });
                    }
                });
            //对password框的特殊处理1.创建一个text框 2获取焦点和失去焦点的时候切换  
            var pwdField = $("input[type=password][placeholder]");
            var pwdVal = pwdField.attr('placeholder');
            pwdField.after('<input class="txt pwdPlaceholder" type="text" value=' + pwdVal + ' autocomplete="off" />');
            var pwdPlaceholder = $('.pwdPlaceholder');
            pwdPlaceholder.show();
            pwdField.hide();

            pwdPlaceholder.focus(function() {
                $(this).hide();
                $(this).prev().show();
                $(this).prev().focus();
            });

            pwdField.blur(function() {
                if (pwdField.val() == '') {
                    $(this).next().show();
                    $(this).hide();
                }
            });

        }
    });
}

