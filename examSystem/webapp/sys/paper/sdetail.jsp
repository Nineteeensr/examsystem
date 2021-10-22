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

<title>试题功能列表</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/theme.css">
<script src="<%=basePath%>js/jquery-1.12.4.js" type="text/javascript"></script>
</head>

<body class="content1">

	<div class="container-fluid">
		<div class="row-fluid">
			<form class="form-inline" method="post"
				action="<%=basePath%>sys/paper?cmd=slist">
				<input class="input-xlarge" placeholder="功能名称..." name="scontent"
					type="text" value="${param.scontent}"> <input
					class="btn icon-search" type="submit" value="查询" /> <a
					class="btn btn-primary" href="<%=basePath%>add.jsp"> <i
					class="icon-plus"></i> 新增试题
				</a>
			</form>

			<div class="well">
				<table class="table">
					<thead>
						<tr>
							<th>题目ID</th>
							<th>题干</th>
							<th>A选项</th>
							<th>B选项</th>
							<th>C选项</th>
							<th>D选项</th>
							<th>标准答案</th>
							<th>题目状态</th>
							<th style="width: 90px;">编辑</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${subjectList}" var="item">
							<tr>
								<td>${item.sid}</td>
								<td>${item.scontent}</td>
								<td>${item.sa}</td>
								<td>${item.sb}</td>
								<td>${item.sc}</td>
								<td>${item.sd}</td>
								<td>${item.skey}</td>
								<td><c:choose>
										<c:when test="${item.sstate=='1'}">
												可用		
											</c:when>
										<c:otherwise>不可用</c:otherwise>
									</c:choose></td>
								<td><a
									href="<%=basePath%>SubjectServlet?cmd=update&sid=${item.sid}">编辑</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!--注意修改servlet映射  -->
				<div class="pagination pagination-right">
					<ul>
						<li>
							<!--pages是传入的分页工具对象  --> <a>共计：${pager.totalPageCount}页/${pager.totalCount}条记录</a>
						</li>



						<!--上一页如果currentPageNo为1则上一页失去效果 -->
						<li><c:if test="${pager.currentPageNo==1}" var="fp">
								<a style="disabled: true; color: #000000;">上一页</a>
							</c:if> <c:if test="${!fp}">
								<!--注意要处理的servlet映射-->
								<a
									href="<%=basePath%>SubjectServlet?cmd=limit&currNo=${pager.currentPageNo-1}">上一页</a>
							</c:if></li>

						<c:forEach begin="${pager.minPageNo }" step="1"
							end="${pager.maxPageNo }" var="index">
							<li><c:if test="${pager.currentPageNo==index}" var="t">
									<a style="color: red; background-color: #bbb">${index}</a>
								</c:if> <c:if test="${!t}">
									<!--注意要处理的servlet映射-->
									<a
										href="<%=basePath%>PaperServlet?cmd=limit&currNo=${index}">${index}</a>
								</c:if></li>
						</c:forEach>

						<!--上一页如果currentPageNo等于tatolPageCount则下一页失去效果 -->
						<li><c:if
								test="${pager.currentPageNo==pager.totalPageCount }" var="fp">
								<a style="disabled: true; color: #000000;">下一页</a>
							</c:if> <c:if test="${!fp}">
								<!--注意要处理的servlet映射-->
								<a
									href="<%=basePath%>PaperServlet?cmd=limit&currNo=${pager.currentPageNo+1}">下一页</a>
							</c:if></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
