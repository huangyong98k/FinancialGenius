var Util = Util || {};
Util.config = {
	JSfile: environment.basePath + "/v2/local/js/",
	CSSfile: environment.basePath + "/v2/local/css/",
	imgfile: environment.basePath + "/v2/local/img/",
	CITYSPOTLIGHT: [],
	HOTCITYSPOTLIGHT: [],
	BANKSSPOTLIGHT: []
};
Util.getName = function(a) {
	return document.getElementsByName(a)
};
Util.getID = function(id) {
	return document.getElementById(id)
};
Util.getTag = function(ele, oParent) {
	return (oParent || document).getElementsByTagName(ele)
};
Util.ct = function(txt) {
	return document.createTextNode(txt)
};
Util.ce = function(name) {
	return document.createElement(name)
};
Util.alink = function(name) {
	return $(name).bind("focus", function() {
		if (this.blur) {
			this.blur()
		}
	})
};
Util.stopBubble = function(e) {
	e.stopPropagation ? e.stopPropagation() : e.cancelBubble = true
};
Util.stopDefault = function(e) {
	e.preventDefault ? e.preventDefault() : e.returnValue = false
};
Util.clSelect = function() {
	try {
		window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty()
	} catch (_) {}
};
Util.getStyle = function(element) {
	return element.currentStyle || document.defaultView.getComputedStyle(element, null)
};
Util.exid = function(id) {
	return document.getElementById(id) ? true : false
};
Util.strTrim = function(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "")
};
Util.checkVal = function(val) {
	return val == null || val == ''
};
Util.Browser = function() {
	var a = navigator.userAgent.toLowerCase();
	var u = navigator.userAgent;
	var b = {};
	b.isStrict = document.compatMode == "CSS1Compat";
	b.isFirefox = a.indexOf("firefox") > -1;
	b.isOpera = a.indexOf("opera") > -1;
	b.isSafari = (/webkit|khtml/).test(a);
	b.isSafari3 = b.isSafari && a.indexOf("webkit/5") != -1;
	b.isIE = !b.isOpera && a.indexOf("msie") > -1;
	b.isIE6 = !b.isOpera && a.indexOf("msie 6") > -1;
	b.isIE7 = !b.isOpera && a.indexOf("msie 7") > -1;
	b.isIE8 = !b.isOpera && a.indexOf("msie 8") > -1;
	b.isGecko = !b.isSafari && a.indexOf("gecko") > -1;
	b.isMozilla = document.all != undefined && document.getElementById != undefined && !window.opera != undefined;
	b.isTrident = u.indexOf('Trident') > -1;
	b.isPresto = u.indexOf('Presto') > -1;
	b.isWebKit = u.indexOf('AppleWebKit') > -1;
	b.isGecko = u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1;
	b.isMobile = !!u.match(/AppleWebKit.*Mobile.*/) || !!u.match(/AppleWebKit/);
	b.isios = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
	b.isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1;
	b.isiPhone = u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1;
	b.isiPad = u.indexOf('iPad') > -1;
	b.isWebApp = u.indexOf('Safari') == -1;
	return b
}();
Util.isCookie = function(name) {
	var a = $.cookie(name);
	var n = document.cookie.indexOf(name + '=');
	if (n == -1) {
		return false
	} else {
		return true
	}
};
/**
 * Check and invoke callback function
 */
