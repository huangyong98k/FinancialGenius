$(document).ready(function(event) {
    //柱状图-----------------
    // 横轴数据
    var getNames = function() {
        var name = ['2017.1.', '2017.2', '2017.3', '2017.4', '2017.5','2017.6.', '2017.7', '2017.8', '2017.9', '2017.10'];
        return name;
    };

    // 纵轴数据
    var getValues = function() {
        var value = ['20', '30', '30', '35', '35','40','45','45','50','50'];
        return value;
    };

    // 柱状图参数
    var barChartData = {
        labels: getNames(),
        datasets: [{
            label: 'Dataset 1',
            // 默认背景颜色
            backgroundColor: "rgba(0,0,255,0.5)",
            data: getValues()
        }]

    };

    $(function() {
        // 生成柱状图
        var ctx = document.getElementById("myChart_1").getContext("2d");
        window.myBar = new Chart(ctx, {
            type: 'bar',
            data: barChartData,
            options: {
                responsive: true,
                legend: {
                    position: 'top',
                },
                title: {
                    display: true,
                    text: '累计投资金额柱状图'
                }
            }
        });
    });

});