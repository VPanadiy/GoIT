<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 24.08.2017
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dish</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<table border="1">
    <tr>
        <th>Image</th>
        <th colspan="2">Description</th>
    </tr>
    <tr>
        <td rowspan="5"><img width="255" height="255" src="<c:url value="/resources/images/dishes/${dish.name}.jpg"/>"/></td>
        <td>Name</td>
        <td>${dish.id}</td>
    </tr>
    <tr>
        <td>Cost</td>
        <td>${dish.cost}</td>
    </tr>
    <tr>
        <td>Weight</td>
        <td>${dish.weight}</td>
    </tr>
    <tr>
        <td>Category</td>
        <td>${dish.menu.name}</td>
    </tr>
    <tr>
        <td>Ingredients</td>
        <td>${dish.ingredients}</td>
    </tr>
</table>
</body>
</html>
