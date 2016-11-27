<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2016/7/19
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="application/javascript" language="JavaScript">
    function turn() {
        self.location="${pageContext.request.contextPath}/SessionRem2.htm";

    }
</script>

<input type="button" value="签到" onclick="turn()"> 用户名:${sessionScope.secondname}




</body>
</html>
