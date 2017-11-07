function userGain() {
	var gain = $('#userGain');
	gain.wrap('<div class="gain-items"></div>').css('z-index', 9);
	setTimeout(function() {
		gain.animate({
			top: -290,
			right: 0
		}, 800).animate({
			top: -300,
			right: 0
		}, 800)
	}, 800)
}

function showPer() {
	var tar = $('.progre');
	tar.each(function() {
		var self = $(this);
		var per = self.find('.per');
		var div = per.find('div');
		var num = parseInt(per.attr('data-rel'));
		var interval;
		var count = 0;
		if (num == 100) {
			count = 100
		};
		var plus = function() {
			div.css({
				width: count + '%'
			});
			if (count == num || count == 100) {
				clearInterval(interval)
			};
			count++
		};
		interval = setInterval(plus, 5)
	})
}

function slideSwitch() {
	var stay = 6,
		fade = 0.7,
		msec = 1000,
		timer = 400,
		timeout, prev = next = 0,
		slider = $('#slider'),
		autoPlay = true,
		slideindex = true,
		controls = false,
		html = '',
		term = slider.children('li'),
		len = term.length;
	slider.wrap('<div class="slider-items"></div>');
	if (slideindex) {
		if (len > 1) {
			html += '<div class="slider-index">';
			html += '<ol class="items">';
			for (var i = 1; i <= len; i++) {
				html += '<li ' + (i == 1 ? 'class="current"' : '') + '>' + i + '</li>'
			};
			html += '</ol>';
			html += '</div>'
		}
	}
	if (controls) {
		html += '<div class="slider-updown">';
		html += '<a href="#" class="button prev" data-rel="prev">prev</a>';
		html += '<a href="#" class="button next" data-rel="next">next</a>';
		html += '</div>'
	}
	slider.parent('.slider-items').wrap('<div class="slider-wrap"></div>').css({
		'position': 'relative',
		'overflow': 'hidden'
	}).after(html);
	var thumbCont = slider.parent().siblings('.slider-index');
	var thumb = thumbCont.find('li');
	var button = slider.parent().siblings('.slider-updown');
	slider.fadeIn();
	if (len == 1) {
		term.first().fadeIn()
	}
	if (!autoPlay) {
		term.first().fadeIn()
	}
	button.find('.button').bind('click', function() {
		var self = $(this).attr('data-rel');
		if (self == 'prev') {
			if (prev == 0) {
				next = len - 1
			} else {
				next = prev - 1
			}
		} else if (self == 'next') {
			if (prev == len - 1) {
				next = 0
			} else {
				next = prev + 1
			}
		};
		if (autoPlay) {
			changeAutoPlay()
		}
		return false
	});
	thumb.bind('click', function() {
		next = thumb.index($(this));
		clearTimeout(timeout);
		changePlay(next);
		if (next == len - 1) {
			next = 0
		} else {
			next++
		}
	});
	slider.hover(function() {
		clearTimeout(timeout)
	}, function() {
		if (autoPlay) {
			if (len > 1) {
				timeout = setTimeout(changeAutoPlay, stay * msec)
			}
		}
	});
	var changePlay = function(next) {
		term.eq(prev).fadeOut(fade * msec);
		term.eq(next).fadeIn(fade * msec);
		thumb.removeClass('current');
		thumb.eq(next).addClass('current');
		if (typeof($('#userGain')[0]) != '') {
			$('#userGain').find('.opacity').css({
				opacity: term.eq(next).attr('data-opacity')
			})
		}
		prev = next
	};
	var changeAutoPlay = function() {
		clearTimeout(timeout);
		changePlay(next);
		next = prev + 1;
		if (next >= len) {
			next = 0
		};
		if (autoPlay) {
			timeout = setTimeout(changeAutoPlay, stay * msec)
		}
	};
	if (autoPlay) {
		if (len > 1) {
			changeAutoPlay()
		}
	}
}

function guideLoad() {
	var b = true;
	var n = $.cookie('NoviceGuide');
	$.cookie('NoviceGuide', b, {
		expires: 30,
		path: '/'
	});
	if (!n && !environment.userId) {
		Util.loadJS(environment.basePath + '/v2/local/js/common/guide.js')
	}
}

function investLoan(loanId) {
	var investUrl = environment.basePath + "/yuexitong/detail/" + loanId + ".html";
	window.location.href = investUrl
}

function investCredit(loanInvestorId) {
	var investUrl = environment.basePath + "/yuexitong/zhuan/" + loanInvestorId + ".html";
	window.location.href = investUrl
}

