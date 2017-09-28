<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 25.08.2017
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Page</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<table>

    <tr>
        <th>Dishes</th>
        <th>Weight</th>
        <th>Cost</th>
    </tr>

    <c:forEach items="${dishes}" var="dish">
        <tr>
            <%--<c:if test="${dish.name == '%ala%'}">--%>
                <td><a href="/dish/${dish.name}">${dish.name}</a></td>
                <td>${dish.weight}</td>
                <td>${dish.cost}</td>
            <%--</c:if>--%>
        </tr>
    </c:forEach>

</table>
</body>
</html>
