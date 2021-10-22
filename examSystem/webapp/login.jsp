<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<!-- 引入登录css样式 -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/denglu.css">
	
	<link rel="stylesheet" type="text/css" href="css/denglu.css">
<style type="text/css">
#stu {
	color: red;
}

#man {
	color: #000000;
}
/* 鍏ㄥ眬灞炴�ф竻闄ゅ唴澶栬竟璺� */
*{
	margin: 0px;
	padding: 0px;
}
body{
	background-image: url(../img/bg.d47fb98b.png);
}
/* 椤堕儴琛ㄥご */
.top{
	width: 1556px;
	height:60px;
	background-color:RGB(51,51,51);
}
/* 椤堕儴logo  */
.top-img{
	width: 140px;
	height: 44px;
	/* border: 1px solid black; */
	margin-left: 194.5px;
	padding-top: 5px;
}
/* logo鍥剧墖 */
.top-img img{
	width: 100%;
	height: 100%;
}
/* *******************涓棿閮ㄥ垎**************** */
/* 涓棿閮ㄥ垎 */
.center{
	width: 1556px;
	height: 449.6px;
}
/* 宸︿晶澶у浘鐗� */
.left-img{
	width: 699px;
	height: 499.6px;
	margin-left:274.5px;
	padding-top: 150px;
}
/* 宸︿晶鍥剧墖鏍峰紡 */
.left-img img{
	width: 429px;
	height: 256px;
}
/* 鍙充晶鐧诲綍鏍� */
.right-do{
	width: 447px;
	height: 446px;
	border: 1px solid #DDDDDD;
	margin-left: 900px;
	margin-top: -600px;
}
/* 瀛︾敓鐧诲綍鍜岀鐞嗗憳鐧诲綍 */
.student{
	width: 370px;
	height: 30px;
	margin-left: 30px;
}
.student p{
	display: inline-block;
	padding-top: 13px;
}
.student p:nth-of-type(1){
	margin-right: 190px;
	margin-left: 20px;
}
/* 鏂囧瓧鏍峰紡 */
.student a{
	text-decoration: none;
	font-size: 15px;
}
/* 椤堕儴鐧诲綍鏂囧瓧閮ㄥ垎 */
.zhanhao{
	height: 60px;
	width: 320px;
	line-height: 60px;
	padding: 5px 30px;
	margin-left: 30px;
	margin-bottom: 10px;
	border-bottom: 3px solid gray;
}
/* 鏂囧瓧浣嶇疆鎺у埗 */
.zhanhao p{
	width: 100px;
	height: 65px;
	margin-left: -30px;
	border-bottom: 3px solid #1890FF;
}
/* 鏂囧瓧瀛椾綋鏍峰紡鎺у埗 */
.zhanhao a{
	text-decoration: none;
	color: #1890FF;
	font-size: 15px;
}
/* 鐢ㄦ埛淇℃伅杈撳叆妗� */
.user{
	width: 360px;
	height: 40px;
	margin-left: 30px;
}
/* 鍥炬爣瀛樻斁妗� */
.user span{
	width: 25px;
	height: 36px;
	position: relative;
	top: 33px;
	left: 10px;
}
/* 鍥炬爣澶у皬 */
.user span img{
	width: 16px;
	height: 18px;
}
/* 琛ㄥ崟 */
#usre{
	width: 345px;
	height: 36px;
	padding-left: 30px;
}

