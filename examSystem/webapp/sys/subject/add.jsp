<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>增加试题功能</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/theme.css">
		<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
		<style type="text/css">
			.tab-pane label,
			input {
				display: block;
			}
			#btnsave{
				background-color: #333333;
				background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#6c7994), to(#414959));
				border-radius:4px;
				color: white;
				width: 58px;
				height: 30px;
				border: 1px solid #363d4a;
				font-size: 14px;
				margin-left:23px ;
			}
			#btnsave:hover{
				background-color:#414959 ;
			}
			.btn{
				display: inline-block;
				border: 1px solid #bbbbbb;
				width: 58px;
				height: 28px;
				border-radius:4px;
				/* background-color: #333333; */
				background-image: linear-gradient(to bottom, #ffffff, #e6e6e6);
				border-color: rgba(0, 0, 0, 0.15) rgba(0, 0, 0, 0.15) rgba(0, 0, 0, 0.25);
				text-decoration: none;
				color: #333333;
				text-align: center;
				line-height: 30px;
				margin: 10px;
				font-size: 14px;
			}
			.well{
				border: 1px RGB(204,204,204) solid;
				padding: 20px;
				width: 90%;
			}
		</style>
	</head>

	<body class="content1">
		<script>
    		$('#a_leader_txt', parent.document).html('添加试题功能');
		</script>
		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="<%=basePath%>SubjectServlet?cmd=add">
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-primary" value="保存 " id="btnsave">
						<a href="<%=basePath%>SubjectServlet?cmd=limit" class="btn">取消</a>

					</div>

					<div class="well">
						<div class="tab-pane active in">
							<label>
								题目类型：
							</label>
							<select name="subType" style="width: 130px;height: 20px;line-height: 20px;">
								<option value="0">没的选的选择题</option>
								<option value="1">不简单的简答题</option>
							</select>
							<label>
								题干：
							</label>
							<textarea rows="7" cols="60" style="resize:none;" name="scontent"></textarea>
							
							<label>
								A选项内容：
							</label>
							<input type="text" name="sa" maxlength="100">
							<label>
								B选项内容：
							</label>
							<input type="text" name="sb" maxlength="100">
							<label>
								C选项内容：
							</label>
							<input type="text" name="sc" maxlength="100">
							<label>
								D选项内容：
							</label>
							<input type="text" name="sd" maxlength="100">
							<label>
								正确答案选项：
							</label>
							<input type="text" name="skey" maxlength="10">
							<label>
								试题状态：
							</label>
							<select name="sstate">
								<option value="1">
									正常
								</option>
								<option value="0">
									锁定
								</option>
							</select>
							<div style="color: red">
								${msg}
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
