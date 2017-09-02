//$(document).ready(function(){ 
//	var url = location.href;  
//	var paraString = url.substring(url.indexOf("?")+1,url.length);  
//	var param = paraString.substring(paraString.indexOf("=")+1, url.length)
//	var check = param.charAt(0)+param.charAt(1)+param.charAt(2)+param.charAt(3)
//	if(check=="http")
//		history.go(-1);
//	
//	var json = {username:param}	
//	
//	$.ajax({
//		type:"POST",
//		url:"../index.do",
//		dataType:"json",     
//		contentType:"application/json",     
//		data:JSON.stringify(json),
//		success:function(data){
//			if(data.username=="back"){
//				window.top.location.href = "../jsp/login.jsp"
//			}else
//				$("#msg").html(data.username)		
//		}
//	})
//})

function redirectWithParam(whitch){
	var url = location.href;  
	var paraString = url.substring(url.indexOf("?")+1,url.length);  
	var param = paraString.substring(paraString.indexOf("=")+1, url.length)
	if(whitch==0){
		$.get("../showgoods.do?type="+"FURNITURE",function(){
//			$.post("main/booklist.jsp",{serial:param})
			window.location.href = "main/booklist.jsp?serial="+param
		})
	}else if(whitch==1){
		$.get("../showgoods.do?type="+"CLOTHES",function(){
//			$.post("main/booklist.jsp",{serial:param})
			window.location.href = "main/booklist.jsp?serial="+param
		})
	}else if(whitch==2){
		$.get("../showgoods.do?type="+"FOOD",function(){
//			$.post("main/booklist.jsp",{serial:param})
			window.location.href = "main/booklist.jsp?serial="+param
		})
	}else if(whitch==3){
		$.get("../showgoods.do?type="+"BOOK",function(){
//			$.post("main/booklist.jsp",{serial:param})
			window.location.href = "main/booklist.jsp?serial="+param
		})
	}else if(whitch==4){
		$.get("../showgoods.do?type="+"ELECT",function(){
//			$.post("main/booklist.jsp",{serial:param})
			window.location.href = "main/booklist.jsp?serial="+param
		})
	}else if(whitch==5)
		$.post("../check.do",{serial:param},function(){
			window.location.href = "main/mylist.jsp?serial="+param
		})
	
}

$(function(){
	$("#one").mouseover(function(){
		$(this).css("background","#CCCCFF")
	});
	$("#two").mouseover(function(){
		$(this).css("background","#CCCCFF")
	});
	$("#three").mouseover(function(){
		$(this).css("background","#CCCCFF")
	});
	$("#four").mouseover(function(){
		$(this).css("background","#CCCCFF")
	});
	$("#five").mouseover(function(){
		$(this).css("background","#CCCCFF")
	});
	$("#six").mouseover(function(){
		$(this).css("background","#CCCCFF")
	});
	
	$("#one").mouseout(function(){
		$(this).css("background","#f0f0f0")
	});
	$("#two").mouseout(function(){
		$(this).css("background","#f0f0f0")
	});
	$("#three").mouseout(function(){
		$(this).css("background","#f0f0f0")
	});
	$("#four").mouseout(function(){
		$(this).css("background","#f0f0f0")
	});
	$("#five").mouseout(function(){
		$(this).css("background","#f0f0f0")
	});
	$("#six").mouseout(function(){
		$(this).css("background","#f0f0f0")
	});
	
	$("#first").mouseover(function(){
		$(this).css("background","#daaaaa")
	});
	$("#second").mouseover(function(){
		$(this).css("background","#daaaaa")
	});
	$("#third").mouseover(function(){
		$(this).css("background","#daaaaa")
	});
	$("#forth").mouseover(function(){
		$(this).css("background","#daaaaa")
	});
	$("#first").mouseout(function(){
		$(this).css("background","#ff5555")
	});
	$("#second").mouseout(function(){
		$(this).css("background","#ff5555")
	});
	$("#third").mouseout(function(){
		$(this).css("background","#ff5555")
	});
	$("#forth").mouseout(function(){
		$(this).css("background","#ff5555")
	});
})



