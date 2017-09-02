<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
</head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 商品添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回 </a>
</td>
</tr>
</table>
<br/>
<br/>
<!-- action对应一个action标签，id对应提交时的对应关系 -->

	<form method="post" id="saveForm" action="product_add" enctype="multipart/form-data">
               商品名称:<input type="text" name="name">
	 商品描述:<input type="text" name="desc"><br/>
	 商品图片:<input type="text" name="image">
	 商品价格:<input type="text" name="price"><br/>
	 <input type="hidden" name="groupIds" value="" id="groupIds"/>
	 <c:forEach items="${list_group}" var="group">
	 ${group.name}
	 <select class="cata_select">
	     <c:forEach items="${group.catageryList}" var="catagery">
	      <option class="cata" value="${catagery.id}">${catagery.name}</option>
	     </c:forEach>
	 </select>
	 </c:forEach>
    <form>
          文件上传：<input type="file" name="attachs"/><br/>
</body>
<script type="text/javascript">

var ids="";
$(".cata").each(function(){
	 if($(this).prop("selected")){
		 ids+=$(this).val()+",";
		 
	 }
});
$("#groupIds").val(ids);


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