Util.invokeCallback = function (cb) {
	if (!!cb && typeof cb === 'function') {
		cb.apply(null, Array.prototype.slice.call(arguments, 1));
	}
};
Util.addStyle = function(str) {
	var b = window.style;
	if (!b) {
		b = window.style = document.createElement('style');
		b.setAttribute('type', 'text/css');
		document.getElementsByTagName('head')[0].appendChild(b)
	};
	b.styleSheet && (b.styleSheet.cssText += str) || b.appendChild(document.createTextNode(str))
};
Util.loadCSS = function(path, name) {
	if (!path) return;
	var b = Util.getTag('link');
	for (var c in b) {
		if (b[c].href == path) return
	};
	var links = document.createElement("link");
	links.id = name;
	links.rel = "stylesheet";
	links.media = "screen";
	links.type = "text/css";
	links.href = path;
	Util.getTag("HEAD").item(0).appendChild(links)
};
Util.loadJS = function(url, callback, ecall) {
	var head = document.head || document.getElementsByTagName("head")[0] || document.documentElement,
		script, options, o, scriptsArray = [];
	if (typeof url === "object") {
		options = url;
		url = undefined
	};
	o = options || {};
	url = url || o.url;
	var path = url.split(",");
	callback = callback || o.success;
	for (var i = 0; i < path.length; i++) {
		str = path[i].slice(path[i].lastIndexOf('/') + 1);
		name = str.substring(0, str.indexOf("."));
		script = document.createElement("script");
		script.async = o.async || false;
		script.type = "text/javascript";
		if (o.charset) script.charset = o.charset;
		if (o.cache === false) {
			path[i] = path[i] + (/\?/.test(path[i]) ? "&" : "?") + "time=" + (new Date()).getTime()
		};
		script.src = (path[i].indexOf("/") == '-1' ? true : false) === true ? Util.config.JSfile + path[i] : path[i];
		head.appendChild(script)
	};
	if ('function' == typeof callback) {
		document.addEventListener ? script.addEventListener("load", function() {
			callback();
			script.onload = null;
			script.parentNode.removeChild(script)
		}, false) : script.onreadystatechange = function() {
			if (/loaded|complete/.test(script.readyState)) {
				callback();
				script.onreadystatechange = null
			}
		}
	};
	if (ecall) {
		script.onerror = function() {
			script = null;
			if ('function' == typeof ecall) ecall()
		}
	}
};
Util.checkScript = function(o) {
	$("head").find("script").each(function() {
		var src = $(this).attr("src");
		if (src.indexOf(o) != -1) {
			src = src.substring(0, src.lastIndexOf("/") + 1);
			Util.config.JSfile = src
		}
	})
};
Util.setIframHeight = function(obj) {
	var fun = function(obj) {
		var o = document.getElementById(obj);
		try {
			var a = o.contentWindow.document.body.scrollHeight;
			var b = o.contentWindow.document.documentElement.scrollHeight;
			var h = Math.max(a, b);
			o.height = h
		} catch (ex) {}
	};
	window.setInterval(fun, 200)
};
Util.XXdate = function(e, c, o) {
	var a = new Date(e);
	if (isNaN(e)) {
		a = new Date(e.replace(/-/g, '/'))
	};
	switch (o) {
		case 'ymd':
			a.setDate(a.getDate() + c);
			return a.getFullYear() + '/' + (a.getMonth() + 1) + '/' + a.getDate();
			break;
		case 'ym':
			a.setMonth((a.getMonth() + 1) + c);
			return a.getFullYear() + '/' + (a.getMonth() + 1) + '/' + a.getDate();
			break;
		default:
			a.setDate(a.getDate() + c);
			return a.getFullYear() + '/' + (a.getMonth() + 1) + '/' + a.getDate()
	}
};
Util.strDate = function(date) {
	var a = new Date(date);
	if (isNaN(date)) {
		a = new Date(date.replace(/-/g, '/'))
	};
	return a
};
Date.prototype.format = function(fmt) {
	var o = {
		"M+": this.getMonth() + 1,
		"d+": this.getDate(),
		"h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
		"H+": this.getHours(),
		"m+": this.getMinutes(),
		"s+": this.getSeconds(),
		"q+": Math.floor((this.getMonth() + 3) / 3),
		"S": this.getMilliseconds()
	};
	var week = {
		"0": "\u65e5",
		"1": "\u4e00",
		"2": "\u4e8c",
		"3": "\u4e09",
		"4": "\u56db",
		"5": "\u4e94",
		"6": "\u516d"
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length))
	};
	if (/(E+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "\u661f\u671f" : "\u5468") : "") + week[this.getDay() + ""])
	};
	for (var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)))
		}
	};
	return fmt
};
Util.getDateStr = function(c, d) {
	d.setDate(d.getDate() + c);
	return (d.getMonth() + 1) + '/' + (d.getDate()) + '/' + d.getFullYear()
};
Util.numFormat = function(s, n) {
	var t = '',
		r = '';
	var Str = function() {
		n = n > 0 && n <= 20 ? n : 2;
		s = parseFloat((s + '').replace(/[^\d\.-]/g, '')).toFixed(n) + '';
		var l = s.split('.')[0].split('').reverse();
		r = s.split('.')[1];
		for (var i = 0; i < l.length; i++) {
			t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? ',' : '')
		}
	};
	if (n >= 0) {
		Str();
		return t.split('').reverse().join('') + '.' + r
	} else {
		Str();
		return t.split('').reverse().join('')
	}
};
Util.StringToArray = function(str, substr) {
	var arrTmp = new Array();
	if (substr == "") {
		arrTmp.push(str);
		return arrTmp
	};
	var i = 0,
		j = 0,
		k = str.length;
	while (i < k) {
		j = str.indexOf(substr, i);
		if (j != -1) {
			if (str.substring(i, j) != "") {
				arrTmp.push(str.substring(i, j))
			};
			i = j + 1
		} else {
			if (str.substring(i, k) != "") {
				arrTmp.push(str.substring(i, k))
			};
			i = k
		}
	};
	return arrTmp
};

