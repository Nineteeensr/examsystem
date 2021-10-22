<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.80.0">
<title>线上考试系统</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">



<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

body {
	background-image: url(img/bg3.jpg);
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
}
</style>


<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet" type="text/css">
</head>
<body class="text-center" style="text-align: center;">

	<form class="form-signin" action="LoginServlet" method="post">
	<c:if test="${mess!=null }"><div style="color:red;">${mess }</div></c:if>
		<div class="lg">
			<img class="mb-4" src="img/kgclogo2.png" > <select
				name="loginType" class="form-control form-control-lg">
				<option value="stuLogin">学生登陆</option>
				<option value="manLogin">管理员登陆</option>
			</select>
			<!-- <h1 class="h3 mb-3 font-weight-normal">管理员登录</h1> -->
			<label for="inputEmail" class="sr-only">用户名</label> <input
				type="text" id="userName" name="userName" class="form-control"
				placeholder="请输入用户名" required autofocus style="margin-top: 15px;">
				<div id="uWaring" style="color:red;"></div>
			<label for="inputPassword "  class="sr-only">密码</label> <input
				type="password" id="userPwd" name="userPwd" class="form-control"
				placeholder="请输入密码" required style="margin-top: 15px;">
				<div id="pWaring" ></div>
			<label for="inputCode" class="sr-only">验证码</label> <input name="uCode" type="text"
				id="inputCode" class="form-control" placeholder="验证码"
				required
				style="width: 75%; display: inline-block; margin-top: 15px;">
			<img id="image" border="0" onclick="refresh()" src="image.jsp"
				title="点击更换图片">
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					记住我
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
			<p class="mt-5 mb-3 text-muted">&copy; 1998-2021</p>
	</form>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript">
		function refresh() {
			//alert(1);
			//IE存在缓存,需要new Date()实现更换路径的作用
			$("#image").attr("src", "image.jsp?" + new Date());
		}
		
		$('#userName').focusout(function(){
			
			console.log($('#userName').val());
			if($('#userName').val()==null || $('#userName').val()=="" ){
				$("#uWaring").text("用户名不能为空！");
			}else{
				$("#uWaring").text("");
			}
			
		});
		
		$('#userPwd').focusout(function(){
			console.log($('#userPwd').val());
			if($('#userPwd').val()==null || $('#userPwd').val()=="" ){
				$("#pWaring").text("密码不能为空！");
				$("#pWaring").css("color","red");
			}else{
				$("#pWaring").text("");
			}
			
		});
		
		$('#inputCode').focusout(function(){
			console.log($('#inputCode').val());
			if($('#inputCode').val()==null || $('#inputCode').val()=="" ){
				$("#cWaring").text("密码不能为空！");
				$("#cWaring").css("color","red");
			}else{
				$("#cWaring").text("");
			}
			
		});
		
		
	</script>
	</div>

</body>
</html>
