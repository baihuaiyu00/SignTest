<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2016/7/21
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/sessionTest" method="post">
        username:<input type="text" name="username">
        password:<input type="password" name="password">
        <input type="submit" value="submit">
    </form>
</body>
</html>
