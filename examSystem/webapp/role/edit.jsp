<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<head>
		<base href="<%=basePath%>">

		<title>编辑角色管理</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/theme.css">
		<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
	</head>

	<body class="content1">
		<script>
    		$('#a_leader_txt', parent.document).html('编辑角色管理');
		</script>

		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="<%=basePath%>RoleServlet?cmd=doEdit">
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-primary" value="保存 ">
						<a href="<%=basePath%>sys/role?cmd=list" class="btn">取消</a>

					</div>

					<div class="well">
						<div class="tab-pane active in">
							<input type="hidden" name="roleId" value="${role.roleId}"/>
							<label>
								角色名称：
							</label>
							<input type="text" name="roleName" maxlength="10"
								value="${role.roleName}">
							<label>
							
								角色状态：
							</label>
							<select name="roleState">
								<c:choose>
									<c:when test="${role.roleState==\"1\"}">
									<option value="1" selected="selected">正常</option>
									<option value="0">锁定</option>		
									</c:when>
									<c:otherwise>
									<option value="1">正常</option>
									<option value="0" selected="selected">锁定</option>	
									</c:otherwise>
								</c:choose>
								
							</select>
							<label>
								角色介绍：
							</label>
								<input type="text" name="roleDesc" maxlength="100"
								value="${role.roleDesc}">
							<div style="color: red">
								${mess}
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>