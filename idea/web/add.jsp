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
        姓名：<input type="text" name="name"/><br/>
        分数：<input type="text" name="score"/><br/>
        出生日期：<input type="date" name="birthday"/><br/>
        <input type="hidden" name="method" value="add">
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
