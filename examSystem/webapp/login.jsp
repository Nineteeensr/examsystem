<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap.css">

<style type="text/css">
#loginForm-continer {
	width: 600px;
	background-color: #E1E1E1;
	border: 1px solid #D2D2D2;
}
</style>



<title>学生登录</title>
</head>

<body>
	<form action="LoginServlet" method="post" style="margin-top: 180px;">
		<div class="container" id="loginForm-continer"
			style="border: 1px solid #CED4DA;">
			<div class="row">
				<div class="col-md-4 offset-4" style="margin-bottom: 30px;">
					<h5 style="margin-top: 60px;">在线考试系统</h5>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 text-right" style="margin: 0px">
					<select class="form-control"
						style="padding: 0px; padding-left: 25px; height: 47px; border: 0px; background-color: #E1E1E1; color: #000000;"
						name="role">
						<option value="0">管理员</option>
						<option value="1">老师</option>
						<option value="2">学生</option>
					</select>
				</div>
				<div class="col-md-8" style="padding: 0px;">
					<input class="form-control " type="text" placeholder="用户名"
						data-validate="required:请填写账号" style="margin: 0px;">
				</div>
			</div>

			<div class="row" style="margin-top: 30px;">
				<label for="exampleFormControlSelect1" class="col-md-3"
					style="height: 47px; line-height: 47px; text-align: center;">密&nbsp;&nbsp;&nbsp;码</label>
				<div class="col-md-8" style="padding: 0px;">
					<input class="form-control " type="text" placeholder="密码"
						style="margin: 0px;">
				</div>
			</div>
			<div class="row" style="margin-top: 30px;">
				<div class="col-md-8 offset-2">
					<input type="text" id="inputCode" name="uCode"
						class="form-control" placeholder="验证码" required
						style="width: 75%; display: inline-block;"> <img id="image"
						border="0" onclick="refresh()" src="image.jsp" title="点击更换图片">
				</div>
			</div>

			<div class="row" style="margin-top: 15px;">
				<div class="form-check form-check-inline col-md-4 offset-2">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox1" value="option1"> <label
						class="form-check-label" for="inlineCheckbox1">记住密码</label>
				</div>
				<div class="col-md-4">
					<a href="repassword.jsp">忘记密码</a>/<a href="regist.jsp">去注册</a>
				</div>

			</div>
			<div class="row" style="margin: 30px 0px;">
				<div class="col-md-4 offset-4">
					<button  class="btn btn-success"
						style="padding: 5px 30px;">登&nbsp;&nbsp;&nbsp;录</button>
				</div>
			</div>

		</div>

	</form>
	<script src="<%=basePath%>js/jquery-1.12.4.js"></script>
	<script src="<%=basePath%>js/bootstrap.js"></script>
	<script src="<%=basePath%>js/pintuer.js"></script>
	<script type="text/javascript">
	    function refresh() {
	    	//alert(1);
			//IE存在缓存,需要new Date()实现更换路径的作用
			$("#image").attr("src","image.jsp?"+new Date());
	    }
    </script>
	<script>
		var basePath = '<%=basePath%>
		$('.form-top-left a').click(
				function() {
					$('.form-top-left').children().removeAttr("style");
					var type = $(this).css('color', 'red').attr("data-type");
					if (type == 'student') {
						$(document).attr("title", "学生登录");
						$("#mes").html('');
						$(".login-form").attr("action",
								basePath + "LoginServlet?cmd=stulogin");
					} else {
						$(document).attr("title", "管理员登录");
						$("#register").html('');
						$("#mes").html('');
						$(".login-form").attr("action",
								basePath + "LoginServlet?cmd=login");
					}
				})
	</script>
</body>

</html>