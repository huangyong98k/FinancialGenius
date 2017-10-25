/**
 * Created by 小胖 on 2017/10/17.
 */
function earn(){
        var beginDate = document.getElementById("beginDate").value.split("-");
        var overDate = document.getElementById("overDate").value.split("-")
        var principal = document.getElementById("principal").value;
        var number = document.getElementById("number").value;
        var rate = document.getElementById("rate").value;
        var earning;
        var year1 = parseInt(beginDate[0])
        var month1 = parseInt(beginDate[1])
        var year2 = parseInt(overDate[0])
        var month2 = parseInt(overDate[1])
        if(year2<year1) {
            alert("到期日期选择错误！");
        }else if(year2==year1&&month2<month1){
            alert("到期日期选择错误！");
        }else if(year2==year1&&month2==month1){
            document.getElementById("earning").value=0;
        }else if(year2==year1&&month2>month1){
            earning = principal*number*(month2-month1)*rate/100;
            document.getElementById("earning").value=earning;
        }else if(year2>year1&&month2>month1){
            earning = principal*number*((year2-year1)*12+(month2-month1))*rate/100;
            document.getElementById("earning").value=earning;
        }else if (year2>year1&&month2==month1) {
        	earning = principal*number*((year2-year1)*12)*rate/100;
        	 document.getElementById("earning").value=earning;
		}else if (year2>year1&&month2<month1) {
			earning = principal*number*((year2-year1)*12+(12-month2+month1))*rate/100;
            document.getElementById("earning").value=earning;
		}
    }