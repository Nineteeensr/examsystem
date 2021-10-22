<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>新增试卷</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/theme.css">
<script src="<%=basePath%>js/jquery-1.12.4.js" type="text/javascript"></script>
</head>

<body class="content1">
	<script>
		$('#a_leader_txt', parent.document).html('新增试卷');
	</script>
	<div class="container-fluid">
		<div class="row-fluid">
			<form method="post" action="<%=basePath%>PaperServlet?cmd=add">
				<div class="btn-toolbar">
					<input type="submit" class="btn btn-primary" value="保存 "> <a
						href="<%=basePath%>PaperServlet?cmd=list" class="btn">取消</a>
				</div>
				<div class="well">
					<div class="tab-pane active in">
						<label> 试卷名称： </label> <input type="text" name="pname"
							maxlength="10"> <label> 试题数量： </label> <input type="text"
							name="scount" maxlength="10">
						<div style="color: red">${mess}</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
