$(document).ready(function(){ 
	var param = getParam()
	var check = param.charAt(0)+param.charAt(1)+param.charAt(2)+param.charAt(3)
	if(check=="http")
		history.go(-1);
})

function getParam(){
	var url = location.href;  
	var paraString = url.substring(url.indexOf("?")+1,url.length);  
	var param = paraString.substring(paraString.indexOf("=")+1, url.length)
	return param
}
function checkGoods(){
	$.post("../../check.do",{serial:getParam()},function(){
		window.location.href = "mylist.jsp?serial="+getParam()
	})
	
}

$(function(){
	$(".click").click(function(){
		alert("您选择的商品正在发往后台处理，请稍等....")
	})
	$(".delete").click(function(){
		alert("删除成功。")
	})
})
