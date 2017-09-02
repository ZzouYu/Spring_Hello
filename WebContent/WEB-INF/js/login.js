// JavaScript Document
$(function(){
	 $("#click").click(function(){
		var url = location.href;  
		var paraString = url.substring(url.indexOf("?")+1,url.length);  
		var number = paraString.substring(paraString.indexOf("=")+1, url.length)
	 	if($("#username").val()!=""&&$("#password").val()!=""&&$("#safecode").val()!=""){
			var json = {name:$("#username").val(),pwd:$("#password").val(),safecode:$("#safecode").val()};
			$.ajax({
				type:"POST",
				url:"../login.do",
				dataType:"json",     
				contentType:"application/json",     
				data:JSON.stringify(json),
				success:function(data){								
					if(data.result == "fail"){
						$("#msg").html("<font color=red>用户名或密码不正确！</font>");
						$("#password").val("")
						$("#username").val("")
					}else if(data.result == "wrong"){
						alert("验证码不正确！")
						$("image").src = "../safecode.do?id="+Math.random;
						$("#safecode").val("")
					}else{
						alert(data.result)
//						$.post("../jsp/index.jsp",{serial:data.result})
						window.location.href = "../jsp/index.jsp?serial="+data.result
					}	
				}
			});
			return true;
		}else{
			alert("请务必填写完整信息！");
			return false;
		}
	 });		
});

$(function(){
	$("flush").click(function(){
		$("image").src = "../safecode.do?id="+Math.random;
	});
});
