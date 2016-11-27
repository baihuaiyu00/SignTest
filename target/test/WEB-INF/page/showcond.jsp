<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2016/7/19
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>签到时间</td>
            <td>名次</td>
            <td>姓名</td>
        </tr>
        <c:forEach items="${condlist}" var="cd">
            <tr>
                <td align="center">${cd.signtime}</td>
                <td align="center">${cd.signrank}</td>
                <td align="center">${cd.uname}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
