<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 14.08.2017
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- HEADER -->
<head>
    <title>Dream Dish</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<!-- /HEADER -->
<!-- MAIN SECTION -->
<body>
<h2>Time now is: ${currentTime}</h2>
<h1>Ресторан "DREAM DISH"</h1>

<table align="center">
    <tr>
        <td><a href="<c:url value="/personal"/>">Personal</a></td>
        <td><a href="<c:url value="/plan"/>">Plan</a></td>
        <td><a href="<c:url value="/contacts"/>">Contacts</a></td>
        <td>
            <form style="margin: 5px" id="searchForm" action="<c:url value="/searchPage"/>" method="POST">
                <label for="searchButton">Search:</label><input type="text" id="searchButton" name="searchButton" placeholder="Search">
                <input id="searchSubmit" type="submit" value="Search">
            </form>
        </td>
    </tr>
</table>

<%@ include file="menu.jsp" %>

<table id="tableFooter">
    <tr id="trFooter1">
        <td id="tdFooter1">Address: Search us ;)</td>
    </tr>
    <tr id="trFooter2">
        <td id="tdFooter2">Phone number: Call us ;)</td>
    </tr>
    <tr id="trFooter3">
        <td id="tdFooter3">@mail: Write us ;)</td>
    </tr>
</table>
</body>
<!-- /MAIN SECTION -->
</html>
