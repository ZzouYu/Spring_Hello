<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
</head>
<body style="text-align: center;">
    <h1>商品列表</h1>
    <form action="search" method="post" id="search">
     <input type="hidden" name="groupIds" value="${groupIds}" id="groupIds"/>
    <c:forEach items="${list_group}" var="group">
	 ${group.name}
	 <select class="cata_select">
	     <c:forEach items="${group.catageryList}" var="catagery">
	      <option class="cata" value="${catagery.id}">${catagery.name}</option>
	      
	     </c:forEach>
	 </select>
	 </c:forEach>
	</form>
	<a href="javascript:document.getElementById('search').submit()">查询</a> &nbsp;&nbsp;
	<a href="addProduct">新增</a>
   <table width="70%" border="1" align="center">
        <tr>
            <td>商品图片</td>
            <td>商品名称</td>
            <td>商品描述</td>
            <td>商品价格</td>
            <td>操作</td>
        </tr>
        <c:forEach var="product" items="${list}">
            <tr>
                 <td><img src="${product.image}" style="width:20px;height:20px;"/></td>
                 <td>${product.name }</td>
                 <td>${product.desc }</td>
                 <td>${product.price }</td>
               <td>
                 <a href="${product.id}/delete">删除</a>
                 
               </td>
            </tr>
        </c:forEach>
    </table>
</body>
<script type="text/javascript">
if($("#groupIds").val() == ""){

	var ids="";
	$(".cata").each(function(){
		 if($(this).prop("selected")){
			 ids+=$(this).val()+",";
		 }
		 
	});
	$("#groupIds").val(ids);
}else{
	$(".cata").each(function(){
		//alert($("#groupIds").val()+"---"+$(this).val());
		if($("#groupIds").val().indexOf($(this).val()) >= 0){
			 $(this).attr("selected",true);
		 }
	});
}

$(".cata_select").change(function(){
	var ids="";
	  $(".cata").each(function(){
		 if($(this).prop("selected")){
			 ids+=$(this).val()+","; 
		 }
	  });
	  $("#groupIds").val(ids);
});
   </script>
</html>