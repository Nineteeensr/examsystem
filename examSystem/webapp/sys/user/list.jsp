<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>用户管理</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/theme.css">
<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
</head>

<body class="content1">
	<div class="container-fluid">
		<div class="row-fluid">
			<form class="form-inline" method="post"
				action="<%=basePath%>UserServlet?cmd=list">

				<input class="input-xlarge" placeholder="用户名查询" name="usname"
					type="text" value=""> <input class="input-xlarge" placeholder="用户真实姓名查询" name="ustruename"
					type="text" value=""><input class="input-xlarge" placeholder="用户权限id查询" name="usroleid"
					type="text" value=""><input
					class="btn icon-search" type="submit" value="查询" /> <a
					class="btn btn-primary" href="<%=basePath%>sys/user/add.jsp"> <i
					class="icon-plus"></i> 新增
				</a>
			</form>

			<div class="well">
				<table class="table">
					<thead>
						<tr>
							<th>角色ID</th>
							<th>用户名</th>
							<!--<th>
									用户密码
								</th>
								-->
							<th>用户真实名字</th>
							<th>用户状态</th>
							<th style="width: 90px;">编辑</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${pages.list}" var="item">
							<tr>
								<td>${item.roleId}</td>
								<td>${item.userName}</td>
								<!--<td>
										${item.userPwd}
									</td>
									-->
								<td>${item.usertruename}</td>
								<td><c:choose>
										<c:when test="${item.userState==\"1\"}">
												正常		
											</c:when>
										<c:otherwise>锁定</c:otherwise>
									</c:choose></td>
								<td><a
									href="<%=basePath%>UserServlet?cmd=toedit&id=${item.userId}">编辑</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!--注意修改servlet映射  -->
				<div class="pagination pagination-right">
					<ul>
						<li>
							<!--pages是传入的分页工具对象  --> <a>共计：${pages.totalPageCount}页/${pages.totalCount}条记录</a>
						</li>



						<!--上一页如果currentPageNo为1则上一页失去效果 -->
						<li><c:if test="${pages.currentPageNo==1}" var="fp">
								<a style="disabled: true; color: #000000;">上一页</a>
							</c:if> <c:if test="${!fp}">
								<!--注意要处理的servlet映射-->
								<a
									href="<%=basePath%>UserServlet?cmd=list&currNo=${pages.currentPageNo-1}">上一页</a>
							</c:if></li>

						<c:forEach begin="${pages.minPageNo }" step="1"
							end="${pages.maxPageNo }" var="index">
							<li><c:if test="${pages.currentPageNo==index}" var="t">
									<a style="color: red; background-color: #bbb">${index}</a>
								</c:if> <c:if test="${!t}">
									<!--注意要处理的servlet映射-->
									<a
										href="<%=basePath%>UserServlet?cmd=list&currno=${pages.minPageNo}">${pages.currentPageNo}</a>
								</c:if></li>
						</c:forEach>

						<!--上一页如果currentPageNo等于tatolPageCount则下一页失去效果 -->
						<li><c:if
								test="${pages.currentPageNo==pages.totalPageCount }" var="fp">
								<a style="disabled: true; color: #000000;">下一页</a>
							</c:if> <c:if test="${!fp}">
								<!--注意要处理的servlet映射-->
								<a
									href="<%=basePath%>UserServlet?cmd=list&currNo=${pages.currentPageNo+1}">下一页</a>
							</c:if></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
