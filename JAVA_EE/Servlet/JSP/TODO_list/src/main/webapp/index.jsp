<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 20.08.2017
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        <%@ include file="css/style.css"%>
    </style>
</head>
<body>
<form action="/taskList" method="post">
    <label>First Name: </label><input type="text" name="first_name">
    <br/>
    <label>Last Name: </label><input type="text" name="last_name"/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
