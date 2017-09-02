<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style>
body{
bg-color:#ddd;
}
#myDiv{
    position:absolute;
    left:50%;
    top:50%;
    margin-left:-200px;
    margin-top:-100px;
    background-color:#ddd;
    padding:10px;
}
.login_input{
  width:200px;
  height:20px;
 
  border:none;
  background-color:#fff;
}
a{
 text-decoration:none;
 margin-left:120px;
}
</style>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
</head>
<body>
<form  action="show" method="post">
<div width="300" border="1" id="myDiv"> 
    <h2 >欢迎登录</h2>      
              用户名: <p> <input type="text" name="username"  class="login_input"></p>    
              密码:  <p> <input type="password" name="password" class="login_input"></p>
         <p>  <input type="submit" name="submit" class="login_submit" value="登录"> <a href="register">注册新用户</a></p>
</div>
</form>
</body>
</html>