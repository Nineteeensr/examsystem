<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
	<head>
		<meta charset="utf-8" />
		<title>找回密码</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/yfregist.css"/>
		<!-- <link rel="stylesheet" href="./iconfont.css"> -->
	</head>
	<body>
		<div id="box">
			<!-- 顶部空区 -->
			<div id="top">
				<img alt="" src="img/logo.png">
			</div>
			<!-- 正文 -->
			<div id="container">
				<!-- 中部 -->
				<div id="boxs">
					<!-- 左边的 -->
					<div id="left">
						<img src="https://exam.yfhl.net/static/img/login2.63e48828.png" >
					</div>
					<!-- 右边的注册新账号 -->
					<div id="right">
						<!-- 注册新账号 -->
						<div id="rights">
							<div class="top">
								
								<div class="top1">
									<a href="#">找回密码</a>
								</div>
								<div class="bottoms">
									<div class="bottoms1">
										
									</div>
								</div>
							</div>
							
							<form action="ForgetpwdServlet" method="post" id="registForm">
							<input type="text" name="phone" id="phoneNum"  required="required" placeholder="手机号码" class="input3" value="" />
							<div id="phoneWaring"></div>
							<input type="text" name="phoneCode" id="phoneCode" required="required"  placeholder="输入验证码" class="input4" value="" />
							<input type="button" name="" id="getCode" onclick="sendCode(this)" class="input1s" value="发送验证码" />
							<div id="codeWaring"></div>
							<input type="password" name="userPwd" id="" placeholder="新密码" class="input5" required="required"  value="" />
							<input type="submit" name="" id="" class="input2s" value="确认" />
							<a href="login.jsp" class="lianjie">已有账号？</a>
							</form>
						</div>
						
					</div>
				</div>
			</div>
			<!-- 底部 -->
			<div id="bottom">
				© 2021KJDE1035GROUP1无限公司
			</div>
		</div>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript">
		
			/* 获取验证码 */		
			var code;
			function sendCode(d){
				$.post("CodeServlet","phoneNumber="+$("#phoneNum").val(),function(data){
					code=data.code;
					console.log(code);
				},"json");
				
				countDownTimer();
			}
			
			/* 表单验证 */
			$("#registForm").submit(function(){
				if(code==$("#phoneCode").val()){
					console.log("验证码正确");
					return true;
				}else{
					console.log("验证码错误");
					$("#phoneCode").css("border","1px solid red");
					$("#codeWaring").text("验证码错误！");
					$("#codeWaring").css("color","red");
					return false;
				}
				
			});
			
			/* 表单事件 */
			$('#phoneNum').focusout(function(){
				console.log('触发事件');
				var phoneNum = $(this).val();
				var test=/^([1])\d{10}$/;
				if(!test.test(phoneNum)){
					console.log('触发验证');
					$(this).css('border','1px solid red');
					$('#phoneWaring').text("请输入正确的手机号！");
					$('#phoneWaring').css('color','red');
				}else{
					$('#phoneWaring').text("");
					$(this).css('border','1px solid #DCDFE6');
				}
			});
			
			
			
			
			/* 返送按钮倒计时 */
			 function countDownTimer(){
				 	var second=60;
			        timer = setInterval(function(){
			            second -= 1; 
			            if(second >0 ){
			                $('#getCode').attr("disabled",true);
			                $('#getCode').css('background-color','#e8e5e5');
			                $('#getCode').val("重新发送(" + second + ")");
			            }else{
			                second=60;
			                clearInterval(timer);
			                $('#getCode').removeAttr("disabled");
			                $('#getCode').css('background-color','#b2ecf3');
			                $('#getCode').val("获取验证码");
			            }
			        },1000);
			    }
			
		</script>
		
		
		
	</body>
</html>
