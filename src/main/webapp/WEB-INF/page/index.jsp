<%@ page import="cn.cal.util.CookieUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<%--<script language="JavaScript" type="application/javascript">--%>
<%--window.onload = function () {--%>
<%--self.location="ShowIp2.htm";--%>
<%--}--%>
<%--</script>--%>

<body>
    <form action="${pageContext.request.contextPath}/SessionRem.htm" method="post">
        <input type="text" name="uid">
        <input type="text" name="uname">
        <input type="submit" value="首次签到">
    </form>

</body>
</html>
