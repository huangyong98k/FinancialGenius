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