function fixedSidebar() {
	var side = $('.sidebar');
	var sideTop = side.offset().top + side.height();
	var h = $('.main').height() - side.height();
	var timer = 300;
	var fixStatus = function() {
		var winHeight = $(window).height();
		var scrollTop = $(document).scrollTop();
		var tempBottom = scrollTop + winHeight - sideTop;
		if (tempBottom > h) {
			tempBottom = h
		};
		if (scrollTop + winHeight > sideTop) {
			side.css({
				position: 'absolute',
				right: '0'
			}).stop(true).animate({
				top: tempBottom
			}, timer)
		} else {
			side.css({
				position: 'static',
				right: '0'
			}).stop(true).animate({
				top: 0
			}, timer)
		}
	};
	$(window).scroll(function() {
		fixStatus()
	});
	$(window).resize(function() {
		fixStatus()
	})
}
$(function() {
	guideLoad();
	userGain();
	fixedSidebar();
	var icon = $('.yol-top dt a');
	icon.hover(function() {
		$(this).css({
			left: 0,
			top: 0,
			margin: 0,
			width: 151,
			height: 151,
			background: 'url(' + Util.config.imgfile + 'home/0' + (icon.index(this) + 1) + '.gif) no-repeat 0 0'
		})
	}, function() {
		$(this).attr('style', '')
	});
	var oApp = $('#yWebapp');
	var oClose = oApp.find('.close');
	oClose.click(function() {
		oApp.fadeOut('slow')
	});

	function refreshHTML(id) {
		return '<div class="refresh"><i class="icons icons-refresh"></i>本场已开标 请<a id="refresh' + id + '" href="javascript:reloads(\'' + id + '\');">刷新</a>查看</div>'
	}
	var Novice = $('#CountdownNovice'),
		Plans = $('#CountdownPlans'),
		Loans = $('#CountdownLoans'),
		CP = $('#CountdownCP');
	Util.loadJS(environment.basePath + '/v2/local/js/common/countdown.js', function() {
		if (Novice.length > 0) {
			Novice.jCountdown({
				duration: 0,
				shifts: refreshHTML('Novice')
			})
		}
		if (Plans.length > 0) {
			Plans.jCountdown({
				duration: 0,
				date: ['10:30:00', '14:30:00', '20:00:00', '20:00:00'],
				shifts: refreshHTML('Plans')
			})
		}
		if (Loans.length > 0) {
			Loans.jCountdown({
				duration: 0,
				shifts: refreshHTML('Loans')
			})
		}
		if (CP.length > 0) {
			CP.jCountdown({
				duration: 0,
				date: ['10:30:00', '14:30:00', '20:00:00', '20:00:00'],
				shifts: refreshHTML('CP')
			})
		}
	});

	//判断是否有新任务新奖励弹窗
	var MissionPopup = $.cookie('MissionPopup');
	if(environment.userId && (document.referrer === _basePath + 'secure/login/' || !document.referrer) && !MissionPopup) {
		missionGuide(); //新任务新奖励弹窗
	}

	//切换到首页新版本
	$('#indexChange').click(function () {
		$.cookie('NEW_INDEX', true, {
			expires: 365*100,
			path: '/',
			domain: '.' + environment.cookieDomain
		});
		window.location.href = environment.nodePath;
	})
});

function reloads(target) {
	var _this = $('#refresh' + target);
	var soffset = _this.offset().top;
	window.location.reload();
	setTimeout(function() {
		$('body,html').animate({
			scrollTop: soffset
		}, 10)
	}, 200)
}

function missionGuide() {
    var isPop = mission && mission.status ? true : false;
    if(isPop) {
        $.cookie('MissionGuide', isPop, {
            expires: 7,
            path: '/'
        });
    }
	var status = mission.status;
    if(status){  //有新奖励或新任务
        if(status === '1') {  //新奖励
            var html = '<div id="taskComplete" class="dialog-main task-complete">';
            html += '<div id="rewardEntry">';
            html += '<div class="task-text">获得<span class="get-text">'+(mission.awardContent.length > 15 ? mission.awardContent.substring(0,15) + '...' : mission.awardContent)+'</span></div>';
            html += '<a href="'+ environment.basePath +'/myMission.session.action" class="task-btn">立即领取</a>';
            html += '</div><a href="javascript:;" class="closeModal task-close">×</a></div>';
            $('body').append(html);
            Util.jDialog.Modal('taskComplete', 'rewardEntry');
			$('#overlayModal').fadeTo(0, 0.6);
        }else if(status === '0') {  //新任务
            var html = '<div id="makeTask" class="dialog-main make-task">';
            html += '<div id="taskEntry">';
            html += '<div class="task-text">'+(mission.abstractinfo.length > 30 ? mission.abstractinfo.substring(0,30) + '...' : mission.abstractinfo)+'</div>';
            html += '<a href="'+ environment.basePath +'/myMission.session.action" class="task-btn">查看任务</a>';
            html += '</div><a href="javascript:;" class="closeModal task-close">×</a></div>';
            $('body').append(html);
            Util.jDialog.Modal('makeTask', 'taskEntry');
			$('#overlayModal').fadeTo(0, 0.6);
        }
    }
    //只弹窗一次 设置已弹窗标记
	$.cookie('MissionPopup', isPop, {
		expires: 1,
		path: '/'
	});
}