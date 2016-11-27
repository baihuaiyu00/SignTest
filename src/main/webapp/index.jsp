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
    <c:if test="${sessionScope.Member==null}">
         <form action="${pageContext.request.contextPath}/SessionRem.htm" method="post">
            <input type="text" name="id" id="stuid">
            <input type="text" name="sname" id="stuname">
            <input type="submit" value="首次签到">
         </form>
    </c:if>

    <%--<c:if test="${sessionScope.Member!=null}">--%>
        <%--<input type="button" value="签到" onclick="turn()">--%>
    <%--</c:if>--%>

    <%--<script type="application/javascript" language="JavaScript">--%>
        <%--function turn() {--%>
            <%--self.location="${pageContext.request.contextPath}/SessionRem2.htm";--%>
        <%--}--%>
    <%--</script>--%>
</body>
</html>
