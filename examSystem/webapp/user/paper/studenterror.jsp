<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>

<head>
<base href="<%=basePath%>">
<title>在线答题</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/paper.css">
<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.js"></script>
</head>
<style type="text/css">
		.navbar-header{
			margin-left:100px;
			
		}
		
	</style>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#" style="margin-top:-10px;color:#e2e2e2;"><img src="img/logo.png" style="display:inline;height:50px;width:90px;"/>在线考试系统</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse" style="background-color:RGB(51,51,51);">
			<ul class="nav navbar-nav">
				<li><a href="<%=basePath%>UserServlet?cmd=paperlist" style="background-color:RGB(51,51,51);color:#e2e2e2">试题列表</a></li>
				<li class="active"><a
					href="<%=basePath%>StudentPaperServlet?cmd=list" style="background-color:RGB(51,51,51);color:#e2e2e2">我的成绩</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${userid!=null}">
						<li><a><c:out value="${sessionScope.user.usertruename}" /></a></li>
						<li><a href="<%=basePath%>UserServlet?cmd=logout">注销</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="login.jsp" style="background-color:RGB(51,51,51);color:#e2e2e2">登录</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>

	<main class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h3 class="panel-title">
					<c:out value="${pname}"></c:out>
				</h3>
			</div>
			<div class="panel-body">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion" href="#Radio">错题库</a>
						</h4>
					</div>
					<div id="Radio" class="panel-collapse collapse in">
						<div class="panel-body">
							<ol>
								<c:forEach items="${pages.list}" var="item">
									<div class="subject" data-sid="${item.sid}"
										data-key="${item.skey}" data-skey="${item.studentkey}">
										<li>${item.scontent}</li>
										<ol>
											
										
											<li><label data-value="A">${item.sa}</label></li>
											<li><label data-value="B">${item.sb}</label></li>
											<li><label data-value="C">${item.sc}</label></li>
											<li><label data-value="D">${item.sd}</label></li>
										</ol>
									</div>
								</c:forEach>
							</ol>

						</div>
					</div>

				</div>
			</div>
		</div>
	</main>
	<script>
    // 获取basePath 
    var basePath = '<%=basePath%>';
		$(function(ev) {
			var len = $('.subject').length;
			$('.subject').each(function(index) {
				var i = index
				var self = $(this)

				self.find('label').each(function() {
					var label = $(this)
					if (self.data('key') == label.data('value')) {
						label.parent().addClass('correct')
					}
					if (self.data('skey') == label.data('value')) {
						label.parent().addClass('error')
					}
				})

				//var data = {userid:userid,sid:self.data('sid'),studentkey:self.data('skey'),studentstate:self.data('state'),pname:pname}
			})

		})
	</script>
</body>

</html>