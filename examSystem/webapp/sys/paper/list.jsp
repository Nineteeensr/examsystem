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

<title>试卷管理</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/theme.css">
</script>
</head>
<body class="content1">
	<div class="container-fluid">
		<div class="row-fluid">
			<form class="form-inline" method="post"
				action="<%=basePath%>PaperServlet?cmd=list">
				<input class="input-xlarge" placeholder="用户名..." name="pname"
					type="text" value="${param.pname}"> <input
					class="btn icon-search" type="submit" value="查询" /> <a
					class="btn btn-primary" href="<%=basePath%>sys/paper/add.jsp">
					<i class="icon-plus"></i> 新增
				</a>
			</form>

			<div class="well">
				<table class="table">
					<thead>
						<tr>
							<th>试题名称</th>
							<th>题目数量</th>

							<th style="width: 90px;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pager.list}" var="paper">
							<tr>
								<td>${paper.pname}</td>
								<td>${paper.scount}</td>

								<td><a href="PaperServlet?cmd=sList&pname=${paper.pname}">查看试题</a>
									<a href="<%=basePath%>PaperServlet?cmd=delete&pname=${item.pname}">删除试题</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!--注意修改servlet映射  -->
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
									href="<%=basePath%>PaperServlet?cmd=list&currNo=${pager.currentPageNo-1}">上一页</a>
							</c:if></li>

						<c:forEach begin="${pager.minPageNo }" step="1"
							end="${pager.maxPageNo }" var="index">
							<li><c:if test="${pager.currentPageNo==index}" var="t">
									<a style="color: red; background-color: #bbb">${index}</a>
								</c:if> <c:if test="${!t}">
									<!--注意要处理的servlet映射-->
									<a
										href="<%=basePath%>PaperServlet?cmd=list&currno=${pager.minPageNo}">${pager.currentPageNo}</a>
								</c:if></li>
						</c:forEach>

						<!--上一页如果currentPageNo等于tatolPageCount则下一页失去效果 -->
						<li><c:if
								test="${pager.currentPageNo==pager.totalPageCount }" var="fp">
								<a style="disabled: true; color: #000000;">下一页</a>
							</c:if> <c:if test="${!fp}">
								<!--注意要处理的servlet映射-->
								<a
									href="<%=basePath%>PaperServlet?cmd=list&currNo=${pager.currentPageNo+1}">下一页</a>
							</c:if></li>
					</ul>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		function del(paper, pname) {
			var re = confirm("是否确定删除？删除后无法恢复，做过题的同学将无法查看!");
			if (re) {
				$.post("PaperServlet", "?cmd=delete&pname=" + pname, function(
						data) {
					console.log(data);
					if (data.result == "true") {
						alert("删除成功");
						$(paper).parent().parent().remove();
					} else {
						alert("删除失败");
					}
				}, "json");
			} else {
				alert("操作取消")
			}
		}
	</script>
</body>
</html>
