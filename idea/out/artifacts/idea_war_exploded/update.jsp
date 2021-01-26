<%--
  Created by IntelliJ IDEA.
  User: BigBang
  Date: 2021/1/24
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/student" method="post">
        编号：<input type="text" name="id" value="${student.id}" readonly/><br/>
        姓名：<input type="text" name="name" value="${student.name}"/><br/>
        分数：<input type="text" name="score" value="${student.score}"/><br/>
        出生日期：<input type="date" name="birthday" value="${student.birthday}"/><br/>
        <input type="hidden" name="method" value="update"/>
        <input type="submit" value="修改"/>
    </form>
</body>
</html>
