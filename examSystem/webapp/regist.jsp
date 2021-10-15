<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>在线考试系统</title>




<script charset="UTF-8"
	src="https://s3.kaoshixing.com/static/plugins/sensorsdata.min.js?v=50f19a4b2f"></script>
<script type="text/javascript"
	src="https://s2.kaoshixing.com/static/plugins/ksx_probe.js?v=de8a9c9d93"></script>
<script type="text/javascript">
	// 初始化
	ksxProbe.sensorsInit();
	// 注册全局属性
	ksxProbe.sensorsRegisterPage({
		platform : '会否培训平台',
		system : '登录',
	});
	// 用户属性
	var sensorsSetProfile = {};

	ksxProbe.sensorsQuick('autoTrack');
	//添加tingyun探针
	ksxProbe.tingyun();
</script>

<meta http-equiv="X-UA-Compatible" content="IE=9" />

<link rel="shortcut icon"
	href="https://s6.kaoshixing.com/ksxing_static/website-3.1/base/examstar-icon.ico" />
<link rel="stylesheet"
	href="https://s4.kaoshixing.com/static/plugins/bootstrap/css/bootstrap.min.css?v=9ed71d9523">
<link rel="stylesheet"
	href="https://s1.kaoshixing.com/static/plugins/website-icons/css/styles.min.css?v=155d7874b1">
<link rel="stylesheet"
	href="https://s3.kaoshixing.com/static/base/css/ksx-loading.css?v=13b811c604">
<link rel="stylesheet"
	href="https://s2.kaoshixing.com/static/website-5.0/css/website-regist.css?v=c35fcb78a5">
<link rel="stylesheet"
	href="https://s1.kaoshixing.com/static/plugins/website-icomoon/style.css?v=2a745b3379">
<link rel="stylesheet"
	href="https://s3.kaoshixing.com/static/plugins/examFont/style.css?v=34b26f4011">
<script type="text/javascript">
	window._agl = window._agl || [];
	(function() {
		_agl.push([ 'production', '_f7L2XwGXjyszb4d1e2oxPybgD' ]);
		(function() {
			var agl = document.createElement('script');
			agl.type = 'text/javascript';
			agl.async = true;
			agl.src = 'https://fxgate.baidu.com/angelia/fcagl.js?production=_f7L2XwGXjyszb4d1e2oxPybgD';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(agl, s);
		})();
	})();
</script>
</head>

<body>
	<div class="banner-bg">
		<div class="mask"></div>

		<div class="header"></div>
		<div class="main-content">
			<div class="title">在线考试系统</div>
			<div class="card" id="registerIng">
				<form action="RegistServlet" method="post" id="subForm" name="form"
					autocomplete="off">
					<div class="form-item phone">
						<input type="text" name="userName" id="userName"
							placeholder="请输入账号" value="" /> <span class="tip"></span>
					</div>
					<div class="form-item phone">
						<input type="text" name="userPwd" id="userPwd" placeholder="请输入密码"
							value="" /> <span class="tip"></span>
					</div>
					<div class="form-item phone">
						<input type="text" name="rePwd" id="rePwd" placeholder="请再次确认密码"
							value="" /> <span class="tip"></span>
					</div>
					<div class="form-item phone">
						<input type="text" name="phone" id="adminPhone"
							placeholder="请输入手机号码(必填)" value="" />

					</div>

					<div class="form-item verify">
						<input type="text" name="verifyCode" id="verifyCode"
							placeholder="请输入短信验证码(必填)" /> <input type="text"
							name="preventDefault"
							style="position: absolute; height: 0; padding: 0; border: 0;" />
						<span class="tip"></span>
						<div class="btn-verify-code btnVerifyCode tencent"
							id="btnVerifyCode">获取验证码</div>
					</div>
					<div class="re-verify-box">
						<div class="msg">
							收不到短信？<a class="btn-verify-code btnVerifyCode">点此重发</a>
						</div>
					</div>




					<div class="btn-box">



						<button class="btn-register" id="btnRegister" data-agl-cvt="5">
							<span>立即注册</span>
							<div class="loading ksx-loading-effect-1">
								<span></span> <span></span> <span></span> <span></span> <span></span>
								<span></span> <span></span> <span></span>
							</div>
						</button>
						<a class="btn-login" target="_blank"
							href="https://www.kaoshixing.com/login/account/login">已有账号，直接登录</a>
					</div>
				</form>

				<div class="card-footer">
					<i class="icon icon-a_warning"></i>参与考试的学员请勿在此注册，请联系考试发起者获得入口链接。
				</div>

			</div>



			
		</div>
	</div>












</body>
</html>
