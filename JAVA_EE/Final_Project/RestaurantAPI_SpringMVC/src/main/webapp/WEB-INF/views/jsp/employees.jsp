<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 14.08.2017
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>

<table style="align-items: center">
    <tr>
        <th>Id</th>
        <th>Surname</th>
        <th>Name</th>
        <th>Date Birth</th>
        <th>Phone Number</th>
        <th>Appointment</th>
        <th>Salary</th>
    </tr>

    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.surname}</td>
            <td><a href="/employee/${employee.name}">${employee.name}</a></td>
            <td>${employee.position}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
