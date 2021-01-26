<%--
  Created by IntelliJ IDEA.
  User: BigBang
  Date: 2021/1/24
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--引入jstl包-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>学生管理系统</h1>
  <table>
    <tr>
      <th>编号</th>
      <th>姓名</th>
      <th>成绩</th>
      <th>出生日期</th>
    </tr>

    <c:forEach items="${list}" var="student">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.score}</td>
      <td>${student.birthday}</td>
      <td>
        <a href="/student?method=delete&id=${student.id}">删除</a>
        <a href="/student?method=findById&id=${student.id}">修改</a>
    </tr>
    </c:forEach>
  </table>
  <a href="add.jsp">添加</a>
  </body>
</html>
