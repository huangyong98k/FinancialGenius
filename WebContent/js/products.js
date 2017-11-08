/**
 * Created by 小胖 on 2017/10/17.
 */
function earn(){
        var beginDate = document.getElementById("beginTime").value.split("-")
        var overDate = document.getElementById("overTime").value.split("-")
        var newBeginDate = new Date(beginDate[1]+'-'+beginDate[2]+'-'+beginDate[0]);
        var newOverDate = new Date(overDate[1]+'-'+overDate[2]+'-'+overDate[0]);
        var days = parseInt(Math.abs(newOverDate-newBeginDate)/1000/60/60/24)
        var principal = document.getElementById("principal").value;
        var number = document.getElementById("number").value;
        var rate = document.getElementById("rate").value;
        var earning=null;
        var spend=(principal*number);
        var month=days/30;
        console.log(spend);
        console.log(days);
        if((beginDate==""||undefined||null||NaN)||(overDate==""||null||undefined||NaN)||(days==NaN)){
        	document.getElementById("earning").value="";
        	document.getElementById("spend").value=spend;
        	return false
        }else if(beginDate[0]>overDate[0]){
        	alert("日期有误！")
        	document.getElementById("earning").value="";
        	document.getElementById("spend").value=spend;
        	return false
        }else if (beginDate[0]==overDate[0]&&beginDate[1]>overDate[1]) {
			alert("日期有误！")
			document.getElementById("earning").value="";
			document.getElementById("spend").value=spend;
			return false
		}else if (beginDate[0]==overDate[0]&&beginDate[1]==overDate[1]&&beginDate[2]>overDate[2]) {
			alert("日期有误！")
			document.getElementById("earning").value="";
			document.getElementById("spend").value=spend;
			return false
		}else if (month<1) {
			alert("投资日期不足1个月！")
			document.getElementById("earning").value=0;
			document.getElementById("spend").value=spend;
			return false
        }else{
			earning=((principal*number*(days/30)*rate)/100).toFixed(2)
        	document.getElementById("earning").value=earning;
			document.getElementById("spend").value=spend;
			return true
		}
    }