function ArrayToString(arr, str) {
	var strTmp = "";
	for (var i = 0; i < arr.length; i++) {
		if (arr[i] != "") {
			if (strTmp == "") {
				strTmp = arr[i]
			} else {
				strTmp = strTmp + str + arr[i]
			}
		}
	};
	return strTmp
};
Util.yMonthCheck = function(m, y) {
	var month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	if (!m || m < 0) return month[0];
	if ((m == 1) && (y % 4 == 0) && ((y % 100 != 0) || (y % 400 == 0))) {
		return 29;
	} else {
		return month[m];
	}
};
Util.Random = function(length, upper, lower, number) {
	if (!upper && !lower && !number) {
		upper = lower = number = true
	};
	var a = [
		["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"],
		["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"],
		["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
	];
	var b = [];
	var c = "";
	b = upper ? b.concat(a[0]) : b;
	b = lower ? b.concat(a[1]) : b;
	b = number ? b.concat(a[2]) : b;
	for (var i = 0; i < length; i++) {
		c += b[Math.round(Math.random() * (b.length - 1))]
	};
	return c
};
Util.getUrlKey = function(key, url) {
	var url = url ? url : location.href;
	var v = '';
	var o = url.indexOf(key + "=");
	if (o != -1) {
		o += key.length + 1;
		e = url.indexOf("&", o);
		if (e == -1) {
			e = url.length
		};
		v = url.substring(o, e)
	};
	return v
};
String.prototype.lengthStr = function() {
	var len = 0;
	for (var i = 0; i < this.length; i++) {
		if (this.charCodeAt(i) > 255 || this.charCodeAt(i) < 0) {
			len += 2
		} else {
			len++
		}
	}
	return len
};
String.prototype.strChars = function() {
	var chars = new Array();
	for (var i = 0; i < this.length; i++) {
		chars[i] = [this.substr(i, 1), this.isCHS(i)]
	}
	String.prototype.charsArray = chars;
	return chars
};
String.prototype.isCHS = function(i) {
	if (this.charCodeAt(i) > 255 || this.charCodeAt(i) < 0) {
		return true
	} else {
		return false
	}
};
String.prototype.subString = function(start, end) {
	var len = 0;
	var str = "";
	this.strChars();
	for (var i = 0; i < this.length; i++) {
		if (this.charsArray[i][1]) {
			len += 2
		} else {
			len++
		};
		if (end < len) {
			return str
		} else if (start < len) {
			str += this.charsArray[i][0]
		}
	};
	return str
};
String.prototype.subChsString = function(start, length) {
	return this.subString(start, start + length)
};
Util.safeRange = function(obj) {
	if (typeof(obj) === "string") {
		b = Util.getID(obj)
	} else {
		b = obj
	}
	var c, d, e, f, g, h, j, k;
	j = b.offsetWidth;
	k = b.offsetHeight;
	p = Util.pageSize();
	c = 0;
	e = p.clientWidth - j;
	g = e / 2;
	d = 0;
	f = p.clientHeight - k;
	var hc = p.clientHeight * 0.382 - k / 2;
	h = (k < p.clientHeight / 2) ? hc : f / 2;
	if (g < 0) g = 0;
	if (h < 0) h = 0;
	return {
		width: j,
		height: k,
		minX: c,
		minY: d,
		maxX: e,
		maxY: f,
		centerX: g,
		centerY: h
	}
};
Util.pageSize = function() {
	var a = Util.Browser.isStrict ? document.documentElement : document.body;
	var b = ["clientWidth", "clientHeight", "scrollWidth", "scrollHeight"];
	var c = {};
	for (var d in b) c[b[d]] = a[b[d]];
	c.scrollLeft = document.body.scrollLeft || document.documentElement.scrollLeft;
	c.scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
	return c
};
Util.Fixed = function(obj) {
	var o = Util.getID(obj);
	if (!Util.Browser.isIE6) {
		o.style.position = "fixed"
	} else {
		var p = Util.pageSize();
		o.style.position = "absolute";
		o.style.top = Util.getStyle(Util.getID(obj))["top"] != "auto" ? parseInt(Util.getStyle(Util.getID(obj))["top"]) + "px" : p.clientHeight - o.offsetHeight - parseInt(Util.getStyle(Util.getID(obj))["bottom"]) + "px";
		Util.addStyle(".ui_fixed{position:absolute; width:100%; height:1px; z-index: 891201; left:expression(documentElement.scrollLeft+documentElement.clientWidth-this.offsetWidth);top:expression(documentElement.scrollTop)}.body-fixed{background-attachment:fixed;background-image:url(about:blank);}");
		var fixeds = $(".ui_dialog_fixed");
		if (fixeds.length == 0) {
			var wrap = Util.ce("div");
			wrap.className = 'ui_fixed';
			wrap.appendChild(o);
			document.body.appendChild(wrap);
			$("html").addClass("body-fixed")
		} else {
			$(fixeds).append(o)
		}
	}
};
Util.strlimit = function(a, b) {
	var c = $(a);
	c.each(function() {
		var d = $(this).text();
		var g = $(this).text().length;
		if (g > b) {
			$(this).attr("title", d);
			d = $(this).text(d.substring(0, b) + "...")
		}
	})
};
Util.chackTextarea = {
	clear: "timer",
	init: function(a, b, c, d, f, g) {
		Util.chackTextarea.clear = setInterval(function() {
			var v = Util.getLength($("#" + a).val()),
				numClor;
			if (v >= 0) {
				if (v > b * 2) {
					$(c).html('已超出<strong class="chackTextareaTipsNum">" +parseInt((v - b*2)/2) +"</strong>个字!');
					if (d) $(d).attr("disabled", "disabled").attr("class", g);
					numClor = Util.Config.chackTextareaTipsColor
				} else {
					$(c).html('还能输入<strong class="chackTextareaTipsNum">" +parseInt((b*2-v)/2) +"</strong>个字!');
					if (d) $(d).attr("disabled", "").attr("class", f);
					numClor = ""
				};
				$(".chackTextareaTipsNum").css({
					fontFamily: "Georgia,Tahoma,Arial",
					position: "relative",
					top: "-5px",
					fontSize: "26px",
					verticalAlign: "middle",
					color: numClor
				})
			} else {
				if (d) $(d).attr("disabled", "disabled").attr("class", f)
			}
		}, 100)
	}
};
Util.scrollTO = function(a, b, c) {
	Util.fixed(a);
	$("#" + a).hide().click(function() {
		var d = b != "" ? Util.getID(b).offsetTop : document.body.offsetTop;
		$("html,body").stop().animate({
			scrollTop: d
		}, {
			duration: c || 500,
			queue: false
		});
		return false
	});
	$(window).bind("scroll", function() {
		var st = $(document).scrollTop();
		(st > 30) ? $("#" + a).show(): $("#" + a).hide()
	})
};
Util.scrollDIV = function(a, b, c) {
	var d = $(a);
	var s = Util.pageSize.get();
	d.css({
		position: "absolute",
		top: b + "px"
	});
	$(window).scroll(function() {
		var g = parseInt(b) + $(window).scrollTop();
		d.animate({
			top: g + "px"
		}, {
			duration: c || 350,
			queue: false
		})
	})
};
Util.File = {
	ShowSize: function(bytes) {
		bytes = parseInt(Number(bytes));
		var unit = new Array("B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB", "DB", "NB");
		var extension = unit[0];
		var max = unit.length;
		for (var i = 1;
			((i < max) && (bytes >= 1024)); i++) {
			bytes = bytes / 1024;
			extension = unit[i]
		}
		return Number(bytes).toFixed(2).replace(/\.00/, "") + extension
	}
};
Util.getPosition = function(obj) {
	if (typeof(obj) === "string") obj = Util.getID(obj);
	var c = 0;
	var d = 0;
	var w = obj.offsetWidth;
	var h = obj.offsetHeight;
	do {
		d += obj.offsetTop || 0;
		c += obj.offsetLeft || 0;
		obj = obj.offsetParent
	} while (obj) return {
		x: c,
		y: d,
		width: w,
		height: h
	}
};
Util.getPOP = function(self, tar, wid) {
	var aTop = self.offset().top;
	var aLeft = self.offset().left;
	var aHeight = self.outerHeight();
	var aWidth = self.outerWidth();
	var tmpWidth = tar.show().width();
	tar.hide();
	var tmpHeight = tar.height();
	var tmpTop = aTop;
	var tmpLeft = aLeft + aWidth / 2;
	var up = tar.find('.ar_up');
	var upInner = tar.find('.ar_up_in');
	if (self.hasClass('ToolTipCols')) {
		tmpWidth = tar.width()
	} else {
		if (tmpWidth > wid) {
			tmpWidth = wid
		} else {
			tmpWidth = tar.width()
		}
	};
	var tipY = $(window).height() - (aTop + tmpHeight);
	var tipX = $(window).width() - (aLeft + tmpWidth);
	if (tipX < Util.ToolTip.x) {
		tmpLeft = tmpLeft - (tmpWidth - aWidth / 2) + 5;
		up.css({
			left: 'auto',
			right: 5 + 'px',
			marginLeft: '0'
		});
		upInner.css({
			left: 'auto',
			right: 5 + 'px',
			marginLeft: '0'
		})
	} else {
		if (tmpLeft < tmpWidth) {
			tmpLeft = tmpLeft - aWidth / 2 - 5;
			up.css({
				left: 5 + 'px',
				marginLeft: '0'
			});
			upInner.css({
				left: 5 + 'px',
				marginLeft: '0'
			})
		} else {
			tmpLeft = tmpLeft - tmpWidth / 2
		}
	};
	if (tipY < Util.ToolTip.y) {
		tmpTop = tmpTop - aHeight - tmpHeight;
		up.addClass('ar_down');
		upInner.addClass('ar_down_in')
	} else {
		tmpTop = tmpTop + aHeight + 12;
		if (self.hasClass('ToolTipCols')) {
			upInner.css({
				'border-color': 'transparent transparent #e8ecef transparent'
			})
		}
	};
	tar.css({
		position: 'absolute',
		top: tmpTop,
		left: tmpLeft,
		width: tmpWidth,
		zIndex: Util.ToolTip.zindex
	});
	tar.fadeIn('slow')
};
Util.callBackType = {
	onFocus: function(tar, text) {
		var typ = '<div class="callback-focus">' + text + '</div>';
		Util.getTargeting(tar, typ)
	},
	error: function(tar, text) {
		var typ = '<div class="callback-error">' + text + '</div>';
		Util.getTargeting(tar, typ)
	},
	succeed: function(tar, text) {
		var typ = '<div class="callback-succeed">' + text + '</div>';
		Util.getTargeting(tar, typ)
	}
};
Util.getTargeting = function(tar, typ) {
	var con = $(typ);
	$('body').append(con);
	con.css({
		position: 'absolute',
		top: tar.offset().top + tar.outerHeight() / 2 - 10,
		left: tar.offset().left + tar.outerWidth() + 10,
		zIndex: 9999
	})
};
Util.callType = {
	loading: function(text) {
		return '<div class="loding-infos"><p class="load32"></p><p class="text">' + text + '</p></div>'
	},
	tips: function(text) {
		return '<div class="not-infos"><p><i class="icons"></i>' + text + '</p></div>'
	},
	erro: function(text) {
		return '<div class="erro-infos"><p><i class="icons"></i>' + text + '</p></div>'
	}
};
Util.Model = function(items, inparams) {
	var params = {
		title: '',
		type: '',
		maskerID: 'modelOverlay',
		contentID: 'modelContent',
		className: '',
		width: 550,
		height: '',
		top: '',
		alpha: 0.35,
		bgColor: '#000',
		time: '',
		onSelect: '',
		noSelect: '',
		isDrag: true,
		btns: true,
		nbtnShow: true,
		dbclick: true,
		keydown: true,
		mZindex: 9997,
		cZindex: 9999,
		ybtn: '确定',
		nbtn: '取消',
		yClass: '',
		nClass: '',
		closeTxt: '关闭'
	};
	if (inparams && typeof(inparams) == 'object') {
		for (var key in inparams) {
			if (key.match(/^_/)) {
				continue
			}
			params[key] = inparams[key]
		}
	};
	Util.config.modelFn = params.noSelect;
	var _width = Util.pageSize()['scrollWidth'];
	var _height = Util.pageSize()['scrollHeight'];
	$(window).size(function() {
		_width = Util.pageSize()['scrollWidth'];
		_height = Util.pageSize()['scrollHeight']
	});
	var html = '<div id="' + params.maskerID + '" style="position:absolute;left:0;top:0;right:0;bottom:0;z-index:' + params.mZindex + ';width:' + _width + 'px;height:' + _height + 'px;background:' + params.bgColor + '"></div>';
	html += '<div id="' + params.contentID + '" class="model-dialog ' + params.className + '" style="z-index:' + params.cZindex + ';width:' + params.width + 'px;height:' + params.height + 'px">';
	html += '<div class="model-head">';
	html += '<h2>' + params.title + '</h2>';
	html += '<a href="javascript:;" class="btn r3 model-close"><i class="icons">' + params.closeTxt + '</i></a>';
	html += '</div>';
	html += '<div class="dialog-body">';
	html += items;
	html += '</div>';
	if (params.btns) {
		html += '<div class="model-foot"><div class="inner">';
		if (params.nbtnShow) {
			html += '<a href="javascript:;" class="btn model-close r3 ' + params.nClass + '"><i class="icons yclose"></i>' + params.nbtn + '</a>'
		};
		html += '<a href="javascript:;" class="btn r3 model-yes ' + params.yClass + '"><i class="icons cm-white"></i>' + params.ybtn + '</a>';
		html += '</div></div>'
	};
	html += '</div>';
	$(html).appendTo('body').fadeIn(200);
	var modelBox = $('#' + params.maskerID);
	var modelBody = $('#' + params.contentID);
	modelBox.fadeTo(0, params.alpha);
	var tmpH = modelBody.height();
	var tmpW = modelBody.width();
	var tmpL = ($(window).width() - tmpW) / 2;
	var tmpT = ($(window).height() - tmpH) / 2 + $(document).scrollTop();
	modelBody.css({
		left: tmpL,
		top: params.top == '' ? tmpT : params.top,
		width: tmpW
	}).fadeIn(200);
	if (typeof params.time === 'number') {
		setTimeout(function() {
			Util.modelClose(modelBox, modelBody)
		}, params.time)
	};
	if (params.isDrag) {
		Util.drag({
			obj: params.contentID,
			handle: '.model-head'
		})
	};
	modelBody.find('.model-yes').click(function() {
		if (params.onSelect != '' && $.isFunction(params.onSelect)) {
			params.onSelect(this)
		}
	});
	modelBody.find('.model-close').click(function() {
		Util.modelClose(modelBox, modelBody);
		return false
	});
	if (params.dbclick) {
		modelBox.bind('dblclick', function(e) {
			e = e || window.event;
			var ele = e.srcElement ? e.srcElement : e.target;
			Util.modelClose(modelBox, modelBody)
		})
	};
	if (params.keydown) {
		document.onkeydown = function(event) {
			event = window.event || event;
			var keyCode = event.keyCode || event.which || event.charCode;
			if (event.keyCode == 27) {
				Util.modelClose(modelBox, modelBody)
			}
		}
	}
};
Util.modelClose = function(o, m) {
	if (Util.config.modelFn != '' && $.isFunction(Util.config.modelFn)) {
		Util.config.modelFn(this)
	};
	o.fadeOut(function() {
		o.remove()
	});
	m.fadeOut(function() {
		m.remove()
	})
};
Util.jDialog = {
	Mask: function(dia, confirmCallback, cancelCallback) {
		if (typeof($('#overlayModal')[0]) == 'undefined') {
			$('body').append('<div id="overlayModal"></div>');
			var mod = $('#overlayModal');
			var tmpWidth = $(document.body).width();
			var tmpHeight = $(document.body).height();
			if (Util.Browser.isios || Util.Browser.isAndroid) {
				tmpWidth = tmpWidth + 20
			};
			mod.css({
				position: 'absolute',
				left: 0,
				top: 0,
				right: 0,
				bottom: 0,
				width: tmpWidth,
				height: tmpHeight,
				background: '#000000',
				zIndex: 9997
			}).fadeTo(0, 0.3);
			Util.jDialog.Event(dia, mod, confirmCallback, cancelCallback)
		}
	},
	Event: function(dia, mod, confirmCallback, cancelCallback) {
		dia.find('.closeModal').click(function() {
			dia.fadeOut();
			mod.fadeOut(function() {
				mod.remove()
			});
			if (cancelCallback != false) cancelCallback();
			return
		});
		dia.find('.verifyModal').click(function() {
			dia.fadeOut();
			mod.fadeOut(function() {
				mod.remove()
			});
			if (confirmCallback != false) confirmCallback();
			return
		});
		document.onkeydown = function(event) {
			event = window.event || event;
			var keyCode = event.keyCode || event.which || event.charCode;
			if (event.keyCode == 27) {
				dia.fadeOut();
				mod.fadeOut(function() {
					mod.remove()
				});
				if (cancelCallback != false) cancelCallback();
				return
			}
		}
	},
	Pois: function(dia, top) {
		var tmpH = dia.height();
		var tmpW = dia.width();
		var tmpL = ($(window).width() - tmpW) / 2;
        var tmpT = (top || ($(window).height() - tmpH) / 2) + $(document).scrollTop();
		dia.css({
			left: tmpL,
			top: tmpT,
			width: tmpW,
			zIndex: 9999
		}).fadeIn(200)
	},
	Modal: function(jdia, undia, top) {
		var dia = $('#' + jdia);
		if (Util.getID(jdia) && Util.getID(undia)) {
			Util.jDialog.Mask(dia, false, false);
			Util.jDialog.Pois(dia, top);
			Util.mDrag(jdia, undia)
		}
	},
	Prompt: function(options) {
		var defaults = {
			button: true,
			buttonCancel: true,
			icon: 'tanhao-gray60',
			title: '提示',
			text: '',
			color: '#475058',
			closed: '关闭',
			cancel: '取消',
			confir: '确认',
			type: 'prompt',
			width: 400,
			confirmCallback: false,
			cancelCallback: false
		};
		if (options && typeof(options) == 'object') {
			for (var key in options) {
				if (key.match(/^_/)) {
					continue
				}
				defaults[key] = options[key]
			}
		};
		$('#dialogPrompt').remove();
		var html = '<div id="dialogPrompt" class="dialog-main" style="width:' + defaults.width + 'px">';
		html += '<div class="dialog-head"><h2>' + defaults.title + '</h2><a href="javascript:;" class="closeModal r3"><i class="icons">' + defaults.closed + '</i></a></div>';
		html += '<div id="dialogCont">';
		if (defaults.type == 'prompt') {
			html += '<div style="position:relative;height:60px;line-height:20px;text-align:left;padding:20px 30px 20px 120px; overflow:hidden">';
			html += '<table style="width:100%"><tr><td style="height:60px;color:' + defaults.color + '">' + defaults.text + '</td></tr></table>';
			html += '<i class="icons ' + defaults.icon + '" style="position:absolute; left:50px; top:50%; margin-top:-30px"></i>';
			html += '</div>'
		};
		if (defaults.type == 'modal') {
			html += defaults.text
		};
		if (defaults.button) {
			html += '<div class="dialog-foot"><div class="bank-action">';
			if (defaults.buttonCancel) {
				html += '<a href="javascript:;" class="r3 bank-delete closeModal"><i class="icons yclose"></i>' + defaults.cancel + '</a>'
			};
			html += '<a href="javascript:;" class="r3 bank-bind verifyModal"><i class="icons cm-white"></i>' + defaults.confir + '</a>';
			html += '</div></div>'
		};
		html += '</div></div>';
		$('body').append(html);
		var dia = $('#dialogPrompt');
		Util.jDialog.Mask(dia, defaults.confirmCallback, defaults.cancelCallback);
		Util.jDialog.Pois(dia);
		Util.mDrag('dialogPrompt', 'dialogCont')
	},
	getPois: function(a, b) {
		this._b = null;
		if (b === null || b === '' || typeof b === 'undefined') {
			return a.width()
		} else {
			return b
		};
		this._b = b
	}
};
Util.drag = function(o) {
	var defaults = {
		obj: "",
		handle: "",
		lock: true,
		lockX: false,
		lockY: false,
		fixed: false,
		parent: "",
		temp: "",
		dstar: function() {},
		dmove: function() {},
		dstop: function() {}
	};
	var o = $.extend(defaults, o);
	var _x, _y, _d, safe, otemp, mx = my = 0,
		_this = $("#" + o.obj);
	Util.config.drag = true;
	_d = o.handle != "" ? $(o.handle, _this) : _this;
	_d.mousedown(function(ev) {
		if (!Util.config.drag) return;
		safe = Util.safeRange(o.obj);
		var tempBox = _this.parent().find(o.temp);
		s = Util.pageSize();
		otemp = o.temp != "" ? tempBox : _this;
		star(ev);
		if (o.obj.setCapture) {
			o.obj.setCapture()
		} else if (window.captureEvents) {
			window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP)
		};
		$(document).on("mousemove", function(e) {
			move(e)
		}).on("mouseup", function(e) {
			stop(e)
		})
	});
	if (o.fixed) o.parent = "";
	if (o.parent != "") $("#" + o.parent).css("position", "relative");
	var star = function(ev) {
			ev = ev || window.event;
			ev.preventDefault();
			p = Util.getPosition(o.obj);
			ny = o.fixed ? Util.Browser.isIE6 ? s.scrollTop : 0 : 0;
			mx = ev.clientX - p.x;
			my = ev.clientY - p.y + ny;
			if (o.temp != "") {
				otemp.css({
					left: p.x + "px",
					top: p.y + ny + "px",
					width: safe.width + "px",
					height: safe.height + "px",
					display: "block"
				})
			};
			if (o.dstar != "" && $.isFunction(o.dstar)) o.dstar(this)
		},
		move = function(ev) {
			var parent;
			ev = ev || window.event;
			window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty();
			Util.clSelect();
			_x = ev.clientX - mx;
			_y = ev.clientY - my;
			if (o.parent != "") {
				parent = Util.getPosition(o.parent);
				op = Util.getPosition(o.obj);
				_x = ev.clientX - mx - parent.x;
				_y = ev.clientY - my - parent.y
			};
			maxX = o.parent != "" ? parent.width - op.width : safe.maxX;
			maxY = o.parent != "" ? parent.height - op.height : safe.maxY;
			if (o.lockX) _y = p.y;
			if (o.lockY) _x = p.x;
			if (o.lock) {
				if (_x <= 0) _x = safe.minX;
				if (_x >= maxX) _x = maxX;
				if (o.fixed) {
					if (_y <= 0) _y = safe.minY;
					if (_y >= maxY) _y = maxY
				} else {
					if (_y > maxY + s.scrollTop) _y = maxY + s.scrollTop;
					if (_y < s.scrollTop) _y = s.scrollTop
				}
			};
			otemp.css({
				left: _x + "px",
				top: _y + "px"
			});
			if (o.dmove != "" && $.isFunction(o.dmove)) o.dmove(this)
		},
		stop = function(ev) {
			if (o.temp != "" && Util.config.drag) {
				otemp.css("display", "none");
				_this.css({
					left: _x + "px",
					top: _y + "px"
				})
			};
			$(document).unbind("mousemove");
			if (o.obj.releaseCapture) {
				o.obj.releaseCapture()
			} else if (window.captureEvents) {
				window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP)
			}
			if (o.dstop != "" && $.isFunction(o.dstop)) o.dstop(this)
		}
};
Util.mDrag = function(a, b) {
	var bDrag = false;
	var disX = 0,
		disY = 0;
	var win = Util.getID(a);
	var obj = Util.getID(b);
	if (win && obj) {
		obj.onmousedown = function(event) {
			(event || window.event).cancelBubble = true
		};
		win.onmousedown = function(event) {
			event = event || window.event;
			bDrag = true;
			disX = event.clientX - win.offsetLeft;
			disY = event.clientY - win.offsetTop;
			this.setCapture && this.setCapture();
			return false
		};
		document.onmousemove = function(event) {
			if (!bDrag) return;
			event = event || window.event;
			var iL = event.clientX - disX;
			var iT = event.clientY - disY;
			var maxL = document.documentElement.clientWidth - win.offsetWidth;
			var maxT = document.documentElement.scrollHeight - win.offsetHeight;
			iL = iL < 0 ? 0 : iL;
			iL = iL > maxL ? maxL : iL;
			iT = iT < 0 ? 0 : iT;
			iT = iT > maxT ? maxT : iT;
			win.style.marginTop = win.style.marginLeft = 0;
			win.style.left = iL + 'px';
			win.style.top = iT + 'px';
			return false
		};
		document.onmouseup = window.onblur = win.onlosecapture = function() {
			bDrag = false;
			win.releaseCapture && win.releaseCapture()
		}
	}
};
Util.ToolTip = {
	x: 20,
	y: 20,
	zindex: 99999,
	timer: 200,
	toolClass: 'tool-tip',
	tipClass: 'ToolTips',
	tipID: 'ToolTip',
	wid: 300,
	hei: 0,
	init: function(cb) {
		$('.' + Util.ToolTip.tipClass).bind('mouseenter', function(e) {
			Util.stopBubble(e);
			var self = $(this);
			var txt = self.attr('data-text');
			Util.ToolTip.createHTML(self, txt, cb)
		}).click(function(e) {
			Util.stopBubble(e);
			var self = $(this);
			var txt = self.attr('data-text');
			if (typeof($('#' + Util.ToolTip.tipID)[0]) === 'undefined') {
				Util.ToolTip.createHTML(self, txt, cb)
			};
			return false
		});
	},
	createHTML: function(self, txt, cb) {
		if (!(txt == '' || txt == 'undefined' || txt == null)) {
			$('#' + Util.ToolTip.tipID).remove();
			var items = [],
				html = '';
			items = $.trim(txt).split("|");
			if (self.hasClass('ToolTipCol')) {
				html += '<div id="' + Util.ToolTip.tipID + '" class="' + Util.ToolTip.toolClass + '" style="position:absolute;left:-10000px;top:-10000px;display:block">';
				html += '<div class="items tool-tip-col">' + items + '</div>'
			} else if (self.hasClass('ToolTipCols')) {
				html += '<div id="' + Util.ToolTip.tipID + '" class="' + Util.ToolTip.toolClass + '" style="width:320px;display:none">';
				html += '<div class="items tool-tip-cols">';
				html += '<ul class="title"><li class="y_0">类型</li><li class="y_1">说明</li></ul>';
				html += '<ul>';
				for (var i = 0; i < items.length; i++) {
					html += '<li class="y_' + i + '">' + items[i] + '</li>'
				};
				html += '</ul>';
				html += '</div>'
			};
			html += '<b class="ar_up"></b><b class="ar_up_in"></b></div>';
			$('body').append(html);
			var tar = $('#' + Util.ToolTip.tipID);
			tar.show(function() {
				Util.getPOP(self, tar, Util.ToolTip.wid)
			});
			Util.getPOP(self, tar, Util.ToolTip.wid);
			tar.mouseleave(function() {
				tar.remove()
			});
			tar.click(function(e) {
				Util.stopBubble(e)
			});
			$(document).click(function() {
				tar.remove()
			});
            Util.invokeCallback(cb);
		}
	}
};

