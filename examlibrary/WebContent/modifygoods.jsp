<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改图书</title>
</head>
<body>
	<div>
		<h1>修改</h1>
		<form action="BookServlet?flag=doUpdate" method="post">
		图书编号：<input type="text" name="id" value="${book.id}"/><br><br>
		图书名称：<input type="text" name="name" value="${book.name}"/><br><br>
		图书作者：<input type="text" name="author" value="${book.author}"/><br><br>
		出版社：<input type="text" name="publish" value="${book.publish}"/><br><br>
		出版日期：<input type="text" name="publishdate" value="${book.publishdate}"/><br><br>
		页数：<input type="text" name="page" value="${book.page}"/><br><br>
		价格：<input type="text" name="price" value="${book.price}"/><br><br>
		图书备注：<input type="text" name="content" value="${book.content}"/><br><br>
		<button>修改</button>
		</form>
	</div>
</body>
</html>