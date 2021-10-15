<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  div{
	  width:500px;
	  margin: 0px auto;
  }
</style>
</head>
<body>
  <div align="center">
  <form action="LoginServlet" method="post">
     <table width="500" border="1" cellspacing="0" cellpadding="0">
        <tr>
           <th colspan="2">登录图书管理系统</th>
        </tr>
        <tr>
           <td style="background-color:pink;">用户名:</td>
           <td> <input name="name" id="name" /> </td>
        </tr>
        <tr>
            <td style="background-color:pink;">密码:</td>
           <td> <input type="password" name="password" id="password" /> </td>
        </tr>
        <tr>
           <td colspan="2">
              <button>登录</button>
           </td>
        </tr>
        <tr>
           <span style="color:red;"></span>
        </tr>
     </table>
</form>  
  </div>
</body>
</html>