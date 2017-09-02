<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表页面</title>
 <script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
</head>
<body style="text-align: center;">
欢迎您：${loginUser.lastName};
    <h1>商品列表</h1>
      
    <table width="70%" border="1" align="center">
        <tr>
            <td>商品</td>
            <td>售价</td>
            <td>描述</td>
            <td>操作</td>
        </tr>

        <c:forEach var="goods" items="${list }">
            <tr>
                <td>${goods.name }</td>
                <td>${goods.price }</td>
                <td>${goods.description }</td>
                <td>
                    <a href="#" class="mycart" goodsId="${goods.id }" >购买</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="listCart">我的购物车</a>
    <script>
      $(".mycart").on("click",function(){
    	  var goodsId=$(this).attr("goodsId") ;
    	  var prama ={
    			  "goodsId":goodsId
    	  }
    	  $.ajax({
    		  url: "mycart",
    		  type: 'get',
    		  data:prama,
    		  dataType: 'json',
    		  success: function (data) {
    		   if(data==1){
    			   alert("购买成功")
    		   }
    		  },
    		  fail: function (err) {
    		    alert(err)
    		  }
    		})
      })
    </script>
</body>
</html>