/* 瀵嗙爜杈撳叆妗� */
.pass{
	width: 360px;
	height: 40px;
	margin: 30px;
}
/* 鍥炬爣瀛樻斁妗� */
.pass span{
	width: 25px;
	height: 36px;
	position: relative;
	top: 34px;
	left: 10px;
}
/* 鍥炬爣澶у皬 */
.pass span img{
	width: 20px;
	height: 22px;
}
/* 琛ㄥ崟 */
#pass{
	width: 345px;
	height: 36px;
	padding-left: 30px;
}
/* ******* */
/* 楠岃瘉鐮� */
.yanzheng{
	width: 375px;
	height: 40px;
	border: 1px solid #DCDFE6;
	margin-left: 30px;
	margin-top: 60px;
	position: relative;
}
/* 瑁呭浘鐗囩殑鐩掑瓙 */
.yan-img{
	width: 108px;
	height: 40px;
	display: inline-block;
	border-right: 1px solid #DCDFE6;
}
/* 鍥剧墖澶у皬 */
.yan-img img{
	width: 90%;
	height: 100%;
}
/* 琛ㄥ崟 */
#yanzheng{
	width: 245px;
	height: 38px;
	font-size: 15px;
	padding-left: 20px;
	outline: aliceblue;
	position: absolute;
	border: none;
}
/* ******************************* */
/* 鐧诲綍鎸夐挳 */
.deng{
	width: 375px;
	height: 40px;
	background-color: #46A6FF;
	margin-top: 35px;
	margin-left: 30px;
}
/* 鎻愪氦琛ㄥ崟 */
#submit{
	width: 375px;
	height: 40px;
	background-color: #46A6FF;
	border: none;
	color: #FFFFFF;
	font-size: 18px;
}
/* 娉ㄥ唽鍙婂繕璁板瘑鐮� */
.zhuce{
	width: 360px;
	height: 30px;
	margin-left: 30px;
}
.zhuce p{
	display: inline-block;
	margin-top: 15px;
	font-size: 13px;
	margin-left: 5px;
}
.zhuce p:nth-of-type(1){
	margin-left: 210px;
}
.zhuce p a{
	text-decoration: none;
	color: #606266;
}
/* 搴曢儴 */
.footer{
	width: 1556px;
	height: 60px;
	background-color: #333333;
	position: absolute;
	bottom: 0px;
}
.footer p{
	font-size: 18px;
	color: #A3A8B0;
	line-height: 60px;
	margin-left: 180px;
}

</style>

</head>
<body>
	<!-- 顶部蓝色表头 -->
	<div class="top">
		<!-- 顶部logo -->
		<div class="top-img">
			<!-- 顶部logo跳转链接 -->
			<a href="login.jsp"><img src="<%=basePath%>img/logo.png"></a>
		</div>
	</div>
	<!-- 中间部分 -->
	<div class="center">
		<!-- 左侧图片 -->
		<div class="left-img">
			<!-- 中间左侧图片 -->
			<img src="https://exam.yfhl.net/static/img/login2.63e48828.png">
		</div>
		<!-- 右侧登录框 -->
		<form action="<%=basePath%>UserServlet?cmd=stulogin" method="post" id="loginform">
			<div class="right-do">
				<!-- 顶部账号登录文字 -->
				<div class="zhanhao">
					<p>
						<a href="#">账号密码登录</a>
					</p>
				</div>
				<div class="student">
					<p>
						<a href="javascript:void(0);" onclick="stuLogin()" id="stu">学生登录</a>
					</p>
					<p>
						<a href="javascript:void(0);" onclick="manLogin()" id="man">管理员登录</a>
					</p>
				</div>
				<!-- 用户信息输入框 -->
				<div class="user">
					<span><img src="<%=basePath%>img/用户-圆.png"></span> <input
						type="text" name="userName" id="usre" placeholder="用户名"
						required="required" value="" />
				</div>
				<!-- 密码输入框 -->
				<div class="pass">
					<span><img src="<%=basePath%>img/密码.png"></span> <input
						type="password" name="userPwd" id="pass" placeholder="密码"
						required="required" value="" />
				</div>
				<!-- 验证码 -->
				<div class="yanzheng">
					<p class="yan-img">
						<img id="codeImg" src="<%=basePath%>code.jsp">
					</p>
					<input type="text" name="uCode" id="yanzheng" placeholder="请输入验证码"
						value="" />
						<div style="color:red;"><c:if test="${mess!=null }">${mess }</c:if></div>
				</div>
				<!-- 登录按钮 -->
				<p class="deng">
					<a href="#"><input type="submit" id="submit" value="登录" /></a>
				</p>
				<!-- 注册及忘记密码 -->
				<div class="zhuce">
					<p>
						<a href="regist.jsp">立即注册</a>
					</p>
					<p>
						<a href="#">忘记密码？</a>
					</p>
				</div>
			</div>
		</form>
	</div>
	<!-- 底部 -->
	<div class="footer">
		<p>© 2021KJDE1035GROUP1无限公司</p>
	</div>

	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
	<script type="text/javascript">
		var basePath="<%=basePath%>";
		function stuLogin(){
			$("#stu").css("color","red");
			$("#man").css("color","#000000");
			$("#loginform").attr("action",basePath+"UserServlet?cmd=stulogin");
		}
		function manLogin(){
			$("#stu").css("color","#000000");
			$("#man").css("color","red");
			$("#loginform").attr("action",basePath+"UserServlet?cmd=login");
		}
		
		/*表单验证  */
		$('#loginform').submit(function(){
			/*更换验证码  */
			console.log('<%=session.getAttribute("code")%>');
			
			
		});

		$("#codeImg").click(function() {
			console.log("更换验证码");
			$('#codeImg').attr('src', basePath + 'code.jsp?' + new Date());
		});
	</script>
</body>
</html>