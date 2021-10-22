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

		<title>角色管理</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/theme.css">
		<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
	</head>

	<body class="content1">
		<div class="container-fluid">
			<div class="row-fluid">
				<form class="form-inline" method="post"
					action="<%=basePath%>sys/role?cmd=list">
					<input class="input-xlarge" placeholder="角色名称..." name="sname"
						type="text" value="${param.sname}">
					<input class="btn icon-search" type="submit" value="查询" />
					<a class="btn btn-primary"
						href="<%=basePath%>role/add.jsp"> <i
						class="icon-plus"></i> 新增 </a>
				</form>

				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>
									角色名称
								</th>
								<th>
									角色说明
								</th>
								<th>
									角色状态
								</th>
								<th style="width: 90px;">
									编辑
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pages.list}" var="role">
								<tr>
									<td>
										${role.roleName}
									</td>
									<td>
										${role.roleDesc}
									</td>
									<td>
										<c:choose>
											<c:when test="${role.roleState==\"1\"}">
												正常		
											</c:when>
											<c:otherwise>锁定</c:otherwise>
										</c:choose>
									</td>
									<td>
										<a href="<%=basePath%>RoleServlet?cmd=edit&id=${role.roleId}">编辑</a>
										&ensp;
										<a
											href="<%=basePath%>RoleServlet?cmd=fun&roleId=${role.roleId}">权限</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="pagination pagination-right">
						<ul>
							<li>
							<!--pages是传入的分页工具对象  -->
								<a>共计：${pages.totalPageCount}页/${pages.totalCount}条记录</a>
							</li>
							
							
							
							<!--上一页如果currentPageNo为1则上一页失去效果 -->
							<li>
								<c:if test= "${pages.currentPageNo==1}" var="fp">
									<a style="disabled: true;color:#000000;" >上一页</a>
								</c:if>
								<c:if test="${!fp}">
									<!--注意要处理的servlet映射-->
									<a
										href="<%=basePath%>RoleServlet?cmd=list&currentPageNo=${pages.currentPageNo-1}">上一页</a>
								</c:if>
							</li>
							
							<c:forEach begin="${pages.minPageNo }" step="1"
								end="${pages.maxPageNo }" var="index">
								<li>
									<c:if test="${pages.currentPageNo==index}" var="t">
										<a style="color: red; background-color: #bbb">${index}</a>
									</c:if>
									<c:if test="${!t}">
										<!--注意要处理的servlet映射-->
										<a href="<%=basePath%>RoleServlet?cmd=list&currentPageNo=${index}">${index}</a>
									</c:if>
								</li>
							</c:forEach>

							<!--上一页如果currentPageNo等于tatolPageCount则下一页失去效果 -->
							<li>
								<c:if
									test="${pages.currentPageNo==pages.totalPageCount }"
									var="fp">
									<a style="disabled: true;color:#000000;">下一页</a>
								</c:if>
								<c:if test="${!fp}">
									<!--注意要处理的servlet映射-->
									<a
										href="<%=basePath%>RoleServlet?cmd=list&currentPageNo=${pages.currentPageNo+1}">下一页</a>
								</c:if>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
