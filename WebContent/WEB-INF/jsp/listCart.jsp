<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车列表</title>
<script type="text/javascript">
    
   
</script>
</head>
<body style="text-align: center;">
    <h1>购物车列表</h1>
   <table width="70%" border="1" align="center">
        <tr>
            <td>商品</td>
            <td>售价</td>
            <td>操作</td>
        </tr>

        <c:forEach var="goods" items="${listCart }">
            <tr>
                <td>${goods.name }</td>
                <td>${goods.price }</td>
                
               <td>
                 <a href="#">删除</a>
               </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>