<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<h1>图书详细信息列表</h1>
<a href="addBook.jsp">增加</a>
   <table border="1" cellspacing="0" cellpadding="0">
      <tr>
      <th>编号</th>
         <th>书名</th>
         <th>作者</th>
         <th>出版社</th>
         <th>出版日期</th>
         <th>页数</th>
         <th>价格</th>
         <th>内容摘要</th>
         <th>操作</th>
      </tr>
      <!-- jstl中迭代标签 -->
      <c:forEach items="${pages.list}" var="book">
         <tr>
        	<td>${book.id}</td>
           	<td>${book.name}</td>
            <td >${book.author}</td>
            <td>${book.publish}</td>
            <td>${book.publishdate}</td>
            <td>${book.page}</td>
            <td>${book.price}</td>
            <td>${book.content}</td>
            <td>
               <a href="javascript:void(0)" onclick="del(this,${book.id})" >删除</a>
               <a href="BookServlet?flag=update&id=${book.id}">修改</a>
            </td>
         </tr>
      </c:forEach>
   </table>
   <p>
          [${pages.currentPageNo }/${pages.totalPageCount}]页
         <a href="BookServlet?currNo=1">第一页</a>
         <a href="BookServlet?currNo=${pages.currentPageNo-1}">上一页</a>
         <a href="BookServlet?currNo=${pages.currentPageNo+1}">下一页</a>
         <a href="BookServlet?currNo=${pages.totalPageCount}">最后一页</a>
        
         
     </p>
</body>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function del(d,id){
			var re = confirm("确定要删除吗");
			if (re){
				$.post("BookServlet","flag=delete&id="+id,function(data){
					console.log(data);
					if(data.result=="true"){
						alert("删除成功");
						$(d).parent().parent().remove();
					}else{
						alert("删除失败");
					}
				},"json");
			}else {
				alert("您取消了删除操作")
			}
	}
</script>
</html>