function divTipCreate(txt) {
	return '<div class="prompt-cont">' + txt + '</div><b class="ar_up"></b><b class="ar_up_in"></b>'
};
Util.arrowPrompt = function(tar, txt, typ) {
	var c;
	if (typ == 'err') {
		c = $('<div class="yPrompt yPromptErr">' + divTipCreate(txt) + '</div>')
	} else if (typ == 'def') {
		c = $('<div class="yPrompt">' + divTipCreate(txt) + '</div>')
	} else {
		c = $('<div class="yPrompt">' + divTipCreate(txt) + '</div>')
	};
	$('body').append(c);
	var x = 10,
		y = 10;
	var aTop = tar.offset().top;
	var aLeft = tar.offset().left;
	var aHeight = tar.outerHeight();
	var aWidth = tar.outerWidth();
	var cWidht = c.width();
	var cHeight = c.height();
	var tipY = $(window).height() - (aTop + cHeight);
	var tipX = $(window).width() - (aLeft + cWidht);
	var tmpTop = aTop;
	var tmpLeft = aLeft + aWidth / 2;
	var up = c.find('.ar_up');
	var upInner = c.find('.ar_up_in');
	var poprompt = c.find('.content');
	if (tipX < x) {
		tmpLeft = tmpLeft - cWidht;
		up.css({
			left: 'auto',
			right: '5px',
			marginLeft: '0'
		});
		upInner.css({
			left: 'auto',
			right: '5px',
			marginLeft: '0'
		})
	} else {
		if (tmpLeft < x) {
			tmpLeft = tmpLeft;
			up.css({
				left: '15px'
			});
			upInner.css({
				left: '15px'
			})
		} else {
			tmpLeft = tmpLeft - cWidht / 2
		}
	};
	if (tipY < y) {
		tmpTop = aTop - aHeight - cHeight;
		up.addClass('ar_down');
		upInner.addClass('ar_down_in')
	} else {
		tmpTop = aTop + aHeight + 12
	};
	c.css({
		display: 'block',
		position: 'absolute',
		top: tmpTop,
		left: tmpLeft,
		zIndex: 999
	});
	var _width = poprompt.width();
	if (_width > 300) {
		_width = 300
	};
	poprompt.css({
		width: _width
	});
	setTimeout(function(){
		$(document).on('click.arrowPrompt',function(){
			c.remove();
			$(document).off('click.arrowPrompt');
		});
	}, 0);
};
Util.jTab = function(tab, pan, evt) {
	$(pan).find('.jPanel').hide();
	$(tab).find('.jTab:first').addClass('current').show();
	$(pan).find('.jPanel:first').show();
	$(tab).find('.jTab').bind(evt, function() {
		$(this).addClass('current').siblings('.jTab').removeClass('current');
		var index = $(tab).find('.jTab').index(this);
		$(pan).children().eq(index).show().siblings().hide();
		var tool = $('#ToolTip');
		if (typeof(tool[0]) != 'undefined') {
			tool.remove()
		};
		return false
	})
};
Util.Countdown = function(options) {
	var defaults = {
		element: 'Countdown',
		targetClass: '',
		timerAfter: '<span id="phoneCode"><a href="javascript:sendVerifycode(1);" id="msgCode" style="cursor:pointer;">短信获取验证码</a></span>',
		time: 60 // 秒
	};
	if (options && typeof(options) == 'object') {
		for (var key in options) {
			if (key.match(/^_/)) {
				continue
			}
			defaults[key] = options[key];
		}
	};
	var clearTimer = null,
		ele = defaults.element,
		count = defaults.time;
	var time = function() {
		if (count == 0) {
			ele.hide();
			ele.after(defaults.timerAfter);
			ele.remove();
			clearInterval(clearTimer);
		} else {
			ele.attr('class', defaults.targetClass + 'getCodeBotton codeDisabled r3');
			ele.html(count + '秒后重新获取');
			count--;
			clearTimer = setTimeout(function() {
				time();
			}, 1000);
		}
	};
	if (!ele.hasClass('codeDisabled')) {
		time();
	}
};
Util.CustomCheckbox = function(a) {
	var sel = 'selected';
	var ove = 'hover';
	a.click(function() {
		var _this = $(this).children('span');
		if (_this.hasClass(sel)) {
			_this.removeClass(sel)
		} else {
			_this.addClass(sel)
		}
	}).hover(function() {
		$(this).children('span').addClass(ove)
	}, function() {
		$(this).children('span').removeClass(ove)
	})
};
Util.CustomRadio = function(a, b) {
	var sel = 'selected';
	var ove = 'hover';
	var a = $(a);
	var b = $(b);
	a.click(function() {
		var _this = $(this).children('span');
		b.find(a).children('span').removeClass(sel);
		if (_this.hasClass(sel)) {
			_this.removeClass(sel)
		} else {
			_this.addClass(sel)
		}
	}).hover(function() {
		$(this).children('span').addClass(ove)
	}, function() {
		$(this).children('span').removeClass(ove)
	})
};
Util.jDropdown = function(tar, drop, name, evt, amte) {
	var clearTime = null;
	tar.on(evt, function() {
		tar.addClass(name);
		if (amte) {
			drop.animate({
				top: $(this).parent().height(),
				opacity: 'show'
			}, 200, function() {
				drop.show()
			})
		} else {
			drop.css({
				top: $(this).parent().height()
			}).show()
		}
	});
	tar.parent().on('mouseleave', function() {
		clearTime = setTimeout(function() {
			tar.removeClass(name);
			if (amte) {
				drop.animate({
					top: 0,
					opacity: 'hide'
				}, 100, function() {
					drop.hide()
				})
			} else {
				drop.hide()
			}
		}, 400)
	}).on('mouseover', function() {
		clearInterval(clearTime)
	})
};
Util.cookie = {
	get: function(a) {
		var b = "";
		var c = a + "=";
		var d = document.cookie;
		if (d.length > 0) {
			g = d.indexOf(c);
			if (g != -1) {
				g += c.length;
				f = d.indexOf(";", g);
				if (f == -1) f = d.length;
				b = unescape(d.substring(g, f))
			}
		};
		return b
	},
	set: function(a, b, t, d, e) {
		var c = "";
		var h = t || 24 * 30;
		if (h != null) {
			c = new Date((new Date()).getTime() + h * 3600000);
			c = "; expires=" + c.toGMTString()
		};
		document.cookie = a + "=" + escape(b) + c + (d ? ";path=" + d : ";path=/") + (e ? ";domain=" + e : "")
	},
	del: function(a) {
		document.cookie = a + "=;path=/;expires=" + (new Date(0)).toGMTString()
	}
};
jQuery.cookie = function(key, value, options) {
	if (arguments.length > 1 && String(value) !== "[object Object]") {
		options = jQuery.extend({}, options);
		if (value === null || value === undefined) {
			options.expires = -1
		};
		if (typeof options.expires === 'number') {
			var days = options.expires,
				t = options.expires = new Date();
			t.setDate(t.getDate() + days)
		};
		value = String(value);
		return (document.cookie = [encodeURIComponent(key), '=', options.raw ? value : encodeURIComponent(value), options.expires ? '; expires=' + options.expires.toUTCString() : '', options.path ? '; path=' + options.path : '', options.domain ? '; domain=' + options.domain : '', options.secure ? '; secure' : ''].join(''))
	};
	options = value || {};
	var result, decode = options.raw ? function(s) {
		return s
	} : decodeURIComponent;
	return (result = new RegExp('(?:^|; )' + encodeURIComponent(key) + '=([^;]*)').exec(document.cookie)) ? decode(result[1]) : null
};
Util.CookieEnable = function() {
	var a = false;
	if (navigator.cookiesEnabled) return true;
	document.cookie = "b=yes;";
	var c = document.cookie;
	if (c.indexOf("b=yes") > -1) a = true;
	document.cookie = "";
	return a
};
Util.measureScrollBar = function () {
	if (document.body.clientWidth >= window.innerWidth) {
		return 0;
	}
	var $measure = $('<div style="width: 100px;height: 100px;overflow: scroll; position: absolute;top: -99999em;"></div>');
	$(document.body).append($measure);
	var scrollBarWidth = $measure[0].offsetWidth - $measure[0].clientWidth;
	$measure.remove();
	return scrollBarWidth;
};
Util.weiXinPay = function() {
	var tar = $('a.weixin');
	if (typeof(tar[0]) != 'undefined') {
		var html = '<div id="weixinDialog" class="dialog-main" style="width:360px">';
		html += '<div class="dialog-head">';
		html += '<h2>关注有利网官方微信</h2>';
		html += '<a href="javascript:;" class="closeModal r3"><i class="icons">关闭</i></a></div>';
		html += '<div id="weixinEntry">';
		html += '<p style="text-align:center;padding:15px 0"><img style="display:block;margin:0 auto;width:220px;height:220px" src="' + Util.config.imgfile + 'common/weixin-code.jpg"></p>';
		html += '<div class="dialog-foot"> <p style="padding:7px 10px 0 10px;font-size:12px">打开微信，点击底部的&Prime;发现&Prime;，使用&Prime;扫一扫&Prime;即可关注有利网官方微信。</p></div>';
		html += '</div></div>';
		$('body').append(html);
		tar.click(function() {
			Util.jDialog.Modal('weixinDialog', 'weixinEntry');
			return false
		})
	}
};
Util.getArrayMin = function (array) {
	return Math.min.apply(Math, array);
};

