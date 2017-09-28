<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 24.08.2017
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacts</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<table width="100%">

    <tr>
        <th>Map</th>
        <th colspan="2">Contacts</th>
    </tr>
    <tr>
        <td rowspan="5"><img width="600" height="600" src="<c:url value="/resources/images/map.png"/>"/></td>
        <td>Address:</td>
        <td>Search us ;)</td>
    </tr>
    <tr>
        <td>Phone number:</td>
        <td>Call us ;)</td>
    </tr>
    <tr>
        <td>@mail:</td>
        <td>Write us ;)</td>
    </tr>

</table>

</body>
</html>
