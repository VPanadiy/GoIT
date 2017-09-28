<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 24.08.2017
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>

<table border="1">
    <tr>
        <th>Image</th>
        <th colspan="2">Name</th>
    </tr>

    <c:forEach items="${personal}" var="waiters">
        <c:if test="${waiters.position == 'WAITER'}">
            <tr>
                <td><img width="255" height="255" src="<c:url value="/resources/images/waiters/waiter.jpg"/>"/>
                </td>
                <td>Name</td>
                <td>${waiters.name}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>