Util.getArrayMax = function (array) {
	return Math.max.apply(Math, array);
};
Util.formatDateStr = function(str){
	if (typeof str === 'string') {
		str = $.trim(str);
		if (str.indexOf('T') >= 0) {
			str = str.replace('T', ' ');
		}
		if (str.indexOf('-') >= 0) {
			str = str.replace(/-/g, '/');
		}
	}
	return str;
};
Util.keys = function(obj){
	var tmpArr = [];
	if (!Object.keys) {
		for (var key in obj) {
			tmpArr.push(key);
		}
	} else {
		tmpArr = Object.keys(obj);
	}
	return tmpArr;
};
Util.RandomNum = function(Min, Max) {
	var Range = Max - Min;
	var Rand = Math.random();
	if(Math.round(Rand * Range)==0){
		return Min + 1;
	}else if(Math.round(Rand * Max)==Max){
		return Max - 1;
	}else{
		var num = Min + Math.round(Rand * Range) - 1;
		return num;
	}
};
Util.getCurrentMonthLast = function(date) {
    date = date ? new Date(date) : new Date();
    var currentMonth = date.getMonth();
    var nextMonth = ++currentMonth;
    var nextMonthFirstDay = new Date(date.getFullYear(), nextMonth, 1);
    var oneDay = 1000 * 60 * 60 * 24;
    return new Date(nextMonthFirstDay - oneDay).getDate();
};

try {
	document.execCommand("BackgroundImageCache", false, true)
} catch (e) {};
$(function() {
	var nav = $('#navDown');
	Util.jDropdown(nav.find('.gls'), nav.find('.dropdown'), 'current', 'mouseover', false);
	Util.ToolTip.init();
	Util.alink('a');
	Util.weiXinPay();
	$('input.input').focus(function() {
		$(this).addClass('focus')
	}).blur(function() {
		$(this).removeClass('focus')
	})
});